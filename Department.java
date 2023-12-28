
package Hotel_Management;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JButton button;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400,200,800,500);

        JLabel l1 = new JLabel("DEPARTMENT");
        l1.setBounds(100,30,150,25);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        JLabel l2 = new JLabel("SALARY");
        l2.setBounds(530,30,150,25);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        add(l2);

        JTable tbl = new JTable();
        tbl.setBounds(10,70,800,300);
        tbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(tbl);

        button = new JButton("Back");
        button.setBounds(340,400,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);

        try{
            Conn c = new Conn();
            String query = "Select * from Department";
            ResultSet rs = c.s.executeQuery(query);
           tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch(Exception ae){
            ae.printStackTrace();
        }

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            setVisible(false);
        }

    }
    public static void main(String[] args) {

        new Department();
    }
}
