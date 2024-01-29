package projects.EmployeeRMI.server.dao;

import projects.EmployeeRMI.server.model.Employee;

public interface EmployeeDao extends DatabaseDao<Employee>, RetrievableById<Employee,Integer> {

}
