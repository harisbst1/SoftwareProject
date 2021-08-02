package UI_Swing;

import Models.Operations;
import Models.Services;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Add_Service extends JFrame {
    private JPanel contentPane;

    public Add_Service(Operations BLOp) {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50, 50, 350, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField serviceName = new Helper.HintTextField("Service Name");
        serviceName.setOpaque(true);
        serviceName.setBackground(Color.WHITE);
        serviceName.setBounds(100, 100, 150, 25);
        contentPane.add(serviceName);

        JTextField serviceType = new Helper.HintTextField("Service Type");
        serviceType.setOpaque(true);
        serviceType.setBackground(Color.WHITE);
        serviceType.setBounds(100, 130, 150, 25);
        contentPane.add(serviceType);

        JTextField serviceCost = new Helper.HintTextField("Service Cost");
        serviceCost.setOpaque(true);
        serviceCost.setBackground(Color.WHITE);
        serviceCost.setBounds(100, 160, 150, 25);
        contentPane.add(serviceCost);

        JButton btnSignIn = new JButton("Add");
        btnSignIn.addActionListener(arg0 -> {
            Services service = new Services();

            if (serviceType.getText().length()>0)
                service.serviceType = serviceType.getText();

            if (serviceName.getText().length()>0)
                service.serviceName = serviceName.getText();

            try{
                if (Integer.parseInt(serviceCost.getText())>=0)
                    service.serviceCost = Integer.parseInt(serviceCost.getText());
                else{
                    service.serviceCost = 0;
                    JFrame Confirm = new JFrame();
                    JOptionPane.showMessageDialog(Confirm, "Invalid Price. Value Set to Default");
                }
            }
            catch (Exception e){
                service.serviceCost = 0;
            }
            if (BLOp.addService(service)){
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Service added to Service List");

                dispose();
            }
            else{
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Connection Error. Could not add Service");
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