package org.example.Controllers;

import org.example.Entities.Doctor;
import org.example.Models.DoctorModel;
import org.example.Views.DoctorView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DoctorController {
    private final DoctorModel model;
    private final DoctorView view;

    public DoctorController(DoctorModel model, DoctorView view) {
        this.model = model;
        this.view = view;

        this.view.getAddButton().addActionListener(e -> addDoctor());
        this.view.getDeleteButton().addActionListener(e -> deleteDoctor());
        this.view.getTable().getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                showSelectedDoctor();
            }
        });


    }

    private void addDoctor() {
        String name = view.getNameTextField().getText().trim();
        String lastName = view.getLastNameTextField().getText().trim();
        String ageStr = view.getAgeTextField().getText().trim();
        String speciality = view.getSpecialityTextField().getText().trim();
        if (name.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || speciality.isEmpty()) {
            JOptionPane.showMessageDialog(null, "all fields must be filled");
            return;

        }
        try {
            int age = Integer.parseInt(ageStr);
            Doctor newDoctor = new Doctor(name, lastName, age, speciality);
            model.addDoctor(newDoctor);
            view.clearForm();

        } catch (NumberFormatException e) {
            view.showMessage("La edad debe ser un numero valido");
        }


    }

    private void deleteDoctor() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            view.showMessage("Por favor, seleccione un doctor para eliminar");
            return;
        }
        Doctor doctorToDelete = model.getAllDoctors().get(selectedRow);
        model.deleteDoctor(doctorToDelete);
    }

    private void updateDoctor(Doctor doctor) {
        model.updateDoctor(doctor);
    }

    private void clearForm() {
        view.getNameTextField().setText("");
        view.getLastNameTextField().setText("");
        view.getAgeTextField().setText("");
        view.getSpecialityTextField().setText("");
    }

    private void showSelectedDoctor() {
        Doctor selectedDoctor = selectDoctor();
        if (selectedDoctor != null) {
            view.showMessage("Doctor seleccionado: " + selectedDoctor.getName() + "\n" +
                    selectedDoctor.getLastName() + "\n" +
                    "Edad: " + selectedDoctor.getAge() + "\n" +
                    "Especialidad: " + selectedDoctor.getSpeciality());
        }
    }

    private Doctor selectDoctor() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow >= 0) {
            return model.getAllDoctors().get(selectedRow);
        }
        return null;
    }


}
