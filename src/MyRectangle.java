/**
 * MyRectangle.java
 * Declaration of class MyRectangle.
 * @author Ben Mishali
 * @extends MyBoundedShape
 */
import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape
{
   /**
    *constructor initializes private variables with default values
    */
   public MyRectangle()
   {
      this(0, 0, 0, 0, Color.BLACK,false); // call constructor
   } // end MyOval no-argument constructor
   /**
    *constructor initializes private variables with random values
    */
   public MyRectangle(int x1, int y1, int x2, int y2, Color myColor, boolean filled)
   {
      setX1(x1); // set x coordinate of first endpoint
      setY1(y1); // set y coordinate of first endpoint
      setX2(x2); // set x coordinate of second endpoint
      setY2(y2); // set y coordinate of second endpoint
      setColor(myColor); // set the color
      setFilled(filled);
   }

   /**
    * draws an rect in the specified color
    * @param g
    * @return void
    */
   public void draw(Graphics g)
   {
      g.setColor(getColor());

      if (isFilled())
         g.fillRect(getUpperLeftX(), getUpperLeftY(),
                 getWidth(), getHeight());
      else
         g.drawRect(getUpperLeftX(), getUpperLeftY(),
                 getWidth(), getHeight());
   } // end method draw
} // end class MyRectangle
