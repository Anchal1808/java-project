package atm_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    String card;
    JButton b1,b2,b3,b4,b5;      //globally declare to access to action performed
    public Home(String card) {
       this.card=card;
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png")); //put inside system memory
       Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0, 0, 1550, 830);
       add(image);

       JLabel l1 = new JLabel("Choose One Option To Continue..  ");
       l1.setFont(new Font("System", Font.BOLD, 28));
       l1.setBounds(420, 200, 500, 35);
       l1.setForeground(Color.white);
       image.add(l1);

       b1 = new JButton("1.DEPOSIT");
       b1.setFont(new Font("Arial", Font.BOLD, 16));
       b1.setForeground(Color.BLUE);
       b1.setBounds(500, 285, 220, 25);
       b1.addActionListener(this);
       image.add(b1);

       b2 = new JButton("2.CASH WITHDRAW");
       b2.setFont(new Font("Arial", Font.BOLD, 16));
       b2.setForeground(Color.BLUE);
       b2.setBounds(500, 330, 220, 25);
       b2.addActionListener(this);
       image.add(b2);

       b3 = new JButton("3.CHECK MY BALANCE");
       b3.setFont(new Font("Arial", Font.BOLD, 16));
       b3.setForeground(Color.BLUE);
       b3.setBounds(500, 370, 220, 25);
       b3.addActionListener(this);
       image.add(b3);



       b5 = new JButton("4.EXIT");
       b5.setFont(new Font("Arial", Font.BOLD, 16));
       b5.setForeground(Color.BLUE);
       b5.setBounds(500, 410, 220, 25);
       b5.addActionListener(this);
       image.add(b5);

       setLayout(null);
       setSize(1550, 1080);
       setLocation(0, 0);//full screen
       setVisible(true);
   }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==b1)
       {
           new Deposit(card);
       }
        if(e.getSource()==b5)
        {
            JOptionPane.showMessageDialog(null,"THANKS FOR VISITING ATM");
             // System.out.println("THANKS FOR VISITING ATM");
            System.exit(0);
        }
        if(e.getSource()==b2)
        {
            new Withdrawal(card);
        }

        if(e.getSource()==b3)
        {
            new Check_Balance(card);
        }

    }
    public static void main(String[]args)
    {new Home("8982");
    }}

