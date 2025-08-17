import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyButton extends JPanel {
    public MyButton(myFrame analyzerPanel) {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 200, 221));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        leftPanel.setOpaque(false); 

        JButton loadButton = new JButton("Load depth.txt");
        loadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton calcButton = new JButton("Calculate");
        calcButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JTextField fluidContactField = new JTextField(String.valueOf(analyzerPanel.getFluidContact()), 8);
        fluidContactField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel volumeLabel = new JLabel("Total Volume");
        volumeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        volumeLabel.setForeground(new Color(25, 25, 112));

        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int res = fileChooser.showOpenDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                analyzerPanel.loadFile(selectedFile);
                volumeLabel.setText("Total Volume: " + analyzerPanel.getFormattedTotalVolume() + " m³");
            }
        });

        
        calcButton.addActionListener(e -> {
            try {
                double contact = Double.parseDouble(fluidContactField.getText());
                analyzerPanel.setFluidContact(contact);
                analyzerPanel.updateGrid();
                volumeLabel.setText("Total Volume: " + analyzerPanel.getFormattedTotalVolume() + " m³");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Fluid Contact value");
            }
        });

        leftPanel.add(loadButton);
        leftPanel.add(new JLabel("Fluid Contact"));
        leftPanel.add(fluidContactField);
        leftPanel.add(calcButton);
        leftPanel.add(volumeLabel);

        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        rightPanel.setOpaque(false);

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        backButton.addActionListener(e -> {
            new MyMenu().setVisible(true);  
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        rightPanel.add(backButton);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
}
