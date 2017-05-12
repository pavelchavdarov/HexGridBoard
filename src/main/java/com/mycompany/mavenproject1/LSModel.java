/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Павел
 */
public class LSModel {
    private int playersCount;
    
    private IBoard board;
    private IPouch pouch;
    
    private int turnCount;
    
    
    
    public void initGame(){
        turnCount = 0;
        board = new Board();
        pouch = new Pouch();
        pouch.init();

    }

    
}
