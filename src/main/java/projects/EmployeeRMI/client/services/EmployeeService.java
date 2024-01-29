package projects.EmployeeRMI.client.services;

import projects.EmployeeRMI.client.model.Employee;
import projects.EmployeeRMI.client.model.EmployeeMapper;
import projects.EmployeeRMI.shared.EmployeeDTO.EmployeeDTO;
import projects.EmployeeRMI.shared.remoteinterfaces.EmployeeServiceInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class EmployeeService {
    private EmployeeServiceInterface EmpService;
    private Registry registry;

   public EmployeeService(){
        try {
            registry = LocateRegistry.getRegistry(1999);
            EmpService =(EmployeeServiceInterface) registry.lookup("EmployeeService");

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Employee> getAllEmployees()
    {
        ArrayList<EmployeeDTO> employees = null;
        try {
            employees = EmpService.getAllEmployees();
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        return EmployeeMapper.mapListToEmployee(employees);

    }

    public Employee getEmployeeById(int Id)
    {
        EmployeeDTO employee = null;
        try {
            employee= EmpService.getEmployeeById(Id);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        return EmployeeMapper.mapToEmployee(employee);

    }

    public void deleteEmployee(Employee employee)
    {
        try {
            EmpService.deleteEmployee(EmployeeMapper.mapToEmployeeDTO(employee));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }


    }

    public void addEmployee(Employee employee)
    {
        try {
            EmpService.addEmployee(EmployeeMapper.mapToEmployeeDTO(employee));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateEmployee(Employee employee)
    {
        try{
            EmpService.updateEmployee(EmployeeMapper.mapToEmployeeDTO(employee));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }

}
