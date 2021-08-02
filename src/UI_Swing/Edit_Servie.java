package UI_Swing;

import Models.Operations;
import Models.Services;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Edit_Servie extends JFrame{

    private JPanel contentPane;

    public Edit_Servie(Services services, Operations BLOp) {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50, 50, 350, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel itemCode = new JLabel(String.valueOf(services.serviceCode));
        itemCode.setOpaque(true);
        itemCode.setBackground(Color.WHITE);
        itemCode.setBounds(100, 70, 150, 25);
        contentPane.add(itemCode);

        JTextField serviceName = new Helper.HintTextField(services.serviceName);
        serviceName.setOpaque(true);
        serviceName.setBackground(Color.WHITE);
        serviceName.setBounds(100, 100, 150, 25);
        contentPane.add(serviceName);

        JTextField serviceType = new Helper.HintTextField(services.serviceType);
        serviceType.setOpaque(true);
        serviceType.setBackground(Color.WHITE);
        serviceType.setBounds(100, 130, 150, 25);
        contentPane.add(serviceType);

        JTextField serviceCost = new Helper.HintTextField(String.valueOf(services.serviceCost));
        serviceCost.setOpaque(true);
        serviceCost.setBackground(Color.WHITE);
        serviceCost.setBounds(100, 160, 150, 25);
        contentPane.add(serviceCost);

        JButton btnSignIn = new JButton("Edit");
        btnSignIn.addActionListener(arg0 -> {
            if (serviceName.getText().length()>0)
                services.serviceName = serviceName.getText();

            if (serviceType.getText().length()>0)
                services.serviceType = serviceType.getText();

            int x = services.serviceCost;
            try {
                if (serviceCost.getText().length()>0)
                    if (Integer.parseInt(serviceCost.getText())>-1)
                        services.serviceCost = Integer.parseInt(serviceCost.getText());
            }
            catch (Exception  e){
                services.serviceCost = x;
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Invalid Cost. Value remains Unchanged");
            }

            if (BLOp.editService(services)){
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Service Modified");

                dispose();
            }
            else{
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Connection Error. Could not Edit Service");
            }
        });
        btnSignIn.setBounds(120, 220, 100, 25);
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