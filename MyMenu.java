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

        
        buttonStart = new JButton("Start");
        buttonExit = new JButton("Exit");

        
        panelCenter = new JPanel(null);
        panelCenter.setBackground(new Color(205, 180, 219));

        panelNorth = new JPanel();
        panelNorth.setPreferredSize(new Dimension(150, 150));
        panelNorth.setBackground(new Color(255, 200, 221));

        label = new JLabel("Gas");
        label.setFont(new Font("Tahoma", Font.PLAIN, 100));
        panelNorth.add(label);

       
        int buttonWidth = 250;
        int buttonHeight = 80;
        int centerX = (1200 - buttonWidth) / 2; 

        buttonStart.setBounds(centerX, 150, buttonWidth, buttonHeight);
        buttonExit.setBounds(centerX, 300, buttonWidth, buttonHeight);

        panelCenter.add(buttonStart);
        panelCenter.add(buttonExit);

    
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);

      
        buttonStart.addActionListener(e -> {
            new myFrame().setVisible(true);
            dispose();
        });

        buttonExit.addActionListener(e -> dispose());
    }
}
