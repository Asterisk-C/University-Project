package exception;

public class Hero 
{
	public String name;
    protected float hp;
    
    public void attackHero(Hero h) throws EnemyHeroIsDeadException
    {
    	if(h.hp == 0)
    	{
    		throw new EnemyHeroIsDeadException(h.name + " already died.");
    	}
    }
    
    public String toString()
    {
        return name;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Hero garen =  new Hero();
        garen.name = "¸ÇÂ×";
        garen.hp = 800;
 
        Hero teemo =  new Hero();
        teemo.name = "ÌáÄª";
        teemo.hp = 0;
        
        try
        {
        	garen.attackHero(teemo);
        }
        catch(EnemyHeroIsDeadException e)
        {
        	System.out.println("Exception reason: " + e.getMessage());
            e.printStackTrace();
        }

	}

}
