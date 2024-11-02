package atm_management_system;
import javax.swing.*;
import java.awt.*; //for image
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField pass;
    JButton b1;
   public Login()
    {
        //for TITLE
        super("Atm Simulation System");

        l1=new JLabel("WELCOME  TO  ATM");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Lucida Bright",Font.BOLD,28));
        l1.setBounds(190,50,450,40);
        add(l1);
// for card
        l2=new JLabel("Card No:");
        l2.setFont(new Font("Ralway",Font.BOLD,24));
        l2.setForeground(Color.BLACK);
        l2.setBounds(100,130,300,24);
        add(l2);
        // textfield
        t1=new JTextField(20);
        t1.setBounds(260,130,230,30);
        t1.setFont(new Font("Arial",Font.PLAIN, 16));
        add(t1);

//for password
        l3=new JLabel("PIN:");
        l3.setFont(new Font("Ralway",Font.BOLD,24));
        l3.setForeground(Color.BLACK);
        l3.setBounds(100,200,300,20);
        add(l3);
        //textfield
        pass=new JPasswordField(20);
        pass.setBounds(260,200,230,30);
        pass.setFont(new Font("Arial",Font.BOLD,20));
        add(pass);

        //login button
        b1=new JButton("SIGN IN");
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setForeground(Color.BLUE);
        b1.setBounds(310,290,100,25);
        b1.addActionListener(this);
        add(b1);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/back.png")); //put inside system memory
        Image i2= i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,500);
        add(image);

        setLayout(null);
        setSize(700,400);
        setLocation(500,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//user enters card no. and pin

            String card=t1.getText();
            String pin=pass.getText();
try{
            if(card.equals("8982")&&(pin.equals("123"))) {
                new Deposit(card);    //pass the card details
                new Withdrawal(card);
                new Check_Balance(card);


                if (e.getSource() == b1)
                    new Home(card).setVisible(true);
                    setVisible(false);

                //database
                Con connection = new Con();
                String query = "insert into users(card,pin)values(?,?)";
                PreparedStatement pstmt = connection.conn.prepareStatement(query);
                pstmt.setString(1, card);    //insert card no.
                pstmt.setString(2, pin);      // insert pin no.
                int rowinserted=pstmt.executeUpdate();   //execute the insert operation
            }
            else
            {JOptionPane.showMessageDialog(null,"invalid card no.or pin");
            }
} catch(Exception e1)
        {System.out.println("Something went wrong! Please try again.");//to handle exceptions and errors
        }}
    public static void main(String[]args)
    {new Login();
    }}
