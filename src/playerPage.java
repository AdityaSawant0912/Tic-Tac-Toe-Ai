

import java.awt.*;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class playerPage {

	private JFrame player;
	char move = 'X';
	gameBoard board = new gameBoard();
	char isWin = ' ';
	TextField player1Name = new TextField("Player 1");
	TextField player2Name = new TextField("Player 2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playerPage window = new playerPage();
					window.player.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public playerPage() {
		initialize();
	}

	public char setLable(Button btn, char move) {
		if (move == 'X') {
			btn.setForeground(Color.decode("#bf1d11"));
			btn.setLabel(Character.toString(move));
			move = 'O';
		} else {
			btn.setForeground(Color.decode("#572599"));
			btn.setLabel(Character.toString(move));
			move = 'X';
		}
		return move;
	}

	public void Win(char win) {
		String winner;
		if (win == 'X') {
			winner = player2Name.getText();
			JOptionPane.showMessageDialog(player, winner + " Has Won", "Well Played", JOptionPane.NO_OPTION);
		} 
		else if (win == 'O') {
			winner = player1Name.getText();
			JOptionPane.showMessageDialog(player, winner + " Has Won", "Well Played", JOptionPane.NO_OPTION);
		}
		else
			JOptionPane.showMessageDialog(player,  "TIE", "Well Played Both of You", JOptionPane.NO_OPTION);
		
		reset();
	}

	public void reset() {
		player.dispose();
		homePage.main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		player = new JFrame();
		player.getContentPane().setBackground(Color.decode("#F5CDDE"));
		player.setBackground(Color.decode("#F5CDDE"));
		player.setResizable(false);
		player.setTitle("X & O | Human Vs Human");
		player.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
		player.setBounds(100, 100, 516, 563);
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.getContentPane().setLayout(null);

		Label title = new Label("VS");
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Century", Font.PLAIN, 40));
		title.setBounds(220, 45, 60, 55);
		title.setAlignment(Label.CENTER);
		player.getContentPane().add(title);

		player1Name.setFont(new Font("Century", Font.PLAIN, 40));
		player1Name.setBounds(25, 45, 170, 55);
		player.getContentPane().add(player1Name);

		player2Name.setFont(new Font("Century", Font.PLAIN, 40));
		player2Name.setBounds(305, 45, 170, 55);
		player.getContentPane().add(player2Name);

		Button btnHome = new Button("Home");
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

		Button btn1 = new Button("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn1.getLabel() == "") {
					move = setLable(btn1, move);
					board.playBoard(1, move);
					isWin = board.checkBoard();
					if (isWin != ' ') {
						Win(isWin);
					}
				}
			}
		});
		btn1.setBackground(Color.decode("#87dce6"));
		btn1.setFont(new Font("Century", Font.PLAIN, 50));
		btn1.setBounds(94, 190, 100, 100);
		player.getContentPane().add(btn1);

		Button btn2 = new Button("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn2.getLabel() == "") {
					move = setLable(btn2, move);
					board.playBoard(2, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn2.setBackground(Color.PINK);
		btn2.setFont(new Font("Century", Font.PLAIN, 50));
		btn2.setBounds(200, 190, 100, 100);
		player.getContentPane().add(btn2);

		Button btn3 = new Button("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn3.getLabel() == "") {
					move = setLable(btn3, move);
					board.playBoard(3, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn3.setBackground(Color.decode("#87dce6"));
		btn3.setFont(new Font("Century", Font.PLAIN, 50));
		btn3.setBounds(306, 190, 100, 100);
		player.getContentPane().add(btn3);

		Button btn4 = new Button("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn4.getLabel() == "") {
					move = setLable(btn4, move);
					board.playBoard(4, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn4.setBackground(Color.PINK);
		btn4.setFont(new Font("Century", Font.PLAIN, 50));
		btn4.setBounds(94, 296, 100, 100);
		player.getContentPane().add(btn4);

		Button btn5 = new Button("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn5.getLabel() == "") {
					move = setLable(btn5, move);
					board.playBoard(5, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn5.setBackground(Color.decode("#87dce6"));
		btn5.setFont(new Font("Century", Font.PLAIN, 50));
		btn5.setBounds(200, 296, 100, 100);
		player.getContentPane().add(btn5);

		Button btn6 = new Button("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn6.getLabel() == "") {
					move = setLable(btn6, move);
					board.playBoard(6, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn6.setBackground(Color.PINK);
		btn6.setFont(new Font("Century", Font.PLAIN, 50));
		btn6.setBounds(306, 296, 100, 100);
		player.getContentPane().add(btn6);

		Button btn7 = new Button("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn7.getLabel() == "") {
					move = setLable(btn7, move);
					board.playBoard(7, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn7.setBackground(Color.decode("#87dce6"));
		btn7.setFont(new Font("Century", Font.PLAIN, 50));
		btn7.setBounds(94, 402, 100, 100);
		player.getContentPane().add(btn7);

		Button btn8 = new Button("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn8.getLabel() == "") {
					move = setLable(btn8, move);
					board.playBoard(8, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn8.setBackground(Color.PINK);
		btn8.setFont(new Font("Century", Font.PLAIN, 50));
		btn8.setBounds(200, 402, 100, 100);
		player.getContentPane().add(btn8);

		Button btn9 = new Button("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn9.getLabel() == "") {
					move = setLable(btn9, move);
					board.playBoard(9, move);
					isWin = board.checkBoard();
					if (isWin != ' ')
						Win(isWin);
				}
			}
		});
		btn9.setBackground(Color.decode("#87dce6"));
		btn9.setFont(new Font("Century", Font.PLAIN, 50));
		btn9.setBounds(306, 402, 100, 100);
		player.getContentPane().add(btn9);
	}

}
