

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class aiPlayer {

	private JFrame player;

	char ai = 'O', human = 'X';
	char move = human;
	gameBoard board = new gameBoard();
	char isWin = ' ';
	Label title = new Label("Human vs AI");
	Button btnHome = new Button("Home");
	int i, j;
	int[] aimove = new int[2];
	Button[][] btns = new Button[3][3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aiPlayer window = new aiPlayer();
					window.player.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public aiPlayer() {
		initialize();
	}

	public char setLable(Button btn, char move, int a, int b) {
		board.playBoard(a, b, move);
		btn.setForeground(Color.decode("#bf1d11"));
		btn.setLabel(Character.toString(move));
		move = ai;
		// Best Move Call
		int[] aimove = board.bestMove(move);

		if (aimove[0] != -1 && aimove[1] != -1) {
			btns[aimove[0]][aimove[1]].setLabel(Character.toString(move));
			btns[aimove[0]][aimove[1]].setForeground(Color.decode("#572599"));
			board.playBoard(aimove[0], aimove[1], move);
		}
		move = human;
		return move;
	}

	public void Win(char win) {
		if (win == ai) {
			JOptionPane.showMessageDialog(player, " AI has Won", "You Noob", JOptionPane.NO_OPTION);
			player.dispose();
			aiWin.main(null);
		} else if (win == human) {
			JOptionPane.showMessageDialog(player, "You Won", "HOW?", JOptionPane.NO_OPTION);
			player.dispose();
			playerWin.main(null);
		} else if(win == 'T'){
			JOptionPane.showMessageDialog(player, "TIE", "Well Played", JOptionPane.NO_OPTION);
			player.dispose();
			tie.main(null);
		}

		
	}


	/**
	 * Initialize the contents of the frame
	 */
	public void initialize() {
		player = new JFrame();
		player.getContentPane().setBackground(Color.decode("#F5CDDE"));
		player.setBackground(Color.decode("#F5CDDE"));
		player.setResizable(false);
		player.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
		player.setBounds(100, 100, 516, 563);
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.getContentPane().setLayout(null);

		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Century", Font.PLAIN, 40));
		title.setBounds(75, 45, 350, 55);
		player.getContentPane().add(title);

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.dispose();
				homePage.main(null);
			}
		});
		btnHome.setBackground(Color.decode("#E2BEF1"));
		btnHome.setFont(new Font("Century", Font.PLAIN, 30));
		btnHome.setBounds(350, 120, 115, 45);
		player.getContentPane().add(btnHome);

		int count = -1;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				btns[i][j] = new Button("");
				Button btn = btns[i][j];
				int a = i, b = j;
				btns[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (btn.getLabel() == "") {
							move = setLable(btn, move, a, b);
							isWin = board.checkBoard();
							if (isWin != ' ') {
								Win(isWin);
							}
						}
					}
				});
				if (count++ % 2 == 0)
					btns[i][j].setBackground(Color.PINK);
				else
					btns[i][j].setBackground(Color.decode("#87dce6"));

				btns[i][j].setFont(new Font("Century", Font.PLAIN, 50));
				btns[i][j].setBounds(94 + (100 * j), 190 + (100 * i), 100, 100);
				player.getContentPane().add(btns[i][j]);

			}
		}
	}
}
