import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplicationWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel toolsPanel;
    private JPanel graphicsPanelToolsPanel;
    private GraphicsPanel graphicsPanel;
    private JSlider gridSizeSlider;
    private JButton clearGridButton;

    private JPanel placeObjectsPanel;
    private JLabel placeObjectsLabel;
    private JPanel placeObjectsButtonsPanel;
    private JButton placeWallButton;
    private JButton placeGuyButton;
    private JButton placeGoalButton;

    private JPanel setRangePanel;
    private JLabel setRangeLabel;
    private JPanel setRangeSliderPanel;
    private JSlider setRangeSlider;
    private JLabel setRangeSliderValueLabel;

    private JPanel displayPanel;
    private JLabel displayLabel;
    private JPanel showButtonsPanel;
    private JButton showSearchButton;
    private JButton showPathButton;

    private JPanel moveToGoalButtonPanel;
    private JButton moveToGoalButton;

    private final int panelMargin = 50;

    public MainApplicationWindow(){


        //Set up the main Panel.
        //This has a two colum grid layout with the graphics panel on the left and the tools panel on the right
        GridLayout MainPanelLayout = new GridLayout(0, 2);
        mainPanel = new JPanel();
        mainPanel.setLayout(MainPanelLayout);


        //Set up the left panel. Border layout with thhe graphics window at the top and the tools at the bottom
        BorderLayout leftSideLayout = new BorderLayout();
        leftPanel = new JPanel();
        leftPanel.setLayout(leftSideLayout);
        graphicsPanel = new GraphicsPanel();
        leftPanel.add(graphicsPanel, BorderLayout.NORTH);

        GridLayout graphicsPanelToolsPanelLayout = new GridLayout(0, 2);
        graphicsPanelToolsPanel = new JPanel();
        graphicsPanelToolsPanel.setLayout(graphicsPanelToolsPanelLayout);

        gridSizeSlider = new JSlider();
        gridSizeSlider.setMinimum(2);
        gridSizeSlider.setMaximum(graphicsPanel.getGrid().getMaxCells());
        gridSizeSlider.setValue(graphicsPanel.getGrid().getCurrentGridSize());
        gridSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Grid size slider changed " + gridSizeSlider.getValue());
                graphicsPanel.setGridSize(gridSizeSlider.getValue());
            }
        });

        graphicsPanelToolsPanel.add(gridSizeSlider);

        clearGridButton = new JButton("Clear");
        clearGridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicsPanel.clearGrid();
                System.out.println("Clear grid button pressed");
            }
        });


        graphicsPanelToolsPanel.add(clearGridButton);

        graphicsPanelToolsPanel.setMaximumSize(new Dimension(graphicsPanel.getPanelWidth(), 20));


        leftPanel.add(graphicsPanelToolsPanel, BorderLayout.SOUTH);

        mainPanel.add(leftPanel);

        GridLayout toolsPanelLayout = new GridLayout(0, 1);
        toolsPanelLayout.setVgap(panelMargin);
        toolsPanel = new JPanel();
        toolsPanel.setLayout(toolsPanelLayout);

        BorderLayout placeObjectsPanelLayout = new BorderLayout();
        placeObjectsPanel = new JPanel();
        placeObjectsPanel.setLayout(placeObjectsPanelLayout);

        placeObjectsLabel = new JLabel();
        placeObjectsLabel.setText("Place Objects:");

        placeObjectsPanel.add(placeObjectsLabel, BorderLayout.NORTH);

        GridLayout placeObjectsButtonsPanelLayout = new GridLayout(0, 3);
        placeObjectsButtonsPanel = new JPanel();
        placeObjectsButtonsPanel.setLayout(placeObjectsButtonsPanelLayout);

        placeWallButton = new JButton("Walls");
        placeWallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Place wall button pressed");
                graphicsPanel.setBrush(CellType.CELL_BLOCKED);
            }
        });
        placeObjectsButtonsPanel.add(placeWallButton);

        placeGuyButton = new JButton("Guy");
        placeGuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Place guy button pressed");
                graphicsPanel.setBrush(CellType.CELL_GUY);
            }
        });
        placeObjectsButtonsPanel.add(placeGuyButton);

        placeGoalButton = new JButton("Goal");
        placeGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Place goal button pressed");
                graphicsPanel.setBrush(CellType.CELL_GOAL);
            }
        });
        placeObjectsButtonsPanel.add(placeGoalButton);
        placeObjectsPanel.add(placeObjectsButtonsPanel, BorderLayout.SOUTH);

        //placeObjectsPanel.setBorder(BorderFactory.createEmptyBorder(panelMargin, 0, panelMargin, 0));

        toolsPanel.add(placeObjectsPanel);


        /*
            private JPanel setRangePanel;
    private JLabel setRangeLabel;
    private JPanel setRangeSliderPanel;
    private JSlider setRangeSlider;
    private JLabel setRangeSliderValueLabel;

         */

        BorderLayout setRangePanelLayout = new BorderLayout();
        setRangePanel = new JPanel();
        setRangePanel.setLayout(setRangePanelLayout);

        setRangeLabel = new JLabel("Set Move Range:");
        setRangePanel.add(setRangeLabel, BorderLayout.NORTH);

        GridLayout setRangeSliderPanelLayout = new GridLayout(0,2);
        setRangeSliderPanel = new JPanel();
        setRangeSliderPanel.setLayout(setRangeSliderPanelLayout);

        setRangeSlider = new JSlider();
        setRangeSlider.setMinimum(2);
        setRangeSlider.setMaximum(graphicsPanel.getGrid().getCurrentGridSize());

        setRangeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setRangeSliderValueLabel.setText(Integer.toString(setRangeSlider.getValue()));
                System.out.println("Set range slider changed " + setRangeSlider.getValue());
            }
        });
        setRangeSliderPanel.add(setRangeSlider);

        setRangeSliderValueLabel = new JLabel();
        setRangeSliderValueLabel.setText(Integer.toString(setRangeSlider.getValue()));
        setRangeSliderPanel.add(setRangeSliderValueLabel);

        setRangePanel.add(setRangeSliderPanel, BorderLayout.SOUTH);
        toolsPanel.add(setRangePanel);

        /*
            private JPanel displayPanel;
    private JLabel displayLabel;
    private JPanel showButtonsPanel;
    private JButton showSearchButton;
    private JButton showPathButton;
         */

        BorderLayout displayPanelLayout = new BorderLayout();
        displayPanel = new JPanel();
        displayPanel.setLayout(displayPanelLayout);

        displayLabel = new JLabel("Disply Mode: ");
        displayPanel.add(displayLabel, BorderLayout.NORTH);

        GridLayout displayButtonsPanelLayout = new GridLayout(0, 2);
        showButtonsPanel = new JPanel();
        showButtonsPanel.setLayout(displayButtonsPanelLayout);

        showSearchButton = new JButton ("Show Search");
        showSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show search results button pressed");
            }
        });

        showButtonsPanel.add(showSearchButton);

        showPathButton = new JButton("Show Path");
        showPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show path button pressed");
            }
        });

        showButtonsPanel.add(showPathButton);


        displayPanel.add(showButtonsPanel, BorderLayout.SOUTH);
        toolsPanel.add(displayPanel);


        BorderLayout moveToGoalButtonPanelLayout = new BorderLayout();
        moveToGoalButtonPanel = new JPanel();
        moveToGoalButtonPanel.setLayout(moveToGoalButtonPanelLayout);

        moveToGoalButton = new JButton("Move to Goal!");

        moveToGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Move to goal button pressed");
            }
        });

        moveToGoalButtonPanel.add(moveToGoalButton, BorderLayout.SOUTH);

        toolsPanel.add(moveToGoalButtonPanel);


        toolsPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        //toolsPanel.setVG

        /*
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanel.add(new JButton("Button 1"));
        toolsPanel.add(new JButton("Button 2"));
        toolsPanel.add(new JButton("Button 3"));
        toolsPanel.add(new JButton("Button 4"));
        toolsPanel.add(new JButton("Button 5"));
        toolsPanel.add(new JButton("Button 6"));
        */

        mainPanel.add(toolsPanel);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

    }


    public static void main (String[] args){
        MainApplicationWindow mainApplicationWindow = new MainApplicationWindow();
    }

}
