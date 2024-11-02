package atm_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Deposit extends JFrame implements ActionListener{
    String card;
    TextField t1;
    JButton b1,b2;
    Deposit(String card)         //passing the card no. from login frame
    { this.card=card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png")); //putting image inside system memory
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel l1 = new JLabel("    ENTER AMOUNT TO DEPOSIT");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(450, 180, 400, 35);
        l1.setForeground(Color.white);
        image.add(l1);

        t1 = new TextField();
        t1.setBounds(470, 230, 200, 25);
        t1.setFont(new Font("System", Font.BOLD, 20));
        image.add(t1);

//deposit buttons
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setForeground(Color.BLUE);
        b1.setBounds(700, 350, 120, 25);
        b1.addActionListener(this);
        image.add(b1);

        //button2
        b2 = new JButton("BACK");
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setForeground(Color.BLUE);
        b2.setBounds(700, 400, 120, 25);
        b2.addActionListener(this);
        image.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);//full screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {

            String amount=t1.getText();

            if(t1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"enter amount to deposit");
            }
            else {
                try{ //database connection

                    Con connection = new Con();
                    String query = "insert into bank(card,operation,amount)values(?,?,?)";
                    PreparedStatement pstmt = connection.conn.prepareStatement(query);
                    pstmt.setString(1,card);
                    pstmt.setString(2,"deposit");
                    pstmt.setString(3,amount);//set the deposit amount
                    int rowinserted=pstmt.executeUpdate();     //Execute the update

                    JOptionPane.showMessageDialog(null,"Rs  "+amount+"Deposited Successfully");

                } catch(Exception E)
                {
                    System.out.println(E.getMessage());
                }}
        }
        else if (e.getSource()==b2)
            new Home(card);

    }
    public static void main(String[]args)
    {
        new Deposit("8982");
    }
}











