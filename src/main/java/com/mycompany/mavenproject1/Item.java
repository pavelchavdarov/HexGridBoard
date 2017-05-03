/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Павел
 */
public class Item extends Object{

    private static int itemsCount = 3;
    private int val;
    
    public static Item create(int val) {
        return new Item(val);
    }

    public static int getItemsCount() {
        return itemsCount;
    }

    public static void setItemsCount(int aItemsCount) {
        itemsCount = aItemsCount;
    }
    
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    private Item(int val) {
        this.val = val;
    }
    
    @Override
    public String toString(){
        return "Item{" + val + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.val;
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        if(this == o)
            return true;
        Item i = (Item) o;
        return this.val == i.val;
    }
    
    public boolean dominate(Item i){
        if (this.val == 0){
            if (i.val == 1)
                return true;
        }
        
        if (this.val == 1){
            if (i.val == 2)
                return true;
        }
        
        if (this.val == 2){
            if (i.val == 0)
                return true;
        }
        
        return false;
    }
        
    
}
