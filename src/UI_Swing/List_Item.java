/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Swing;

import Models.Item;
import Models.Operations;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List_Item extends JPanel {

    List_Item(Item item, Operations BlOp) throws Exception {
        setBackground(new Color(255, 255, 224));
        setPreferredSize(new Dimension(500, 150));
        setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
        setLayout(null);

        JLabel serviceCode = new JLabel(String.valueOf(item.itemCode));
        serviceCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceCode.setBackground(new Color(255, 255, 255));
        serviceCode.setHorizontalAlignment(SwingConstants.CENTER);
        serviceCode.setBounds(10, 10, 150, 35);
        serviceCode.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceCode.setOpaque(true);

        JLabel serviceName = new JLabel(String.valueOf(item.itemName));
        serviceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceName.setBackground(new Color(255, 255, 255));
        serviceName.setHorizontalAlignment(SwingConstants.CENTER);
        serviceName.setBounds(200, 10, 150, 35);
        serviceName.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceName.setOpaque(true);

        JLabel serviceCost = new JLabel(String.valueOf(item.itemPrice));
        serviceCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceCost.setBackground(new Color(255, 255, 255));
        serviceCost.setHorizontalAlignment(SwingConstants.CENTER);
        serviceCost.setBounds(10, 55, 150, 35);
        serviceCost.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceCost.setOpaque(true);

        JLabel serviceType = new JLabel(String.valueOf(item.itemType));
        serviceType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        serviceType.setBackground(new Color(255, 255, 255));
        serviceType.setHorizontalAlignment(SwingConstants.CENTER);
        serviceType.setBounds(200, 55, 150, 35);
        serviceType.setBorder(new LineBorder(new Color(128,0,0),2,true));
        serviceType.setOpaque(true);

        JLabel manufacturer = new JLabel(String.valueOf(item.manufacturer));
        manufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        manufacturer.setBackground(new Color(255, 255, 255));
        manufacturer.setHorizontalAlignment(SwingConstants.CENTER);
        manufacturer.setBounds(10, 100, 150, 35);
        manufacturer.setBorder(new LineBorder(new Color(128,0,0),2,true));
        manufacturer.setOpaque(true);

        JLabel itemQty = new JLabel(String.valueOf(item.itemQty));
        itemQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
        itemQty.setBackground(new Color(255, 255, 255));
        itemQty.setHorizontalAlignment(SwingConstants.CENTER);
        itemQty.setBounds(200, 100, 150, 35);
        itemQty.setBorder(new LineBorder(new Color(128,0,0),2,true));
        itemQty.setOpaque(true);

        add(serviceCode);
        add(serviceName);
        add(serviceCost);
        add(serviceType);
        add(manufacturer);
        add(itemQty);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(370, 60, 70, 25);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JComponent comp = (JComponent) arg0.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);

                JFrame Confirm = new JFrame();
                try {
                    BlOp.removeItem(item.itemCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                JOptionPane.showMessageDialog(Confirm, "Item has been removed from the Inventory");
                win.dispose();
            }
        });

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(370, 10, 70, 25);
        btnEdit.addActionListener(arg0 -> {
            JComponent comp = (JComponent) arg0.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);

            Edit_Item edit_item = new Edit_Item(item,BlOp);
            edit_item.setVisible(true);

            win.dispose();

        });

        add(btnRemove);
        add(btnEdit);

    }
}
