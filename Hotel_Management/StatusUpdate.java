package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StatusUpdate extends JFrame implements ActionListener{
    Choice cb;
    JButton b1, b2, b3;
    JTextField tf1,tf2,tf3,tf4,tf5;
    StatusUpdate(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel addroom = new JLabel("Update Status");
        addroom.setBounds(110,30,200,30);
        addroom.setFont(new Font("phantom", Font.PLAIN, 24));
        addroom.setForeground(Color.BLUE);
        add(addroom);

        JLabel cusId = new JLabel("Customer ID");
        cusId.setBounds(40,100,140,30);
        cusId.setFont(new Font("phantom", Font.PLAIN, 15));
        add(cusId);

        cb = new Choice();
        cb.setBounds(200,100,140,30);
        cb.setFont(new Font("phantom", Font.PLAIN, 15));
        cb.setBackground(Color.WHITE);
        add(cb);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Customeradd");
            while(rs.next()){
               cb.add(rs.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(40,150,120,30);
        roomno.setFont(new Font("phantom", Font.PLAIN, 15));
        add(roomno);

        JLabel name= new JLabel("Name");
        name.setBounds(40,200,140,30);
        name.setFont(new Font("phantom", Font.PLAIN, 15));
        add(name);

        JLabel price = new JLabel("Checkin Time");
        price.setBounds(40,250,120,30);
        price.setFont(new Font("phantom", Font.PLAIN, 15));
        add(price);

        JLabel amountpaid = new JLabel("Amount Paid");
        amountpaid.setBounds(40,300,120,30);
        amountpaid.setFont(new Font("phantom", Font.PLAIN, 15));
        add(amountpaid);

        JLabel pendingamount = new JLabel("Pending Amount");
        pendingamount.setBounds(40,350,120,30);
        pendingamount.setFont(new Font("phantom", Font.PLAIN, 15));
        add(pendingamount);



        b1 = new JButton("Check");
        b1.setBounds(30,430,100,30);
        b1.setFont(new Font("phantom", Font.PLAIN,14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(140,430,100,30);
        b2.setFont(new Font("phantom", Font.PLAIN,14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(250,430,100,30);
        b3.setFont(new Font("phantom", Font.PLAIN,14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\nine.jpg");
        Image i2 = i1.getImage().getScaledInstance(470,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(400,10,450,430);
        add(label);

        setBounds(300,140,900,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){

            tf1 =new JTextField();
            tf1.setBounds(200,150,140,30);
            tf1.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf1);

            tf2 =new JTextField();
            tf2.setBounds(200,200,140,30);
            tf2.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf2);

            tf3 =new JTextField();
            tf3.setBounds(200,250,140,30);
            tf3.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf3);

            tf4 =new JTextField();
            tf4.setBounds(200,300,140,30);
            tf4.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf4);

            tf5 =new JTextField();
            tf5.setBounds(200,350,140,30);
            tf5.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf5);

            String id = cb.getSelectedItem();
            String query1 = "Select * from Customeradd where number = '"+id+"'";
            try{
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query1);
               while(rs.next()){
                   tf1.setText(rs.getString("room_no"));
                   tf2.setText(rs.getString("name"));
                   tf3.setText(rs.getString("time"));
                   tf4.setText(rs.getString("deposit"));
               }
               ResultSet rs2 = c.s.executeQuery("Select * from addroom where room_no = '"+tf1.getText()+"'");
               while(rs2.next()){
                   String price = rs2.getString("price");
                   int amountpaid = Integer.parseInt(price) - Integer.parseInt(tf4.getText());
                   tf5.setText("" + amountpaid);
               }
            }
            catch (Exception e){
                 e.printStackTrace();
            }
        }
        else if (ae.getSource()==b2) {
                String room_no = tf1.getText();
                String name = tf2.getText();
                String time = tf3.getText();
                String deposit = tf4.getText();
                String choice = cb.getSelectedItem();
                String pending = tf5.getText();
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("Update Customeradd set room_no = '"+room_no+"', name = '"+name+"', time = '"+time+"', deposit = '"+deposit+"' where number = '"+choice+"'");
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                   setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        }
        else if (ae.getSource()==b3){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StatusUpdate();
    }
}
