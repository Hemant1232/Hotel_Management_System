package Hotel_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logout extends JFrame implements ActionListener {
    JButton b1,b2;
    logout(){
        JLabel l1 = new JLabel("Are you sure?");
        l1.setBounds(100,80,250,25);
        l1.setFont(new Font("phantom",Font.PLAIN,23));
        add(l1);

         b1= new JButton("YES");
        b1.setBounds(55,160,100,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

         b2= new JButton("NO");
        b2.setBounds(185,160,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        setBounds(570,270,350,250);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            System.exit(0);
            setVisible(false);


        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new logout();
    }
}
