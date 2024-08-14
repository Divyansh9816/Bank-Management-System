package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {

    JButton changepin,back;
    JPasswordField renewpinfield,newpinfield;
    String pinnumber;
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(250,300,500,25);
        text.setForeground(Color.white);
        image.add(text);

        JLabel newpin = new JLabel("New Pin");
        newpin.setFont(new Font("Raleway", Font.BOLD, 15));
        newpin.setBounds(160,350,300,25);
        newpin.setForeground(Color.white);
        image.add(newpin);

        newpinfield = new JPasswordField();
        newpinfield.setFont(new Font("Raleway", Font.BOLD, 15));
        newpinfield.setBounds(250,350,250,30);
        image.add(newpinfield);


        JLabel renewpin = new JLabel("Re-enter New Pin");
        renewpin.setFont(new Font("Raleway", Font.BOLD, 15));
        renewpin.setBounds(160,400,300,25);
        renewpin.setForeground(Color.white);
        image.add(renewpin);

        renewpinfield = new JPasswordField();
        renewpinfield.setFont(new Font("Raleway", Font.BOLD, 15));
        renewpinfield.setBounds(300,400,200,30);
        image.add(renewpinfield);

        changepin = new JButton("Change");
        changepin.setFont(new Font("Raleway", Font.BOLD, 15));
        changepin.setBounds(360,485,150,30);
        changepin.setForeground(Color.black);
        changepin.addActionListener(this);
        image.add(changepin);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(360,520,150,30);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==changepin){
        try{
            String npin = newpinfield.getText();
            String rnpin = renewpinfield.getText();

            if (!npin.equals(rnpin)) {
                JOptionPane.showMessageDialog(null,"Enter Pin Does Not Match");
                return;
            }
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                return;
            }
            if (rnpin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Re-enter New Pin");
                return;
            }

            conn c = new conn();
            String query1 = "update bank set pin = '"+rnpin+"' where newpinfield = '"+pinnumber+"'";
            String query2 = "update login set pin = '"+rnpin+"' where newpinfield = '"+pinnumber+"'";
            String query3 = "update signupthree set pin = '"+rnpin+"' where newpinfield = '"+pinnumber+"'";

            JOptionPane.showMessageDialog(null,"Pin Change Successfully");

            setVisible(false);
            new Transactions(rnpin).setVisible(true);


        } catch (Exception e) {
            System.out.println(e);
        }

        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }
}
