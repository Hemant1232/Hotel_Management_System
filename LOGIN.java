package Hotel_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LOGIN extends JFrame implements ActionListener {
    JTextField text;
    JPasswordField pass;
    JButton submit, cancel;
    LOGIN()  {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,50,100,30);
        user.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(user);

        text = new JTextField();
        text.setBounds(180,50,150,30);
        text.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(text);
        
        JLabel Password = new JLabel("Password");
        Password.setBounds(40,120,100,30);
        Password.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(Password);

        pass = new JPasswordField();
        pass.setBounds(180,120,150,30);
        pass.setFont(new Font("Verdana", Font.PLAIN, 18));
        pass.setEchoChar('*');
        add(pass);

        // adding submit button
        submit = new JButton("Login");
        submit.setBounds(60,200,100,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // adding cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(190,200,100,40);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon image = new ImageIcon("src\\images\\second.jpg");
        Image i2 = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);

        label.setBounds(350,10,200,200);
        add(label);

        setBounds(500,200,600,300);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String usr = text.getText();
            String pass1 = pass.getText();
            try{
              Conn c = new Conn();
              String query = "Select * from logi where username = '"+ usr + "' and password = '"+ pass1 +"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new DashBoard();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource()==cancel) {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
    public static void main(String[] args) {

        new LOGIN();
    }
}

