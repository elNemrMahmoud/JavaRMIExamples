package projects.EmployeeRMI.server.dao;

import projects.EmployeeRMI.server.dao.mysql.MysqlConnectionFactory;
import projects.EmployeeRMI.server.model.Employee;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeRowsetImpl implements EmployeeDao {
    private final String select = "SELECT * FROM employee;";

    @Override
    public void add(Employee entity) {
        try {
            String SQLCommand = "INSERT INTO employee (idEmployee,nameEmployee,address) VALUES (?,?,?)";
            JdbcRowSet rowset = MysqlConnectionFactory.getJDBCRowset();
            rowset.setCommand(select);
            rowset.execute();
            rowset.moveToInsertRow();
            rowset.updateInt(1,entity.getIdEmployee());
            rowset.updateString(2,entity.getNameEmployee());
            rowset.updateString(3,entity.getAddress());
            rowset.insertRow();

        } catch (SQLException e) {
            System.out.println("Error Inserting employee in DB : " + e.getMessage());
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }


    }

    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String SQLCommand = "SELECT * FROM labs.employee;";

            JdbcRowSet rowset = MysqlConnectionFactory.getJDBCRowset();
            rowset.setCommand(SQLCommand);
            rowset.execute();

            int id;
            String name, address;
            while (rowset.next()) {
                id = rowset.getInt("idEmployee");
                name = rowset.getString("nameEmployee");
                address = rowset.getString("address");
                employees.add(new Employee(id, name, address));
            }
            System.out.println("Employees Retrieved Successfully.");


        } catch (SQLException e) {
            System.out.println("Error Retrieving all employees: " + e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(Employee entity) {
        try {
            String SQLCommand = "SELECT * FROM employee WHERE idEmployee = ? ";
            CachedRowSet rowset = MysqlConnectionFactory.getCachedRowset();
            rowset.setCommand(SQLCommand);
            rowset.setInt(1, entity.getIdEmployee());
            rowset.setConcurrency(CachedRowSet.CONCUR_UPDATABLE);
            rowset.execute();
            rowset.next();
            rowset.setKeyColumns(new int[]{1});
            //rowset.updateInt("idEmployee", entity.getIdEmployee());
            rowset.updateString("nameEmployee", entity.getNameEmployee());
            rowset.updateString("address", entity.getAddress());
            rowset.updateRow();
            rowset.acceptChanges();

            System.out.println("Update successful");


        } catch (SQLException e) {
            //System.out.println("Error updating employee : " + e.getMessage());
        }

    }

    @Override
    public void delete(Employee entity) {
        try {
            String SQLCommand = "SELECT * FROM labs.employee where idEmployee = ?";
            JdbcRowSet rowset = MysqlConnectionFactory.getJDBCRowset();
            rowset.setCommand(SQLCommand);
            rowset.setInt(1, entity.getIdEmployee());
            rowset.execute();
            rowset.next();
            rowset.deleteRow();
            rowset.commit();
            System.out.println("EmployeeDTO Successfully Deleted.");

        } catch (SQLException e) {
            System.out.println("Error deleting employee; " + e.getMessage());

        }

    }

    @Override
    public Employee getById(Integer employeeId) {
        Employee employee = null;
        int id;
        String name, address;
        try {
            String SQLCommand = "SELECT * FROM employee where idEmployee = ?";
            JdbcRowSet rowset = MysqlConnectionFactory.getJDBCRowset();
            rowset.setCommand(SQLCommand);
            rowset.setInt(1, employeeId);
            rowset.execute();
            rowset.next();
            id = rowset.getInt("idEmployee");
            name = rowset.getString("nameEmployee");
            address = rowset.getString("Address");
            employee = new Employee(id, name, address);

        } catch (SQLException e) {
            System.out.println("Error retrieving EmployeeDTO by ID: " + e.getMessage());
        }
        return employee;
    }
}
