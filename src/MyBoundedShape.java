/**
 * MyBoundedShape.java
 * abstract class that uses classes MyOval and MyRectangle as Bounded shapes.
 * @author Ben Mishali
 * @extends MyShape
 */
import java.awt.*;
public abstract class MyBoundedShape extends MyShape
{
    private boolean filled; // whether this shape is filled
    /**
     *constructor initializes private variables with default values
     */
    public MyBoundedShape()
    {
        super(0, 0, 0, 0, Color.BLACK); // call constructor
        this.filled = false;
    } // end MyOval no-argument constructor
    /**
     *constructor initializes private variables with random values
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color myColor, boolean filled) {
        super.setX1(x1); // set x coordinate of first endpoint
        super.setY1(y1); // set y coordinate of first endpoint
        super.setX2(x2); // set x coordinate of second endpoint
        super.setY2(y2); // set y coordinate of second endpoint
        super.setColor(myColor); // set the color
        this.filled = filled;
    }

    // get upper left x coordinate
    public int getUpperLeftX()
    {
        return Math.min(getX1(), getX2());
    } // end method getUpperLeftX

    // get upper left y coordinate
    public int getUpperLeftY()
    {
        return Math.min(getY1(), getY2());
    } // end method getUpperLeftY

    // get shape width
    public int getWidth()
    {
        return Math.abs(getX2() - getX1());
    } // end method getWidth

    // get shape height
    public int getHeight()
    {
        return Math.abs(getY2() - getY1());
    } // end method getHeight

    // determines whether this shape is filled
    public boolean isFilled()
    {
        return filled;
    } // end method isFilled

    // sets whether this shape is filled
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    } // end method setFilled



}
