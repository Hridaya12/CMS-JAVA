package course.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.event.*;
import java.sql.*;
//Hridaya Bhattarai
//2065693

public class Main extends JFrame implements ActionListener {
	
	private JPanel panel; // JPanel is a generic lightweight container.
	private JTextField textField; // a text component that allows the editing of a single line text.
	private JPasswordField passwordField; // for entering password. text is not shown.
	private JButton b1, b2; // declaring buttons
	private JComboBox comboBox; // combobox used for various options.

	
	public Main() {

		setBackground(new Color(204, 204, 255));
		setBounds(600, 300, 602, 402);
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		setContentPane(panel);
		panel.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(43, 128, 168)));
		menuBar.setBackground(new Color(204, 204, 255));
		menuBar.setBounds(0, 0, 1000, 30);
		panel.add(menuBar);
		JMenu mnExit = new JMenu("Exit");
		mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(new Color(0, 0, 0));
		mntmExit.setBackground(new Color(204, 204, 255));
		mntmExit.addActionListener(this);
		mnExit.add(mntmExit);
		menuBar.add(mnExit);

		JLabel l3 = new JLabel("");
		l3.setBounds(377, 85, 46, 34);
		panel.add(l3);

		JLabel l4 = new JLabel("");
		l4.setBounds(377, 130, 46, 34);
		panel.add(l3);

		// for design
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(204, 204, 255));
		panel2.setBounds(56, 40, 473, 315);
		panel.add(panel2);
		panel2.setLayout(null);
		
		b1 = new JButton("Login");
		b1.setBounds(186, 177, 113, 39);
		panel2.add(b1);
		b1.addActionListener(this);
				
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(0, 0, 102));
		
		b2 = new JButton("SignUp");
		b2.setBounds(186, 249, 113, 39);
		panel2.add(b2);
		b2.addActionListener(this);							
		b2.setForeground(new Color(255, 255, 255));
		b2.setBackground(new Color(0, 0, 102));
										
		// to select account type for user
		comboBox = new JComboBox();
		comboBox.setBounds(186, 135, 157, 20);
		panel2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select", "Admin", "Instructor", "Student" }));
	
		JLabel l44 = new JLabel("Choose Role");
		l44.setBounds(87, 133, 95, 24);
		panel2.add(l44);
		l44.setForeground(new Color(0, 0, 0));
														
		JLabel l2 = new JLabel("Password : ");
		l2.setBounds(87, 101, 95, 24);
		panel2.add(l2);
		l2.setForeground(new Color(0, 0, 0));
																
		JLabel l1 = new JLabel("Username : ");
		l1.setBounds(87, 67, 95, 24);
		panel2.add(l1);
		l1.setForeground(new Color(0, 0, 0));
	
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 105, 157, 20);
		panel2.add(passwordField);
	
		// username
		textField = new JTextField();
		textField.setBounds(186, 70, 157, 20);
		panel2.add(textField);
	
		JLabel l99 = new JLabel("Don`t have an account?");
		l99.setBounds(178, 226, 138, 13);
		panel2.add(l99);
	
		JLabel l0 = new JLabel("COURSE MANAGEMENT SYSTEM");
		l0.setBounds(40, 0, 391, 56);
		panel2.add(l0);
		l0.setForeground(new Color(0, 0, 0));
		l0.setFont(new Font("Serif", Font.PLAIN, 25));
	}

	public void actionPerformed(ActionEvent ae) {
		// check the account type first with value
		String value = comboBox.getSelectedItem().toString();
		if (ae.getSource() == b1) {
			Boolean status = false;
			try {
				connect con = new connect(); // connecting with database
				String sql = "select * from accounts where username=? and password=? and acc_type=?";
				PreparedStatement st = con.c.prepareStatement(sql);

				st.setString(1, textField.getText());
				st.setString(2, passwordField.getText());
				 st.setString(3, value);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					// check the value indicators first and then perform the action.
					if (value == "Admin") {
						this.setVisible(false);
						AdminHome ah = new AdminHome();
						ah.setVisible(true);
					} else if (value == "Student") {
						this.setVisible(false);
						StudentHome sh = new StudentHome();
						sh.setVisible(true);
					} else if (value == "Instructor") {
						this.setVisible(false);
						InstructorHome ih = new InstructorHome();
						ih.setVisible(true);
					}
					else if (value=="Select") {
						JOptionPane.showMessageDialog(null, "Please choose role ");
					}

				} else
					JOptionPane.showMessageDialog(null, "Invalid Login...!.");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (ae.getSource() == b2) {
			setVisible(false);
			Signup su = new Signup();
			su.setVisible(true);
		}
		
		String msg = ae.getActionCommand();
		if (msg.equals("Exit")) {
			System.exit(ABORT);
		}
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
