package bookServer3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private boolean isConnected;
	
	public Client(Socket socket) throws IOException {
		super();
		this.socket = socket;
		this.dis = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
		isConnected = true;
	}
	@Override
	public void run(){
		while(isConnected){
			try {
				int sign = dis.readInt();
				if (sign == Server.SIGN_SEND_BAGRRAGE) {		//in6 out1
					int bookId = dis.readInt();
					int chapterNum = dis.readInt();
					int startWordMark = dis.readInt();
					int endWordMark = dis.readInt();
					String content = dis.readUTF();
					saveBagrrage(bookId, chapterNum, startWordMark, endWordMark, content);
					Server.sendMessage("收到一条弹幕: " + startWordMark + " " + content);
				} else if (sign == Server.SIGN_ASK_PAGE_BAGRRAGES) {		//in4 out1
					int bookId = dis.readInt();
					int chapterNum = dis.readInt();
					int startWordMark = dis.readInt();
					Server.sendMessage("发送一页弹幕");
					String bagrrages = getPageBagrrages(bookId, chapterNum, startWordMark);
					dos.writeUTF(bagrrages);
					Server.sendMessage("" + bagrrages);
				} else if (sign == Server.SIGN_DOWNLOAD_CHAPTER) {		//in3 out2
					int bookId = dis.readInt();
					int chapterNum = dis.readInt();
					String name = Server.getChapterName(bookId, chapterNum);
					String content = Server.getChapterContent(bookId, chapterNum);
					if (name != null) {
						dos.writeUTF(name);
						dos.writeUTF(content);
					}else {
						dos.writeUTF("");
						dos.writeUTF("");
					}
					Server.sendMessage("发送完整的一章");
				} else if(sign == Server.SIGN_ASK_CELLING_BOOK){		//in1 out6
					int bookId = Server.selectBookId();
					String[] bookInfo = Server.getBookInfo(bookId);
					byte[] image = Server.getBookImage(bookId);
					dos.writeInt(bookId);
					dos.writeUTF(bookInfo[0]);
					dos.writeUTF(bookInfo[1]);
					dos.writeUTF(bookInfo[2]);
					dos.writeUTF(bookInfo[3]);
					dos.writeInt(image.length);
					dos.write(image);
					Server.sendMessage(bookInfo[0] + "\n" + bookInfo[1] + "\n" + bookInfo[2] + "\n" + bookInfo[3]);
					Server.sendMessage("发送一本书" + " " + bookId);
				} else if (sign == Server.SIGN_BREAK_CONNECT) {
					Server.clientsList.remove(socket);
					isConnected = false;
					Server.sendMessage("断开连接");
					break;
				}
			} catch (Exception e) {
				isConnected = false;
				Server.sendMessage("wrong");
			}
		}
	}

	private void saveBagrrage(int bookId, int chapterNum, 
			int startWordMark, int endWordMark, String content){
		if(content == null || content.length() == 0){
			return;
		}
		String strPath = Server.BOOK_ROOT_PATH + "\\" + bookId + "\\" + chapterNum;
		File fPath = new File(strPath);
		if(!fPath.exists()){
			fPath.mkdirs();
		}
		File file = new File(strPath + "\\" + "bagrrages.bgs");
		try {
			@SuppressWarnings("resource")
			FileOutputStream fos = new FileOutputStream(file, true);
			fos.write(("" + startWordMark + "#" + endWordMark + "#" + content + "\n").getBytes());
		} catch (Exception e) {
		}
	}

	private String getPageBagrrages(int bookId, int chapterNum, int startWordMark){
		String bagrrages = "";
		File file = new File(Server.BOOK_ROOT_PATH + "\\" + bookId + "\\" + chapterNum + "\\" + "bagrrages.bgs");
		try {
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			StringBuilder sBuilder = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null){
				String[] s = line.split("#");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				String content = s[2];
				if(startWordMark >= start && startWordMark < end){
					sBuilder.append(content + "\n");
				}
			}
			bagrrages = sBuilder.toString();
		} catch (Exception e) {
		}
		return bagrrages;
	}
}
