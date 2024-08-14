package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JButton submit,cancel;
    JRadioButton savingaccount,currentaccount,fixeddepositeaccount,recurringaccount;
    JCheckBox atmcard,mobilebanking,chequebook,internetbanking,emailsmsalerts,estatement,condition;
    String formno;

    SignupThree(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("New Account Application Form - Page 3");

        JLabel accountdetails = new JLabel("Page-3 Account Details");
        accountdetails.setFont(new Font("Raleway", Font.BOLD, 30));
        accountdetails.setBounds(250,80,450,35);
        add(accountdetails);

        JLabel accounttype = new JLabel("Account Type :");
        accounttype.setFont(new Font("Raleway", Font.BOLD, 25));
        accounttype.setBounds(120,150,450,35);
        add(accounttype);

        savingaccount = new JRadioButton("Saving Account");
        savingaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingaccount.setBounds(120,190,350,30);
        savingaccount.setBackground(Color.WHITE);
        add(savingaccount);

        currentaccount = new JRadioButton("Current Account");
        currentaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentaccount.setBounds(120,240,350,30);
        currentaccount.setBackground(Color.WHITE);
        add(currentaccount);

        fixeddepositeaccount = new JRadioButton("Fixed Deposite Account");
        fixeddepositeaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fixeddepositeaccount.setBounds(470,190,450,30);
        fixeddepositeaccount.setBackground(Color.WHITE);
        add(fixeddepositeaccount);

        recurringaccount = new JRadioButton("Recurring Deposite Account");
        recurringaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringaccount.setBounds(470,240,450,30);
        recurringaccount.setBackground(Color.WHITE);
        add(recurringaccount);

        JLabel carddetails = new JLabel("Card Number :");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 25));
        carddetails.setBounds(120,290,450,35);
        add(carddetails);

        JLabel cardnumberlimit = new JLabel("(Your 14 Digits Card Number) ");
        cardnumberlimit.setFont(new Font("Raleway", Font.BOLD, 15));
        cardnumberlimit.setBounds(100,320,250,25);
        add(cardnumberlimit);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4185");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 25));
        cardnumber.setBounds(350,290,450,35);
        add(cardnumber);

        JLabel pindetails = new JLabel("PIN :");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 25));
        pindetails.setBounds(120,360,450,35);
        add(pindetails);

        JLabel pinnumberlimit = new JLabel("(Your 4 Digits Password) ");
        pinnumberlimit.setFont(new Font("Raleway", Font.BOLD, 15));
        pinnumberlimit.setBounds(100,390,250,25);
        add(pinnumberlimit);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 25));
        pinnumber.setBounds(350,360,450,35);
        add(pinnumber);

        JLabel sevicerequired = new JLabel("Service Required :");
        sevicerequired.setFont(new Font("Raleway", Font.BOLD, 25));
        sevicerequired.setBounds(120,440,450,35);
        add(sevicerequired);

        atmcard = new JCheckBox("ATM Card");
        atmcard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmcard.setBounds(120,490,350,30);
        atmcard.setBackground(Color.WHITE);
        add(atmcard);

        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobilebanking.setBounds(120,530,350,30);
        mobilebanking.setBackground(Color.WHITE);
        add(mobilebanking);

        chequebook = new JCheckBox("Cheque Book");
        chequebook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequebook.setBounds(120,570,350,30);
        chequebook.setBackground(Color.WHITE);
        add(chequebook);

        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetbanking.setBounds(500,490,350,30);
        internetbanking.setBackground(Color.WHITE);
        add(internetbanking);

        emailsmsalerts = new JCheckBox("Emails & Sms Alerts");
        emailsmsalerts.setFont(new Font("Raleway", Font.BOLD, 16));
        emailsmsalerts.setBounds(500,530,350,30);
        emailsmsalerts.setBackground(Color.WHITE);
        add(emailsmsalerts);

        estatement = new JCheckBox("E Statement");
        estatement.setFont(new Font("Raleway", Font.BOLD, 16));
        estatement.setBounds(500,570,350,30);
        estatement.setBackground(Color.WHITE);
        add(estatement);

        condition = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        condition.setFont(new Font("Raleway", Font.BOLD, 12));
        condition.setBounds(120,630,700,30);
        condition.setBackground(Color.WHITE);
        add(condition);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(450,670,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(200,670,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){

            String accounttype = null;
            if(savingaccount.isSelected()){
                accounttype = "Saving Account";
            } else if (currentaccount.isSelected()) {
                accounttype = "Current Account";

            } else if (fixeddepositeaccount.isSelected()) {
                accounttype = "Fixed Deposite Account";

            } else if (recurringaccount.isSelected()) {
                accounttype = "Recurring Deposite Account";

            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 50409360000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(atmcard.isSelected()){
                facility = facility + "ATM Card";
            } else if (mobilebanking.isSelected()) {
                facility = facility + "Mobile Banking";

            } else if (chequebook.isSelected()) {
                facility = facility + "Cheque Book";

            } else if (internetbanking.isSelected()) {
                facility = facility + "Internet Banking";

            } else if (emailsmsalerts.isSelected()) {
                facility = facility + "Emails & Sms Alerts";

            } else if (estatement.isSelected()) {
                facility = facility + "E Statement";

            }

            try{
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type id Required");
                }else {
                    conn c = new conn();
                    String query = "insert into signupthree values ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number :" + cardnumber + "\n Pin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            } catch (Exception e){
                System.out.println(e);
            }


        }
        else if (ae.getSource() == cancel){

            setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args) {

        new SignupThree("");
    }

}
