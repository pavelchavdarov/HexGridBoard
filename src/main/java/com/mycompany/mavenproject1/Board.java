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
 * @author РџР°РІРµР»
 */
public class Board implements IBoard {
   private HashMap<Point, Stone> Stones;
   //private static HashSet<Point> checkedPoints;

   
   public void StonesToPlayers(){
       
   }
       
           
   private ArrayList<ArrayList<Stone>> players;
   
   private HashSet<Point> getStoneEnvirons(Point pPoint){
       HashSet<Point> env = pPoint.getEnvirons();
       
       HashSet<Point> stones = (HashSet<Point>) Stones.keySet();
       env.retainAll(stones);
       
       return env;
   }
   
//   private boolean checkAstar(HashSet<Point> pp, Point p2){
//       if(pp.contains(p2)) return true;
//       //checkedPoints.addAll(pp);
//       
//       for(Point p : pp){
//           HashSet<Point> env = getStoneEnvirons(p);
//           checkedPoints.addAll(env);
//           if(checkAstar(env, p2)) return true;    
//           
//       }
//       return false;
//   }
// переделать!   
   private boolean checkIslandRule(Point p){
//        ArrayList<Point> envStones = new ArrayList<>(getStoneEnvirons(p));
//        for(int i = 0; i <envStones.size(); i++ )
//            for(int j = i+1; i <envStones.size(); j++ ){
//                checkedPoints.clear();
//                checkedPoints.add(envStones.get(i));
//                return checkAstar(checkedPoints,envStones.get(j));
//            }
        return true;
   }

//   private boolean checkTowEnvirons(Point p){
//       HashSet<Point> stoneEnv = getStoneEnvirons(p);
//       return stoneEnv.size()>2;
//   }
    
   private boolean checkWin(){
       return false;
   }
           
    @Override
    public Message putStone(Stone pStone, Point pPoint){
        HashSet<Point> stoneEnv = getStoneEnvirons(pPoint);
        if(stoneEnv.size() > 2){
            Stones.put(pPoint, pStone);
            if (checkWin())
                return Message.Win;
            for(Point p : stoneEnv)
                Stones.get(p).flip(pStone);
            if (checkWin()) return Message.Win;
            return Message.Success;
        }
        else
            return Message.Error_Environs;
    
   }
    
    @Override
    public Message moveStone(Point oldPoint, Point newPoint){
        if (!Stones.get(oldPoint).isMovable())
            return Message.Error_Immovable;
        if (checkIslandRule(oldPoint)){
            HashSet<Point> stoneEnv = getStoneEnvirons(newPoint);
            if(stoneEnv.size() > 2){
                Stone s = Stones.remove(oldPoint);
                Stones.put(newPoint, s);
                Stones.get(newPoint).setMovable(false);
                if (checkWin())
                    return Message.Win;
                for(Point p : stoneEnv)
                    Stones.get(p).flip(s);
                if (checkWin()) return Message.Win;
                return Message.Success;
            }   
            else
                return Message.Error_Environs;
        }
        else
            return Message.Error_Island;
    }
    
    @Override
    public HashMap<Point, Stone> getBoard(){
        return new HashMap<>(Stones);
    }
   
}
