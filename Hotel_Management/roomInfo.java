
package Hotel_Management;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

        public class roomInfo extends JFrame implements ActionListener {

            JButton b;
            roomInfo(){
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);

                JLabel l1 = new JLabel("ROOM NO");
                l1.setBounds(10,30,80,25);
                l1.setFont(new Font("serif", Font.BOLD, 14));
                add(l1);

                JLabel l2 = new JLabel("AVAILABLE");
                l2.setBounds(110,30,110,25);
                l2.setFont(new Font("serif", Font.BOLD, 15));
                add(l2);

                JLabel l3 = new JLabel("STATUS");
                l3.setBounds(220,30,90,25);
                l3.setFont(new Font("serif", Font.BOLD, 15));
                add(l3);

                JLabel l4 = new JLabel("PRICE");
                l4.setBounds(320,30,90,25);
                l4.setFont(new Font("serif", Font.BOLD, 15));
                add(l4);

                JLabel l5 = new JLabel("BED TYPE");
                l5.setBounds(420,30,90,25);
                l5.setFont(new Font("serif", Font.BOLD, 15));
                add(l5);

                b = new JButton("Back");
                b.setBounds(180,400,120,30);
                b.setBackground(Color.BLACK);
                b.setForeground(Color.WHITE);
                b.addActionListener(this);

                JTable tbl = new JTable();
                tbl.setBounds(10,70,500,600);
                tbl.setFont(new Font("serif", Font.PLAIN, 18));
                tbl.add(b);
                add(tbl);

                ImageIcon i1 = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\eight.jpg");
                Image i2 = i1.getImage().getScaledInstance(500,600,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(500,0,550,600);
                add(image);
                try{
                    Conn c = new Conn();
                    String query = "Select * from addroom";
                    ResultSet rs = c.s.executeQuery(query);
                    tbl.setModel(DbUtils.resultSetToTableModel(rs));

                } catch(Exception ae ){
                    ae.printStackTrace();
                }
                setBounds(300,200,1050,600);
                setVisible(true);
            }
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b){
                   setVisible(false);
                   // new reception();
                }
            }
            public static void main(String[] args) {

                new roomInfo();
            }
        }
