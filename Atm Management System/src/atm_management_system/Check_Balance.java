
package atm_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Check_Balance extends JFrame implements ActionListener{

    JButton b1;
    String card;
    JLabel t1;
    Check_Balance (String card)
    {
        this.card=card;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        b1= new JButton("Back");
        b1.setBounds(700,400,140,25);
        b1.addActionListener(this);
        image.add(b1);

        Con c=new Con();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where card = '"+card+"'");
            while(rs.next())
            {
                if(rs.getString("operation").equals("deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                if(rs.getString("operation").equals("withdraw"))

                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        t1=new JLabel("Your Current Account balance is Rs "+balance);
        t1.setForeground(Color.WHITE);
        t1.setBounds(420,220,450,30);
        t1.setFont(new Font("System", Font.BOLD, 20));
        image.add(t1);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Home(card).setVisible(true);
    }
    public static void main(String[]args){
        new Check_Balance("8982");
    }
}





































































