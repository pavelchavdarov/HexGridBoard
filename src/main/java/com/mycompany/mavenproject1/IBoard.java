/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.HashMap;

/**
 *
 * @author Павел
 */
public interface IBoard {

    HashMap<Point, Stone> getBoard();

    int moveStone(Point oldPoint, Point newPoint);

    int putStone(Stone pStone, Point pPoint);
    
}
