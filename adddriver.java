package Hotel_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adddriver extends JFrame implements ActionListener {
    JTextField name1, age1, model1, location1, Car1;
    JButton add, cancel;
    JComboBox cb1, cb;
    adddriver(){
        setBounds(280,150,930,530);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel adddriver = new JLabel("ADD DRIVER");
        adddriver.setBounds(100,10,150,30);
        adddriver.setFont(new Font("phantom", Font.TYPE1_FONT, 22));
        adddriver.setForeground(Color.BLACK);
        add(adddriver);

        JLabel name = new JLabel("Name");
        name.setBounds(50,70,130,30);
        name.setFont(new Font("phamtom", Font.TYPE1_FONT,17));
        add(name);

        name1 =  new JTextField();
        name1.setBounds(190,70,130,30);
        name1.setFont(new Font("none", Font.TYPE1_FONT,14));
        add(name1);

        JLabel age = new JLabel("Age");
        age.setBounds(50,115,130,30);
        age.setFont(new Font("phamtom", Font.TYPE1_FONT,17));
        add(age);

        age1 =  new JTextField();
        age1.setBounds(190,115,130,30);
        age1.setFont(new Font("none", Font.TYPE1_FONT,14));
        add(age1);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50,160,130,30);
        gender.setFont(new Font("phantom", Font.TYPE1_FONT,17));
        add(gender);

        String str1[] = {" Male", " Female", " Others"};
        cb = new JComboBox(str1);
        cb.setBounds(190,160,130,30);
        cb.setFont(new Font("phantom", Font.TYPE1_FONT,14));
        cb.setBackground(Color.white);
        cb.setForeground(Color.BLACK);
        add(cb);

        JLabel Car = new JLabel("Car Company");
        Car.setBounds(50,205,130,30);
        Car.setFont(new Font("none", Font.TYPE1_FONT,17));
        add(Car);

        Car1 =  new JTextField();
        Car1.setBounds(190,205,130,30);
        Car1.setFont(new Font("none", Font.TYPE1_FONT,14));
        add(Car1);

        JLabel model = new JLabel("Car Model");
        model.setBounds(50,250,130,30);
        model.setFont(new Font("none", Font.TYPE1_FONT,17));
        add(model);

        model1 =  new JTextField();
        model1.setBounds(190,250,130,30);
        model1.setFont(new Font("none", Font.TYPE1_FONT,14));
        add(model1);

        JLabel available = new JLabel("Available");
        available.setBounds(50,295,130,30);
        available.setFont(new Font("none", Font.TYPE1_FONT,17));
        add(available);

        String str2[] = {" Available", " Busy"};
        cb1 = new JComboBox(str2);
        cb1.setBounds(190,295,130,30);
        cb1.setFont(new Font("phantom", Font.TYPE1_FONT,14));
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.BLACK);
        add(cb1);

        JLabel  location = new JLabel("Location");
        location.setBounds(50,340,130,30);
        location.setFont(new Font("none", Font.TYPE1_FONT,17));
        add(location);

        location1 =  new JTextField();
        location1.setBounds(190,340,130,30);
        location1.setFont(new Font("none", Font.TYPE1_FONT,14));
        add(location1);

        cancel  = new JButton("Cancel");
        cancel.setBounds(200,410,110,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        add  = new JButton("Add Driver");
        add.setBounds(60,410,110,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        ImageIcon icon = new ImageIcon("src\\images\\eleven.jpg");
        Image i2 = icon.getImage().getScaledInstance(550,430,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel p = new JLabel(i3);
        p.setBounds(340,20,550,450);
        add(p);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = name1.getText();
        String age = age1.getText();
        String company = Car1.getText();
        String model = model1.getText();
        String location = location1.getText();
        String gender = (String) cb.getSelectedItem();
        String available = (String) cb1.getSelectedItem();
        if (ae.getSource() == add) {
            if(name1.getText().isEmpty() ||  !name1.getText().matches("[a-zA-Z_]+" )){
                JOptionPane.showMessageDialog(null, "Please enter a valid Name");
            } else if (age1.getText().isEmpty() || !age1.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid age");

            } else if (Car1.getText().isEmpty() || !Car1.getText().matches("[a-zA-Z_]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a Car Company");

            }
            else if (model1.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Please enter a Car model");
            }
            else if (location1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your location");

            }
            else try {
                    Conn c = new Conn();
                    String query = "Insert into adddriver values('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + model + "', '" + available + "', '" + location + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Driver added successfully");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
       else if (ae.getSource() == cancel) {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new adddriver();
    }
}
