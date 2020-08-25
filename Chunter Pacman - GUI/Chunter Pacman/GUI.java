/**
* * This class is the GUI Class of the "Chunter Pac" application.
* "Chunter Pac" is a very simple, GUI based adventure game. Users
* can walk around to collect pieces of cheese. That's all.
*
* To play this game,create an instance of this class.
*
* This GUI class is responsible for the GUI Transformation of the game
*
* @author Youssef Abouwarda and Muhammad Asad Soomauroo
* @version 2020.06.07
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GUI implements ActionListener {

private JFrame frame;
private JPanel commandPanel;
private JTextField commandInput;
private JLabel inputLabel;
private JButton okButton;
private JPanel imgPanel;
private JLabel imgLabel;
private JPanel outputPanel;
private JLabel outputLabel;
private JTextArea outputTextArea;

private Container contentPane;

private ImageIcon image;
private Parser parser;
private Game game;
private Room currentRoom;

public GUI()
{
game =new Game();
frame =new JFrame();
commandPanel = new JPanel();
commandInput = new JTextField(12);
outputTextArea = new JTextArea(50,50);

contentPane=frame.getContentPane();
inputLabel = new JLabel("Enter You command");
okButton = new JButton("OK");
outputLabel = new JLabel("");
//sampleImg = new ImageIcon("Alester.jpeg");
imgLabel = new JLabel(image);
imgPanel = new JPanel();
imgPanel.add(imgLabel);

frame.setSize(500,500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(commandPanel);

//formatting my commandPanel
commandPanel.setLayout(new FlowLayout());
commandPanel.add(inputLabel);
commandPanel.add(commandInput);
commandPanel.add(okButton);

//formatting image label
imgLabel.setPreferredSize(new Dimension(400, 600));

//formatting main frame
contentPane.add(commandPanel, BorderLayout.NORTH);
contentPane.add(outputTextArea, BorderLayout.SOUTH);
contentPane.add(imgPanel,BorderLayout.CENTER);


okButton.addActionListener(this);
outputTextArea.setText(printWelcome());
frame.pack();
frame.setVisible(true);
}

//public container directions()
//{

//}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
String inputText = commandInput.getText();

//outputLabel.setText(inputText);
parser = new Parser(inputText);
Command command = parser.getCommand();
String commandWord = command.getCommandWord();
if (commandWord.equals("go")) {
outputTextArea.setText( game.goRoom(command) + "\n");

} else if (commandWord.equals("back")) {
outputTextArea.setText( game.goBack() + "\n");

} else if (commandWord.equals("help")) {
outputTextArea.setText( game.printHelp() + parser.showCommands() + "\n");

} else if (commandWord.equals("quit")) {
outputTextArea.setText( game.quit(command) + "\n");
} else if(commandWord.equals("I don't know what you mean")){
outputTextArea.setText("I don't know what this means\n");
}
imgLabel.removeAll();
image = game.getCurrentRoom().getImage();
imgLabel = new JLabel(image);
imgLabel.revalidate();
imgPanel.add(imgLabel);

//String password =passwordText.getText();
//System.out.println(user+","+password);*/
//System.out.println("ButtonClicked");
}

public String printWelcome()
{
String welcomeString = ""
+"Welcome to Chunter Pacman! \n"
+"Chunter Packman is a new, incredibly interisting adventure game. \n"
+"Type 'help' if you need help.\n"
+game.getCurrentRoom().getLongDescription();

return welcomeString;
}
}