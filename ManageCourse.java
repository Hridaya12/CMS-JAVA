package course.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageCourse extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2;
    private JButton b1,b2,b3,b4,b5;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new ManageCourse().setVisible(true);
    }
    user uu = new user();
    public ManageCourse() {
        setBounds(600, 200, 634, 472);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "manage Course", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 29, 589, 395);
        contentPane.add(panel);
        panel.setBackground(new Color(204, 204, 255));
        panel.setLayout(null);
        
        b4 = new JButton("View All");
        b4.setBounds(396, 238, 111, 33);
        panel.add(b4);
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBackground(new Color(0, 0, 102));
        b4.setForeground(Color.WHITE);
                
        b3 = new JButton("Delete");
        b3.setBounds(237, 237, 111, 33);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
                        
        b2 = new JButton("Back");
        b2.setBounds(338, 310, 111, 33);
        panel.add(b2);
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
                                
        b1 = new JButton("Add");
        b1.setBounds(77, 237, 111, 33);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
                                        
        b5 = new JButton("Update");
        b5.setBounds(137, 310, 111, 33);
        panel.add(b5);
        b5.addActionListener(this);
        b5.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b5.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b5.setBackground(new Color(0, 0, 102));
        b5.setForeground(Color.WHITE);
                                                
        comboBox = new JComboBox();
        comboBox.setBounds(261, 175, 198, 20);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel(
        		new String[] { "Active", "Cancelled"}));
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JLabel l3 = new JLabel("Course Status");
        l3.setBounds(137, 173, 110, 22);
        panel.add(l3);
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel l2 = new JLabel("Course Name");
        l2.setBounds(137, 111, 110, 22);
        panel.add(l2);
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setBounds(261, 113, 198, 20);
        panel.add(t2);
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
                                                                                
        t1 = new JTextField();
        t1.setBounds(261, 50, 198, 20);
        panel.add(t1);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setColumns(10);
        
        JLabel l1 = new JLabel("Course ID");
        l1.setBounds(137, 48, 110, 22);
        panel.add(l1);
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.setBackground(new Color(204, 204, 255));

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b2) {
            this.setVisible(false);
            new AdminHome().setVisible(true);
        }
        else if(ae.getSource() == b3){
       	 this.setVisible(false);
            new DeleteCourse().setVisible(true);
       }
        else  if(ae.getSource() == b4) {
            this.setVisible(false);
            new ViewCourses().setVisible(true);
        }
        else {
        try{
        	if((t1.getText()).length() < 1) {
    			JOptionPane.showMessageDialog(null, "Please enter Course ID");
    			this.setVisible(false);
                new ManageCourse().setVisible(true);
    		}
    		
    		else if((t2.getText()).length() < 1) {
    			JOptionPane.showMessageDialog(null, "Please Course name");
    			this.setVisible(false);
                new ManageCourse().setVisible(true);
    		}
    		else {
    			if( uu.isCourseExist2(t1.getText())) {
                    JOptionPane.showMessageDialog(null, "Already Exists");}
            	else {
            connect con = new connect();
            if(ae.getSource() == b1){
                String sql = "insert into coursedb(course_id, course_name, status) values(?, ?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3,(String) comboBox.getSelectedItem());
                int rs = st.executeUpdate();
                if (rs > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }else
                    JOptionPane.showMessageDialog(null, "Error in Adding");
                t1.setText("");
                t2.setText("");
                st.close();}
          
            if(ae.getSource() == b5){
                String sql = "update coursedb set status=? where course_name=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1,(String) comboBox.getSelectedItem());
                st.setString(2, t2.getText());

                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Course '"+t2.getText()+"' Updated!");
                else
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    st.close();
                    t1.setText("");
                    t2.setText("");
                    con.c.close();
            }
    		}
    		}
    		}catch(Exception e){

        }
        }
    }
}