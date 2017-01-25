/**
 * @(#)Picture.java
 *
 *
 * @author 
 * @version 1.00 2015/11/4
 */
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
public class Picture extends JComponent {
  
  // class data  or instance variables
  private Color c;
  private ImageIcon pic;
  private boolean picture;  
  private String txt;
  private int xSide;
  private int ySide;
  private boolean rectangles,resizeImg ;
  private int i;
  private int j;
  private int width;
  private int length;
  private String font;
  private int size;
  private Font setting;
  
  /**
   * Creates a new instance of <code>Picture</code>.
   */
  public Picture() {
    this.c = Color.RED;
    this.pic = null;
    this.picture = false;
    this.txt = "";
    repaint();
    rectangles = false;
    this.resizeImg = false;
  }
  
  public Picture(ImageIcon i, int x, int y){
    this.c = Color.RED;
    this.pic = i;
    this.picture = true;
    this.txt = "";
    rectangles = false;
    xSide = x;
    ySide = y;
    repaint();    
  }
  
  public Picture (String str, String font, int x, int y, int size)
  {
    this.c = Color.RED;
    this.pic = null;
    this.picture = false;
    this.txt = str;
    rectangles = false;
    xSide = x;
    ySide = y;
    repaint ();
    this.size = size;
    repaint();
  }
  public Picture(int x, int y, int width, int length) {
    this.c = Color.RED;
    this.pic = null;
    this.picture = false;
    this.txt = "";
    rectangles = true;
    this.width = width;
    this.length = length;
    xSide = x;
    ySide = y;
    repaint();
  }
  
  public void paint (Graphics g){
    if (this.picture){
      this.pic.paintIcon(this, g, xSide, ySide);
    }
    else if (!this.txt.equals ("")) 
    {
      Font trbi = new Font(font, Font.PLAIN, this.size);
      g.setFont (trbi);
      g.setColor (this.c);
      g.drawString(txt, xSide,ySide);
    }
    else if (rectangles == true)
    {
      g.setColor (this.c);   
      g.fillRect (xSide, ySide, width, length);
    }
    else {
      g.setColor (this.c);
      g.drawRect(110,10, 200, 50);
      g.drawOval (110,10, 200, 50);
      g.fillOval (185,10, 50, 50);
    }
    
  }
  public void changeFont (String font, int size)
  {
    Picture n = new Picture (this.txt,font,this.xSide, this.ySide, size);
    this.size = size;
  }
  public void resetColor(Color col){
    this.c = col;
    repaint();
  }
  
  public void resetColor (int r, int g, int b){
    this.c = new Color (r, g, b);
    repaint();
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Self testing method
    
    JFrame f = new JFrame("Testing");
    
    Picture p = new Picture();
    
    f.add(p);
    f.setSize(400, 150);
    f.setVisible(true);
    
    JOptionPane.showMessageDialog (null, "Wait");
    p.resetColor(Color.BLUE);
    
    JOptionPane.showMessageDialog (null, "Wait");
    p.resetColor(0,0,0);
    
    JOptionPane.showMessageDialog (null, "Wait");
    
    Picture p1 = new Picture (0, 0,20,50);
    JOptionPane.showMessageDialog (null, "Wait");
    p1.resetColor(Color.YELLOW);
    
    f.remove(p);
    
    f.add(p1);
    f.setVisible(true);
    
    f.remove(p);
    Picture pd = new Picture("Sachi is awesome", "TimesRoman", 180, 30, 20);
    pd.changeFont ("Dialog", 20);
    f.add(pd);
    
    
    f.setVisible(true);
  }
}
