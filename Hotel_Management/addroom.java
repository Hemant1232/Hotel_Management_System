package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addroom extends JFrame implements ActionListener{
    JTextField room1,price1;
    JComboBox cb,cb1,cb2;
    JButton b1, b2;
    addroom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel addroom = new JLabel("Add Rooms");
        addroom.setBounds(120,10,140,30);
        addroom.setFont(new Font("phantom", Font.PLAIN, 24));
        addroom.setForeground(Color.BLACK);
        add(addroom);

        JLabel room = new JLabel("Room No.");
        room.setBounds(40,70,140,30);
        room.setFont(new Font("phantom", Font.PLAIN, 20));
        add(room);

         room1 = new JTextField();
        room1.setBounds(220,70,120,30);
        room1.setFont(new Font("phantom", Font.PLAIN, 15));
        add(room1);

        JLabel status = new JLabel("Available");
        status.setBounds(40,120,120,30);
        status.setFont(new Font("phantom", Font.PLAIN, 20));
        add(status);

        String str[] = {"None", "Available", "Occupied"};
         cb = new JComboBox(str);
        cb.setBounds(220,120,120,30);
        cb.setFont(new Font("phantom", Font.PLAIN,16));
        cb.setBackground(Color.white);
        cb.setForeground(Color.BLACK);
        add(cb);

        JLabel cleanstatus = new JLabel("Cleaning Status");
        cleanstatus.setBounds(40,170,140,30);
        cleanstatus.setFont(new Font("phantom", Font.PLAIN, 19));
        add(cleanstatus);

        String str1[] = {"None","Cleaned", "Dirty"};
         cb1 = new JComboBox(str1);
        cb1.setBounds(220,170,120,30);
        cb1.setFont(new Font("phantom", Font.PLAIN,16));
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.BLACK);
        add(cb1);

        JLabel price = new JLabel("Price");
        price.setBounds(40,220,120,30);
        price.setFont(new Font("phantom", Font.PLAIN, 20));
        add(price);

         price1 = new JTextField();
        price1.setBounds(220,220,120,30);
        price1.setFont(new Font("phantom", Font.PLAIN, 15));
        add(price1);

        JLabel roomtype = new JLabel("Bed Type");
        roomtype.setBounds(40,270,120,30);
        roomtype.setFont(new Font("phantom", Font.PLAIN, 20));
        add(roomtype);

        String str2[] = {"None","Single Bed", "Double Bed"};
         cb2 = new JComboBox(str2);
        cb2.setBounds(220,270,120,30);
        cb2.setFont(new Font("phantom", Font.PLAIN,16));
        cb2.setBackground(Color.white);
        cb2.setForeground(Color.BLACK);
        add(cb2);

         b1 = new JButton("Add Room");
        b1.setBounds(50,350,120,30);
        b1.setFont(new Font("phantom", Font.PLAIN,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

         b2 = new JButton("Cancel");
        b2.setBounds(210,350,120,30);
        b2.setFont(new Font("phantom", Font.PLAIN,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\eight.jpg");
        Image i2 = i1.getImage().getScaledInstance(470,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(400,10,450,430);
        add(label);

        setBounds(300,140,900,500);
       // setUndecorated(true);
          setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String room = room1.getText();
        String price = price1.getText();
        String available = (String) cb.getSelectedItem();
        String status = (String) cb1.getSelectedItem();
        String type = (String) cb2.getSelectedItem();
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                String query = "Insert into addroom values ('"+room+"', '"+available+"', '"+status+"', '"+price+"', '"+type+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
           setVisible(false);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
        public static void main(String[] args) {
        new addroom();
    }
}
