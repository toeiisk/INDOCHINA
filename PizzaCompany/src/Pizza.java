/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_28
 */

//pzType = "Pan", "Crispy"
//pzSize = "S", "M", "L"
//pzStatus = "BAKED", "UNBAKED"
public abstract class Pizza {

    private String pzType, pzSize, pzStatus, pzName;
    private double price;
    
    public Pizza(Pizza target, double price, String pzName) {
        this.pzName = pzName;
        this.pzType = target.pzType;
        this.pzSize = target.pzSize;
        this.pzStatus = "UNBAKE";
        this.price = price;
    }

    public String getPzName() {
        return pzName;
    }

    /**
     * @return the pzType
     */
    public String getPzType() {
        return pzType;
    }

    public double getPzPrice() {
        return price;
    }

    public void setPzPrice(double price) {
        this.price = price;
    }

    /**
     * @param pzType the pzType to set
     */
    public void setPzType(String pzType) {
        this.pzType = pzType;
    }

    /**
     * @return the pzSize
     */
    public String getPzSize() {
        return pzSize;
    }

    /**
     * @param pzSize the pzSize to set
     */
    public void setPzSize(String pzSize) {
        this.pzSize = pzSize;
    }
    
    public abstract Pizza clone();

    /**
     * @return the pzStatus
     */
    public String getPzStatus() {
        return pzStatus;
    }

    /**
     * @param pzStatus the pzStatus to set
     */
    public void setPzStatus(String pzStatus) {
        this.pzStatus = pzStatus;
    }

}
