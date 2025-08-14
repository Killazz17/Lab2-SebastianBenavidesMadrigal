package org.example.Models;

import org.example.Entities.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DoctorsTableModel extends AbstractTableModel {

    private final List<Doctor> doctors;
    private final String[] columnNames = {"Name", "Lastname", "Age", "Speciality"};

    public DoctorsTableModel(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public int getRowCount() {
        return this.doctors.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = this.doctors.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> doctor.getName();
            case 1 -> doctor.getLastName();
            case 2 -> doctor.getAge();
            case 3 -> doctor.getSpeciality();
            default -> null;
        };

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
