import javax.swing.*;
import java.awt.*;


public class Grid{
   
    JFrame a = new JFrame("Nanogram");
    private JButton[][] buttons ;

    

   public Grid(){
    a.setSize(900,900);
    a.setVisible(true);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel gridPanel = new JPanel(new GridLayout(16, 16, 0, 0));
    buttons = new JButton[16][16];
    a.add(gridPanel);

    for(int i=0;i < 16;i++){
        for(int x=0; x  <16;x++){
            JButton button = new JButton();
            buttons[i][x] = button;
            gridPanel.add(button);
            button.setVisible(true);
        }
    }
    a.setVisible(true);


   }
}