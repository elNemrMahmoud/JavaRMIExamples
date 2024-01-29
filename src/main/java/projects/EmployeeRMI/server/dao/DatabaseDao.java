package projects.EmployeeRMI.server.dao;

import java.util.List;

public interface DatabaseDao<T> {
    void add(T entity);
    List<T> getAll();
    void update(T entity);
    void delete(T entity);
}
