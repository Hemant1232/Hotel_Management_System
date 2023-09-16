package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class addcustomer extends JFrame implements ActionListener {

    JComboBox cb1;
    JTextField  tf1,tf2,tf3,tf4;
    JRadioButton rb1,rb2;
    Choice c1;
    JButton submit,cancel;
    JLabel d;
    addcustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("New Customer Form");
        l1.setBounds(100,20,300,30);
        l1.setFont(new Font("serif", Font.PLAIN,24));
        l1.setForeground(Color.black);
        add(l1);

        JLabel l2 = new JLabel("Id");
        l2.setBounds(35,80,300,30);
        l2.setFont(new Font("seirf", Font.PLAIN,20));
        add(l2);

        String st[] = {"Aadhar Card", "Passport", "Driving License", "Voted-ID Card", "Ration Card"};
        cb1 = new JComboBox(st);
        cb1.setBounds(200,80,150,25);
        cb1.setFont(new Font("seirf", Font.PLAIN,17));
        cb1.setBackground(Color.lightGray);
        add(cb1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,300,30);
        l3.setFont(new Font("seirf", Font.PLAIN,20));
        add(l3);

        tf1 = new JTextField();
        tf1.setBounds(200,120,150,25);
        tf1.setFont(new Font("seirf", Font.BOLD,17));
        add(tf1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,160,300,30);
        l4.setFont(new Font("seirf", Font.PLAIN,20));
        add(l4);

        tf2 = new JTextField();
        tf2.setBounds(200,160,150,25);
        tf2.setFont(new Font("seirf", Font.PLAIN,16));
        add(tf2);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,200,300,30);
       l5.setFont(new Font("seirf", Font.PLAIN,20));
        add(l5);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(200,200,70,30);
       rb1.setFont(new Font("seirf", Font.BOLD,13));
        add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(280,200,70,30);
        rb2.setFont(new Font("seirf", Font.BOLD,13));
        add(rb2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,240,300,30);
        l6.setFont(new Font("seirf", Font.PLAIN,20));
        add(l6);

        tf3 = new JTextField();
        tf3.setBounds(200,240,150,25);
        tf3.setFont(new Font("seirf", Font.PLAIN,16));
        add(tf3);

        JLabel l7 = new JLabel("Room Number");
        l7.setBounds(35,280,150,30);
        l7.setFont(new Font("seirf", Font.PLAIN,20));
        add(l7);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            String s = "Select * from addroom";
            ResultSet rs =  c.s.executeQuery(s);
            while(rs.next()){
                c1.add(rs.getString("room_no"));
            }
        }catch(Exception a){
            a.printStackTrace();
        }
        c1.setBounds(200,280,150,30);
        add(c1);

        JLabel l8 = new JLabel("Check-In Time");
        l8.setBounds(35,320,300,30);
        l8.setFont(new Font("seirf", Font.PLAIN,20));
        add(l8);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        d = new JLabel("" + formattedDate);
        d.setBounds(200,320,150,30);
        d.setFont(new Font("seirf", Font.PLAIN,16));
        add(d);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,300,30);
        l9.setFont(new Font("seirf", Font.PLAIN,20));
        add(l9);

        tf4 = new JTextField();
        tf4.setBounds(200,360,150,25);
        tf4.setFont(new Font("seirf", Font.PLAIN,16));
        add(tf4);

        ImageIcon img = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\fifth.png");
        Image i = img.getImage().getScaledInstance(450,400,Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i);
        JLabel l = new JLabel(img1);
        l.setBounds(350,20,500,400);
        add(l);

        submit = new JButton("Submit");
        submit.setBounds(40,430,130,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(210,430,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

//        setUndecorated(true);
        setBounds(350,170,800,550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String id = (String) cb1.getSelectedItem();
        String number = tf1.getText();
        String name = tf2.getText();
        String gender = null;
        if (rb1.isSelected()) {
            gender = "male";
        } else if (rb2.isSelected()) {
            gender = "female";
        }
        String country = tf3.getText();
        String time = d.getText();
        String room_no = (String) c1.getSelectedItem();
        String deposit = tf4.getText();
        if (ae.getSource() == submit) {

                try {
                    Conn c = new Conn();
                    String query = "Insert into Customeradd values('" + id + "',  '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room_no + "','"+time+"', '" + deposit + "')";
                    c.s.executeUpdate(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            JOptionPane.showMessageDialog(null, "addcustomer added successfully");
           setVisible(false);

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args) {
        new addcustomer();
    }

}
