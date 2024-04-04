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
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class DeleteStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2;
    private JButton b1,b2,b3;
    private JComboBox comboBox_1;

    public static void main(String[] args) {
        new DeleteStudent().setVisible(true);
    }

    public DeleteStudent() {
        setBounds(600, 200, 450, 350);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student ID");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(53, 80, 110, 22);
        contentPane.add(l1);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 82, 198, 20);
        contentPane.add(t2);

        JLabel l2 = new JLabel("Course");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(53, 120, 110, 22);
        contentPane.add(l2);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BscIT", "bibm"}));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(169, 120, 198, 20);
        contentPane.add(comboBox_1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(150, 250, 108, 33);
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Delete Student", TitledBorder.LEADING,
        TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 29, 398, 200);
        contentPane.add(panel);
        panel.setBackground(new Color(204, 204, 255));
        panel.setLayout(null);
        
        b3 = new JButton("Delete");
        b3.setBounds(147, 136, 100, 33);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
        contentPane.setBackground(new Color(204, 204, 255));

    }

    public void actionPerformed(ActionEvent ae){
	
    	 if(ae.getSource() == b2){
             this.setVisible(false);
             new ManageStudent().setVisible(true);
         }
    	 else {
        try{
        	if((t2.getText()).length() < 1){
    			JOptionPane.showMessageDialog(null, "Error in Deleting");
    		}
        	else {
            connect con = new connect();
            if(ae.getSource() == b3){
                String sql = "delete from student where student_id=?";
                
                PreparedStatement st = con.c.prepareStatement(sql);
               
                st.setString(1, t2.getText());
//                st.setString(2, (String) comboBox_1.getSelectedItem());

                int i = st.executeUpdate();
               
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Student '"+t2.getText()+"' Deleted!");
                }
            else {
                JOptionPane.showMessageDialog(null, "Error in deleting");

            }
            if ((String) comboBox_1.getSelectedItem()=="BscIT"){
                String sql2 = "delete from bscit where student_id=?";
                PreparedStatement st2 = con.c.prepareStatement(sql2);
               
                st2.setString(1, t2.getText());
     
                st2.executeUpdate();
            }
            else {
                String sql3 = "delete from bibm where student_id=?";
                PreparedStatement st3 = con.c.prepareStatement(sql3);
                st3.setString(1, t2.getText());
            
                st3.executeUpdate();
            }
           
            con.c.close();
        }
        	}
        }catch(Exception e){

        }
    }
    }
}