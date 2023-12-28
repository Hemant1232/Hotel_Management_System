package Hotel_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addemployee extends JFrame implements ActionListener {
    JTextField name1, age1, salary1, phone1, email1, aadhar1;
    JButton submit,cancel;
    JRadioButton rd,rd1;
    JComboBox cb;
    addemployee(){
        setBounds(350,130,850,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel top = new JLabel("Add Employee");
        top.setBounds(110,10,160,30);
        top.setFont(new Font("phantom", Font.PLAIN, 24));
        top.setForeground(Color.BLACK);
        add(top );

        JLabel name = new JLabel("NAME");
        name.setBounds(50,70,130,30);
        name.setFont(new Font("phamtom", Font.PLAIN,17));
        add(name);

        name1 =  new JTextField();
        name1.setBounds(190,70,130,30);
        add(name1);

        JLabel age = new JLabel("AGE");
        age.setBounds(50,120,130,30);
        age.setFont(new Font("phamtom", Font.PLAIN,17));
        add(age);

         age1 =  new JTextField();
        age1.setBounds(190,120,130,30);
        add(age1);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50,170,130,30);
        gender.setFont(new Font("phantom", Font.PLAIN,17));
        add(gender);

        rd = new JRadioButton("Male");
        rd.setBounds(190,170,60,30);
        rd.setBackground(Color.WHITE);
        add(rd);

         rd1 = new JRadioButton("Female");
        rd1.setBounds(250,170,70,30);
        rd1.setBackground(Color.WHITE);
        add(rd1);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rd);
        bg.add(rd1);

        JLabel job = new JLabel("JOB");
        job.setBounds(50,220,130,30);
        job.setFont(new Font("none", Font.PLAIN,17));
        add(job);

        String str[] = {"None", " Chefs", "Accountant", "Front desk clerk", "Manager", "Waiter/Waitress","Rooom Service","Kitchen Staff", "Housekeeping"};
         cb = new JComboBox(str);
        cb.setBackground(Color.WHITE);
        cb.setFont(new Font("none", Font.PLAIN,15));
        cb.setBounds(190,220,130,30);
        add(cb);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(50,270,130,30);
        salary.setFont(new Font("none", Font.PLAIN,17));
        add(salary);

         salary1 =  new JTextField();
        salary1.setBounds(190,270,130,30);
        add(salary1);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50,320,130,30);
        phone.setFont(new Font("none", Font.PLAIN,17));
        add(phone);

         phone1 =  new JTextField();
        phone1.setBounds(190,320,130,30);
        add(phone1);

        JLabel  email = new JLabel("EMAIL ID");
        email.setBounds(50,370,130,30);
        email.setFont(new Font("none", Font.PLAIN,17));
        add(email);

        email1 =  new JTextField();
        email1.setBounds(190,370,130,30);
        add(email1);

        JLabel aadhar = new JLabel("AADHAR NO.");
        aadhar.setBounds(50,420,130,30);
        aadhar.setFont(new Font("none", Font.PLAIN,17));
        add(aadhar);

        aadhar1 =  new JTextField();
        aadhar1.setBounds(190,420,130,30);
        add(aadhar1);

        submit  = new JButton("SUBMIT");
        submit.setBounds(50,500,110,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

         cancel  = new JButton("CANCEL");
        cancel.setBounds(210,500,110,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon icon = new ImageIcon("src\\images\\tenth.jpg");
        Image i2 = icon.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel p = new JLabel(i3);
        p.setBounds(360,60,450,370);
        add(p);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String name = name1.getText();
        String age = age1.getText();
        String salary = salary1.getText();
        String phone = phone1.getText();
        String email = email1.getText();
        String aadhar = aadhar1.getText();

        String gender = null;

        if (rd.isSelected()) {
            gender = "Male";
        } else if (rd1.isSelected()) {
            gender = "Female";
        }

        String job = (String) cb.getSelectedItem();
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                String query = "Insert into employee values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhar + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "employee is add successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new addemployee();
    }
}
