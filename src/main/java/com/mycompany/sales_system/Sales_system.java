/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sales_system;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author duyan
 */
public class Sales_system {

    public static void main(String[] args) {
        try{
            Dotenv dotenv = Dotenv.load();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(""+dotenv.get("DB_URL")+";databaseName=sales_management_db;encrypt=false",dotenv.get("DB_USER"),dotenv.get("DB_PASSWORD"));
                        System.out.println("ket noi thanh cong!!!");
        }catch(ClassNotFoundException | SQLException ex){
        System.out.println("loi" + ex.getMessage());
    }
    }
}
