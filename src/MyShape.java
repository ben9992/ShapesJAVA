/**
 * MyShape.java
 * Declaration of abstract class MyShape.
 * @author Ben Mishali
 */
import java.awt.*;

public abstract class MyShape
{
    private int x1; // x coordinate of first endpoint
    private int y1; // y coordinate of first endpoint
    private int x2; // x coordinate of second endpoint
    private int y2; // y coordinate of second endpoint
    private Color myColor; // color of this shape

    /**
     *constructor initializes private variables with default values
     */
    public MyShape()
    {
        this(0,0,0,0,Color.black);
    }
    /**
     *constructor initializes private variables with random values
     * @param x1
     * @param myColor
     * @param x2
     * @param y1
     * @param y2
     */
    public MyShape(int x1, int y1, int x2, int y2, Color myColor) {
        setX1(x1); // set x coordinate of first endpoint
        setY1(y1); // set y coordinate of first endpoint
        setX2(x2); // set x coordinate of second endpoint
        setY2(y2); // set y coordinate of second endpoint
        setColor(myColor); // set the color

    }
    /**
     *set the x-coordinate of the first point
     * @param x1
     */
    public void setX1(int x1)
    {
        this.x1 = (x1 >= 0 ? x1 : 0);
    } // end method setX1
    /**
     *get the x-coordinate of the first point
     * @return x1
     */
    public int getX1()
    {
        return x1;
    } // end method getX1
    /**
     *set the x-coordinate of the second point
     * @param x2
     */
    public void setX2(int x2)
    {
        this.x2 = (x2 >= 0 ? x2 : 0);
    } // end method setX2
    /**
     *get the x-coordinate of the second point
     * @return x2
     */
    public int getX2()
    {
        return x2;
    } // end method getX2
    /**
     *set the y-coordinate of the first point
     * @param y1
     */
    public void setY1(int y1)
    {
        this.y1 = (y1 >= 0 ? y1 : 0);
    } // end method setY1
    /**
     *get the y-coordinate of the first point
     * @return y1
     */
    public int getY1()
    {
        return y1;
    } // end method getY1
    /**
     *set the y-coordinate of the second point
     * @param y2
     */

    public void setY2(int y2)
    {
        this.y2 = (y2 >= 0 ? y2 : 0);
    } // end method setY2
    /**
     *get the y-coordinate of the second point
     * @return y2
     */

    public int getY2()
    {
        return y2;
    } // end method getY2
    /**
     *set the color
     * @param myColor
     */
    public void setColor(Color myColor)
    {
        this.myColor = myColor;
    } // end method setColor
    /**
     *get the color
     * @return myColor
     */

    public Color getColor()
    {
        return myColor;
    } // end method getColor
    /**
     * an abstract class to draw in the specified color
     * @param g
     * @return void
     */
    public abstract void draw(Graphics g);
}
