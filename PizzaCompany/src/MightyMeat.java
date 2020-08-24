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
    private String hamAmount, suasageAmount;
    public MightyMeat(MightyMeat target) {
        super(target);
        this.hamAmount = target.hamAmount;
        this.suasageAmount = target.suasageAmount;
    }
    
    @Override
    public Pizza clone() {
        return new MightyMeat(this);
    }
}
