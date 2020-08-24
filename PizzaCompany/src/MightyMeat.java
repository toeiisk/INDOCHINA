/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_28
 */
public class MightyMeat extends Pizza {
    private boolean isHam, isSausage;
    
    public MightyMeat(){
        this.isHam = false;
        this.isSausage = false;
        super.setPzType("MightyMeat");
    }

    public boolean isIsHam() {
        return isHam;
    }

    public void setIsHam(boolean isHam) {
        this.isHam = isHam;
    }

    public boolean isIsSausage() {
        return isSausage;
    }

    public void setIsSausage(boolean isSausage) {
        this.isSausage = isSausage;
    }
    
    public MightyMeat(MightyMeat target) {
        super(target);
        this.isHam = target.isHam;
        this.isSausage = target.isSausage;
    }
    
    @Override
    public Pizza clone() {
        return new MightyMeat(this);
    }
}
