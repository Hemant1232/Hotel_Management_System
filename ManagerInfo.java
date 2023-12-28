
package Hotel_Management;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {

    JButton button;
    ManagerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("NAME");
        l1.setBounds(30,30,60,25);
        l1.setFont(new Font("serif", Font.BOLD, 14));
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(200,30,110,25);
        l2.setFont(new Font("serif", Font.BOLD, 15));
        add(l2);

        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(320,30,90,25);
        l3.setFont(new Font("serif", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("JOB");
        l4.setBounds(450,30,90,25);
        l4.setFont(new Font("serif", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(580,30,90,25);
        l5.setFont(new Font("serif", Font.BOLD, 15));
        add(l5);

        JLabel l6 = new JLabel("PHONE");
        l6.setBounds(710,30,90,25);
        l6.setFont(new Font("serif", Font.BOLD, 15));
        add(l6);

        JLabel l7 = new JLabel("EMAIL");
        l7.setBounds(850,30,90,25);
        l7.setFont(new Font("serif", Font.BOLD, 15));
        add(l7);

        JLabel l8 = new JLabel("AADHAR");
        l8.setBounds(1000,30,90,25);
        l8.setFont(new Font("serif", Font.BOLD, 15));
        add(l8);

        JTable tbl = new JTable();
        tbl.setBounds(10,70,1100,300);
        tbl.setFont(new Font("serif", Font.PLAIN, 15));
        add(tbl);

        // setResizable(false);

        button = new JButton("Back");
        button.setBounds(460,400,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);

        try{
            Conn c = new Conn();
            String query = "Select * from employee where job = 'Manager'";
            ResultSet rs = c.s.executeQuery(query);
            tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch(Exception ae ){
            ae.printStackTrace();
        }

        setBounds(250,200,1100,500);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            setVisible(false);
            // new reception();
        }
    }
    public static void main(String[] args) {

        new ManagerInfo();
    }
}

