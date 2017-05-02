/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Павел
 */
public class Point extends Object{

    public static Point create(int X, int Y, int Z) {
        return new Point(X, Y, Z);
    }
    
    private int X;
    private int Y;
    private int Z;

    private Point(int X, int Y, int Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    private static final ArrayList<Point> directions = new ArrayList<>(
            Arrays.asList(
                    Point.create(0, 1, -1),
                    Point.create(0, -1, 1),
                    Point.create(1, 0, -1),
                    Point.create(-1, 0, 1),
                    Point.create(1, -1, 0),
                    Point.create(-1, 1, 0)
            )
    );
    
    
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int Z) {
        this.Z = Z;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        if(this == o)
            return true;
        Point p = (Point) o;
        if(this.getX() != p.getX())
            return false;
        if(this.getY() != p.getY())
            return false;
        return this.getZ() == p.getZ();
    }

    @Override
    public String toString(){
        return "Point{"+X+","+Y+","+Z+"}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.X;
        hash = 41 * hash + this.Y;
        hash = 41 * hash + this.Z;
        return hash;
    }
    
    
    private Point sum(Point p1, Point p2){
        Point res = Point.create(0, 0, 0);
        res.X = p1.X + p2.X;
        res.Y = p1.Y + p2.Y;
        res.Z = p1.Z + p2.Z;
        
        return res;
    }
    
    public HashSet<Point> getEnvirons(){
        HashSet<Point> environs = new HashSet<>();
        for(Point d : directions){
            environs.add(sum(this,d));
        }
        
        return environs;
    }
}
