

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
import javax.swing.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.awt.*;
import javax.swing.JScrollPane;


public class leaderBoard {

    private JFrame leaderBoardPage;
    Label title_ai_count = new Label("");
    Label title_tie_count = new Label("");
    Label title_player_count = new Label("");
    ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    leaderBoard window = new leaderBoard();
                    window.leaderBoardPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public leaderBoard() {
        initialize();
    }

    public void getLeaderBoard() {
        int tie_count = 0, player_win_count = 0, ai_win_count = 0, count = 0;
        ResultSet rs;

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
                 rs = stmt.executeQuery( "SELECT * FROM leaderboard where player_status = 'TIE';" );
                while(rs.next()){
                    tie_count++;
                }
                rs = stmt.executeQuery( "SELECT * FROM leaderboard where player_status = 'AI WIN';" );
                while(rs.next()){
                    ai_win_count++;
                }
                rs = stmt.executeQuery( "SELECT * FROM leaderboard where player_status = 'PLAYER WIN';" );
                while(rs.next()){
                    player_win_count++;
                }
                String[][] data = new String[ai_win_count + player_win_count + tie_count][2];
                String[] column = {"Player Name", "Win Status"};
                rs = stmt.executeQuery( "SELECT * FROM leaderboard ;" );
                while(rs.next()){
                    data[count][0] = rs.getString("player_name");
                    data[count][1] = rs.getString("player_status");
                    count++;
                }

                System.out.println(tie_count);
                System.out.println(ai_win_count);
                System.out.println(player_win_count);
                title_ai_count.setText("" + ai_win_count);
                title_tie_count.setText("" + tie_count);
                title_player_count.setText("" + player_win_count);

                JTable jt = new JTable(data, column);
                jt.setBounds(65, 241, 470, 240);
                jt.setFont(new Font("Century", Font.PLAIN, 15));

                scrollPane.add(jt);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        leaderBoardPage = new JFrame();
        leaderBoardPage.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Engginearing\\SAKEC\\SEM 3\\Java Mini Project\\favico\\icon.png"));
        leaderBoardPage.setTitle("X & O | Leader Board");
        leaderBoardPage.getContentPane().setBackground(Color.decode("#F5CDDE"));
        leaderBoardPage.setBackground(Color.decode("#F5CDDE"));
        leaderBoardPage.setResizable(false);
        leaderBoardPage.setBounds(100, 100, 616, 616);
        leaderBoardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leaderBoardPage.getContentPane().setLayout(null);

        Label title = new Label("Leader Board");
        title.setAlignment(Label.CENTER);
        title.setFont(new Font("Century", Font.PLAIN, 45));
        title.setBounds(125, 25, 350, 55);
        leaderBoardPage.getContentPane().add(title);

        Button btnHome = new Button("Home");
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leaderBoardPage.dispose();
                homePage.main(null);
            }
        });
        btnHome.setBackground(Color.decode("#E2BEF1"));
        btnHome.setFont(new Font("Century", Font.PLAIN, 30));
        btnHome.setBounds(205, 520, 190, 45);
        leaderBoardPage.getContentPane().add(btnHome);

//=================================================================================
        Label title_player = new Label("Times Human Won :");
        title_player.setFont(new Font("Century", Font.PLAIN, 25));
        title_player.setAlignment(Label.RIGHT);
        title_player.setBounds(65, 100, 250, 55);
        leaderBoardPage.getContentPane().add(title_player);

        title_player_count.setFont(new Font("Century", Font.PLAIN, 30));
        title_player_count.setAlignment(Label.CENTER);
        title_player_count.setBounds(330, 100, 50, 55);
        leaderBoardPage.getContentPane().add(title_player_count);

//=================================================================================

        Label title_ai = new Label("Times AI Won :");
        title_ai.setFont(new Font("Century", Font.PLAIN, 25));
        title_ai.setAlignment(Label.RIGHT);
        title_ai.setBounds(65, 140, 250, 55);
        leaderBoardPage.getContentPane().add(title_ai);

        title_ai_count.setFont(new Font("Century", Font.PLAIN, 30));
        title_ai_count.setAlignment(Label.CENTER);
        title_ai_count.setBounds(330, 140, 50, 55);
        leaderBoardPage.getContentPane().add(title_ai_count);

//=================================================================================

        Label title_tie = new Label("Times Tie :");
        title_tie.setFont(new Font("Century", Font.PLAIN, 25));
        title_tie.setAlignment(Label.RIGHT);
        title_tie.setBounds(65, 180, 250, 55);
        leaderBoardPage.getContentPane().add(title_tie);

        title_tie_count.setFont(new Font("Century", Font.PLAIN, 30));
        title_tie_count.setAlignment(Label.CENTER);
        title_tie_count.setBounds(330, 180, 50, 55);
        leaderBoardPage.getContentPane().add(title_tie_count);
//=================================================================================

        scrollPane.setFont(new Font("Century", Font.PLAIN, 25));
        //scrollPane.setScrollPosition(new Point(0, 10));
        scrollPane.setBackground(Color.decode("#f2e9f2"));
        scrollPane.setBounds(65, 241, 470, 240);

        leaderBoardPage.getContentPane().add(scrollPane);
//        leaderBoardPage.getContentPane().add(scroller);
//=================================================================================
        getLeaderBoard();
    }
}
