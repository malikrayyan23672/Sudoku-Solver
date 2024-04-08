package com.mycompany.app;
import javax.swing.*;
import com.mycompany.*;
/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    private SudokuBoard sudokuBoard;

    public App(){

        sudokuBoard = new SudokuBoard();

        setSize(600,900);
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(sudokuBoard);
        setVisible(true);



    }

    public static void main(String[] args)
    {
        App app = new App();
    }
}
