package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdrawn extends JFrame implements ActionListener {

    JButton withdrawn,back;
    JTextField amount;
    String pinnumber;

    Withdrawn(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter a amount you want to Withdrawn");
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(170, 350, 300, 25);
        amount.setForeground(Color.BLACK);
        image.add(amount);

        withdrawn = new JButton("Withdrawn");
        withdrawn.setBounds(355,485,150,30);
        withdrawn.addActionListener(this);
        image.add(withdrawn);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawn){
            String number = amount.getText();
            Date date = new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter an amount you want to withdrawn");
            } else{
                try {
                    conn conn = new conn();
                    String query = "insert into bank values('" + pinnumber + "','Withdrawn','" + date + "','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawnl Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e){
                    System.out.println(e);

                }
            }

        } else if(ae.getSource() == back){

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawn("");
    }
}
