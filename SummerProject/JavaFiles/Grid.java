import javax.swing.*;
import java.awt.*;

public class Grid{
   
    JFrame a = new JFrame();
    JButton b;
    

   public Grid(){
    a.setSize(800,800);
    a.setVisible(true);
    for(int i=0;i < 14;i++){
        for(int x=0; x  <14;x++){
            b = new JButton();
            b.setBounds(50+x*50,50+i*50,50,50);
            b.setBackground(Color.white);
            a.add(b);
            b.setVisible(true);
        }
    }
   }

}