package course.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

class Signup extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton b1, b2;
	private JComboBox comboBox2;
	private JLabel l98;
	private JPasswordField textField_2;

	public static void main(String[] args) {
		new Signup().setVisible(true);
	}

	 user uu = new user();
	 
	public Signup() {
		setBounds(600, 250, 606, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Create-Account", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(44, 10, 477, 349);
		panel.setBackground(new Color(204, 204, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblaccounttype = new JLabel("Account type :");
		lblaccounttype.setBounds(55, 150, 140, 26);
		panel.add(lblaccounttype);
		lblaccounttype.setForeground(Color.BLACK);
		lblaccounttype.setFont(new Font("Tahoma", Font.BOLD, 14));
				
		comboBox2 = new JComboBox();
		comboBox2.setBounds(203, 155, 148, 20);
		panel.add(comboBox2);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "Instructor", "Student" }));
						
		b1 = new JButton("Create");
		b1.setBounds(203, 195, 100, 35);
		panel.add(b1);
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b1.setBackground(new Color(0, 0, 102));
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Login");
		b2.setBounds(203, 281, 100, 35);
		panel.add(b2);
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBackground(new Color(0, 0, 102));
		b2.setForeground(Color.WHITE);
			
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(55, 42, 92, 26);
		panel.add(lblUsername);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
												
		textField = new JTextField();
		textField.setBounds(203, 48, 148, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(55, 78, 92, 26);
		panel.add(lblName);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 84, 148, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(55, 114, 92, 26);
		panel.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		l98 = new JLabel("Already have an account?");
		l98.setBounds(174, 250, 206, 13);
		panel.add(l98);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(203, 114, 148, 20);
		panel.add(textField_2);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b2) {
			this.setVisible(false);
			new Main().setVisible(true);

		}
		
		else
			
		if((textField.getText()).length() < 1) {
			JOptionPane.showMessageDialog(null, "Please enter username");
		}
		
		else if((textField_1.getText()).length() < 1) {
			JOptionPane.showMessageDialog(null, "Please enter name");
		}
		
		else if((textField_1.getText()).length() < 1){
			JOptionPane.showMessageDialog(null, "Please enter password");
		}
		
		else {
		try {
			if( uu.isUserExist(textField.getText())) {
                JOptionPane.showMessageDialog(null, "Username Exists");}
        	else {
			connect con = new connect();

			if (ae.getSource() == b1) {
				// sql query to save new account details.
				String sql = "insert into accounts(username, name, password,acc_type) values(?, ?, ?,?)";
				PreparedStatement st = con.c.prepareStatement(sql);
				// setString will get values from textfrields and comboboxes and set in query
				st.setString(1, textField.getText());
				st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4, (String) comboBox2.getSelectedItem());

				int i = st.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "successfully Created");
				}

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");

			}
        	}
		} catch (Exception e) {

		}
		}
	}
}