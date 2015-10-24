/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.ArrayList;

public class ArrayListColumna {
    private ArrayList colores = new ArrayList();
    private int numVacios;

    //constructores
    public ArrayListColumna() {
    }

    public ArrayListColumna(int numVacios) {
        this.numVacios = numVacios;
    }
    //---------------
    public void setColor(Color color){
        colores.add(color);
    }
    
    public Color getColor(String color){
        for(int i=0;i<colores.size();i++){
            if(((Color)colores.get(i)).getColor().equals(color)){
                return ((Color)colores.get(i));
            }
        }
        return null;
    }
    
    public int getNumVacios() {
        return numVacios;
    }

    public void setNumVacios(int numVacios) {
        this.numVacios = numVacios;
    }
    
    
    
    
    
    
}
