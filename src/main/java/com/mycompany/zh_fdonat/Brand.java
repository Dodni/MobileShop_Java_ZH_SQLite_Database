/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zh_fdonat;

/**
 *
 * @author 4-110-7-hallgato
 */
public class Brand {
    private int id;
    private String brandName;

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", brandName=" + brandName + '}';
    }

    
    
}
