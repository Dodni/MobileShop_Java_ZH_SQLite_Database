/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zh_fdonat;

/**
 *
 * @author 4-110-7-hallgato
 */
public class Mobile {
    private int imei;
    private String type;
    private float Screen;
    private int camera;
    private int ram;
    private int rom;
    private int operationSystem;
    private int price;
    private int brandId;

    public Mobile(int imei, String type, float Screen, int camera, int ram, int rom, int operationSystem, int price, int brandId) {
        this.imei = imei;
        this.type = type;
        this.Screen = Screen;
        this.camera = camera;
        this.ram = ram;
        this.rom = rom;
        this.operationSystem = operationSystem;
        this.price = price;
        this.brandId = brandId;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScreen() {
        return Screen;
    }

    public void setScreen(float Screen) {
        this.Screen = Screen;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(int operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Mobile{" + "imei=" + imei + ", type=" + type + ", Screen=" + Screen + ", camera=" + camera + ", ram=" + ram + ", rom=" + rom + ", operationSystem=" + operationSystem + ", price=" + price + ", brandId=" + brandId + '}';
    }
    
    
           
           
}
