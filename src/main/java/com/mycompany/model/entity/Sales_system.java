/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.model.entity;

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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sales_management_db;encrypt=false","sa","12345678");
                        System.out.println("ket noi thanh cong!!!");
        }catch(ClassNotFoundException | SQLException ex){
        System.out.println("loi" + ex.getMessage());
    }
    }
}
