package org.example.Views;

import org.example.Entities.Doctor;
import org.example.Models.DoctorModel;
import org.example.Models.DoctorsTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DoctorView implements Observer {
    private  JPanel contentPanel;
    private JPanel formPanel;
    private JPanel ButtonPanel;
    private JPanel TablePanel;
    private JPanel namePanel;
    private JPanel informationPanel;
    private JPanel nameGroupPanel;
    private JPanel lastNameGroupPanel;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JTextField lastNameTextField;
    private JLabel lastNameLabel;
    private JPanel ageGroupPanel;
    private JPanel specialityGroupPanel;
    private JTextField ageTextField;
    private JTextField specialityTextField;
    private JLabel ageLabel;
    private JLabel specialityLabel;
    private JButton cleanButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTable table;
    private JScrollPane tableScrollPanel;
    private final DoctorModel model;

    public DoctorView(DoctorModel model) {
        /*fillTable();
        DoctorsTableModel model = new DoctorsTableModel(this.doctors);
        table.setModel(model);

        //inicializar


        addButton.addActionListener(e -> addDoctor());
        table.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                showSelectedDoctor();
            }
        });*/

        //nuevo

        this.model = model;
        model.addObserver(this);
        updateTable(this.model.getAllDoctors());

    }
/*


    private void addDoctor() {
        String name = nameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String age = ageTextField.getText().trim();
        String speciality = specialityTextField.getText().trim();
        if (name.isEmpty() || lastName.isEmpty() || age.isEmpty() || speciality.isEmpty()) {
            JOptionPane.showMessageDialog(null, "all fields must be filled");
            return;

        }
        //Creacion del objeto para ingresar a la lista

        Doctor newDoctor = new Doctor(name, lastName, Integer.parseInt(age), speciality);
        this.doctors.add(newDoctor);

        //notificar al modelo de cambio
        ((AbstractTableModel) table.getModel()).fireTableDataChanged();

        //limpiar campos

        nameTextField.setText("");
        lastNameTextField.setText("");
        ageTextField.setText("");
        specialityTextField.setText("");

    }

    private void showSelectedDoctor() {
        Doctor selectedDoctor = getSelectedDoctor();
        if (selectedDoctor != null) {
            JOptionPane.showMessageDialog(contentPanel, "Doctor seleccionado: " + selectedDoctor.getName() + "\n" + selectedDoctor.getLastName() + "\n" + "Edad: " + selectedDoctor.getAge() + "\n" + "Especialidad: " + selectedDoctor.getSpeciality());
        }
    }

    public Doctor getSelectedDoctor() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            return doctors.get(row);
        }
        return null;
    }

    private void fillTable() {
        doctors.add(new Doctor("Sebastian", "Benavides", 45, "Pediatra"));
        doctors.add(new Doctor("Paula", "Zuniga", 25, "Geriatra"));
        doctors.add(new Doctor("Juan", "Garcia", 35, "Cardiologo"));
    }

*/
    public  JPanel getContentPanel() {
        return contentPanel;
    }
    //nuevo

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public JTextField getSpecialityTextField() {
        return specialityTextField;
    }
    public JButton getCleanButton() {
        return cleanButton;
    }
    public JButton getUpdateButton() {
        return updateButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }


    public JTable getTable() {
        return table;
    }

    public String showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
        return message;
    }
    public void clearForm() {
        nameTextField.setText("");
        lastNameTextField.setText("");
        ageTextField.setText("");
        specialityTextField.setText("");
    }
    private void updateTable(List<Doctor> doctors) {
        DoctorsTableModel tableModel=new DoctorsTableModel(doctors);
        table.setModel(tableModel);
        ((AbstractTableModel) table.getModel()).fireTableDataChanged();


    }

    //Este es un metodo llamado automaticamente cuando el Modelo notifica cambios
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DoctorModel){
            DoctorModel doctorModel = (DoctorModel) o;
            updateTable( doctorModel.getAllDoctors());
        }

    }
    public Doctor getSelectedDoctor() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            return model.getAllDoctors().get(row);
        }
        return null;
    }
}
