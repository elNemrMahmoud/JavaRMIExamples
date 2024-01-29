package projects.EmployeeRMI.server.dao.mysql;


import projects.EmployeeRMI.server.dao.PropertyFileUtil;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnectionFactory {
    private final  static Properties prop = PropertyFileUtil.getPropertiesFromFile();
    private final static String DBUrl = PropertyFileUtil.DBProperties.URL.toString();
    private final static String DBUser = PropertyFileUtil.DBProperties.USERNAME.toString();
    private final static String DBPass = PropertyFileUtil.DBProperties.PASSWORD.toString();

    private static RowSetFactory rsFactory;
    public static JdbcRowSet getJDBCRowset() {
        JdbcRowSet jdbcRowSet =null;
        try{
            rsFactory = RowSetProvider.newFactory();
            jdbcRowSet = rsFactory.createJdbcRowSet();

            jdbcRowSet.setUrl(prop.getProperty(DBUrl));
            jdbcRowSet.setUsername(prop.getProperty(DBUser));
            jdbcRowSet.setPassword(prop.getProperty(DBPass));

        }catch(SQLException e)
        {
            System.out.println("Error retrieving JDBCRowset in : getJDBCRowset : "+e.getMessage());
        }
        System.out.println("Rowset Successfully Retrieved.");
        return jdbcRowSet;

    }

    public static CachedRowSet getCachedRowset()
    {
        CachedRowSet cachedRowset =null;
        try{
            rsFactory = RowSetProvider.newFactory();
            cachedRowset = rsFactory.createCachedRowSet();

            cachedRowset.setUrl(prop.getProperty(DBUrl));
            cachedRowset.setUsername(prop.getProperty(DBUser));
            cachedRowset.setPassword(prop.getProperty(DBPass));

        }catch(SQLException e)
        {
            System.out.println("Error retrieving cachedRowset in : getCachedRowset : "+e.getMessage());
        }
        System.out.println("Rowset Successfully Retrieved.");
        return cachedRowset;

    }

}
