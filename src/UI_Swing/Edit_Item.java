package UI_Swing;

import Models.Item;
import Models.Operations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Edit_Item extends JFrame {
    private JPanel contentPane;

    public Edit_Item(Item item, Operations BLOp) {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(50, 50, 350, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel itemCode = new JLabel(String.valueOf(item.itemCode));
        itemCode.setOpaque(true);
        itemCode.setBackground(Color.WHITE);
        itemCode.setBounds(100, 30, 150, 25);
        contentPane.add(itemCode);

        JTextField itemName = new Helper.HintTextField(item.itemName);
        itemName.setOpaque(true);
        itemName.setBackground(Color.WHITE);
        itemName.setBounds(100, 60, 150, 25);
        contentPane.add(itemName);

        JTextField manufacturer = new Helper.HintTextField(item.manufacturer);
        manufacturer.setOpaque(true);
        manufacturer.setBackground(Color.WHITE);
        manufacturer.setBounds(100, 90, 150, 25);
        contentPane.add(manufacturer);

        JTextField itemType = new Helper.HintTextField(item.itemType);
        itemType.setOpaque(true);
        itemType.setBackground(Color.WHITE);
        itemType.setBounds(100, 120, 150, 25);
        contentPane.add(itemType);

        JTextField itemPrice = new Helper.HintTextField(String.valueOf(item.itemPrice));
        itemPrice.setOpaque(true);
        itemPrice.setBackground(Color.WHITE);
        itemPrice.setBounds(100, 150, 150, 25);
        contentPane.add(itemPrice);

        JTextField itemQty = new Helper.HintTextField(String.valueOf(item.itemQty));
        itemQty.setOpaque(true);
        itemQty.setBackground(Color.WHITE);
        itemQty.setBounds(100, 180, 150, 25);
        contentPane.add(itemQty);

        JButton btnSignIn = new JButton("Edit");
        btnSignIn.addActionListener(arg0 -> {
            int x = item.itemQty;
            try{
                if (itemQty.getText().length()>0)
                    if (Integer.parseInt(itemQty.getText())>-1)
                        item.itemQty = Integer.parseInt(itemQty.getText());
            }catch (Exception e){
                item.itemQty = x;
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Invalid Quantity. Value remains Unchanged");

            }

            x = item.itemPrice;
            try{
                if (itemPrice.getText().length()>0)
                    if (Integer.parseInt(itemPrice.getText())>-1)
                        item.itemPrice = Integer.parseInt(itemPrice.getText());
            }catch (Exception e){
                item.itemPrice = x;
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Invalid Price. Value remains Unchanged");

            }

            if (manufacturer.getText().length()>0)
                item.manufacturer = manufacturer.getText();

            if (itemType.getText().length()>0)
                item.itemType = itemType.getText();

            if (itemName.getText().length()>0)
                item.itemName = itemName.getText();

            if (BLOp.editItem(item)){
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Item Modified in Inventory");

                dispose();
            }
            else{
                JFrame Confirm = new JFrame();
                JOptionPane.showMessageDialog(Confirm, "Connection Error. Could not Edit Item");
            }
        });
        btnSignIn.setBounds(120, 230, 100, 25);
        contentPane.add(btnSignIn);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setBounds(0, 0, 448, 220);
        panel.setOpaque(true);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 239, 213));
        panel_1.setBounds(0, 220, 448, 242);
        panel_1.setOpaque(true);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
    }
}

