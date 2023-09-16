package Hotel_Management;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener{
    DashBoard(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(null);
        setBounds(0,0,screenSize.width,screenSize.height);

        ImageIcon i1 = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);

        JLabel text = new JLabel("The Taj Hotel Welcomes You");
        text.setBounds(500,80,800,60);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("phantom", Font.PLAIN, 40));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        mb.setBackground(Color.white);
        image.add(mb);

        JMenu menu = new JMenu("MANAGEMENT");
        menu.setFont(new Font("phantom", Font.PLAIN,20));
        menu.setForeground(Color.black);
        mb.add(menu);

        JMenuItem r = new JMenuItem("RECEPTION");
        r.setFont(new Font("phantom", Font.PLAIN, 15));
        r.setForeground(Color.BLACK);
        r.addActionListener(this);
        menu.add(r);

        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("phantom", Font.PLAIN,20));
        admin.setForeground(Color.black);
        admin.addActionListener(this);
        mb.add(admin);

        JMenuItem m1 = new JMenuItem("ADD ROOM");
        m1.setFont(new Font("phantom", Font.PLAIN,15));
        m1.setForeground(Color.BLACK);
        m1.addActionListener(this);
        admin.add(m1);

        JMenuItem m2 = new JMenuItem("ADD EMOLOYEE");
        m2.setFont(new Font("phantom", Font.PLAIN,15));
        m2.setForeground(Color.BLACK);
        m2.addActionListener(this);
        admin.add(m2);

        JMenuItem m3 = new JMenuItem("ADD DRIVER");
        m3.setFont(new Font("phantom", Font.PLAIN,15));
        m3.setForeground(Color.BLACK);
        m3.addActionListener(this);
        admin.add(m3);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMOLOYEE")){
            new addemployee();
        }
        else  if(ae.getActionCommand().equals("ADD DRIVER")){
            new adddriver();
        }
        else  if(ae.getActionCommand().equals("ADD ROOM")){
            new addroom();
        }
        else  if(ae.getActionCommand().equals("RECEPTION")){
            new reception();
        }
    }
    public static void main(String[] args) {

        new DashBoard();
    }
}

