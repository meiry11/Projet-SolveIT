package org.exemple;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;

public class MySQLConnect {
    private static Connection connexion;

    private MySQLConnect()
    {
        try
        {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("127.0.0.1");
            ds.setPortNumber(3306);
            ds.setDatabaseName("tpjsp");
            ds.setUser("root");
            ds.setPassword("");
            connexion = ds.getConnection();
        }

        // Handle any errors that may have occurred.
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnexion()
    {
        if (connexion == null)
            new MySQLConnect();
        return connexion;
    }
}
