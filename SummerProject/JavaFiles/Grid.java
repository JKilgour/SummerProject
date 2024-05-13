import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;



public class Grid{
   
    JFrame frame = new JFrame("Nanogram");
    private JButton[][] buttons;
    private int[][] game;
    private int [][] solution;

    
    public Grid(int[][] game, int[][] solution){
        this.game = game;
        this.solution = solution;
        initialiseGrid();
    }
   private void initialiseGrid(){
    frame.setSize(900,900);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainFrame = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(15, 15, -1, -1)); //creates a layout for the grid with the gaps non existent between buttons
    gridPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0)); //creates a gap between the top and left
    buttons = new JButton[16][16];
    frame.add(mainFrame);
    mainFrame.add(gridPanel,BorderLayout.CENTER);
    JButton checkBox = new JButton("Click to check");
    mainFrame.add(checkBox,BorderLayout.NORTH);
    checkBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if(Arrays.deepEquals(solution, game)){
                checkBox.setText("Correct");
            }
            else{
                checkBox.setText("Incorrect");
            }
        }
    });

   

    for(int i=0;i < 15;i++){
        for(int x=0; x  <15;x++){
            JButton button = new JButton();
            buttons[i][x] = button;
            button.setOpaque(true);
            button.setBackground(Color.WHITE);
            int row = i;
            int col = x;
            // button.setVisible(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("Button clicked at row: " + row + ", col: " + col);

                    if(solution[row][col] == 0){
                        button.setOpaque(true);
                        button.setBackground(Color.BLACK);
                        solution[row][col] = 1;
                }
                    else if(solution[row][col] == 1){
                        button.setOpaque(true);
                        button.setBackground(Color.WHITE);
                        solution[row][col] = 0;
                    }
                }
            });
            gridPanel.add(button);
        
    }
    frame.setVisible(true);
   }
}
}