package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AoE extends JFrame implements ActionListener{
    
    JButton adminLoginButton, employeeLoginButton;
    
    AoE() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 300);
        add(image);

        adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setBounds(10, 50, 200, 50);
        adminLoginButton.setFont(new Font("serif", Font.BOLD, 20));
        adminLoginButton.addActionListener(this);
        image.add(adminLoginButton);

        employeeLoginButton = new JButton("Employee Login");
        employeeLoginButton.setBounds(10, 200, 200, 50);
        employeeLoginButton.setFont(new Font("serif", Font.BOLD, 20));
        employeeLoginButton.addActionListener(this);
        image.add(employeeLoginButton);

        setSize(600, 320);
        setLocation(450, 200);
        setVisible(true);
        }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == adminLoginButton) {
            setVisible(false);
            new Login();
        }else {
            setVisible(false);
            new EMPLogin();
        }
    }
    
     public static void main(String[] args) {
        new AoE();
    }
}