package Hotel_Management;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setBounds(100,140,1366,564);
        setLayout(null);

        ImageIcon i = new ImageIcon("C:\\Users\\karti\\IdeaProjects\\Begineer_java\\src\\images\\first.jpg");
        JLabel label = new JLabel(i);
        label.setSize(1366,565);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,400,100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 20));


        JButton button = new JButton("Next");
        button.setBounds(1200,430,90,30);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
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