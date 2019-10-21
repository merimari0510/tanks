/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inici;

/**
 *
 * @author Meriem
 */
public class Posicio {
    private int x;
    private int y;
    
    public Posicio(int a, int b) {
        x=a;
        y=b;
    }
    
    public void mostrarPosicio() {
        System.out.print("(");
        System.out.print(x);
        System.out.print(",");
        System.out.print(y);
        System.out.println(")");
    }
    
     public boolean iguals(Posicio p){
        return x==p.x && y==p.y;
    }
    
    public int x() {
        return x;
    }
    
    public int y() {
        return y;
    }
    
    public void incrementarX() {
        x++;
    }
    
    public void incrementarY() {
        y++;
    }
    
    public void decrementarY() {
        y--;
    }
    
    public void decrementarX() {
        x--;
    }
}
