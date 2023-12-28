package Hotel_Management;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100,140,1366,564);
        setLayout(null);

        ImageIcon i = new ImageIcon("src/images/first.jpg");
        JLabel label = new JLabel(i);
        label.setSize(1366,565);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,400,100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 20));

        JButton button = new JButton("Next");
        button.setPreferredSize(new Dimension(100,30));
        button.setBounds(1200,430,90,30);
        button.setForeground(Color.black);
        button.addActionListener(this);
        button.setFont(new Font("phantom",Font.PLAIN,17));

        label.add(button);
        add(label);
        label.add(text);
        setVisible(true);
    }

     public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new LOGIN();
    }

    public static void main(String args[]) {
        new HotelManagementSystem();
    }
}