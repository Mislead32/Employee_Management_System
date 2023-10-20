package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EMPLogin extends JFrame implements ActionListener{
    
    JButton login, back;
    JTextField tfusername, tfpassword;
    JLabel empusername, emppassword;
    
    EMPLogin() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        empusername = new JLabel("Username");
        empusername.setBounds(40, 20, 100, 30);
        add(empusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        emppassword = new JLabel("Password");
        emppassword.setBounds(40, 70, 100, 30);
        add(emppassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(25, 140, 150 ,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        back = new JButton("Back");
        back.setBounds(210, 140, 150 ,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(370, 25, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                Conn c = new Conn();
                String query = "select * from emplogin where username = '"+username+"' and password = '"+password+"'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new EDash();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       } else {
           setVisible(false);
           new AoE();
       }
    }
    
    public static void main(String[] args) {
        new EMPLogin();
    }
}