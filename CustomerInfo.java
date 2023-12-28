package Hotel_Management;

import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class CustomerInfo extends JFrame implements ActionListener {
    JButton button;

    CustomerInfo(){
        setLayout(null);

        JLabel l1 = new JLabel("IDENTITY");
        l1.setBounds(20,30,90,25);
        l1.setFont(new Font("serif", Font.BOLD, 15));
        add(l1);

        JLabel l2 = new JLabel("NUMBER");
        l2.setBounds(150,30,70,25);
        l2.setFont(new Font("serif", Font.BOLD, 15));
        add(l2);

        JLabel l3 = new JLabel("NAME");
        l3.setBounds(270,30,70,25);
        l3.setFont(new Font("serif", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(390,30,70,25);
        l4.setFont(new Font("serif", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("COUNRTY");
        l5.setBounds(510,30,100,25);
        l5.setFont(new Font("serif", Font.BOLD, 15));
        add(l5);

        JLabel l6 = new JLabel("ROOM NO");
        l6.setBounds(650,30,120,20);
        l6.setFont(new Font("serif", Font.BOLD, 15));
        add(l6);

        JLabel l7 = new JLabel("TIME");
        l7.setBounds(780,30,70,20);
        l7.setFont(new Font("serif", Font.BOLD, 15));
        add(l7);

        JLabel l8 = new JLabel("DEPOSIT");
        l8.setBounds(890,30,70,20);
        l8.setFont(new Font("serif", Font.BOLD, 15));
        add(l8);

        JTable tbl = new JTable();
        tbl.setBounds(0,70,1000,200);
        tbl.setFont(new Font("serif", Font.PLAIN, 18));
        add(tbl);


        try{
            Conn c = new Conn();
            String query = "Select * from customeradd";
            ResultSet rs = c.s.executeQuery(query);
            tbl.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1000,500);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
