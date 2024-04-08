package com.malik.sudokusolver;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuBoard extends JPanel{

    /*=============CONSTANTS================= */

    private static final int ROWS_SIZE = 9; //sudoku board rows size
    private static final int COLS_SIZE = 9; //sudoku board column size

    /*=============DECLARATION=============== */
    private JLabel title;
    private JTextField boxes[][]; //boxes array
    private String board[][];
    private JPanel panels[][]; //panels to add boxes in grid
    private JPanel head,grid, foot; //grid that fill add array of panels in 3x3
    private JButton solve_btn, clear_btn;

    public SudokuBoard(){

        /* ================INITIALIZATION============== */
        title = new JLabel("Sudoku Solver");
        boxes = new JTextField[ROWS_SIZE][COLS_SIZE]; // intializing input boxes in 9x9 grid
        board = new String[ROWS_SIZE][COLS_SIZE];
        panels = new JPanel[3][3]; //initalizing panel in 3x3 grid
        grid = new JPanel(); //intizling grid
        foot = new JPanel();
        head = new JPanel();
        solve_btn = new JButton("Solve");
        clear_btn = new JButton("Clear Board");

        grid.setLayout(new GridLayout(3,3,0,0)); //set layout to gridLayout

        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
        //running loop for panels to add them to grid panel
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                panels[i][j] = new JPanel();
                panels[i][j].setLayout(new GridLayout(3,3,0,0));
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grid.add(panels[i][j]);
            }
        }

        //running loop for boxes to add them to panels of 3x3
        for(int i=0; i<ROWS_SIZE; i++){
            for(int j=0; j<COLS_SIZE; j++){
                boxes[i][j] = new JTextField();
                boxes[i][j].setHorizontalAlignment(JTextField.CENTER);
                boxes[i][j].setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
                int fm = (i + 1) / 3;
                if((i + 1) % 3 > 0){
                    fm++;
                }

                int cm = (j + 1) / 3;
                if((j + 1) % 3 > 0){
                    cm++;
                }

                panels[fm-1][cm-1].add(boxes[i][j]);
            }
        }

        head.add(title);
        foot.add(solve_btn);
        foot.add(clear_btn);
        setLayout(new BorderLayout());
        add(head, BorderLayout.NORTH);
        add(grid,BorderLayout.CENTER); //adding grid to the main panel
        add(foot,BorderLayout.SOUTH);

        solve_btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                for(int i=0; i<ROWS_SIZE;i++){
                    for(int j=0; j<COLS_SIZE;j++){
                        board[i][j] = boxes[i][j].getText();
                    }
                }
                Solver.solveBoard(board);
                for (int i = 0; i < ROWS_SIZE; i++) {
                    for (int j = 0; j < COLS_SIZE; j++) {
                        boxes[i][j].setText(board[i][j]);
                    }
                }
            }
        });

        clear_btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0){
                for(int i=0; i<ROWS_SIZE; i++){
                    for(int j=0; j<COLS_SIZE; j++){
                        boxes[i][j].setText("");
                    }
                }
            }
        });

    }

}
