package GUI;

import Comp_Decomp.Compressor;
import Comp_Decomp.Decompressor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(String name){
        this.setTitle(name);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel(); // panel for heading
        headingPanel.setBackground(new Color(63, 81, 181));
        headingPanel.setPreferredSize(new Dimension(getWidth(), 80));

        JLabel headingLabel = new JLabel("Compressor_Decompressor-Tool"); // Configurations of heading
        headingLabel.setFont(new Font("Arial", Font.BOLD,24));
        headingLabel.setForeground(Color.black);
        headingPanel.add(headingLabel);

        JPanel buttonPanel = new JPanel(); // Button Panel
        buttonPanel.setBackground(new Color(63, 81, 181));
        buttonPanel.setPreferredSize(new Dimension(getWidth(),120));


        compressButton = new JButton("Select File to Compress"); // compress Button
        compressButton.setBackground(new Color(255, 255, 255));
        compressButton.setForeground(Color.black);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select File to Decompress"); // Decompress Button
        decompressButton.setBackground(new Color(255, 255, 255));
        decompressButton.setForeground(Color.black);
        decompressButton.addActionListener(this);

        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        c.add(headingPanel,BorderLayout.NORTH);
        c.add(buttonPanel,BorderLayout.CENTER);

        this.setSize(500,300);
        this.getContentPane().setBackground(Color.white); // background color of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the Frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }
}

