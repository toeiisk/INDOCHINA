/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_28
 */
public class ChickenDeluxe extends Pizza {
    private boolean isRoastedChicken, isBbqChickenAmount;

    public ChickenDeluxe(boolean isRoastedChicken, boolean isBbqChickenAmount) {
        this.isRoastedChicken = isRoastedChicken;
        this.isBbqChickenAmount = isBbqChickenAmount;
    }

    public ChickenDeluxe() {
        this(false, false);
    }

    public boolean isIsRoastedChicken() {
        return isRoastedChicken;
    }

    public void setIsRoastedChicken(boolean isRoastedChicken) {
        this.isRoastedChicken = isRoastedChicken;
    }

    public boolean isIsBbqChickenAmount() {
        return isBbqChickenAmount;
    }

    public void setIsBbqChickenAmount(boolean isBbqChickenAmount) {
        this.isBbqChickenAmount = isBbqChickenAmount;
    }
    
  
    
    public ChickenDeluxe(ChickenDeluxe target) {
        super(target);
        this.isBbqChickenAmount = target.isBbqChickenAmount;
        this.isBbqChickenAmount = target.isBbqChickenAmount;
    }
    
    @Override
    public Pizza clone() {
        return new ChickenDeluxe(this);
    }
}
