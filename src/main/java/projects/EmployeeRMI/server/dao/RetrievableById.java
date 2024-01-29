package projects.EmployeeRMI.server.dao;

public interface RetrievableById<T,ID> {
    T getById(ID id);
}
