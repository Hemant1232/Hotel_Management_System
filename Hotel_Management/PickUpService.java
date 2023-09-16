
package Hotel_Management;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class PickUpService extends JFrame implements ActionListener {

    JButton search1,back;
    Choice ch;
    JTable tbl;
    PickUpService(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel search = new JLabel("Pickup Service");
        search.setBounds(450,30,200,25);
        search.setFont(new Font("Tahoma",Font.PLAIN,25));
        search.setForeground(Color.blue);
        add(search);

        JLabel l0 = new JLabel("Type Of Car");
        l0.setBounds(120,100,120,40);
        l0.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(l0);

        ch = new Choice();
        ch.setBounds(250,110,150,40);
        ch.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(ch);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from adddriver");
            while(rs.next()){
                ch.add(rs.getString("Car_model"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("NAME");
        l1.setBounds(30,200,80,25);
        l1.setFont(new Font("serif", Font.BOLD, 14));
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(180,200,110,25);
        l2.setFont(new Font("serif", Font.BOLD, 14));
        add(l2);

        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(320,200,110,25);
        l3.setFont(new Font("serif", Font.BOLD, 14));
        add(l3);

        JLabel l4 = new JLabel("CAR COMPANY");
        l4.setBounds(460,200,110,25);
        l4.setFont(new Font("serif", Font.BOLD, 14));
        add(l4);

        JLabel l5 = new JLabel("CAR MODEL");
        l5.setBounds(620,200,110,25);
        l5.setFont(new Font("serif", Font.BOLD, 15));
        add(l5);

        JLabel l6 = new JLabel("AVAILABLE");
        l6.setBounds(770,200,90,25);
        l6.setFont(new Font("serif", Font.BOLD, 15));
        add(l6);

        JLabel l7 = new JLabel("LOCATION");
        l7.setBounds(920,200,90,25);
        l7.setFont(new Font("serif", Font.BOLD, 15));
        add(l7);

        search1 = new JButton("Search");
        search1.setBounds(360,500,120,30);
        search1.setBackground(Color.BLACK);
        search1.setForeground(Color.WHITE);
        search1.addActionListener(this);
        add(search1);

        back = new JButton("Back");
        back.setBounds(570,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        tbl = new JTable();
        tbl.setBounds(0,250,1050,200);
        tbl.setFont(new Font("serif", Font.PLAIN, 18));
        add(tbl);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from adddriver");
            tbl.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

        setBounds(250,150,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search1) {
            String s = ch.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from adddriver  where Car_model = '"+s+"'");
                tbl.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ae){
               ae.printStackTrace();
            }
        }
         else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new PickUpService();
    }
}
