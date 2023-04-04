import java.util.ArrayList;
import java.util.Scanner;

public class Patient {
    private String name;
    private int age;
    private String gender;
    private String contact;

    public Patient(String name, int age, String gender, String contact) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }
}

public class Doctor {
    private String name;
    private String specialization;
    private String contact;

    public Doctor(String name, String specialization, String contact) {
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getContact() {
        return contact;
    }
}

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

public class Hospital {
    private String name;
    private String location;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void listPatients() {
        System.out.println("List of patients:");
        for (Patient patient : patients) {
            System.out.println("Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Gender: " + patient.getGender() + ", Contact: " + patient.getContact());
        }
    }

    public void listDoctors() {
        System.out.println("List of doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization() + ", Contact: " + doctor.getContact());
        }
    }

    public void listAppointments() {
        System.out.println("List of appointments:");
        for (Appointment appointment : appointments) {
        System.out.println("Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + ", Patient: " + appointment.getPatient().getName() + ", Doctor: " + appointment.getDoctor().getName());
        }
        }
        public static void main(String[] args) {
            Hospital hospital = new Hospital("XYZ Hospital", "New York");
            Scanner scanner = new Scanner(System.in);
        
            while (true) {
                System.out.println("Enter your choice:");
                System.out.println("1. Add a patient");
                System.out.println("2. Add a doctor");
                System.out.println("3. Make an appointment");
                System.out.println("4. List patients");
                System.out.println("5. List doctors");
                System.out.println("6. List appointments");
                System.out.println("0. Exit");
        
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
        
                switch (choice) {
                    case 1:
                        System.out.println("Enter patient name:");
                        String patientName = scanner.nextLine();
                        System.out.println("Enter patient age:");
                        int patientAge = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.println("Enter patient gender:");
                        String patientGender = scanner.nextLine();
                        System.out.println("Enter patient contact:");
                        String patientContact = scanner.nextLine();
                        Patient patient = new Patient(patientName, patientAge, patientGender, patientContact);
                        hospital.addPatient(patient);
                        System.out.println("Patient added successfully!");
                        break;
        
                    case 2:
                        System.out.println("Enter doctor name:");
                        String doctorName = scanner.nextLine();
                        System.out.println("Enter doctor specialization:");
                        String doctorSpecialization = scanner.nextLine();
                        System.out.println("Enter doctor contact:");
                        String doctorContact = scanner.nextLine();
                        Doctor doctor = new Doctor(doctorName, doctorSpecialization, doctorContact);
                        hospital.addDoctor(doctor);
                        System.out.println("Doctor added successfully!");
                        break;
        
                    case 3:
                        System.out.println("Enter patient name:");
                        String patientNameForAppointment = scanner.nextLine();
                        Patient patientForAppointment = null;
                        for (Patient p : hospital.patients) {
                            if (p.getName().equals(patientNameForAppointment)) {
                                patientForAppointment = p;
                                break;
                            }
                        }
                        if (patientForAppointment == null) {
                            System.out.println("Patient not found!");
                            break;
                        }
                        System.out.println("Enter doctor name:");
                        String doctorNameForAppointment = scanner.nextLine();
                        Doctor doctorForAppointment = null;
                        for (Doctor d : hospital.doctors) {
                            if (d.getName().equals(doctorNameForAppointment)) {
                                doctorForAppointment = d;
                                break;
                            }
                        }
                        if (doctorForAppointment == null) {
                            System.out.println("Doctor not found!");
                            break;
                        }
                        System.out.println("Enter appointment date (MM/DD/YYYY):");
                        String appointmentDate = scanner.nextLine();
                        System.out.println("Enter appointment time (HH:MM AM/PM):");
                        String appointmentTime = scanner.nextLine();
                        Appointment appointment = new Appointment(patientForAppointment, doctorForAppointment, appointmentDate, appointmentTime);
                        hospital.addAppointment(appointment);
                        System.out.println("Appointment created successfully!");
                        break;
        
                    case 4:
                        hospital.listPatients();
                        break;
        
                    case 5:
                        hospital.listDoctors();
                        break;
        
                    case 6:
                        hospital.listAppointments();
                        break;
        
                    case 0:
                        System.out.println("Thank you for using the hospital management system!");
                        System.exit(0);
                        default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
                   
        