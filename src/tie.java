

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.TextField;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class tie {

	private JFrame tiePage;
	TextField playerName = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tie window = new tie();
					window.tiePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tie() {
		initialize();
	}
	
	public void addPlayer() {
		String player_name = playerName.getText();
		String status = "TIE";

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
		tiePage = new JFrame();
		tiePage.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
		tiePage.setTitle("X & O | Tie");
		tiePage.getContentPane().setBackground(Color.decode("#F5CDDE"));
		tiePage.setBackground(Color.decode("#F5CDDE"));
		tiePage.setResizable(false);
		tiePage.setBounds(100, 100, 516, 516);
		tiePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tiePage.getContentPane().setLayout(null);
		
		Label title = new Label("TIE");
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Century", Font.PLAIN, 45));
		title.setBounds(75, 45, 350, 55);
		tiePage.getContentPane().add(title);
		
		Button btnHome = new Button("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiePage.dispose();
				addPlayer();
				homePage.main(null);
			}
		});
		btnHome.setBackground(Color.decode("#E2BEF1"));
		btnHome.setFont(new Font("Century", Font.PLAIN, 30));
		btnHome.setBounds(40, 371, 190, 45);
		tiePage.getContentPane().add(btnHome);
		
		Button btnPlayAgain = new Button("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiePage.dispose();
				addPlayer();
				aiPlayer.main(null);
			}
		});
		btnPlayAgain.setFont(new Font("Century", Font.PLAIN, 30));
		btnPlayAgain.setBackground(new Color(226, 190, 241));
		btnPlayAgain.setBounds(270, 371, 190, 45);
		tiePage.getContentPane().add(btnPlayAgain);
		
		Label title_1 = new Label("Atleast you were not defeated by ");
		title_1.setFont(new Font("Century", Font.PLAIN, 30));
		title_1.setAlignment(Label.CENTER);
		title_1.setBounds(25, 106, 450, 55);
		tiePage.getContentPane().add(title_1);
		
		Label title_1_1 = new Label("The Best AI");
		title_1_1.setFont(new Font("Century", Font.PLAIN, 25));
		title_1_1.setAlignment(Label.CENTER);
		title_1_1.setBounds(75, 167, 350, 55);
		tiePage.getContentPane().add(title_1_1);
		
		
		Label title_1_3 = new Label("Enter your Name");
		title_1_3.setFont(new Font("Century", Font.PLAIN, 30));
		title_1_3.setAlignment(Label.CENTER);
		title_1_3.setBounds(50, 228, 400, 55);
		tiePage.getContentPane().add(title_1_3);
		
		
		playerName.setFont(new Font("Century", Font.PLAIN, 30));
		playerName.setBounds(125, 289, 250, 54);
		tiePage.getContentPane().add(playerName);
		
		Label title_1_2 = new Label("Ps: That's the best you can get GGWP");
		title_1_2.setFont(new Font("Century", Font.PLAIN, 15));
		title_1_2.setAlignment(Label.RIGHT);
		title_1_2.setBounds(120, 422, 350, 55);
		tiePage.getContentPane().add(title_1_2);
		
	}
}
