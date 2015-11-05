package com.opinioapp.analytics;

import com.util.ConnectionConfiguration;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by manishatri on 5/11/15.
 */
public class Main {
    public static void main(String [] args){
        //System.out.println("hello world");

        Connection connection = null;
        try{

            //1. Create a connection
            connection = ConnectionConfiguration.getConnection();
            if (connection!= null){
                System.out.println("Connection Established");
            }
            //2. Create a Statement
            Statement statement = connection.createStatement();

            //3 Execute MYSQL query
           /* String sql = "insert into employee"
                    + "(name, id)"
                    + "values('manish', 20)";
            statement.executeUpdate(sql);
            System.out.println("Insert Complete");
*/

            String sql  = "select name, id  from employee ";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString("name");
                int id = rs.getInt("id");
                System.out.println("name: " +name);
                System.out.println("id : " +id);

            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (connection!= null){
                try{
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
