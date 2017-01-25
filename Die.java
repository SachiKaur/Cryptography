/**
 * @(#)Die.java
 *
 *
 * @author 
 * @version 1.00 2015/10/7
 */

public class Die {
    // class data
     
    private int value;
    private int faces = 6;   
       
        
    /**
     * Creates a new instance of <code>Die</code>.
     */
    public Die() {
     rollDie();
    }
    
    public Die (int sides){
     faces = sides;
     rollDie();
    }
    
    public void rollDie(){
     value = (int)(Math.random() * faces + 1);     
    }
    
    public int getValue(){
     return value;
    }
    
    public boolean compareToMe (Die anotherDie)
    {
      return (value == anotherDie.getValue());     
    }
    
    /**
     * @param args the command line arguments
     * Self Testing purposes
     */
    public static void main(String[] args) {
        
        Die d = new Die();
        
        System.out.println(d.getValue());
        
        d.rollDie();
        
        System.out.println(d.getValue());
        
        Die d1 = new Die (7);
        
        System.out.println(d1.getValue());
        
        d1.rollDie();
        
        System.out.println(d1.getValue());
        
        System.out.println (d1.compareToMe (d));
        
    }
}
