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
    private JLabel[] topCount;
    private JLabel[] leftCount;
    
    
    public Grid(int[][] game, int[][] solution){
        this.game = game;
        this.solution = solution;
        initialiseGrid();
    }
    private void initialiseGrid(){
        frame.setSize(1200,1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainFrame = new JPanel(new BorderLayout()); //createsa layout to add each panel to
        JPanel gridPanel = new JPanel(new GridLayout(15, 15, -1, -1)); //creates a layout for the grid of buttons
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0)); //creates a gap between the top and left
        buttons = new JButton[15][15];
        frame.add(mainFrame);
        mainFrame.add(gridPanel,BorderLayout.CENTER);
        JButton checkBox = new JButton("Click to check");
        mainFrame.add(checkBox,BorderLayout.SOUTH);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(Arrays.deepEquals(solution, game)){ //checks whether the player matches the solution
                    checkBox.setText("Correct"); 
                }
                else{
                    checkBox.setText("Incorrect");
                }
            }
        });
        
        JPanel topText = new JPanel(new GridLayout(1,15));
        JPanel leftText = new JPanel(new GridLayout(15,1));
        leftText.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        topText.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        
        topCount = new JLabel[15];
        leftCount = new JLabel[15];
        
        mainFrame.add(leftText, BorderLayout.WEST);
        mainFrame.add(topText, BorderLayout.NORTH);
        int count = 0;
        
        
        for(int i = 0; i<15;i++){
            
            count = 0;
            JLabel label = new JLabel();
            
            for(int j = 0; j < 15; j++){
                if(game[j][i] == 1){
                    count++;
                }
                if(j == 14 && count!=0){
                    String labelText = label.getText();
                    labelText += count;
                    label.setText(labelText);
                    count = 0;

                }
                if(game[j][i]== 0){
                    if(count != 0){
                        String labelText = label.getText();
                        labelText += count;
                        for(int x = 0; x< 15-j;x++){
                            if(game[j+x][i] == 1){
                                labelText += ", ";  
                                break;                 
                            }
                            
                        }
                        
                        
                        label.setText(labelText);
                        count = 0;
                        
                    }
                }    
            }
            label.setPreferredSize(new Dimension(50, 50)); 
            label.setHorizontalAlignment(SwingConstants.CENTER);
            
            topText.add(label);
            topCount[i] = label;
            
        }
        for (int i = 0; i < 15; i++) {
            
            count = 0;
            JLabel label = new JLabel();
            
            for(int j = 0; j < 15; j++){
                if(game[i][j] == 1){
                    count++;
                }
                if(j == 14 && count!=0){
                    String labelText = label.getText();
                    labelText += count;
                    label.setText(labelText);
                    count = 0;

                }
                if(game[i][j]== 0){
                    if(count != 0){
                        String labelText = label.getText();
                        labelText += count;
                        for(int x = 0; x< 15-j;x++){
                            if(game[i][j+x] == 1){
                                labelText += ", ";  
                                break;                     
                            }
                        }
                        
                        
                        label.setText(labelText);
                        count = 0;
                        
                    }
                }    
            }
            
            label.setPreferredSize(new Dimension(50, 50));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            
            leftText.add(label);
            leftCount[i] = label;
            
        }
        
        for(int i=0;i < 15;i++){
            for(int x=0; x  <15;x++){ //adds the buttons in
                JButton button = new JButton();
                buttons[i][x] = button;
                button.setOpaque(true);
                button.setBackground(Color.WHITE);
                int row = i;
                int col = x;
                // button.setVisible(false);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.setPreferredSize(new Dimension(50,50));
                button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(solution[row][col] == 0){ //checks to see whether to change to black or white
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