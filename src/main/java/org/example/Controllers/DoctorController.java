package org.example.Controllers;

import org.example.Entities.Doctor;
import org.example.Models.DoctorModel;
import org.example.Views.DoctorView;

import javax.swing.*;

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
        this.view.getUpdateButton().addActionListener(e -> {
            updateDoctor();

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

    private void updateDoctor() {
        // 1. Obtenemos el doctor original que fue seleccionado
        Doctor originalDoctor = view.getSelectedDoctor();
        if (originalDoctor == null) {
            view.showMessage("Por favor, seleccione un doctor de la tabla para actualizar.");
            return;
        }

        // 2. Obtenemos los nuevos datos desde los campos de texto
        String name = view.getNameTextField().getText().trim();
        String lastName = view.getLastNameTextField().getText().trim();
        String ageStr = view.getAgeTextField().getText().trim();
        String speciality = view.getSpecialityTextField().getText().trim();

        if (name.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || speciality.isEmpty()) {
            view.showMessage("Todos los campos deben estar llenos para actualizar.");
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            // 3. Creamos un nuevo objeto Doctor con la información actualizada
            Doctor updatedDoctor = new Doctor(name, lastName, age, speciality);

            // 4. Le pedimos al modelo que reemplace el original con el actualizado
            model.updateDoctor(originalDoctor, updatedDoctor);

            view.clearForm(); // Limpiamos el formulario después de actualizar
            view.showMessage("¡Doctor actualizado exitosamente!");

        } catch (NumberFormatException e) {
            view.showMessage("La edad debe ser un número válido.");
        }
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

        return view.getSelectedDoctor();

    }


}
