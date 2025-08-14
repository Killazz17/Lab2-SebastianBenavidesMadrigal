package org.example.Views;

import javax.swing.*;

public class MainView extends JFrame {
    private JPanel contentPanel;
    private JTabbedPane mainTabPanel;

    public MainView() {
        setTitle("Lab 2");
        setContentPane(contentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        //cargar los paneles de las pestanas

        mainTabPanel.add("Doctor Management", new DoctorView().getContentPanel());
        mainTabPanel.add("Patients Management",new PatienView().getContentPanel());
        mainTabPanel.add("History",new HistoryView().getContentPanel());
    }
}
