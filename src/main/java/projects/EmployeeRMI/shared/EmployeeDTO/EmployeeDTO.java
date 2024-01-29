package projects.EmployeeRMI.shared.EmployeeDTO;

import projects.EmployeeRMI.server.model.Employee;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int idEmployee;
    private String nameEmployee;
    private String address;

    // Default constructor
    public EmployeeDTO() {
    }

    // Overloaded constructor
    public EmployeeDTO(int idEmployee, String nameEmployee, String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.address = address;
    }
    public EmployeeDTO(Employee emp)
    {
        this.idEmployee = emp.getIdEmployee();
        this.nameEmployee = emp.getNameEmployee();
        this.address = emp.getAddress();
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
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}



