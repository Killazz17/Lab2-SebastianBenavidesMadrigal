package org.example.Models;

import org.example.Entities.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class DoctorModel extends Observable {
    private final List<Doctor> doctors=new ArrayList<Doctor>();
    public DoctorModel(){
        doctors.add(new Doctor("Sebastian", "Benavides", 45, "Pediatra"));
        doctors.add(new Doctor("Paula", "Zuniga", 25, "Geriatra"));
        doctors.add(new Doctor("Juan", "Garcia", 35, "Cardiologo"));
    }

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
        setChanged();
        notifyObservers();
    }
    public void deleteDoctor(Doctor doctor){
        doctors.remove(doctor);
        setChanged();
        notifyObservers();
    }
    public void updateDoctor(Doctor doctor){
        doctors.set(doctors.indexOf(doctor),doctor);
    }
    public List<Doctor> getAllDoctors(){
        return doctors;
    }
}
