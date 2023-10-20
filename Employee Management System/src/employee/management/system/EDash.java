package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EDash extends JFrame implements ActionListener{
    
    JLabel lblname, lblfname, lbldob, lblsalary, lbladdress, lblphone, lblemail, lbleducation, lbldesignation, lblaadhar;
    JButton show, back;
    JTextField lblempId;
    String empId;
    
    EDash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel heading = new JLabel("View Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        image.add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        labelname.setForeground(Color.WHITE);
        image.add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 150,150,30);
        image.add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(450,150,150,30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        labelfname.setForeground(Color.WHITE);
        image.add(labelfname);
        
        lblfname = new JLabel();
        lblfname.setBounds(600, 150,150,30);
        image.add(lblfname);
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        labeldob.setForeground(Color.WHITE);
        image.add(labeldob);
        
        lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        image.add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(450,200,150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        labelsalary.setForeground(Color.WHITE);
        image.add(labelsalary);
        
        lblsalary = new JLabel();
        lblsalary.setBounds(600, 200,150,30);
        image.add(lblsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        labeladdress.setForeground(Color.WHITE);
        image.add(labeladdress);
        
        lbladdress = new JLabel();
        lbladdress.setBounds(200, 250,150,30);
        image.add(lbladdress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(450,250,150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        labelphone.setForeground(Color.WHITE);
        image.add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(600, 250,150,30);
        image.add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        labelemail.setForeground(Color.WHITE);
        image.add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(200, 300,150,30);
        image.add(lblemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(450,300,150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        labeleducation.setForeground(Color.WHITE);
        image.add(labeleducation);
        
        lbleducation = new JLabel();
        lbleducation.setBounds(600, 300,150,30);
        image.add(lbleducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        labeldesignation.setForeground(Color.WHITE);
        image.add(labeldesignation);
        
        lbldesignation = new JLabel();
        lbldesignation.setBounds(200, 350,150,30);
        image.add(lbldesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(450,350,150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        labelaadhar.setForeground(Color.WHITE);
        image.add(labelaadhar);
        
        lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350,150,30);
        image.add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(250,100,150,30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        labelempId.setForeground(Color.WHITE);
        image.add(labelempId);
        
        lblempId = new JTextField();
        lblempId.setBounds(370,100,150,30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblempId);
        
        show = new JButton("Show Details");
        show.setBounds(600, 90, 150, 40);
        show.addActionListener(this);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        image.add(show);
        
        back = new JButton("Back");
        back.setBounds(300, 500, 150 ,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == show) {
                
            String empId = lblempId.getText();

            try {
                
                Conn c = new Conn();
                
                String query = "SELECT * FROM employee WHERE empId = '"+empId+"'";
                ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                lbladdress.setText(rs.getString("address"));
                lblsalary.setText(rs.getString("salary"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                lbleducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                lbldesignation.setText(rs.getString("designation"));
                
                JOptionPane.showMessageDialog(null, "Employee Data Found");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Employee ID");
                setVisible(false);
                new EDash();
            }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            } else {
                setVisible(false);
                new EMPLogin();
            }
    }
    
    public static void main(String[] args) {
        new EDash();
    }
}