/**
 * MyOval.java
 * Declaration of class MyOval.
 * @author Ben Mishali
 * @extends MyBoundedShape
 */
import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape
{
   /**
    *constructor initializes private variables with default values
    */
   public MyOval()
   {
      this(0, 0, 0, 0, Color.BLACK,false); // call constructor
   } // end MyOval no-argument constructor
   /**
    *constructor initializes private variables with random values
    */
   public MyOval(int x1, int y1, int x2, int y2, Color myColor, boolean filled)
   {
      super.setX1(x1); // set x coordinate of first endpoint
      super.setY1(y1); // set y coordinate of first endpoint
      super.setX2(x2); // set x coordinate of second endpoint
      super.setY2(y2); // set y coordinate of second endpoint
      super.setColor(myColor); // set the color
      super.setFilled(filled);
   }
   /**
    * draws an oval in the specified color
    * @param g
    * @return void
    */
   public void draw(Graphics g)
   {
      g.setColor(getColor());

      if (isFilled())
         g.fillOval(getUpperLeftX(), getUpperLeftY(),
                 getWidth(), getHeight());
      else
         g.drawOval(getUpperLeftX(), getUpperLeftY(),
                 getWidth(), getHeight());
   } // end method draw

} // end class MyOval
