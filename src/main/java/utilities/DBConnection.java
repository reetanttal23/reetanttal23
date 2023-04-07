package utilities;

import java.sql.*;

public class DBConnection{

public Connection getConnection(String dbURL, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbURL,userName,password);

        Statement stmnt = connection.createStatement();
        stmnt.executeUpdate("update country set Name='Brazillian' where Code= 'BRAmpyon'");
        //System.out.println(y);
        stmnt.executeQuery("select *from country Where Population>800000000");
        ResultSet rs = stmnt.getResultSet();
        while(rs.next()){
        int indepYear = rs.getInt(6);
        String countryName = rs.getString("Name");
            System.out.println(indepYear+"   "+countryName);
        }
        return connection;
        }
        }

