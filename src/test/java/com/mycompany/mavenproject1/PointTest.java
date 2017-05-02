/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Павел
 */
public class PointTest {
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class Point.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        int X = 0;
        int Y = 0;
        int Z = 0;
        Point result = Point.create(X, Y, Z);
        assertNotNull(result);

    }

    /**
     * Test of getX method, of class Point.
     */
    @org.junit.Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = Point.create(0, -1, 1);
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);

    }

    /**
     * Test of setX method, of class Point.
     */
    @org.junit.Test
    public void testSetX() {
        System.out.println("setX");
        int X = 1;
        Point instance = Point.create(0, -1, 1);
        instance.setX(X);
        assertEquals(instance.getX(), X);
    }

    /**
     * Test of getY method, of class Point.
     */
    @org.junit.Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = Point.create(0, -1, 1);
        int expResult = -1;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class Point.
     */
    @org.junit.Test
    public void testSetY() {
        System.out.println("setY");
        int Y = 0;
        Point instance = Point.create(0, -1, 1);
        instance.setY(Y);
        assertEquals(instance.getY(), Y);
    }

    /**
     * Test of getZ method, of class Point.
     */
    @org.junit.Test
    public void testGetZ() {
        System.out.println("getZ");
        Point instance =  Point.create(0, -1, 1);
        int expResult = 1;
        int result = instance.getZ();
        assertEquals(expResult, result);
    }

    /**
     * Test of setZ method, of class Point.
     */
    @org.junit.Test
    public void testSetZ() {
        System.out.println("setZ");
        int Z = 1;
        Point instance = Point.create(1, -1, 0);
        instance.setZ(Z);
        assertEquals(instance.getZ(), Z);
    }

    /**
     * Test of equals method, of class Point.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Point o = Point.create(1, -1, 0);
        Point instance = Point.create(1, -1, 0);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Point.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Point instance = Point.create(1, -1, 0);
        String expResult = "Point{1,-1,0}";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEnvirons method, of class Point.
     */
    @org.junit.Test
    public void testGetEnvirons() {
        System.out.println("getEnvirons");
        Point instance = Point.create(1, -1, 0);
        HashSet<Point> list = instance.getEnvirons();
        for(Point p: list){
            System.out.println(p.toString());
        }

    }
    
}
