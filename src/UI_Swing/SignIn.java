package UI_Swing;

import Models.Operations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SignIn extends JFrame {
    private JPanel contentPane;

    public SignIn(Operations BLOp){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField lblUnameEntry = new Helper.HintTextField("UserID");
        lblUnameEntry.setOpaque(true);
        lblUnameEntry.setBackground(Color.WHITE);
        lblUnameEntry.setBounds(100, 130, 200, 25);
        contentPane.add(lblUnameEntry);

        JTextField lblPWordEntry = new Helper.HintTextField("Password");
        lblPWordEntry.setOpaque(true);
        lblPWordEntry.setBackground(Color.WHITE);
        lblPWordEntry.setBounds(100, 160, 200, 25);
        contentPane.add(lblPWordEntry);

        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.addActionListener(arg0 -> {
            if (BLOp.authenticateUser(lblUnameEntry.getText(),lblPWordEntry.getText())){
                Main_Frame Window = new Main_Frame(BLOp);
                Window.setVisible(true);
                dispose();
            }
            else {
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Invalid Credentials");
            }
        });
        btnSignIn.setBounds(130, 280, 100, 25);
        contentPane.add(btnSignIn);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setBounds(0, 0, 448, 197);
        panel.setOpaque(true);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 239, 213));
        panel_1.setBounds(0, 197, 448, 242);
        panel_1.setOpaque(true);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

    }

}
