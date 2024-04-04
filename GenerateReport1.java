package course.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class GenerateReport1 extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable table;
    private JTextField t1;
    private JButton b1,b2,b3,b4;
    String status;
    private JLabel pf;
    private JLabel label2;
    private JLabel label1;
    private JLabel lblNewLabel;
    public static void main(String[] args) {
        new GenerateReport1().setVisible(true);
    }

    public void marks() {
        try {
        	if((t1.getText()).length() < 1) {
        		JOptionPane.showMessageDialog(null, "Please enter Student ID");
        		}
            connect con = new connect();
            String sql = "select student_name, student_id,`Concepts and Technologies of AI`, `Object-Oriented Design and Programming`, `Numerical Methods and Concurrency`, `Distributed and Cloud System Programming`, `Collaborative Development`, `Human Computer Interaction` FROM bscit where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
         
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {
        	
        }
    }
    
    public void marksbibm() {
        try {
        	if((t1.getText()).length() < 1) {
        		JOptionPane.showMessageDialog(null, "Please enter Student ID");
        		}
            connect con = new connect();
            String sql = "select  student_name, student_id,`Innovative Business`, `Digital Business`, `Contemporary Issues in International Business`, `International HR Professional`, `Operation and Project Planning`, `Managing Finance and Accounts` FROM bibm where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
       
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {
        
        }
    }
    public void generatebscit() {
        try {
        	if((t1.getText()).length() < 1) {
        		JOptionPane.showMessageDialog(null, "Please enter Student ID");
        		}
            connect con = new connect();
            String sql = "select student_name, student_id,`Concepts and Technologies of AI`, `Object-Oriented Design and Programming`, `Numerical Methods and Concurrency`, `Distributed and Cloud System Programming`, `Collaborative Development`, `Human Computer Interaction` FROM bscit where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
            	int a = rs.getInt("Concepts and Technologies of AI");
            	int b = rs.getInt("Object-Oriented Design and Programming");
            	int c = rs.getInt("Numerical Methods and Concurrency");
            	int d = rs.getInt("Distributed and Cloud System Programming");
            	int e = rs.getInt("Collaborative Development");
            	int f = rs.getInt("Human Computer Interaction");

            	
            	
            	if ((a<40 && a>0)||(b<40 && b>0)||(c<40 && c>0)||(d<40 && d>0)||(e<40 && e>0)||(f<40 && f>0)) {
            		label1.setText("Status:");
            		pf.setText("Fail");
            		label2.setText("Sorry! You can not proceed to another semester.");
            	}
            	
            	else {
            		label1.setText("Status:");
            		pf.setText("Pass");
            		label2.setText("Congratulations! You can proceed to another semester.");
            	}
       
            }
            
            
            rs.close();
            st.close();
            con.c.close();

        } catch (Exception e) {

        }
    }
    public void generatebibm() {
        try {
        	if((t1.getText()).length() < 1) {
        		JOptionPane.showMessageDialog(null, "Please enter Student ID");
        		}
            connect con = new connect();
            String sql = "select  student_name, student_id,`Innovative Business`, `Digital Business`, `Contemporary Issues in International Business`, `International HR Professional`, `Operation and Project Planning`, `Managing Finance and Accounts` FROM bibm where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
            	int a = rs.getInt("Innovative Business");
            	int b = rs.getInt("Digital Business");
            	int c = rs.getInt("Contemporary Issues in International Business");
            	int d = rs.getInt("International HR Professional");
            	int e = rs.getInt("Operation and Project Planning");
            	int f = rs.getInt("Managing Finance and Accounts");

        		 
        	if ((a<40 && a>0)||(b<40 && b>0)||(c<40 && c>0)||(d<40 && d>0)||(e<40 && e>0)||(f<40 && f>0)) {
        		label1.setText("Status:");
        		pf.setText("Fail");
        		label2.setText("Sorry! You can not proceed to another semester.");
        	}
        	
        	else {
        		label1.setText("Status:");
        		pf.setText("Pass");
        		label2.setText("Congratulations! You can proceed to another semester.");
        	}
            }
            
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public GenerateReport1() {
        setBounds(350, 200, 900, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 170, 871, 251);
        scrollPane.setBackground(new Color(204, 204, 255));
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
            }
        });
        table.setBackground(new Color(204, 204, 255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JLabel l1 = new JLabel("Generate Report Level 5");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(250, 20, 400, 47);
        contentPane.add(l1);

        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                AdminHome home = new AdminHome();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        l2.setBounds(90, 90, 72, 33);
        contentPane.add(l2);

        t1 = new JTextField();
      
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(170, 109, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        b1 = new JButton("Search in BscIT");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 80, 200, 20);
        contentPane.add(b1);

        b2 = new JButton("Search in BIBM");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350, 110, 200, 20);
        contentPane.add(b2);

        b3 = new JButton("Generate Report (BscIT)");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(580, 80, 200, 20);
        contentPane.add(b3);

        b4 = new JButton("Generate Report (BIBM)");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(580, 110, 200, 20);
        contentPane.add(b4);
        
        label1 = new JLabel("");
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label1.setBounds(15, 432, 46, 14);
        contentPane.add(label1);
        
        pf = new JLabel("");
        pf.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pf.setBounds(71, 433, 46, 14);
        contentPane.add(pf);
        
        label2 = new JLabel("");
        label2.setFont(new Font("Tahoma", Font.BOLD, 12));
        label2.setBounds(281, 433, 358, 14);
        contentPane.add(label2);
        
        lblNewLabel = new JLabel("Student Id");
        lblNewLabel.setBounds(206, 86, 72, 13);
        contentPane.add(lblNewLabel);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            marks();
        }
        if (ae.getSource()==b2){
            marksbibm();
        }
        if (ae.getSource()==b3){
            generatebscit();
        }
        if (ae.getSource()==b4){
            generatebibm();
        }

    }
}