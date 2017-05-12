/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Павел
 */
public class Pouch implements IPouch {
    private ArrayList<Stone> pouchOfStones;
    
    
    @Override
    public void init(){
        for (int i=0; i<6; i++){
            pouchOfStones.add(Stone.create(Entity.Stone, Entity.Scissors));
            pouchOfStones.add(Stone.create(Entity.Scissors, Entity.Paper));
            pouchOfStones.add(Stone.create(Entity.Paper, Entity.Stone));
        }
        shuffle();
        shuffle();
        shuffle();
    }
    
    @Override
    public void shuffle(){
        Random rnd = new Random();
        Collections.shuffle(pouchOfStones,rnd);
    }
    
    @Override
    public Stone handOutStone(){
        Stone res = null;    
        if (pouchOfStones.size() > 0)
            res = pouchOfStones.remove(0);
        return res;
    }
    
}
