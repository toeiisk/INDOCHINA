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
