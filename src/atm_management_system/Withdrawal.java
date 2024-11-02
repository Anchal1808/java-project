
package atm_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {
    String card;
    TextField t1;
    JButton b1, b2;

    Withdrawal(String card) {
        this.card = card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png")); // Load image
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel l1 = new JLabel("    ENTER AMOUNT TO WITHDRAW");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(450, 180, 400, 35);
        l1.setForeground(Color.white);
        image.add(l1);

        t1 = new TextField();
        t1.setBounds(470, 230, 200, 25);
        t1.setFont(new Font("System", Font.BOLD, 20));
        image.add(t1);

        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setForeground(Color.BLUE);
        b1.setBounds(700, 350, 140, 25);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setForeground(Color.BLUE);
        b2.setBounds(700, 400, 140, 25);
        b2.addActionListener(this);
        image.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0); // Full screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
              if (e.getSource() == b1) {
            String amount = t1.getText(); // Get value from textbox
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter amount to withdraw");
            }
                    else {
                     try {
                    Con c = new Con();
                    ResultSet rs = c.s.executeQuery("select amount from bank where card = '" + card + "'");
                         if (rs.next()) {
                        int amountFetch = Integer.parseInt(rs.getString("amount"));
                        int chk = Integer.parseInt(amount);   //converting fetched amount from database to integer type for comparing
                        if (chk > amountFetch) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance");
                        } else {
                            int balance = amountFetch - chk;
                            String balanceIs = Integer.toString(balance);
                                    try {
                                    Con connection = new Con();

                                // Record the withdrawal operation
                                String query = "insert into bank(card, operation, amount) values(?, ?, ?)";
                                PreparedStatement pstmt = connection.conn.prepareStatement(query);
                                pstmt.setString(1, card);
                                pstmt.setString(2, "withdraw");
                                pstmt.setString(3, amount); // Record the withdrawn amount
                                pstmt.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawal successful");
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }}
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }}
              else if (e.getSource() == b2) {
            new Home(card);
        }}

    public static void main(String[] args) {
        new Withdrawal("8982");
    }}













































