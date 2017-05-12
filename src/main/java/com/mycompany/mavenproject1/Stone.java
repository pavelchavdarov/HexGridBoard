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

    public static Stone create(Entity SideA, Entity SideB) {
        return new Stone(SideA, SideB);
    }
    private Entity face;
    private Entity back;
    private boolean movable;

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
    

    private Stone(Entity SideA, Entity SideB) {
        face = SideA;
        back = SideB;
        movable = true;
    }

    
    
    public Entity getFace() {
        return face;
    }
    
    public void flip(Stone pStone){
        boolean toFlip = false;
        if((pStone.getFace() == Entity.Stone && this.getFace() == Entity.Scissors)
            ||
            (pStone.getFace() == Entity.Scissors && this.getFace() == Entity.Paper)
            ||
            (pStone.getFace() == Entity.Paper && this.getFace() == Entity.Stone)    
        )
            toFlip = true;
        
        if(toFlip == true){
            Entity dummy = pStone.face;
            pStone.face = pStone.back;
            pStone.back = dummy;
        }
    }
    
}
