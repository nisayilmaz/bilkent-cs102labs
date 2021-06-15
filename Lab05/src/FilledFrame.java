import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;  
import javax.swing.*;  

public class FilledFrame extends JFrame {

    JPanel panel;
    JButton[] buttons = new JButton[25];

    public FilledFrame(){
        
        setSize(400,400);
        setTitle("A Simple Java Game");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createElements();    
    }

    private void createElements() {
        panel = new JPanel();
        for (int i = 1; i < 26; i++) {
            JButton button = new JButton("" + i);
            panel.add(button);
            buttons[i - 1] =  button;    
        }
        add(panel);
        
        panel.setLayout(new GridLayout(5,5));

    }
    private void selectButtons() {
        int goal =(int) Math.random() * 25;
        int bomb1 = 0;
        int bomb2 = 0;
        JButton goalButton = buttons[goal];  
        
        do {
            bomb2 = (int) Math.random() * 25;
        } while (bomb2 == goal || bomb2 == bomb1);
        do {
            bomb1 = (int) Math.random() * 25;
        } while (bomb1 == goal || bomb1 == bomb2);
        System.out.println(bomb1+"," + bomb2+"," +goal);
      

    }

   

        
        
    
}
