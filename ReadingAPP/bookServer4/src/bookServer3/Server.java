package bookServer3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Server extends Application {
	private static final int PORT = 8000;

	public static final int SIGN_BREAK_CONNECT = -1;		//断开连接标志
	public static final int SIGN_SEND_BAGRRAGE = 0;		//发送弹幕标志
	public static final int SIGN_ASK_PAGE_BAGRRAGES = 1;		//请求一页弹幕标志
	public static final int SIGN_DOWNLOAD_CHAPTER = 2;		//下载章节标志
	public static final int SIGN_ASK_CELLING_BOOK = 3;		//获取书库的书
	
	public static final String NO_CHAPTER = "@";		//没有多余章节信号
	public static final String DOWNLOAD_OVER = "@@";		//章节下载完毕信号
	
	public static final String BOOK_ROOT_PATH = "book_root";		//书籍存放的根目录
	
	public static ServerSocket serverSocket;
	public static LinkedList<Client> clientsList;
	
	private Runnable serverTask;
	private Thread serverThread;
	
	private Scene scene;
	
	private FlowPane flowPane;
	private Button openServerBtn;
	private Label pathLabel;
	private TextField pathField;
	private Label idLabel;
	private TextField idField;
	private Button addBookBtn;
	
	private static boolean isOpenMessage = true;
	private static int[] booksId;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		initApp();
		scene = new Scene(flowPane, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void initApp(){
		initView();
		initTask();
		inputBooksId();
	}
	
	private void initView(){
		flowPane = new FlowPane(Orientation.VERTICAL, 0, 10);
		openServerBtn = new Button("open server");
		pathLabel = new Label("book path");
		pathField = new TextField();
		idLabel = new Label("book id");
		idField = new TextField();
		addBookBtn = new Button("add book");
		flowPane.getChildren().addAll(openServerBtn, pathLabel, pathField,
				idLabel, idField, addBookBtn);
		flowPane.setPadding(new Insets(20, 20, 20, 20));
		
		openServerBtn.setOnAction(e->{
			openServer();
		});
		
		addBookBtn.setOnAction(e->{
			String path = pathField.getText();
			String bookId = idField.getText();
			addBook(path, bookId);
		});
	}
	
	private void initTask(){
		serverTask = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Socket socket = serverSocket.accept();
						Server.sendMessage("客户端连上");
						Client client = new Client(socket);
						clientsList.addLast(client);
						client.start();
					} catch (Exception e) {
						Server.sendMessage("wrong");
					}
				}
			}
			
		};
	}
	
	private void inputBooksId(){
		File path = new File(BOOK_ROOT_PATH);
		if(!path.exists()){
			path.mkdir();
		}
		String[] files = path.list();
		booksId = new int[files.length];
		for(int i = 0; i < files.length; i++){
			booksId[i] = Integer.parseInt(files[i]);
		}
	}
	
	private void openServer(){
		try {
			serverSocket = new ServerSocket(PORT);
			clientsList = new LinkedList<Client>();
			Server.sendMessage("服务器打开成功");
			serverThread = new Thread(serverTask);
			serverThread.start();
		} catch (Exception e) {
			Server.sendMessage("服务器打开失败");
		}
	}

	@SuppressWarnings("resource")
	private boolean addBook(String path, String bookId){
		final String ROOT = BOOK_ROOT_PATH + "\\" + bookId;
		final String BOOK = "book.txt";
		final String IMAGE = "image.png";
		
		final String BOOK_INFO = "book_info.txt";
		final String BOOK_IMAGE = "book_image.png";
		final String NAME = "name.txt";
		final String CONTENT = "content.txt";
		
		BufferedReader bookReader = null;
		
		try {
			File bookFile = new File(path + "\\" + BOOK);
			FileInputStream bookDis = new FileInputStream(bookFile);
			bookReader = new BufferedReader(new InputStreamReader(bookDis));
		} catch (Exception e) {
			sendMessage("没有书籍");
		}
		
		ArrayList<String> chaptersName = new ArrayList<String>();
		ArrayList<String> chaptersContent = new ArrayList<String>();
		String bookInfo = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while((line = bookReader.readLine()) != null){
				if(line.length() != 0 && line.charAt(0) == '#'){
					if(line.length() > 1){
						chaptersName.add(line.substring(1, line.length()));
					}
					if(chaptersName.size() > 1){
						String content = formatString(sb.toString(), '呯', '砰');
						chaptersContent.add(content);
					}else{
						bookInfo = sb.toString();
					}
					sb = new StringBuilder("");
				}else if(line.length() != 0 && line.charAt(0) != '#'){
					sb.append(line + "\n");
				}
			}
		} catch (Exception e) {
			
		}
		try {
			String strPath;
			for(int i = 0; i < chaptersName.size(); i++){
				strPath = ROOT + "\\" + i;
				File chapterPath = new File(strPath);
				if(!chapterPath.exists()){
					chapterPath.mkdirs();
				}
				File nameFile = new File(strPath + "\\" + NAME);
				File contentFile = new File(strPath + "\\" + CONTENT);
				FileOutputStream nameFos = new FileOutputStream(nameFile);
				FileOutputStream contentFos = new FileOutputStream(contentFile);
				nameFos.write(chaptersName.get(i).getBytes());
				contentFos.write(chaptersContent.get(i).getBytes());
			}
			File infoFile = new File(ROOT + "\\" + BOOK_INFO);
			FileOutputStream infoFos = new FileOutputStream(infoFile);
			infoFos.write(bookInfo.getBytes());
		} catch (Exception e) {
		}
		try {
			File imageFile = new File(path + "\\" + IMAGE);
			FileInputStream fis = new FileInputStream(imageFile);
			byte[] imageBytes = new byte[fis.available()];
			fis.read(imageBytes);
			File outFile = new File(ROOT + "\\" + BOOK_IMAGE);
			FileOutputStream fos = new FileOutputStream(outFile);
			fos.write(imageBytes);
		} catch (Exception e) {
		}
		inputBooksId();
		
		
		return true;
	}
	
	private String formatString(String str, char oldWord, char newWord){
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < sb.length(); i++){
			if(sb.charAt(i) == oldWord){
				sb.setCharAt(i, newWord);
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings("resource")
	public static String getChapterContent(int bookId, int chapterNum){
		File contentFile = new File(BOOK_ROOT_PATH + "\\" + bookId + "\\"
				+ chapterNum + "\\" + "content.txt");
		try {
			FileInputStream contentFis = new FileInputStream(contentFile);
			BufferedReader contentBr = new BufferedReader(new InputStreamReader(contentFis));
			String line = null;
			StringBuilder content = new StringBuilder();
			while((line = contentBr.readLine()) != null){
				content.append(line + "\n");
			}
			return content.toString();
		} catch (Exception e){
			return null;
		}
	}
	
	@SuppressWarnings("resource")
	public static String getChapterName(int bookId, int chapterNum){
		File nameFile = new File(BOOK_ROOT_PATH + "\\" + bookId + "\\"
				+ chapterNum + "\\" + "name.txt");
		try {
			FileInputStream nameFis = new FileInputStream(nameFile);
			BufferedReader nameBr = new BufferedReader(new InputStreamReader(nameFis));
			String line = nameBr.readLine();
			return line;
		} catch (Exception e){
			return null;
		}
	}
	
	@SuppressWarnings("resource")
	public static byte[] getBookImage(int bookId){
		byte[] imageBytes = null;
		File imageFile = new File(BOOK_ROOT_PATH + "\\" + bookId + "\\" + "book_image.png");
		try {
			FileInputStream fis = new FileInputStream(imageFile);
			imageBytes = new byte[fis.available()];
			fis.read(imageBytes);
		} catch (Exception e) {
		}
		
		return imageBytes;
	}
	
	@SuppressWarnings("resource")
	public static String[] getBookInfo(int bookId){
		String[] bookInfo = new String[4];
		File infoFile = new File(BOOK_ROOT_PATH + "\\" + bookId + "\\" + "book_info.txt");
		try {
			FileInputStream fis = new FileInputStream(infoFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while((line = br.readLine()) != null){
				if(line.length() != 0 && line.charAt(line.length()-1) == '&'){
					sb.append(line.substring(0, line.length()-1));
					bookInfo[i] = sb.toString();
					sb = new StringBuilder();
					i++;
				}else{
					sb.append(line);
				}
			}
		} catch (Exception e) {
			sendMessage("wrong");
		}
		return bookInfo;
	}
	
	public static int selectBookId(){
		if(booksId != null && booksId.length != 0){
			int num = (int) (Math.random()*booksId.length);
			return booksId[num];
		}
		return -1;
	}
	
	public static void sendMessage(String s){
		if(isOpenMessage){
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
