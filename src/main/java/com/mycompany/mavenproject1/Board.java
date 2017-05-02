/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Павел
 */
public class Board {
   private HashMap<Point, Stone> Stones;
   
   private boolean CheckEnvironsRule(Point pPoint){
       HashSet<Point> env = pPoint.getEnvirons();
       
       HashSet<Point> stones = (HashSet<Point>) Stones.keySet();
       env.retainAll(stones);
       
       return env.size() >= 2;
   }

   
   public int putStone(Stone pStone, Point pPoint){
       if (!CheckEnvironsRule(pPoint))
           return 1;
       
       return 0;
   }
   
}
