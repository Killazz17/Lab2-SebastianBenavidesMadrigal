package org.example.Views;

import org.example.Controllers.DoctorController;
import org.example.Models.DoctorModel;

import javax.swing.*;

public class MainView extends JFrame {
    private JPanel contentPanel;
    private JTabbedPane mainTabPanel;

    DoctorView doctorView;


    public MainView() {
        setTitle("Lab 2");
        setContentPane(contentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        //cargar los paneles de las pestanas

        DoctorModel doctorModel = new DoctorModel();
        DoctorView  doctorView= new DoctorView(doctorModel);
        new DoctorController(doctorModel,doctorView);

        mainTabPanel.add("Doctor Management",  doctorView.getContentPanel());
        mainTabPanel.add("Patients Management",new PatienView().getContentPanel());
        mainTabPanel.add("History",new HistoryView().getContentPanel());
    }
}
