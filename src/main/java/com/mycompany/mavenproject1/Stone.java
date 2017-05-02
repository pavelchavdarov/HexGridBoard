/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author Павел
 */
public class Stone {

    public static Stone create(Item SideA, Item SideB) {
        return new Stone(SideA, SideB);
    }
    private Item face;
    private Item back;
    private boolean movable;

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
    

    private Stone(Item SideA, Item SideB) {
        face = SideA;
        back = SideB;
        movable = true;
    }

    
    
    public Item getFace() {
        return face;
    }
    
    public void flip(Stone pStone){
        if(pStone.face.dominate(this.face)){
            Item dummy = pStone.face;
            pStone.face = pStone.back;
            pStone.back = dummy;
        }
    }
    
}
