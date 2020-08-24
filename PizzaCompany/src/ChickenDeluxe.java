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
    private String roastedChickenAmount, bbqChickenAmount;
    public ChickenDeluxe(ChickenDeluxe target) {
        super(target);
        this.roastedChickenAmount = target.roastedChickenAmount;
        this.bbqChickenAmount = target.bbqChickenAmount;
    }
    
    @Override
    public Pizza clone() {
        return new ChickenDeluxe(this);
    }
}
