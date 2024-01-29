package projects.EmployeeRMI.server.service;

import projects.EmployeeRMI.server.dao.EmployeeRowsetImpl;
import projects.EmployeeRMI.server.model.Employee;
import projects.EmployeeRMI.shared.EmployeeDTO.EmployeeDTO;
import projects.EmployeeRMI.shared.remoteinterfaces.EmployeeServiceInterface;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.stream.Collectors;

public class EmployeeService extends UnicastRemoteObject implements EmployeeServiceInterface {
    public EmployeeService() throws RemoteException {
        //super();

    }
    @Override
    public EmployeeDTO getEmployeeById(int Id)
    {
        Employee employee = null;
        EmployeeRowsetImpl empDao = new EmployeeRowsetImpl();
        employee = empDao.getById(Id);
        //check if null & handle
        return new EmployeeDTO(employee);
    }
    @Override
    public ArrayList<EmployeeDTO> getAllEmployees()
    {
        EmployeeRowsetImpl empDao = new EmployeeRowsetImpl();
        List<Employee> employees = new ArrayList<>(empDao.getAll());
        return employees.stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));


    }
    @Override
    public void addEmployee(EmployeeDTO newEmployee)
    {
        EmployeeRowsetImpl empDao = new EmployeeRowsetImpl();
        empDao. add(new Employee(newEmployee));
        System.out.println("Employee Successfully added to DB");
    }

    @Override
    public void updateEmployee(EmployeeDTO emp) throws RemoteException {
        EmployeeRowsetImpl empDao = new EmployeeRowsetImpl();
        empDao.update(new Employee(emp));

    }

    @Override
    public void deleteEmployee(EmployeeDTO emp) throws RemoteException {
        EmployeeRowsetImpl empDao = new EmployeeRowsetImpl();
        empDao.delete(new Employee(emp));

    }

}
