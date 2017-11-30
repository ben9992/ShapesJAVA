/**
 * DrawPanel.java
 * Program that uses classes MyLine, MyOval and MyRectangle to draw random shapes.
 * @author Ben Mishali
 * @extends Jpanel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class DrawPanel extends JPanel {
   private MyShape shapes[] = new MyShape[MAXSHAPES]; // array of Shapes
   private int x1, y1, x2, y2, x1_moved, y1_moved, index;
   private Color currentColor;
   private String currentType;
   private boolean currentFilled;
   private MyShape currentShape;
   private JLabel statusLabelTemp;
   private JFrame tempFrameThis;
   private static final int MAXSHAPES =100;




   public DrawPanel(JLabel statusLabel, JFrame frameThis) {
      currentFilled = false;
      currentType = "Line";
      currentColor = Color.black;
      currentShape = new MyLine(x1, y1, x2, y2, currentColor);
      this.addMouseListener(myMouseAdapter);
      this.addMouseMotionListener(myMouseAdapter);
      statusLabelTemp = statusLabel;
      tempFrameThis = frameThis;

   }


   public void addShapeToArr() {
            shapes[index] = currentShape;
            index++;
   }
    /**
     * The method used for initializes our Mouse Adapter actions
     * by overriding this method.
     * <p>
     * This method adds an anonymous MouseAdapter to
     * the returned MouseAdapter.
     * also uses {@link MouseAdapter} to take only the events that we needs like {@link #addMouseListener(MouseListener)} and {@link #addShapeToArr()} ...
     * to add this Shape to the array of shapes
     */
   MouseAdapter myMouseAdapter = new MouseAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
         if (isLeftMouseButton(e) == true) {
               x2 = e.getX();
               y2 = e.getY();

            statusLabelTemp.setText("(" + x2 + "," + y2 + ")");
            switch (currentType) {
               case "Oval": //Oval Type
                  currentShape = new MyOval(x1, y1, x2, y2, currentColor, currentFilled);

                  break;
               case "Rectangle": // Rect Type
                  currentShape = new MyRectangle(x1, y1, x2, y2, currentColor, currentFilled);

                  break;
               case "Line": // Line Type
                  currentShape = new MyLine(x1, y1, x2, y2, currentColor);

                  break;
            }
            repaint();
         }
      }
      @Override
      public void mouseMoved(MouseEvent e) {
         x1_moved = e.getX();
         y1_moved = e.getY();
         statusLabelTemp.setText("(" + x1_moved + "," + y1_moved + ")");

      }

      @Override
      public void mouseReleased(MouseEvent e) {
         try {//cannot be happened but maybe for the future
            if (isLeftMouseButton(e) == true && x1 != e.getX() && y1 != e.getY()) {
                  addShapeToArr();
                  currentShape = null;
                  repaint();
            }
      }
         catch (ArrayIndexOutOfBoundsException ex) {
            index--;
            repaint();
         }
      }

      @Override
      public void mousePressed(MouseEvent e) {
         //If left button pressed
         if (isLeftMouseButton(e) == true) {
            if(index<MAXSHAPES) {
               x1 = e.getX();
               y1 = e.getY();
            }
            else {
               JOptionPane.showMessageDialog(tempFrameThis,String.format("Cannot exceed the current number of shapes: %d",index),"Capacity Overload",JOptionPane.WARNING_MESSAGE);
            }
         }

      }
   };
   /**
    *set the Index of the array of shapes that needs to draw.
    * @param index
    */
   public void setIndex(int index) {
      this.index = index;
   }
   /**
    *Get the Index of the array of shapes that needs to draw.
    */
   public int getIndex() {
      return this.index;
   }
   /**
    *set the Drawing Shape that needs to draw.
    * @param shape
    */
   public void setDrawingShape(String shape) {
      this.currentType = shape;
   }
   /**
    *set the Drawing Color for the shape that needs to draw.
    * @param color
    */
   public void setDrawingColor(Color color) {
      this.currentColor = color;
   }
   /**
    *set the Filled or not for the shape that needs to draw.
    * @param filled
    */
   public void setFilled(boolean filled) {
      this.currentFilled = filled;
   }
   /**
    *set the Current Shape that needs to draw.
    * @param currentShape
    */
   public void setCurrentShape(MyShape currentShape) {
      this.currentShape = currentShape;
   }

   /**
    *uses the override of the paintComponent function that uses Graphics to draw on our JPanel
    * @param g
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int i=0;i<index;i++)
         if (shapes[i] != null) {
            shapes[i].draw(g);
         }
      if(currentShape!=null)
         currentShape.draw(g);
      } // end method paintComponent
   } // end class DrawPanel

