package course.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageInstructor extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2;
    private JComboBox comboBox_2, comboBox_3;
    JButton b1,b2,b3,b4;
    private JTextField t1;
    private JButton b5;
    private JComboBox cbm1;
 
    public static void main(String[] args) {
        new ManageInstructor().setVisible(true);
    }

user uu = new user();

    public ManageInstructor() {
        super("Add Instructor");
        setBounds(700, 200, 708, 438);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(204, 204, 255));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Add/Delete-Instructor ",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(99, 27, 464, 344);
        contentPane.setBackground(new Color(204,204,255));
        panel.setBackground(new Color(204, 204, 255));
        contentPane.add(panel);
        panel.setLayout(null);
                
        JLabel l1 = new JLabel("Instructor_id");
        l1.setBounds(47, 61, 102, 22);
        panel.add(l1);
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
                        
                        
        t2 = new JTextField();
        t2.setBounds(159, 95, 156, 20);
        panel.add(t2);
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(47, 93, 102, 22);
        panel.add(l2);
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
                                        
        comboBox_3 = new JComboBox();
        comboBox_3.setBounds(159, 127, 154, 20);
        panel.add(comboBox_3);
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"BscIT", "BIBM"}));
        comboBox_3.setForeground(new Color(0, 0, 0));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        	
        JLabel l7 = new JLabel("Faculty");
        l7.setBounds(47, 125, 102, 22);
        panel.add(l7);
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                        
        comboBox_2 = new JComboBox();
        comboBox_2.setBounds(159, 157, 154, 20);
        panel.add(comboBox_2);
        comboBox_2.setModel(
        new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
       	comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
       	comboBox_2.setForeground(new Color(0, 0, 0));
                                                                
       	JLabel l5 = new JLabel("Level");
       	l5.setBounds(47, 155, 102, 22);
       	panel.add(l5);
       	l5.setForeground(new Color(0, 0, 0));
    	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                                
    	JLabel l6 = new JLabel("Module");
    	l6.setBounds(47, 187, 102, 22);
    	panel.add(l6);
    	l6.setForeground(new Color(0, 0, 0));
    	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                                        
    	b4 = new JButton("View All");
    	b4.setBounds(277, 244, 111, 33);
    	panel.add(b4);
    	b4.addActionListener(this);
    	b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	b4.setBackground(new Color(0, 0, 102));
    	b4.setForeground(Color.WHITE);
                                                                                                
    	b3 = new JButton("Delete");
    	b3.setBounds(145, 244, 111, 33);
    	panel.add(b3);
    	b3.addActionListener(this);
    	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	b3.setBackground(new Color(0, 0, 102));
    	b3.setForeground(Color.WHITE);
                                                                                                        
    	b1 = new JButton("ADD");
    	b1.setBounds(10, 244, 111, 33);
    	panel.add(b1);
    	b1.addActionListener(this);
    	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	b1.setBackground(new Color(0, 0, 102));
    	b1.setForeground(Color.WHITE);
                                                                                                                
    	b2 = new JButton("Back");
    	b2.setBounds(145, 292, 111, 33);
    	panel.add(b2);
    	b2.addActionListener(this);
    	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	b2.setBackground(new Color(0, 0, 102));
    	b2.setForeground(Color.WHITE);
    	
    	t1 = new JTextField();
    	t1.setForeground(Color.BLACK);
    	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	t1.setColumns(10);
    	t1.setBounds(159, 65, 156, 20);
    	panel.add(t1);
    	
    	b5 = new JButton("Select");
    	b5.setForeground(Color.WHITE);
    	b5.addActionListener(this);
    	b5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	b5.setBackground(new Color(0, 0, 102));
    	b5.setBounds(323, 128, 111, 33);
    	panel.add(b5);
    	
    	cbm1 = new JComboBox();
    	cbm1.setForeground(Color.BLACK);
    	cbm1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    	cbm1.setBounds(159, 187, 154, 20);
    	panel.add(cbm1);
    }

    public void actionPerformed(ActionEvent ae){
    	  if (ae.getSource() == b3){
              this.setVisible(false);
              new DeleteInstructor().setVisible(true);
          }

    	  else if(ae.getSource() == b2){
              this.setVisible(false);
              new AdminHome().setVisible(true);
          }
    	  else if(ae.getSource() == b4){
              this.setVisible(false);
              new ViewInstructors("Admin").setVisible(true);
          }
    	  else {
        try{	
        	if((t1.getText()).length() < 1||(t2.getText()).length() < 1) {
			JOptionPane.showMessageDialog(null, "Please enter all data");
            }
            if(ae.getSource() == b1){
                try{
                	if( uu.isUserExist2(t1.getText())) {
                        JOptionPane.showMessageDialog(null, "Already Exists");}
                	else {
                    connect con = new connect();
                    String sql = "insert into instructor(instructor_id, name, faculty, semester,module) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setInt(1, Integer.valueOf(t1.getText()));
                    st.setString(2, t2.getText());
                    st.setString(3, (String) comboBox_3.getSelectedItem());
                    st.setString(4, (String) comboBox_2.getSelectedItem());
                    st.setString(5, (String) cbm1.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new ManageInstructor().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "error");
                    }}
                	}catch(Exception e){

                }
            }
                
          
            if (ae.getSource()==b5){
                // if user selects another course, the combobox for marks will change from here
                if (((String)comboBox_3.getSelectedItem()) == "BIBM" && ((String)comboBox_2.getSelectedItem()) == "4") {
                    cbm1.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Innovative Business", "Principles of Business", "Project Based Learning","Responsible Business","Sustainable Business"
                    }));


                }
                else if (((String)comboBox_3.getSelectedItem()) == "BIBM" && ((String)comboBox_2.getSelectedItem()) == "5") {
                    cbm1.setModel(new DefaultComboBoxModel(new String[] {"Innovative Business","Digital Business",
                            "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                            "Managing Finance and Accounts"
                    }));


               
                }
                else if (((String)comboBox_3.getSelectedItem()) == "BIBM" && ((String)comboBox_2.getSelectedItem()) == "6") {
                    cbm1.setModel(new DefaultComboBoxModel(new String[] {"Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                            "Marketing Consultant"
                    }));



  
                }
                 if(((String)comboBox_3.getSelectedItem()) == "BscIT" && ((String)comboBox_2.getSelectedItem()) == "4") {
                	
                	cbm1.setModel(new DefaultComboBoxModel(new String[] {"Introductory Programming","Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                            "Internet Software","Computational Mathematics"
                    }));
                	
               
                }
                 else if(((String)comboBox_3.getSelectedItem()) == "BscIT" && ((String)comboBox_2.getSelectedItem()) == "5") {
                 	
                 	cbm1.setModel(new DefaultComboBoxModel(new String[] {"Concepts and Technologies of AI","Object-Oriented Design and Programming",
                            "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                            "Human Computer Interaction",
                     }));
                 	
                
                 }
                 else if(((String)comboBox_3.getSelectedItem()) == "BscIT" && ((String)comboBox_2.getSelectedItem()) == "5") {
                  	
                  	cbm1.setModel(new DefaultComboBoxModel(new String[] {"Complex System","High Performance Computing","Project and Professionalism",
                            "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
                      }));
                
                  }
            
            }
    }
    	  
        catch(Exception e){

        }   
    	  }}
}