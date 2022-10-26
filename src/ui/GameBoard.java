/**
 * @author Tom Ole Haelbich
 */

package ui;

import java.io.*;

public class GameBoard {

    private PrintStream outStream;
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    
    GameBoard(PrintStream outStream) {
        this.outStream = outStream;
    }

    private static final Colors color = new Colors();

    int[][] board = new int[10][10];

    private void getShips() {
        // bekomme die information wo deine schiffe sind, bzw, wo du bei dem gegener schon hin geschossen hast.
    }

    public void show() {


        board[0][0] = 0;
        board[1][0] = 0;
        board[2][0] = 3;

        board[3][0] = 4;

        int i = 0;
        this.outStream.print("   ");
        for (int j = 0; j < 10; j++) {
            this.outStream.print("| " + j + " |");
        }
        for (int[] row : board) {
            
            this.outStream.print("\n" + letters[i] + "  ");
            i++;
            for (int element : row) {
                if (element == 0) {
                    this.outStream.print("| " + " " + " |");
                } else if(element == 1) {
                    this.outStream.print("| " + "○" + " |"); // ship
                } else if(element == 2) {
                    this.outStream.print("| " + color.red() + "◌" + color.reset() + " |"); // destroyed ship
                } else if(element == 3) {
                    this.outStream.print("| " + color.red() +"X" + color.reset() + " |"); // ship was hit
                } else if(element == 4) {
                    this.outStream.print("| " + color.blue() + "X" + color.reset() + " |"); //other players water was hit
                }
                
            }
            


        }
        this.outStream.println("");
    }
}
