package course.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AdminHome extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton b1,b2,b3,b5;
    private JButton b4;

    public static void main(String[] args) {
        new AdminHome().setVisible(true);
    }

    public AdminHome() {

        setBounds(400, 150, 725, 525);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(204, 204, 255));


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setForeground(Color.BLACK);
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(new Color(204, 204, 255));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(204, 204, 255));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);
        menuBar.add(mnExit);

        JLabel l1 = new JLabel("Admin Dashboard");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(240, 30, 328, 80);
        contentPane.add(l1);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Works", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(122, 107, 488, 323);
        panel.setBackground(new Color(204, 204, 255));
        contentPane.add(panel);
        panel.setLayout(null);
        
        b5 = new JButton("Generate Student Report");
        b5.setBounds(137, 257, 200, 44);
        panel.add(b5);
        b5.addActionListener(this);
        b5.setBackground(new Color(0, 0, 102));
        b5.setForeground(Color.WHITE);
                
        b3 = new JButton("Manage Students");
        b3.setBounds(137, 197, 200, 44);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
        
        b2 = new JButton("Manage Courses");
        b2.setBounds(137, 87, 200, 44);
        panel.add(b2);
        b2.addActionListener(this);
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
        
        
        b1 = new JButton("Manage Instructors");
        b1.setBounds(137, 26, 200, 44);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
        
        b4 = new JButton("Manage Modules");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(0, 0, 102));
        b4.setBounds(137, 142, 200, 44);
        panel.add(b4);
        b4.addActionListener(this);                               

    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Logout")){
            setVisible(false);
            new Main().setVisible(true);
        }else if(msg.equals("Exit")){
            System.exit(ABORT);
        }
        if(ae.getSource() == b1){
            this.setVisible(false);
            new ManageInstructor().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new ManageCourse().setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new ManageStudent().setVisible(true);
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new Module1().setVisible(true);
        }
        if(ae.getSource() == b5){
            this.setVisible(false);
            new ChooseReport().setVisible(true);
        }

    }
}
