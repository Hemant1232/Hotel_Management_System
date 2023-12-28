
package Hotel_Management;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JButton search1,back,reset;
    JComboBox cb;
  JCheckBox box;
    JTable tbl;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search for room");
        search.setBounds(450,30,200,25);
        search.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(search);

        JLabel l0 = new JLabel("Bed Type");
        l0.setBounds(120,100,150,40);
        l0.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(l0);

        cb = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        cb.setBounds(220,100,150,40);
        cb.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(cb);

        box = new JCheckBox("Show Only Available");
        box.setBounds(600,100,190,40);
        box.setFont(new Font("phantom", Font.PLAIN,16));
        add(box);

        JLabel l1 = new JLabel("ROOM NO");
        l1.setBounds(30,200,80,25);
        l1.setFont(new Font("serif", Font.BOLD, 14));
        add(l1);

        JLabel l2 = new JLabel("AVAILABLE");
        l2.setBounds(240,200,110,25);
        l2.setFont(new Font("serif", Font.BOLD, 15));
        add(l2);

        JLabel l3 = new JLabel("STATUS");
        l3.setBounds(450,200,90,25);
        l3.setFont(new Font("serif", Font.BOLD, 15));
        add(l3);

        JLabel l4 = new JLabel("PRICE");
        l4.setBounds(660,200,90,25);
        l4.setFont(new Font("serif", Font.BOLD, 15));
        add(l4);

        JLabel l5 = new JLabel("BED TYPE");
        l5.setBounds(870,200,90,25);
        l5.setFont(new Font("serif", Font.BOLD, 15));
        add(l5);

        search1 = new JButton("Search");
        search1.setBounds(300,500,120,30);
        search1.setBackground(Color.BLACK);
        search1.setForeground(Color.WHITE);
        search1.addActionListener(this);
        add(search1);

        reset = new JButton("Reset");
        reset.setBounds(445,500,120,30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        back = new JButton("Back");
        back.setBounds(590,500,120,30);
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
            String query = "Select * from addroom";
            ResultSet rs = c.s.executeQuery(query);
            tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch(Exception ae ){
            ae.printStackTrace();
        }
        setBounds(250,150,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        ResultSet rs;
        if (e.getSource() == search1) {
            try {
                Conn c = new Conn();

                String query1 = " Select * from addroom where bed_type = '" + cb.getSelectedItem() + "'";
                String query2 = "Select * from addroom where available = 'Available' AND  bed_type = '" + cb.getSelectedItem() + "'";
                if (box.isSelected()) {

                    rs = c.s.executeQuery(query2);

                } else {

                    rs = c.s.executeQuery(query1);
                }
                tbl.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==reset){
            try{
                Conn c = new Conn();
                String query1 = " Select * from addroom ";
                ResultSet rs1 = c.s.executeQuery(query1);
                tbl.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch(Exception a){
                a.printStackTrace();
            }
        }
        else if (e.getSource() == back) {
             setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
