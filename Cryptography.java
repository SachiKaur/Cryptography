import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import javax.swing.JComboBox;
import java.lang.Object;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
public class Cryptography extends JFrame implements ActionListener {
  
  private Picture pic1;
  private JLabel lblin,lblstart,lblout;
  private JTextArea in,out;
  private JTextPane startEnter;
  private String startString [], settingStr [], ascii [],letter;
  private JButton enter,clear,copy;
  private JList settingList;
  private JScrollPane scroller,scroller1;
  private int cipher [];
  private Die d;
  private int start, num;
  private String output;
  private int selected;
  public Cryptography() { 
    super ("Cryptography");
    
    letter = "";
    output = "";
    start = 0;
    num = 0;
    try
    {
      pic1 =  new Picture(new ImageIcon(ImageIO.read(getClass().getResource("encryption.png"))),0,0);
      pic1.setBounds (0,0,1366,768); //Initailizing the pictures/buttons and putting it into a certain location
    }
    catch (Exception d)
    {
    }
    
    String settingStr [] = {" Encrypt "," Decrypt "};
    settingList = new JList(settingStr); //data has type Object[]
    settingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    settingList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    settingList.setVisibleRowCount(1);
    settingList.setFont(settingList.getFont().deriveFont(20.0f));
    settingList.setBounds(1000,50,176,28);
    settingList.setSelectedIndex(0);
    
    lblin = new JLabel ("Input Text:");
    lblin.setFont(new Font("Serif", Font.PLAIN, 20));
    lblin.setBounds (235,50,500,50);
    lblin.setForeground(Color.BLUE);
    
    in = new JTextArea ();
    in.setBounds (60,125,1240,100);
    
    
    lblout = new JLabel ("Output Text:");
    lblout.setFont(new Font("Serif", Font.PLAIN, 20));
    lblout.setBounds (235,433,500,50);
    lblout.setForeground(Color.BLUE);
    
    out = new JTextArea ();
    out.setBounds (60,508,1240,100);
    
    in.setLineWrap(true);
    in.setWrapStyleWord(true);
    scroller = new JScrollPane(in); //Adding a scroller to the JTextArea and setting its location
    scroller.setBounds (60,125,1240,100);
    
    out.setLineWrap(true);
    out.setWrapStyleWord(true);
    
    scroller1 = new JScrollPane(out); //Adding a scroller to the JTextArea and setting its location
    scroller1.setBounds (60,508,1240,100);
    
    lblstart = new JLabel ("Enter a number (0 - 93):");
    lblstart.setFont(new Font("Serif", Font.PLAIN, 20));
    lblstart.setBounds (180,315,500,50);
    lblstart.setForeground(Color.BLUE);
    
    startEnter = new JTextPane ();
    startEnter.setFont(new Font("Serif", Font.PLAIN, 30));
    startEnter.setBounds (525,319,35,50);
    
    enter = new JButton ("Enter");
    enter.setBounds (1100,250,200,50);
    
    copy = new JButton ("Copy");
    copy.setBounds (1100,633,200,50);
    
    clear = new JButton ("Clear");
    clear.setBounds (850,250,200,50);
    
    add (copy);
    add (lblout);
    add (scroller1);
    add (settingList);
    add (enter);
    add (clear);
    add (startEnter);
    add (lblstart);
    add (scroller);
    add (lblin);
    add (pic1);
    
    ascii = new String [ArrayLibrary.countLines("Ascii.txt")];
    cipher = new int [10000];
    ArrayLibrary.uploadFile ("Ascii.txt",ascii);
    
    copy.addActionListener (this);
    clear.addActionListener (this);
    enter.addActionListener (this);
    setResizable (false);
    setSize(1366,768);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);    
  }
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == clear)
    {
      in.setText(""); 
    }
    else if (e.getSource() == copy)
    {
      StringSelection selection = new StringSelection(out.getText());
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(selection, selection);
    }
    else if (e.getSource() == enter)
    {
      output = "";
      if (settingList.getSelectedIndex() == 0)
      {
        Die d = new Die(5);
        d.rollDie();
        ArrayLibrary.uploadFile("C" + d.getValue() + ".txt", cipher);
        start = ArrayLibrary.linearSearch (cipher,Integer.parseInt(startEnter.getText()));
        for (int i = 0; i < in.getText().length(); i++)
        {
          num = ArrayLibrary.linearSearch(ascii,Character.toString((in.getText()).charAt(i)));
          //JOptionPane.showMessageDialog (null, num);
          int number = num + cipher[start];
          number = decrease (number);
          letter = ascii [number];
          output = output + letter;
          start++;
        }
        out.setText(output + d.getValue());        
      }
      else
      {
        int encrypt = in.getText().length();
        int filenum = Integer.parseInt(Character.toString((in.getText()).charAt(encrypt - 1)));
        ArrayLibrary.uploadFile("C" + filenum + ".txt", cipher);
        start = ArrayLibrary.linearSearch (cipher,Integer.parseInt(startEnter.getText()));
        String txt = (in.getText()).substring (0, encrypt - 1);
        for (int i = 0; i < txt.length(); i++)
        {
          num = ArrayLibrary.linearSearch(ascii,Character.toString(txt.charAt(i)));
          //JOptionPane.showMessageDialog (null, num);
          int number = num - cipher[start];
          number = increase (number);
          letter = ascii [number];
          output = output + letter;
          start++;
        }
        out.setText(output); 
        
      }
    }
  }
  public int decrease (int number)
  {
    if (number > 94)
    {
      number = number - 94; 
      decrease (number);
    }
    return number;
  }
  public int increase (int number)
  {
    if (number < 0)
    {
      number = number + 94; 
      increase (number);
    }
    return number;
  }
  public static void main(String[] args) { 
    Cryptography myGui = new Cryptography();
  }
  
  /* ADD YOUR CODE HERE */
  
}
