package  ge.gtu.stud;

import java.text.*;
import javax.swing.text.MaskFormatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;

public class Test1 {

    public static void main(String[] args) throws Exception {

        Connection con = null;
        try {

// Setting up the DataSource object
//            sun.jdbc.odbc.ee.DataSource ds
//                    = new sun.jdbc.odbc.ee.DataSource();
//            ds.setDatabaseName("student");
//            con = DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};Server=MyServerName;Database=MyDataBase","","");

                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Example for Excel:
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=c:/temp/TStudent.xls;DriverID=22;READONLY=false","","");

//                con = DriverManager.getConnection("jdbc:odbc:DSStud","","");


// Getting a connection object
//            con = ds.getConnection();

// Getting database info
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("Server name: "
                               + meta.getDatabaseProductName());
            System.out.println("Server version: "
                               + meta.getDatabaseProductVersion());

// Closing the connection
            con.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}


