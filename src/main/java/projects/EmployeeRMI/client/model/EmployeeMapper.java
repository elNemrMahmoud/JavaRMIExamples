package projects.EmployeeRMI.client.model;

import projects.EmployeeRMI.shared.EmployeeDTO.EmployeeDTO;

import java.util.ArrayList;

public class EmployeeMapper {

    // Convert EmployeeDTO to Employee
    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getIdEmployee(),
                employeeDTO.getNameEmployee(),
                employeeDTO.getAddress()
        );
    }

    // Convert Employee to EmployeeDTO
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getAddress()
        );
    }
    // Map a List of EmployeeDTO to a List of Employee
    public static ArrayList<Employee> mapListToEmployee(ArrayList<EmployeeDTO> employeeDTOList) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            employeeList.add(mapToEmployee(employeeDTO));
        }
        return employeeList;
    }

    // Map a List of Employee to a List of EmployeeDTO
    public static ArrayList<EmployeeDTO> mapListToEmployeeDTO(ArrayList<Employee> employeeList) {
        ArrayList<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeDTOList.add(mapToEmployeeDTO(employee));
        }
        return employeeDTOList;
    }
}
