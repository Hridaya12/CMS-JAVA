package course.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

// This part will be used for viewing marks of the students
class ViewMarks extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField t1;
    private JButton b1,b2;
    private JLabel lblNewLabel;
    public static void main(String[] args) {
        new ViewMarks().setVisible(true);
    }

    public void marks() {
        try {
        	if((t1.getText()).length() < 1) {
        		JOptionPane.showMessageDialog(null, "Please enter Student ID");
        		}
            connect con = new connect();
            String sql = "select * from bscit where student_id="+t1.getText()+"";
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
            String sql = "select * from bibm where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public ViewMarks() {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 133, 871, 288);
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

        JLabel l1 = new JLabel("View Marks");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(274, 10, 400, 47);
        contentPane.add(l1);

        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                StudentHome home = new StudentHome();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l2.setBounds(90, 90, 72, 33);
        contentPane.add(l2);

        t1 = new JTextField();
     
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(162, 103, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        b1 = new JButton("Search in BscIT");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(512, 63, 200, 20);
        contentPane.add(b1);

        b2 = new JButton("Search in BIBM");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(512, 101, 200, 20);
        contentPane.add(b2);
        
        lblNewLabel = new JLabel("Student Id");
        lblNewLabel.setBounds(197, 80, 73, 13);
        contentPane.add(lblNewLabel);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            marks();
        }
        if (ae.getSource()==b2){
            marksbibm();
        }

    }
}