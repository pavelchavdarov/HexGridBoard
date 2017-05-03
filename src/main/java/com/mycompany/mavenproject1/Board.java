/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
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
   private static HashSet<Point> checkedPoints;
   
   private HashSet<Point> getStoneEnvirons(Point pPoint){
       HashSet<Point> env = pPoint.getEnvirons();
       
       HashSet<Point> stones = (HashSet<Point>) Stones.keySet();
       env.retainAll(stones);
       
       return env;
   }
   
   private boolean checkAstar(HashSet<Point> pp, Point p2){
       if(pp.contains(p2)) return true;
       //checkedPoints.addAll(pp);
       
       for(Point p : pp){
           HashSet<Point> env = getStoneEnvirons(p);
           checkedPoints.addAll(env);
           if(checkAstar(env, p2)) return true;    
           
       }
       return false;
   }
   
   private boolean checkIslandRule(Point p){
        ArrayList<Point> envStones = new ArrayList<>(getStoneEnvirons(p));
        for(int i = 0; i <envStones.size(); i++ )
            for(int j = i+1; i <envStones.size(); j++ ){
                checkedPoints.clear();
                checkedPoints.add(envStones.get(i));
                return checkAstar(checkedPoints,envStones.get(j));
            }
        return true;
   }

   
    public int putStone(Stone pStone, Point pPoint){
    HashSet<Point> stoneEnv = getStoneEnvirons(pPoint);
        if (stoneEnv.size()<2)
        return 1;
    
    Stones.put(pPoint, pStone);
    for(Point p : stoneEnv)
        Stones.get(p).flip(pStone);
    
    return 0;
   }
    
    public int moveStone(Point oldPoint, Point newPoint){
        if (checkIslandRule(oldPoint)){
            
            return 0;
        }
        else
            return 10;
    }
   
}
