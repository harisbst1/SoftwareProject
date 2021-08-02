package UI_Swing;

import Models.Item;
import Models.Operations;
import Models.Services;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class View_List extends JFrame {

    private JPanel contentPane;


    public View_List(Operations BLOp,String type) throws Exception {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        setTitle(type+" List");

        JPanel ListHolderPane = new JPanel();
        ListHolderPane.setPreferredSize(new Dimension(500,375));
        ListHolderPane.setOpaque(true);

        //ScrollPane Setup
        JScrollPane ListHolder = new JScrollPane(ListHolderPane);
        ListHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ListHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ListHolder.setMinimumSize(new Dimension(500,375));
        ListHolder.setPreferredSize(new Dimension(500,375));
        ListHolder.getViewport().setMinimumSize(new Dimension(500,375));
        ListHolder.getViewport().setPreferredSize(new Dimension(500,375));
        contentPane.setLayout(new BorderLayout(0, 0));

        getContentPane().add(ListHolder);

//        JPanel MainPanel = new JPanel();
//        MainPanel.setBackground(new Color(245, 255, 250));
//        contentPane.add(MainPanel, BorderLayout.NORTH);
//        MainPanel.setPreferredSize(new Dimension(400,125));
//        MainPanel.setLayout(null);

        JPanel panel2 = new JPanel();
        int size = 0;
        if (type.equals("Services"))
        {
            ArrayList<Services> servicesArrayList =  BLOp.getServices();
            size = servicesArrayList.size() + 1;
            for (Services entry: servicesArrayList) {

                JPanel sp1 = new List_Service(entry, BLOp);
                panel2.add(sp1);

            }
            panel2.setPreferredSize(new Dimension(500,size*110));

        }
        else if (type.equals("Inventory"))
        {
            ArrayList<Item> itemArrayList =  BLOp.getItemList();
            size = itemArrayList.size() + 1;
            for (Item entry: itemArrayList) {

                JPanel sp1 = new List_Item(entry, BLOp);
                panel2.add(sp1);

            }
            panel2.setPreferredSize(new Dimension(500,size*150));
        }

        ListHolder.getViewport().setView(panel2);
    }

}
