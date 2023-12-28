package Hotel_Management;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class roomInfo extends JFrame implements ActionListener {
    public JPanel contentPane;
    public JTable table;
    public JLabel lblAvailability;
    public JLabel lblCleanStatus;
    public JLabel lblNewLabel;
    public JLabel lblNewLabel_1;
    public JLabel lblId;
    public JButton btnNewButton;

    roomInfo() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon("src\\images\\eight.jpg");
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,0,600,600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 60, 500, 400);
        contentPane.add(table);

         btnNewButton = new JButton("Back");
        btnNewButton.setBounds(180, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from addroom");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(119, 25, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(216, 25, 76, 14);
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(330, 25, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(417, 25, 76, 14);
        contentPane.add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(12, 25, 90, 14);
        contentPane.add(lblId);

        getContentPane().setBackground(Color.WHITE);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from addroom");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae ) {
        if (ae.getSource() == btnNewButton) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new roomInfo();
    }

}