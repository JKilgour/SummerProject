import javax.swing.*;
import java.awt.*;


public class Grid{
   
    JFrame a = new JFrame("Nanogram");
    private JButton[][] buttons ;

    

   public Grid(){
    a.setSize(900,900);
    a.setVisible(true);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel gridPanel = new JPanel(new GridLayout(15, 15, -5, -5)); //creates a layout for the grid with the gaps non existent between buttons
    gridPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0)); //creates a gap between the top and left
    buttons = new JButton[16][16];
    a.add(gridPanel);

    for(int i=0;i < 15;i++){
        for(int x=0; x  <15;x++){
            JButton button = new JButton();
            buttons[i][x] = button;
            gridPanel.add(button);
            button.setVisible(true);
        }
    }
    a.setVisible(true);


   }
}