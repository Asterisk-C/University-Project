
public class Test {
    public String name;
    protected float hp;
 
    public void attackHero(Test h) throws EnemyHeroIsDeadException{
        if(h.hp == 0){
            throw new EnemyHeroIsDeadException(h.name + " �Ѿ�����,����Ҫʩ�ż���" );
        }
    }
 
    public String toString(){
        return name;
    }
     
    class EnemyHeroIsDeadException extends Exception{
         
        public EnemyHeroIsDeadException(){
             
        }
        public EnemyHeroIsDeadException(String msg){
            super(msg);
        }
    }
      
    public static void main(String[] args) {
         
        Test garen =  new Test();
        garen.name = "����";
        garen.hp = 616;
 
        Test teemo =  new Test();
        teemo.name = "��Ī";
        teemo.hp = 0;
         
        try {
            garen.attackHero(teemo);
             
        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("�쳣�ľ���ԭ��:"+e.getMessage());
            e.printStackTrace();
        }
         
    }
}
