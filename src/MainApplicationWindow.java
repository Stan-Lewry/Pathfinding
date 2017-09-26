import javax.swing.*;
import java.awt.*;

public class MainApplicationWindow extends JFrame {

    public MainApplicationWindow(){
        GridLayout MainPanelLayout = new GridLayout(0, 2);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(MainPanelLayout);

        GraphicsPanel graphicsPanel = new GraphicsPanel();
        mainPanel.add(graphicsPanel);

        GridLayout toolsPanelLayout = new GridLayout(0, 1);
        JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanel.add(new JButton("Button 1"));
        toolsPanel.add(new JButton("Button 2"));
        toolsPanel.add(new JButton("Button 3"));
        toolsPanel.add(new JButton("Button 4"));
        toolsPanel.add(new JButton("Button 5"));
        toolsPanel.add(new JButton("Button 6"));
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
