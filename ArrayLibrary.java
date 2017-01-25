import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class ArrayLibrary  {
  
  public static int linearSearch (int array [], int searchKey) //Asks for array from LoginRecord and what the user wants to search
  {
    for (int i = 0; i< array.length; i++)
    {
      if (searchKey == array[i]) //If what the user want to search is the same as that element than it returns where it is in the array
      {
        return i; 
      }
    }
    return 0; //If it can not find what the user wants to search then it returns -1
  }
   public static int linearSearch (String array [],String searchKey) //Asks for array from LoginRecord and what the user wants to search
  {
    for (int i = 0; i< array.length; i++)
    {
      if (searchKey.equals(array[i])) //If what the user want to search is the same as that element than it returns where it is in the array
      {
        return i; 
      }
    }
    return 0; //If it can not find what the user wants to search then it returns -1
  }
  public static void uploadFile (String inFile,String array []) //method to break the line in the student txt file
  {
    try
    { 
      BufferedReader fr = new BufferedReader(new FileReader(inFile)); //Opens the file
      
      for (int i = 0; i < ArrayLibrary.countLines(inFile); i++)
      {
        array[i] = fr.readLine();
      }
      fr.close (); //Closes the file
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog (null, e.toString());
      JOptionPane.showMessageDialog (null,"Error: 1");
    }
  }
    public static void uploadFile (String inFile,int array []) //method to break the line in the student txt file
  {
    try
    { 
      BufferedReader fr = new BufferedReader(new FileReader(inFile)); //Opens the file
      
      for (int i = 0; i < ArrayLibrary.countLines(inFile); i++)
      {
        array[i] = Integer.parseInt(fr.readLine());
      }
      fr.close (); //Closes the file
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog (null, e.toString());
      JOptionPane.showMessageDialog (null,"Error: 2");
    }
  }
    public static int countLines (String infile) //Count the number of lines in a txt file
  {
    int size = 0;
    try
    { 
      BufferedReader fr = new BufferedReader(new FileReader(infile));//opens file
      while (fr.readLine() != null)
      { 
        size++; //Adding 1 to size if the string is not null
      }
      fr.close();
      return size; //Returning the size of the array
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog (null, e.toString());
      JOptionPane.showMessageDialog (null,"Error: 3");
    }
    
    return size;
  }
  public static void main(String[] args) {  //Self Testing
   
  }
}

