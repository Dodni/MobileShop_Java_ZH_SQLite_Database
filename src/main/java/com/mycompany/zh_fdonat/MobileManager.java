/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zh_fdonat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4-110-7-hallgato
 */
public class MobileManager {
    private final String URL = "jdbc:sqlite:MobileShop.db";
    
    public List<Mobile> getAllMobile() {
        try {
            Statement statement = getAllStatement();
            List<Mobile> mobiles = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Mobiles");
            while (rs.next()) {
                int imei = rs.getInt("IMEI");
                String type = rs.getString("Type");
                float Screen = rs.getFloat("Screen");
                int camera = rs.getInt("Camera");
                int ram = rs.getInt("RAM");
                int rom = rs.getInt("ROM");
                int operationSystem = rs.getInt("OperationSystem");
                int price = rs.getInt("Price");
                int brandId = rs.getInt("BrandId");
                
                Mobile mobile = new Mobile(imei, type, Screen, camera, ram, rom, operationSystem, price, brandId);
                mobiles.add(mobile);
            }
            return mobiles;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<MobileQuery> getAll() {
        try {
            Statement statement = getAllStatement();
            String query = "SELECT c.IMEI, b.BrandName, c.Type, c.Screen, c.RAM, c.ROM, c.OperationSystem, c.Price, c.Camera " +
                    "FROM Mobiles as c " + "INNER JOIN Brands as b " + "ON c.BrandId = b.Id";
            
            List<MobileQuery> mobileQueries = new ArrayList<>();
            boolean isQuery = statement.execute(query);
           ResultSet resultSet = statement.getResultSet();
           
            while (resultSet.next()) {                
                int imei = resultSet.getInt("IMEI");
                String type = resultSet.getString("Type");
                float Screen = resultSet.getFloat("Screen");
                int camera = resultSet.getInt("Camera");
                int ram = resultSet.getInt("RAM");
                int rom = resultSet.getInt("ROM");
                int operationSystem = resultSet.getInt("OperationSystem");
                int price = resultSet.getInt("Price");
                String mobileBrand = resultSet.getString("BrandName");
                
                mobileQueries.add(new MobileQuery(imei, type, Screen, camera, ram, rom, operationSystem, price, mobileBrand));
            }
            return mobileQueries;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public int sum() {
        
        String query = "SELECT SUM(price) FROM Mobiles;";
        int ossz=0;
        try {
            Statement statement = getAllStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            
                ossz=resultSet.getInt(1);
            }
            return ossz;
        } catch (SQLException e) {
            return -1;
        }
        
        
    }
    
    public MobileQuery getHigher(){
            MobileQuery mq = null;
            String query = "SELECT * FROM Mobiles INNER JOIN Brands ORDER BY Price DESC LIMIT 1";
            try {
                
                Statement statement = getAllStatement();
                ResultSet resultSet = statement.executeQuery(query);
                //List<MobileQuery> mobileQueries = new ArrayList<>();
                int imei = resultSet.getInt("IMEI");
                String type = resultSet.getString("Type");
                float Screen = resultSet.getFloat("Screen");
                int camera = resultSet.getInt("Camera");
                int ram = resultSet.getInt("RAM");
                int rom = resultSet.getInt("ROM");
                int operationSystem = resultSet.getInt("OperationSystem");
                int price = resultSet.getInt("Price");
                String mobileBrand = resultSet.getString("BrandName");
                mq = new MobileQuery(imei, type, Screen, camera, ram, rom, operationSystem, price, mobileBrand);
                return mq;
                
            
            //return mobileQueries;
            } catch (SQLException e) {
                return null;
            }
            
        }
    
    
    
    public boolean modify(String Type, int discount){
        try {
            Statement statement = getAllStatement();
            
            
            int currentPrice = 0;
            ResultSet resultSet = statement.executeQuery("SELECT Price FROM Mobiles WHERE Type='"+Type+"'");
            
            if (resultSet.next()) {
                currentPrice = resultSet.getInt("Price");
            }
            
            int newPrice = (int) (currentPrice - (currentPrice * ((double) discount / 100.0)));
            System.out.println(newPrice);//szazalekszamitas
            int modified = statement.executeUpdate("UPDATE Mobiles SET Price = " + newPrice + " WHERE Type = '" + Type + "'");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private Statement getAllStatement() 
        throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        Statement statement = conn.createStatement();
        return statement;
    }
    
}
