package Export_Data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Sign_In {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_In window = new Sign_In();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sign_In() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 616, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign-In");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(239, 11, 133, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(66, 113, 125, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1_1.setBounds(66, 175, 93, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tb1 = new JTextField();
		tb1.setBounds(222, 120, 139, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JPasswordField();
		tb2.setBounds(222, 175, 139, 20);
		frame.getContentPane().add(tb2);
		
		JButton btnNewButton = new JButton("Log-In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=tb1.getText();
				String p=tb2.getText();
				
					try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
						String q="select count(*) from signup where username=? and pass=?";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setString(1, u);
						ps.setString(2, p);
						ResultSet rs=ps.executeQuery();
						rs.next();
						int c=rs.getInt(1);
						if(c==0) {
							JOptionPane.showMessageDialog(btnNewButton,"Invalid");
							
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "login done");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(203, 261, 125, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
