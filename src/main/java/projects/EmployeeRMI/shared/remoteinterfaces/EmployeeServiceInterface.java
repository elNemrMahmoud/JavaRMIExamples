package projects.EmployeeRMI.shared.remoteinterfaces;

import projects.EmployeeRMI.shared.EmployeeDTO.EmployeeDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EmployeeServiceInterface extends Remote {
    public ArrayList<EmployeeDTO> getAllEmployees() throws RemoteException;
    public EmployeeDTO getEmployeeById(int Id) throws RemoteException;
    public void addEmployee(EmployeeDTO emp) throws RemoteException;

    public void updateEmployee(EmployeeDTO emp) throws RemoteException;
    public void deleteEmployee(EmployeeDTO emp) throws RemoteException;

}
