/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MobileManager mm = new MobileManager();
        List<Mobile> mobiles = mm.getAllMobile();
        for (Mobile mobile : mobiles) {
            System.out.println(mobile.toString());
        }
        List<MobileQuery> query = mm.getAll();
        for (MobileQuery mobileQuery : query) {
            System.out.println(mobileQuery.toString());
            
        }
        
        boolean a = mm.modify("Iphone 12 Pro", 10);
        System.out.println(a);
        System.out.println(mm.sum());   
        
        System.out.println(mm.getHigher().toString());
        
    }
    
    
    
    
}
