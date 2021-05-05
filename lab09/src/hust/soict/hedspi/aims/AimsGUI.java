package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Track;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class AimsGUI extends JFrame {
    private final JPanel displayPanel;
    private final JButton createOrderBtn = new JButton("New order");
    private final JButton addItemBtn = new JButton("Add");
    private final JTextField termField = new JTextField();
    private final JButton searchItemBtn = new JButton("Search");
    private final JButton deleteItemBtn = new JButton("Delete");
    private JScrollPane scrollPane;
    private JList<Media> mediaList;
    private Order order;
    private int mediaCount;

    public AimsGUI() {
        JFrame f = this;
        Container parentContainer = getContentPane();
        parentContainer.setLayout(new BorderLayout());
        parentContainer.add(new JPanel() {
            {
                setLayout(new FlowLayout());
                add(createOrderBtn);
            }
        }, BorderLayout.NORTH);


        termField.setColumns(10);
        parentContainer.add(new JPanel() {
            {
                setLayout(new FlowLayout());
                add(addItemBtn);
                add(termField);
                add(searchItemBtn);
                add(deleteItemBtn);
            }
        }, BorderLayout.SOUTH);

        order = new Order();


        mediaCount += 3;
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Abcddd", "def", 20f, "abcd", 2);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Abc2", "def", 20f, "cvbxvb", 2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Abc3", "def", 20f, "dfgdfg", 2);
        order.addMedia(dvd);
        order.addMedia(dvd2);
        order.addMedia(dvd3);


        displayPanel = new JPanel(new BorderLayout());
        displayPanel.add(new JLabel("Order "  + SwingConstants.CENTER), BorderLayout.NORTH);
        mediaList = new JList<>(new Vector<>(order.getItemsOrdered()));
        mediaList.setFont(new Font("monospaced", Font.PLAIN, 15));
        scrollPane = new JScrollPane(mediaList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayPanel.add(scrollPane);
        parentContainer.add(displayPanel);


        createOrderBtn.addActionListener(evt -> {
            order = new Order();
            displayPanel.removeAll();
            displayPanel.add(new JLabel("Order ", SwingConstants.CENTER), BorderLayout.NORTH);
            mediaList = new JList<>(new Vector<>(order.getItemsOrdered()));
            mediaList.setFont(new Font("monospaced", Font.PLAIN, 15));
            scrollPane = new JScrollPane(mediaList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            displayPanel.add(scrollPane);
            displayPanel.revalidate();
            displayPanel.repaint();
        });

        addItemBtn.addActionListener(evt -> {
            JDialog inputForm = new JDialog(f, "Add Media", true);
            inputForm.setLayout(new FlowLayout());

            JButton confirmBtn = new JButton("OK");
            String[] options = { "CD", "DVD",};
            JComboBox<String> chooseMediaBox = new JComboBox<>(options);
            inputForm.add(chooseMediaBox);
            inputForm.add(confirmBtn);
            confirmBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    String choosed = (String) chooseMediaBox.getSelectedItem();
                    System.out.println(choosed);
                    inputForm.dispose();
                    if (choosed != null && choosed.equals("DVD")) { // CD choosed
                        JDialog inputDVDForm = new JDialog(f, "Add DVD", true);
                        inputDVDForm.setLayout(new GridLayout(6, 1));
                        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel titleLabel = new JLabel("Title:");
                        JTextField titleField = new JTextField();
                        titleField.setColumns(25);
                        titlePanel.add(titleLabel);
                        titlePanel.add(titleField);
                        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel categoryLabel = new JLabel("Category:");
                        JTextField categoryField = new JTextField();
                        categoryField.setColumns(25);
                        categoryPanel.add(categoryLabel);
                        categoryPanel.add(categoryField);
                        JPanel directorPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel directorLabel = new JLabel("Director:");
                        JTextField directorField = new JTextField();
                        directorField.setColumns(25);
                        directorPanel.add(directorLabel);
                        directorPanel.add(directorField);
                        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel lengthLabel = new JLabel("Length:");
                        JTextField lengthField = new JTextField();
                        lengthField.setColumns(25);
                        lengthPanel.add(lengthLabel);
                        lengthPanel.add(lengthField);
                        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel costLabel = new JLabel("Cost($):");
                        JTextField costField = new JTextField();
                        costField.setColumns(25);
                        costPanel.add(costLabel);
                        costPanel.add(costField);
                        JPanel btnPanel = new JPanel(new FlowLayout());
                        JButton addConfirmBtn = new JButton("Add");
                        btnPanel.add(addConfirmBtn);
                        inputDVDForm.add(titlePanel);
                        inputDVDForm.add(categoryPanel);
                        inputDVDForm.add(directorPanel);
                        inputDVDForm.add(lengthPanel);
                        inputDVDForm.add(costPanel);
                        inputDVDForm.add(btnPanel);

                        addConfirmBtn.addActionListener(evt14 -> {
                            if (titleField.getText().isEmpty() || categoryField.getText().isEmpty()
                                    || directorField.getText().isEmpty() || lengthField.getText().isEmpty()
                                    || costField.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(inputDVDForm, "Must fill all text fields",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            int length;
                            try {
                                length = Integer.parseInt(lengthField.getText());
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(inputDVDForm,
                                        "Length field must be integer number!", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            float cost;
                            try {
                                cost = Float.parseFloat(costField.getText());
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(inputDVDForm, "Cost field must be real number!",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            mediaCount++;
                            order.addMedia(new DigitalVideoDisc(mediaCount, titleField.getText(),
                                    categoryField.getText(), cost, directorField.getText(), length));
                            inputDVDForm.dispose();
                            mediaList.removeAll();
                            mediaList.setListData(new Vector<>(order.search(termField.getText())));
                            displayPanel.revalidate();
                            displayPanel.repaint();
                        });
                        inputDVDForm.setSize(400, 300);
                        inputDVDForm.setResizable(false);
                        inputDVDForm.setVisible(true);
                    } else { // DVD choosed
                        JDialog inputCDForm = new JDialog(f, "Add CD", true);
                        inputCDForm.setLayout(new GridLayout(0, 1));
                        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel titleLabel = new JLabel("Title:");
                        JTextField titleField = new JTextField();
                        titleField.setColumns(25);
                        titlePanel.add(titleLabel);
                        titlePanel.add(titleField);
                        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel categoryLabel = new JLabel("Category:");
                        JTextField categoryField = new JTextField();
                        categoryField.setColumns(25);
                        categoryPanel.add(categoryLabel);
                        categoryPanel.add(categoryField);
                        JPanel artistPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel artistLabel = new JLabel("Artist:");
                        JTextField artistField = new JTextField();
                        artistField.setColumns(25);
                        artistPanel.add(artistLabel);
                        artistPanel.add(artistField);
                        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JLabel costLabel = new JLabel("Cost($):");
                        JTextField costField = new JTextField();
                        costField.setColumns(25);
                        costPanel.add(costLabel);
                        costPanel.add(costField);
                        JPanel btnPanel = new JPanel(new FlowLayout());
                        JButton addConfirmBtn = new JButton("Add");
                        JButton addTrackBtn = new JButton("Add Track");
                        btnPanel.add(addTrackBtn);
                        btnPanel.add(addConfirmBtn);
                        inputCDForm.add(titlePanel);
                        inputCDForm.add(categoryPanel);
                        inputCDForm.add(artistPanel);
                        inputCDForm.add(costPanel);
                        inputCDForm.add(btnPanel);
                        JList<Track> trackList = new JList<>(new Vector<>());
                        JScrollPane scrollTrackPane = new JScrollPane(trackList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        inputCDForm.add(scrollTrackPane);
                        List<Track> tracks = new ArrayList<>();
                        addTrackBtn.addActionListener(evt1 -> {
                            JDialog inputTrackForm = new JDialog(f, "Add Track", true);
                            inputTrackForm.setLayout(new GridLayout(0, 1));
                            JPanel titleTrackPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            JLabel titleTrackLabel = new JLabel("Title:");
                            JTextField titleTrackField = new JTextField();
                            titleTrackField.setColumns(25);
                            titleTrackPanel.add(titleTrackLabel);
                            titleTrackPanel.add(titleTrackField);
                            JPanel lengthTrackPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            JLabel lengthTrackLabel = new JLabel("Length:");
                            JTextField lengthTrackField = new JTextField();
                            lengthTrackField.setColumns(25);
                            lengthTrackPanel.add(lengthTrackLabel);
                            lengthTrackPanel.add(lengthTrackField);
                            JPanel btnPanel1 = new JPanel(new FlowLayout());
                            JButton addConfirmBtn1 = new JButton("Add");
                            btnPanel1.add(addConfirmBtn1);
                            inputTrackForm.add(titleTrackPanel);
                            inputTrackForm.add(lengthTrackPanel);
                            inputTrackForm.add(btnPanel1);
                            addConfirmBtn1.addActionListener(evt11 -> {
                                if (titleTrackField.getText().isEmpty() || lengthTrackField.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(inputTrackForm,
                                            "Must fill all text fields", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                int length;
                                try {
                                    length = Integer.parseInt(lengthTrackField.getText());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(inputTrackForm,
                                            "Length field must be integer number!", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                inputTrackForm.dispose();
                                trackList.removeAll();
                                tracks.add(new Track(titleTrackField.getText(), length));
                                trackList.setListData(new Vector<>(tracks));
                                trackList.revalidate();
                                trackList.repaint();
                            });
                            inputTrackForm.setSize(400, 200);
                            inputTrackForm.setResizable(false);
                            inputTrackForm.setVisible(true);
                        });

                        addConfirmBtn.addActionListener(evt12 -> {
                            if (titleField.getText().isEmpty() || categoryField.getText().isEmpty()
                                    || artistField.getText().isEmpty() || costField.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(inputCDForm, "Must fill all text fields",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            float cost;
                            try {
                                cost = Float.parseFloat(costField.getText());
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(inputCDForm, "Cost field must be real number!",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            mediaCount++;
                            order.addMedia(new CompactDisc(mediaCount, titleField.getText(),
                                    categoryField.getText(), cost, artistField.getText()));
                            inputCDForm.dispose();
                            mediaList.removeAll();
                            mediaList.setListData(new Vector<>(order.search(termField.getText())));
                            displayPanel.revalidate();
                            displayPanel.repaint();
                        });
                        inputCDForm.setSize(400, 300);
                        inputCDForm.setResizable(false);
                        inputCDForm.setVisible(true);
                    }
                }
            });

            inputForm.setSize(400, 100);
            inputForm.setResizable(false);
            inputForm.setVisible(true);
        });


        searchItemBtn.addActionListener(evt -> {

            if (termField.getText() == null) {
                mediaList.removeAll();
                mediaList.setListData(new Vector<>(order.getItemsOrdered()));
                displayPanel.revalidate();
                displayPanel.repaint();
                return;
            }

            mediaList.removeAll();
            mediaList.setListData(new Vector<>(order.search(termField.getText())));
            displayPanel.revalidate();
            displayPanel.repaint();
        });


        deleteItemBtn.addActionListener(evt -> {

            if (mediaList.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(parentContainer, "Select media first", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (Media media : mediaList.getSelectedValuesList()) {
                order.removeMedia(media);
            }

            mediaList.removeAll();
            mediaList.setListData(new Vector<>(order.getItemsOrdered()));
            displayPanel.revalidate();
            displayPanel.repaint();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aims Project");
        setSize(1000, 700);
        setMinimumSize(new Dimension(600, 300));
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AimsGUI::new);
    }
}