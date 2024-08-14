package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField PinTextField;
    Login() {
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(300,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No. :");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,40);
        add(cardTextField);

        JLabel Pin = new JLabel("PIN :");
        Pin.setFont(new Font("Raleway",Font.BOLD,20));
        Pin.setBounds(120,220,400,40);
        add(Pin);

        PinTextField = new JPasswordField();
        PinTextField.setBounds(300,220,250,40);
        add(PinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(420,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,220,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);


        setSize(800, 480);
        setVisible(true);
        setLocation(350,180);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            PinTextField.setText("");
        } else if(ae.getSource() == signin){
            conn conn = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = PinTextField.getText();
            String query = " select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{

                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin Number");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else if(ae.getSource() == signup){

            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}
