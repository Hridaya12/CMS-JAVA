package course.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

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

class EnrollCourse extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2;
    private JComboBox comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    private JTextField t1;

    public static void main(String[] args) {
        new EnrollCourse().setVisible(true);
    }
    user uu = new user();

    public EnrollCourse() {
        super("Enroll Course");
        setBounds(700, 200, 425, 433);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 63, 102, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 97, 102, 22);
        contentPane.add(l2);

        JLabel l5 = new JLabel("Level");
        l5.setForeground(new Color(0, 0, 0));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 182, 102, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Semester");
        l6.setForeground(new Color(0, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 222, 102, 22);
        contentPane.add(l6);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Four" }));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(176, 220, 154, 20);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(
        new DefaultComboBoxModel(new String[] {"3", "4", "5", "6"}));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(0, 0, 0));
        comboBox_2.setBounds(176, 180, 154, 20);
        contentPane.add(comboBox_2);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 140, 102, 22);
        contentPane.add(l7);

        comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(
        new String[] { "BscIT", "BIBM"}));
        comboBox_3.setForeground(new Color(0, 0, 0));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_3.setBounds(176, 138, 154, 20);
        contentPane.add(comboBox_3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Enroll Yourself ",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(204, 204, 255));
        panel.setBounds(10, 38, 379, 330);
        contentPane.setBackground(new Color(204, 204, 255));
        panel.setBackground(new Color(204, 204, 255));
        contentPane.add(panel);
        panel.setLayout(null);
        
        b1 = new JButton("Enroll");
        b1.setBounds(61, 266, 111, 33);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Back");
        b2.setBounds(212, 266, 111, 33);
        panel.add(b2);
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setColumns(10);
        t1.setBounds(167, 34, 154, 20);
        panel.add(t1);
        
        t2 = new JTextField();
        t2.setBounds(167, 66, 154, 20);
        panel.add(t2);
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
    }
    public void actionPerformed(ActionEvent ae){
       
            if(ae.getSource() == b1){
            	if((t1.getText()).length() < 1) {
        			JOptionPane.showMessageDialog(null, "Please enter Student ID");
        			this.setVisible(false);
                    new EnrollCourse().setVisible(true);
        		}
        		
        		else if((t2.getText()).length() < 1) {
        			JOptionPane.showMessageDialog(null, "Please enter name");
        			this.setVisible(false);
                    new EnrollCourse().setVisible(true);
        		}
        		else {
                try{
                	if( uu.isUserExist1(t1.getText())) {
                        JOptionPane.showMessageDialog(null, "Already Enrolled");}
                	else {
                    connect con = new connect();
                    String sql = "insert into student(student_id, name, course, level, semester) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, (String) comboBox_3.getSelectedItem());
                    st.setString(4, (String) comboBox_2.getSelectedItem());
                    st.setString(5, (String) comboBox_1.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Enrolled");
                        this.setVisible(false);
                        new EnrollCourse().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
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
                	}
                  }catch(Exception e){
                    e.printStackTrace();
                }
        		}
          }
            else if(ae.getSource() == b2) {
        		this.setVisible(false);
                new StudentHome().setVisible(true);
            }
    

    }	
}