package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposite,back;
    JTextField amount;
    String pinnumber;

    Deposit(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter a amount you want to deposit");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(170, 350, 300, 25);
        amount.setForeground(Color.BLACK);
        image.add(amount);

        deposite = new JButton("Deposit");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);

    }

    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource() == deposite){
        try {
            String number = amount.getText();
            Date date = new Date();

            if (ae.getSource() == deposite) {
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter an amount you want to deposit");
                } else {
//              try {
                    conn conn = new conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }

        }catch (Exception e){
                  System.out.println(e);

              }
          }

//    } else if(ae.getSource() == back){
//
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
