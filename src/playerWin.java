

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.TextField;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class playerWin {

	private JFrame playerWinPage;
	TextField playerName = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playerWin window = new playerWin();
					window.playerWinPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public playerWin() {
		initialize();
	}
	
	public void addPlayer() {
		String player_name = playerName.getText();
		String status = "PLAYER WIN";

		String dir = System.getProperty("user.dir");
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.out.println(e);
		}
		String url = "jdbc:sqlite:"+dir+"players.db";
		File dbf = new File(dir + "players.db");
		if(!dbf.exists())
			db.createNewDatabase();

		try {
			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				Statement stmt  = conn.createStatement();
				String sql = "INSERT INTO leaderboard (player_name,player_status) " +
						"VALUES ('" + player_name + "','" + status + "');";
				stmt.executeUpdate(sql);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		playerWinPage = new JFrame();
		playerWinPage.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
		playerWinPage.setTitle("X & O | Victory");
		playerWinPage.getContentPane().setBackground(Color.decode("#F5CDDE"));
		playerWinPage.setBackground(Color.decode("#F5CDDE"));
		playerWinPage.setResizable(false);
		playerWinPage.setBounds(100, 100, 516, 516);
		playerWinPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerWinPage.getContentPane().setLayout(null);
		
		Label title = new Label("YOU WON");
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Century", Font.PLAIN, 45));
		title.setBounds(75, 45, 350, 55);
		playerWinPage.getContentPane().add(title);
		
		Button btnHome = new Button("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerWinPage.dispose();
				addPlayer();
				homePage.main(null);
			}
		});
		btnHome.setBackground(Color.decode("#E2BEF1"));
		btnHome.setFont(new Font("Century", Font.PLAIN, 30));
		btnHome.setBounds(40, 371, 190, 45);
		playerWinPage.getContentPane().add(btnHome);
		
		Button btnPlayAgain = new Button("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerWinPage.dispose();
				addPlayer();
				aiPlayer.main(null);
			}
		});
		btnPlayAgain.setFont(new Font("Century", Font.PLAIN, 30));
		btnPlayAgain.setBackground(new Color(226, 190, 241));
		btnPlayAgain.setBounds(270, 371, 190, 45);
		playerWinPage.getContentPane().add(btnPlayAgain);
		
		Label title_1 = new Label("Haha you defeated");
		title_1.setFont(new Font("Century", Font.PLAIN, 30));
		title_1.setAlignment(Label.CENTER);
		title_1.setBounds(75, 106, 350, 55);
		playerWinPage.getContentPane().add(title_1);
		
		Label title_1_1 = new Label("The Best AI");
		title_1_1.setFont(new Font("Century", Font.PLAIN, 25));
		title_1_1.setAlignment(Label.CENTER);
		title_1_1.setBounds(75, 167, 350, 55);
		playerWinPage.getContentPane().add(title_1_1);
		
		
		Label title_1_3 = new Label("Enter your Legendary Name");
		title_1_3.setFont(new Font("Century", Font.PLAIN, 30));
		title_1_3.setAlignment(Label.CENTER);
		title_1_3.setBounds(50, 228, 400, 55);
		playerWinPage.getContentPane().add(title_1_3);
		
		
		playerName.setFont(new Font("Century", Font.PLAIN, 30));
		playerName.setBounds(125, 289, 250, 54);
		playerWinPage.getContentPane().add(playerName);
		
		Label title_1_2 = new Label("PS: Developer cries in pain");
		title_1_2.setFont(new Font("Century", Font.PLAIN, 15));
		title_1_2.setAlignment(Label.RIGHT);
		title_1_2.setBounds(120, 422, 350, 55);
		playerWinPage.getContentPane().add(title_1_2);
	}
}
