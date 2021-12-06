

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class homePage {

	private JFrame home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage window = new homePage();
					window.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homePage() {
		initialize();
	}

	
	private void initialize() {
		home = new JFrame();
		home.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
		home.setTitle("X & O");
		home.getContentPane().setBackground(Color.decode("#F5CDDE"));
		home.setBackground(Color.decode("#F5CDDE"));
		home.setResizable(false);
		home.setBounds(100, 100, 516, 517);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		
		Label title1 = new Label("Tic Tac Toe");
		title1.setAlignment(Label.CENTER);
		title1.setFont(new Font("Century", Font.PLAIN, 40));
		title1.setBackground(Color.decode("#F5CDDE"));
		title1.setBounds(135, 45, 230, 50);
		home.getContentPane().add(title1);
		
		Label title1_1 = new Label("With AI?");
		title1_1.setFont(new Font("Century", Font.PLAIN, 30));
		title1_1.setBackground(Color.decode("#F5CDDE"));
		title1_1.setAlignment(Label.RIGHT);
		title1_1.setBounds(135, 90, 230, 50);
		home.getContentPane().add(title1_1);
		
		Button btnPlayer = new Button("Human");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.dispose();
				playerPage.main(null);
			}
		});
		btnPlayer.setBackground(Color.decode("#E2BEF1"));
		btnPlayer.setFont(new Font("Century", Font.PLAIN, 30));
		btnPlayer.setBounds(33, 250, 200, 80);
		home.getContentPane().add(btnPlayer);
		
		Button btnAI = new Button("AI");
		btnAI.setActionCommand("callAI");
		btnAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.dispose();
				aiPlayer.main(null);
			}
		});
		btnAI.setFont(new Font("Century", Font.PLAIN, 30));
		btnAI.setBackground(Color.decode("#E2BEF1"));
		btnAI.setBounds(266, 250, 200, 80);
		home.getContentPane().add(btnAI);
		
		Label title1_1_1 = new Label("Play Against:");
		title1_1_1.setFont(new Font("Century", Font.PLAIN, 30));
		title1_1_1.setBackground(Color.decode("#F5CDDE"));
		title1_1_1.setAlignment(Label.CENTER);
		title1_1_1.setBounds(135, 170, 230, 50);
		home.getContentPane().add(title1_1_1);
		
		Button btnLB = new Button("Leader Board");
		btnLB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.dispose();
				leaderBoard.main(null);
			}
		});
		btnLB.setFont(new Font("Century", Font.PLAIN, 30));
		btnLB.setBackground(Color.decode("#E2BEF1"));
		btnLB.setActionCommand("callLB");
		btnLB.setBounds(125, 362, 250, 80);
		home.getContentPane().add(btnLB);

		Label title_1_2 = new Label("By Aditya Sawant SE4 46");
		title_1_2.setFont(new Font("Century", Font.PLAIN, 25));
		title_1_2.setAlignment(Label.RIGHT);
		title_1_2.setBounds(120, 430, 350, 55);
		home.getContentPane().add(title_1_2);
	}
}
