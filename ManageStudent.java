package course.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.sql.*;
import java.util.*;
//this will be used for adding or deleteing students

public class ManageStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2,b3,b4;
    private JTextField t1;

    public static void main(String[] args) {
        new ManageStudent().setVisible(true);
    }

    user uu = new user();


    public ManageStudent() {
        super("Add Student");
        setBounds(700, 200, 623, 497);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Add/Delete- Students ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(204, 204, 255));
        panel.setBounds(10, 38, 564, 378);
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.add(panel);
        panel.setLayout(null);
        
        b4 = new JButton("View All");
        b4.setBounds(346, 250, 111, 33);
        panel.add(b4);
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBackground(new Color(0, 0, 102));
        b4.setForeground(Color.WHITE);
                
        b2 = new JButton("Back");
        b2.setBounds(193, 318, 111, 33);
        panel.add(b2);
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
                        
        b3 = new JButton("Delete");
        b3.setBounds(193, 250, 111, 33);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
                                
        b1 = new JButton("ADD");
        b1.setBounds(49, 250, 111, 33);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
                                                
        JLabel l1 = new JLabel("Student_id");
        l1.setBounds(49, 28, 102, 22);
        panel.add(l1);
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setBounds(209, 65, 154, 20);
        panel.add(t2);
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(49, 63, 102, 22);
        panel.add(l2);
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                        
        comboBox_3 = new JComboBox();
        comboBox_3.setBounds(209, 104, 154, 20);
        panel.add(comboBox_3);
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"BscIT", "BIBM"}));
        comboBox_3.setForeground(new Color(0, 0, 0));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JLabel l7 = new JLabel("Course");
        l7.setBounds(49, 102, 102, 22);
        panel.add(l7);
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        comboBox_2 = new JComboBox();
        comboBox_2.setBounds(209, 143, 154, 20);
        panel.add(comboBox_2);
        comboBox_2.setModel(
        new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(0, 0, 0));
        
        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(209, 184, 154, 20);
        panel.add(comboBox_1);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"First", "Second", "Third", "Four"}));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JLabel l6 = new JLabel("Semester");
        l6.setBounds(49, 182, 102, 22);
        panel.add(l6);
        l6.setForeground(new Color(0, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel l5 = new JLabel("Level");
        l5.setBounds(49, 141, 102, 22);
        panel.add(l5);
        l5.setForeground(new Color(0, 0, 0));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setColumns(10);
        t1.setBounds(209, 32, 154, 20);
        panel.add(t1);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b3){
            this.setVisible(false);
            new DeleteStudent().setVisible(true);
        }

        else if(ae.getSource() == b2){
            this.setVisible(false);
            new AdminHome().setVisible(true);
        }
        else if(ae.getSource() == b4){
            this.setVisible(false);
            new ViewStudents("Admin").setVisible(true);
        }
        else {
    	if((t1.getText()).length() < 1||(t2.getText()).length() < 1) {
			JOptionPane.showMessageDialog(null, "Please enter all data");
    	}
    	else {
            if(ae.getSource() == b1){
                try{
                	if( uu.isUserExist1(t1.getText())) {
                        JOptionPane.showMessageDialog(null, "Already Enrolled");
                        }
                	else {
                    connect con = new connect();
                    String sql = "insert into student(student_id, name, course, level, semester) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setInt(1, Integer.valueOf(t1.getText()));
                    st.setString(2, t2.getText());
                    st.setString(3, (String) comboBox_3.getSelectedItem());
                    st.setString(4, (String) comboBox_2.getSelectedItem());
                    st.setString(5, (String) comboBox_1.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new ManageStudent().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "error");
                    }
                    if ((String) comboBox_3.getSelectedItem()=="BscIT"){
                        String sql2 = "insert into bscit(student_id,student_name,level) values(?,?,?)";
                        PreparedStatement st2 = con.c.prepareStatement(sql2);
                        st2.setString(1, t1.getText());
                        st2.setString(2, t2.getText());
                        st2.setString(3, (String) comboBox_2.getSelectedItem());

                        st2.executeUpdate();
                    }
                    else {
                        String sql2 = "insert into bibm(student_id,student_name,level) values(?,?,?)";
                        PreparedStatement st2 = con.c.prepareStatement(sql2);
                        st2.setString(1, t1.getText());
                        st2.setString(2, t2.getText());
                        st2.setString(3, (String) comboBox_2.getSelectedItem());
                        st2.executeUpdate();
                    }
                	} }catch(Exception e){
                   
                }
            }
         
        }
    	
        }
 	
    }
    }



