import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Template.
 *
 * @author Youssef Abouwarda
 * Muhammad Asad Soomauroo
 * @version 02/06/2020
 */
public class Prototype implements ActionListener{

    private JPanel panel;
    private JFrame frame;
    private JTextField commandInput;
    private JLabel inputLabel;
    private JButton okButton;
    private JLabel outputLabel;
    private JLabel imgLabel;
    private ImageIcon sampleImg; 
    /**
     * Constructor for objects of class Prototype
     */
    public Prototype()
    {
        frame =new JFrame();
        panel = new JPanel();
        commandInput = new JTextField(12);
        inputLabel = new JLabel("Enter You command");
        okButton = new JButton("OK");
        outputLabel = new JLabel("");
        sampleImg = new ImageIcon("Alester.jpeg"); 
        imgLabel = new JLabel(sampleImg);
 
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        imgLabel.setPreferredSize(new Dimension(250, 100));
        panel.add(inputLabel);
        panel.add(commandInput);
        panel.add(okButton);
        panel.add(outputLabel);
        panel.add(imgLabel);
        
        okButton.addActionListener(this);
        
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
		String command = commandInput.getText();
		outputLabel.setText(command);
		//String password =passwordText.getText();
		//System.out.println(user+","+password);*/
		//System.out.println("ButtonClicked");
	}
}
