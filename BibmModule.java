package course.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BibmModule extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1;
    private JButton b1,b2,b3,b4,b5;
    private JTextField t4;
    private JComboBox comboBox;
    private JComboBox comboBox2;

    public static void main(String[] args) {
        new BibmModule().setVisible(true);
    }
  
    user uu = new user();
    private JButton b6;
    public BibmModule() {
        setBounds(600, 200, 634, 472);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Manage BIBM Module", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 29, 589, 395);
        contentPane.add(panel);
        panel.setBackground(new Color(204, 204, 255));
        panel.setLayout(null);
        
        b4 = new JButton("View All");
        b4.setBounds(398, 274, 111, 33);
        panel.add(b4);
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBackground(new Color(0, 0, 102));
        b4.setForeground(Color.WHITE);
                
        b3 = new JButton("Delete");
        b3.setBounds(240, 273, 111, 33);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
                        
        b2 = new JButton("Back");
        b2.setBounds(348, 329, 111, 33);
        panel.add(b2);
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
                                
        b1 = new JButton("Add");
        b1.setBounds(77, 273, 111, 33);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
                                        
        b5 = new JButton("Update");
        b5.setBounds(137, 329, 111, 33);
        panel.add(b5);
        b5.addActionListener(this);
        b5.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b5.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b5.setBackground(new Color(0, 0, 102));
        b5.setForeground(Color.WHITE);
        
        JLabel l3 = new JLabel("Level");
        l3.setBounds(137, 102, 111, 22);
        panel.add(l3);
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel l2 = new JLabel("Module Name");
        l2.setBounds(137, 157, 110, 22);
        panel.add(l2);
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                                
        t1 = new JTextField();
        t1.setBounds(261, 50, 198, 20);
        panel.add(t1);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setColumns(10);
        
        JLabel l1 = new JLabel("Module ID");
        l1.setBounds(137, 48, 110, 22);
        panel.add(l1);
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel l4 = new JLabel("Instructor");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(137, 217, 110, 22);
        panel.add(l4);
        
        t4 = new JTextField();
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(261, 219, 198, 20);
        panel.add(t4);
        
        comboBox = new JComboBox();
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
        comboBox.setBounds(261, 105, 198, 21);
        panel.add(comboBox);
        
        comboBox2 = new JComboBox();
        comboBox2.setForeground(new Color(0, 0, 0));
        comboBox2.setBounds(261, 160, 198, 21);
        panel.add(comboBox2);
        
        b6 = new JButton("Select");
        b6.addActionListener(this);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b6.setBackground(new Color(0, 0, 102));
        b6.setBounds(468, 102, 95, 33);
        panel.add(b6);
        contentPane.setBackground(new Color(204, 204, 255));

    }

    public void actionPerformed(ActionEvent ae){
    	if (ae.getSource()==b6) {
    		 if (((String)comboBox.getSelectedItem()) == "4") {
    			 comboBox2.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University","Principles of Business","Project Based Learning","Responsible Business","Sustainable Business"
                 }));
    		 }
    		 else if  (((String)comboBox.getSelectedItem()) == "5") {
    			 comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Innovative Business","Digital Business","Contemporary Issues in International Business","International HR Professional","Operation and Project Planning","Managing Finance and Accounts"
                 }));
    		 }
    		 else {
    			 comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Strategic Business", "Global Context for Multinational Enterprises", "Professional Project", "Marketing Consultant"
                 }));
    		 }
    	}
    	else if(ae.getSource() == b3){
        	 this.setVisible(false);
             new DeleteBibmModule().setVisible(true);
    	 }
    	 else if(ae.getSource() == b2){
                this.setVisible(false);
                new Module1().setVisible(true);

            }
    	 else if(ae.getSource() == b4){
                this.setVisible(false);
                new ViewBibmModule().setVisible(true);
            }
    	 else {
        try{
        	if((t1.getText()).length() < 1 ||(t4.getText().length()<1)) {
    			JOptionPane.showMessageDialog(null, "Please fill all the fields ");
    		}
    		
        	else {
            
            if(ae.getSource() == b1){
            	if( uu.isModuleExist(t1.getText())) {
                    JOptionPane.showMessageDialog(null, "Module Exists");}
            	else {
            	connect con = new connect();
                String sql = "insert into bibmmodule(id, name, level, tutor) values(?, ?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setInt(1, Integer.valueOf(t1.getText()));
                st.setString(2, (String)comboBox2.getItemAt(comboBox2.getSelectedIndex()));
                st.setString(3, (String)comboBox.getItemAt(comboBox.getSelectedIndex()));
                st.setString(4, t4.getText());
                int rs = st.executeUpdate();
                if (rs > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }else
                    JOptionPane.showMessageDialog(null, "Error in Adding");
                t1.setText("");
             
                t4.setText("");
                st.close();
                con.c.close();
            	}
            }
        	}
           
        	
            if(ae.getSource() == b5){
            	connect con = new connect();
                String sql = "update bibmmodule set name =?, level=?,tutor=? where id=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, (String)comboBox2.getItemAt(comboBox2.getSelectedIndex()));
                st.setString(2,(String)comboBox.getItemAt(comboBox.getSelectedIndex()));
                st.setString(3, t4.getText());
                st.setInt(4, Integer.valueOf(t1.getText()));
                
                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Module '"+(String)comboBox2.getItemAt(comboBox2.getSelectedIndex())+"' Updated!");
                else
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    st.close();
                    t1.setText("");
                    con.c.close();
            }
        
        	}catch(Exception e){

        }
    }
    }
}