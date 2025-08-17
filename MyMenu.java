import javax.swing.*;
import java.awt.*;

 class MyMenu extends JFrame {
    private JButton buttonStart, buttonExit;
    private JPanel panelCenter, panelNorth;
    private JLabel label;

    public MyMenu() {
        setTitle("Gas Volume Analyzer (2D Grid)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setUndecorated(false); 

        
        panelCenter = new JPanel(null);
        panelCenter.setBackground(new Color(205, 180, 219));

            panelNorth = new JPanel();
            panelNorth.setPreferredSize(new Dimension(150, 150))    ;
            panelNorth.setBackground(new Color(255, 200, 221));

                label = new JLabel("Gas");
                label.setFont(new Font("Tahoma", Font.PLAIN, 100));
                panelNorth.add(label);

                    panelCenter = new JPanel();
                    panelCenter.setBackground(new Color(205, 180, 219));
                    panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

                    panelCenter.add(Box.createVerticalGlue());

                        buttonStart = new JButton("Start");
                        buttonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
                        buttonStart.setPreferredSize(new Dimension(400, 120));
                        buttonStart.setMaximumSize(new Dimension(400, 120));
                        panelCenter.add(buttonStart);

                            panelCenter.add(Box.createVerticalStrut(30));

                            buttonExit = new JButton("Exit");
                            buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
                            buttonExit.setPreferredSize(new Dimension(400, 120));
                            buttonExit.setMaximumSize(new Dimension(400, 120));
                            panelCenter.add(buttonExit);
                    
                                panelCenter.add(Box.createVerticalGlue());

                                buttonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
                                buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);


      
        buttonStart.addActionListener(e -> {
            new myFrame().setVisible(true);
            dispose();
        });

        buttonExit.addActionListener(e -> dispose());
    }
}
