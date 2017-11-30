import javax.swing.*;
import java.awt.*;

/**
 * TestDraw.java
 * Program that test our program and set the settings of the {@link JFrame} - also hold the main function
 * @author Ben Mishali
 */
public class TestDraw
{
   public static void main(String[] args)
   {
       DrawFrame frame = new DrawFrame();
       frame.setTitle("Shape Drawings");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500, 500);
       frame.getContentPane().setBackground(Color.white);
       frame.setVisible(true);
   }// end main
} // end class TestDraw