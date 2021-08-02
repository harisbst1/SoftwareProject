package UI_Swing;

import Models.Operations;
import Models.Services;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List_Service extends JPanel {

    public List_Service(Services services, Operations BLOp) {
        setBackground(new Color(255, 255, 224));
        setPreferredSize(new Dimension(500, 100));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JLabel serviceCode = new JLabel(String.valueOf(services.serviceCode));
        serviceCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceCode.setBackground(new Color(255, 255, 255));
        serviceCode.setHorizontalAlignment(SwingConstants.CENTER);
        serviceCode.setBounds(10, 10, 150, 35);
        serviceCode.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceCode.setOpaque(true);

        JLabel serviceName = new JLabel(String.valueOf(services.serviceName));
        serviceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceName.setBackground(new Color(255, 255, 255));
        serviceName.setHorizontalAlignment(SwingConstants.CENTER);
        serviceName.setBounds(200, 10, 150, 35);
        serviceName.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceName.setOpaque(true);

        JLabel serviceCost = new JLabel(String.valueOf(services.serviceCost));
        serviceCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceCost.setBackground(new Color(255, 255, 255));
        serviceCost.setHorizontalAlignment(SwingConstants.CENTER);
        serviceCost.setBounds(10, 55, 150, 35);
        serviceCost.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceCost.setOpaque(true);

        JLabel serviceType = new JLabel(String.valueOf(services.serviceType));
        serviceType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceType.setBackground(new Color(255, 255, 255));
        serviceType.setHorizontalAlignment(SwingConstants.CENTER);
        serviceType.setBounds(200, 55, 150, 35);
        serviceType.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceType.setOpaque(true);

        add(serviceCode);
        add(serviceName);
        add(serviceCost);
        add(serviceType);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(370, 60, 70, 25);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JComponent comp = (JComponent) arg0.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);

                JFrame Confirm = new JFrame();
                try {
                    BLOp.removeService(services.serviceCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                JOptionPane.showMessageDialog(Confirm, "Service has been removed from the list");
                win.dispose();
            }
        });

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(370, 10, 70, 25);
        btnEdit.addActionListener(arg0 -> {
            JComponent comp = (JComponent) arg0.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);

            Edit_Servie edit_servie = new Edit_Servie(services,BLOp);
            edit_servie.setVisible(true);

            win.dispose();
        });

        add(btnRemove);
        add(btnEdit);

    }
}