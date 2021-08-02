package UI_Swing;

import Models.Operations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main_Frame extends JFrame {

    private JPanel contentPane;

    public Main_Frame(Operations BLOp) {
        //JFrame Setup
        setTitle("Car Manager");
        setResizable(false);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //ADD BUTTON -> TO BE IMPLEMENTED
//        JPanel Account_BackPanel = new JPanel();
//        Account_BackPanel.setBackground(new Color(255, 250, 240));
////        Account_BackPanel.setBounds(0, 0, 400, 200);
//        contentPane.add(Account_BackPanel);

        JPanel Action_BackPanel = new JPanel();
        Action_BackPanel.setBackground(new Color(255, 240, 245));
        Action_BackPanel.setBounds(0, 200, 400, 300);
        contentPane.add(Action_BackPanel);
        Action_BackPanel.setLayout(null);

        JPanel Action_Buttons_Panel = new JPanel();
        Action_Buttons_Panel.setBackground(new Color(255, 240, 245));
        Action_Buttons_Panel.setBounds(20, 10, 400, 130);
        Action_BackPanel.add(Action_Buttons_Panel);
        Action_Buttons_Panel.setLayout(null);

        JButton btnNewsFeed = new JButton("Add Service");
        btnNewsFeed.addActionListener(arg0 -> {
            Add_Service Window = new Add_Service(BLOp);
            Window.setVisible(true);
        });
        btnNewsFeed.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewsFeed.setBounds(0, 70, 150, 30);
        Action_Buttons_Panel.add(btnNewsFeed);

        JButton btnAddPost = new JButton("View Services");
        btnAddPost.addActionListener(arg0 -> {
            View_List Window = null;
            try {
                Window = new View_List(BLOp,"Services");
                Window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnAddPost.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddPost.setBounds(0, 20, 150, 30);
        Action_Buttons_Panel.add(btnAddPost);

        JButton btnMyPosts = new JButton("View Inventory");
        btnMyPosts.addActionListener(arg0 -> {
            View_List Window = null;
            try {
                Window = new View_List(BLOp,"Inventory");
                Window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnMyPosts.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMyPosts.setBounds(180, 20, 150, 30);
        Action_Buttons_Panel.add(btnMyPosts);

        JButton btngetFollowing = new JButton("Add Item");
        btngetFollowing.addActionListener(arg0 -> {
            Add_Item Window = new Add_Item(BLOp);
            Window.setVisible(true);
        });
        btngetFollowing.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btngetFollowing.setBounds(180, 70, 150, 30);
        Action_Buttons_Panel.add(btngetFollowing);
    }

}
