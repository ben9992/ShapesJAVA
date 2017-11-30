/**
 * DrawJFrame.java
 * {@link JFrame} uses J-Objects -> {@link JButton},{@link JComboBox},{@link JCheckBox} and {@link JLabel} with {@link JPanel} to set the GUI.
 * also uses {@link Color} to set array of colors, {@link string} to set array of Colors names and Shapes names
 * @extends {@link JFrame}.
 * @author Ben Mishali
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawFrame extends JFrame {
    private JButton undoButton;
    private JButton clearButton;
    private JComboBox<String> colorChoices;
    private JComboBox<String> shapeChoices;
    private JCheckBox filledCheckBox;
    private JLabel statusLabel=new JLabel("(" + 0 + "," + 0 + ")");
    private JPanel upperMenu;
    private Color[] myColors = new Color[13];
    private static final String shapesNames[] = {"Line","Oval","Rectangle"};
    private String[] colorsName = new String[13];
    private DrawPanel panel=new DrawPanel(statusLabel,this);

    /**
     *constructor initializes the GUI with setGUI function
     */
    public DrawFrame() {
        setGUI();
    }
    /**
     *initializes our menus, buttons, panel & labeltext
     */
    public void setGUI() {
        initMenus();
        initButtons();
       colorsName= initColors();
        statusLabel.setOpaque(true);
        upperMenu.add(undoButton);
        upperMenu.add(clearButton);
        upperMenu.add(colorChoices);
        upperMenu.add(shapeChoices);
        upperMenu.add(filledCheckBox);
        this.add(upperMenu,BorderLayout.NORTH);
        this.add(statusLabel,BorderLayout.SOUTH);
        this.add(panel,BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }
    /**
     *initializes our menus like buttons and filled Check Box
     */
    public void initMenus()
    {
        upperMenu = new JPanel();
        filledCheckBox = new JCheckBox("filled");
        undoButton = new JButton("Undo");
        clearButton = new JButton("Clear");
        initComboCheck();
    }
    /**
     *initializes our ComboCheck menus - one of colors & one for shapes
     *also uses {@link ItemListener} and {@link ActionListener} to set {@link JComboBox} and {@link JCheckBox}  events.
     */

    public void initComboCheck() {
        colorChoices = new JComboBox<String>(initColors());
        shapeChoices = new JComboBox<String>(shapesNames);
        colorChoices.setMaximumRowCount(8);
        colorChoices.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            panel.setDrawingColor(myColors[colorChoices.getSelectedIndex()]);
                        }

                    }
                } // end anonymous inner class
        ); // end call to addItemListener
        shapeChoices.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                                    panel.setDrawingShape(shapesNames[shapeChoices.getSelectedIndex()]);
                        }
                    }
                } // end anonymous inner class
        ); // end call to addItemListener
        filledCheckBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (filledCheckBox.isSelected())
                            panel.setFilled(true);
                        else
                            panel.setFilled(false);
                    }
                }
        );
    }
    /**
     *initializes our Buttons
     *also uses {@link ActionListener} to set {@link JButton} events.
     */
    public void initButtons() {
        undoButton.addActionListener(
                new ActionListener()
                {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(panel.getIndex()!=0) {
                    panel.setIndex(panel.getIndex() - 1);
                    panel.repaint();
                }
            }
        }
        );
        clearButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        panel.setIndex(0);
                        panel.setCurrentShape(null);
                        panel.repaint();
                    }
                }
        );


    }

    /**
     *indexing our arrays of colors names and Colors Objects
     *also uses {@link ActionListener} to set {@link JButton} events.
     */
    private final String[] initColors() {
        String names[] = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
        myColors[0]= new Color(0,0,0); //Black
        myColors[1]= new Color(0,0,255); //Blue
        myColors[2]= new Color(0,255,255); //Cyan
        myColors[3]= new Color(169,169,169); //Dark Gray
        myColors[4]= new Color(128,128,128); //Gray
        myColors[5]= new Color(0,128,0); //Green
        myColors[6]= new Color(211,211,211); //Light Gray
        myColors[7]= new Color(255,0, 255); //Magenta
        myColors[8]= new Color(255, 165,0); //Orange
        myColors[9]= new Color(255, 192, 203); //Pink
        myColors[10]= new Color(255,0,0); //Red
        myColors[11]= new Color(255, 255, 255); //White
        myColors[12]= new Color(255, 255,0); //Yellow
        return names;
    }
}
