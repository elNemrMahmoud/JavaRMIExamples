package projects.EmployeeRMI.server.model;

import projects.EmployeeRMI.shared.EmployeeDTO.EmployeeDTO;

public class Employee {
    private int idEmployee;
    private String nameEmployee;
    private String address;

    // Default constructor
    public Employee() {
    }

    public Employee(EmployeeDTO emp){
        this.idEmployee = emp.getIdEmployee();
        this.nameEmployee = emp.getNameEmployee();
        this.address = emp.getAddress();
    }

    // Overloaded constructor
    public Employee(int idEmployee, String nameEmployee, String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.address = address;
    }

    // Getters and Setters
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ToString method
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

