package Hotel_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    reception(){
        setBounds(350,160,800,570);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        b1 = new JButton("New Customer Form");
        b1.setBounds(10,30,200,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Rooms Info");
        b2.setBounds(10,70,200,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Department Info");
        b3.setBounds(10,110,200,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Employees Info");
        b4.setBounds(10,150,200,30);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBounds(10,190,200,30);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBounds(10,230,200,30);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Checkout");
        b7.setBounds(10,270,200,30);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Status");
        b8.setBounds(10,310,200,30);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBounds(10,350,200,30);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pickup Room Service");
        b10.setBounds(10,390,200,30);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search Room ");
        b11.setBounds(10,430,200,30);
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBounds(10,470,200,30);
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.addActionListener(this);
        add(b12);

        ImageIcon img = new ImageIcon("src\\images\\fourth.jpg");
        Image img2 = img.getImage().getScaledInstance(550,500, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel jb = new JLabel(img3);
        jb.setBounds(220,20,550,500);
        add(jb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==b1){
            new addcustomer();
        }
        else if (ae.getSource()==b2) {
          new roomInfo();
        }
        else if (ae.getSource()==b3) {
            new Department();
        }
        else if (ae.getSource()==b4) {
            new EmployeeInfo();
        }
        else if (ae.getSource()==b5) {
            new CustomerInfo();
        }
        else if (ae.getSource()==b6) {
            new ManagerInfo();
        }
        else if (ae.getSource()==b7) {
            new CheckOut();
        }
        else if (ae.getSource()==b8) {
            new StatusUpdate();
        }
        else if (ae.getSource()==b9) {
            new UpdateRoomStatus();
        }
        else if (ae.getSource()==b10) {
            new PickUpService();
        }
        else if (ae.getSource()==b11) {
            new SearchRoom();
        }
        else if (ae.getSource()==b12) {
            new logout();
        }
    }
    public static void main(String[] args) {
        new reception();
    }
}
