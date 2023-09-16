package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener{
    Choice cb;
    JButton b1, b2, b3;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JLabel name,roomno,price;
    UpdateRoomStatus(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel addroom = new JLabel("Update Room Status");
        addroom.setBounds(90,30,230,30);
        addroom.setFont(new Font("phantom", Font.PLAIN, 24));
        addroom.setForeground(Color.BLUE);
        add(addroom);

        JLabel cusId = new JLabel("Customer ID");
        cusId.setBounds(40,100,140,30);
        cusId.setFont(new Font("phantom", Font.PLAIN, 18));
        add(cusId);

        cb = new Choice();
        cb.setBounds(200,100,140,30);
        cb.setFont(new Font("phantom", Font.PLAIN, 18));
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

        roomno = new JLabel("Room Number");
        roomno.setBounds(40,160,120,30);
        roomno.setFont(new Font("phantom", Font.PLAIN, 18));
        add(roomno);

        name= new JLabel("Availability");
        name.setBounds(40,220,140,30);
        name.setFont(new Font("phantom", Font.PLAIN, 18));
        add(name);

        price = new JLabel("Cleaning Status");
        price.setBounds(40,280,140,30);
        price.setFont(new Font("phantom", Font.PLAIN, 18));
        add(price);

        b1 = new JButton("Check");
        b1.setBounds(30,350,100,30);
        b1.setFont(new Font("phantom", Font.PLAIN,14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(140,350,100,30);
        b2.setFont(new Font("phantom", Font.PLAIN,14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(250,350,100,30);
        b3.setFont(new Font("phantom", Font.PLAIN,14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\seventh.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(400,30,450,350);
        add(label);

        setBounds(300,140,900,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){

            tf1 =new JTextField();
            tf1.setBounds(200,160,140,30);
            tf1.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf1);

            tf2 =new JTextField();
            tf2.setBounds(200,220,140,30);
            tf2.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf2);

            tf3 =new JTextField();
            tf3.setBounds(200,280,140,30);
            tf3.setFont(new Font("phantom", Font.PLAIN,15));
            add(tf3);


            String id = cb.getSelectedItem();
            String query1 = "Select * from Customeradd where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                while(rs.next()){
                    tf1.setText(rs.getString("room_no"));
                }
                ResultSet rs2 = c.s.executeQuery("Select * from addroom where room_no = '"+tf1.getText()+"'");
                while(rs2.next()){
                        tf2.setText(rs2.getString("available"));
                        tf3.setText(rs2.getString("cleaning_status"));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==b2) {
            String room_no = tf1.getText();
            String availability = tf2.getText();
            String status = tf3.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("Update addroom set room_no = '"+room_no+"', available = '"+availability+"', cleaning_status = '"+status+"' where room_no = '"+room_no+"'");
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

        new UpdateRoomStatus();
    }
}

