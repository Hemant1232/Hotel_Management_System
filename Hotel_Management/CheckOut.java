package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CheckOut extends JFrame implements ActionListener {

    Choice ch;
    JButton checkout,back,detail;
    JTextField tf1,tf2,tf3;
    CheckOut(){


        ImageIcon img = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\sixth.jpg");
        Image img2 = img.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon img3  = new ImageIcon(img2);
        JLabel l = new JLabel(img3);
        l.setBounds(430,30,430,300);
        add(l);

        JLabel l1 = new JLabel("CHECKOUT");
        l1.setBounds(130,20,150,30);
        l1.setFont(new Font("Phantom",Font.PLAIN,22));
        l1.setForeground(Color.BLUE);
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(40,80,120,30);
        l2.setFont(new Font("Phantom",Font.PLAIN,16));
        add(l2);

         ch = new Choice();
        ch.setBounds(180,80,190,30);
        ch.setFont(new Font("Phantom",Font.PLAIN,15));
        add(ch);


        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(40,130,120,30);
        l3.setFont(new Font("Phantom",Font.PLAIN,16));
        add(l3);

         tf1 = new JTextField();
        tf1.setBounds(180,130,190,30);
        tf1.setFont(new Font("Phantom",Font.PLAIN,15));
        add(tf1);

        JLabel l4 = new JLabel("Checkin Time");
        l4.setBounds(40,180,120,30);
        l4.setFont(new Font("Phantom",Font.PLAIN,16));
        add(l4);

         tf2 = new JTextField();
        tf2.setBounds(180,180,190,30);
        tf2.setFont(new Font("Phantom",Font.PLAIN,15));
        add(tf2);

        JLabel l5 = new JLabel("Checkout Time");
        l5.setBounds(40,230,120,30);
        l5.setFont(new Font("Phantom",Font.PLAIN,16));
        add(l5);

         tf3 = new JTextField();
        tf3.setBounds(180,230,190,30);
        tf3.setFont(new Font("Phantom",Font.PLAIN,15));
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        tf3.setText("" + formattedDate);
        add(tf3);

        detail = new JButton("Details");
        detail.setBounds(40,300,100,30);
        detail.setBackground(Color.black);
        detail.setForeground(Color.white);
        detail.addActionListener(this);
        add(detail);

        checkout = new JButton("Checkout");
        checkout.setBounds(155,300,100,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Customeradd");
            while(rs.next()){
                ch.add(rs.getString("number"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        setLocationRelativeTo(null);
        setBounds(300,200,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==detail){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from Customeradd where number = '"+ch.getSelectedItem()+"'");
                while(rs.next()){
                    tf1.setText(rs.getString("room_no"));
                    tf2.setText(rs.getString("time"));
                }
            } catch (Exception ae){
                ae.printStackTrace();
            }
        }
       else if(e.getSource()==checkout){
           String query1 = "delete from Customeradd where number = '"+ch.getSelectedItem()+"'";
            String query2 = "Update addroom set available = 'Available' where room_no = '"+tf1.getText()+"' ";
            try {
                Conn c = new Conn();
               c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Complete");
                setVisible(false);
            }
            catch(Exception ae){
               ae.printStackTrace();
            }
        }
        else if (e.getSource()==back) {
               setVisible(false);

            }

        }

    public static void main(String[] args) {

        new CheckOut();
    }
}
