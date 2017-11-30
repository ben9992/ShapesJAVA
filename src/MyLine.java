/**
 * MyLine.java
 * Declaration of class MyLine.
 * @author Ben Mishali
 * @extends MyShape
 */
import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{
   /**
    *constructor initializes private variables with default values
    */
   // constructor initializes private variables with default values
   public MyLine()
   {
      super(0, 0, 0, 0, Color.BLACK); // call constructor to set values
   } // end MyLine no-argument constructor
   /**
    *constructor initializes private variables with random values
    */
   // constructor with input values
   public MyLine(int x1, int y1, int x2, int y2, Color color)
   {
      super(x1,y1,x2,y2,color);
   } // end MyLine constructor





   /**
    * draws an line in the specified color
    * @param g
    * @return void
    */
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      g.drawLine(getX1(), getY1(), getX2(), getY2());
   } // end method draw
} // end class MyLine
