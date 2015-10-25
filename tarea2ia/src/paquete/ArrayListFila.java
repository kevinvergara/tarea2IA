package paquete;

import java.util.ArrayList;

public class ArrayListFila {
    private ArrayList colores = new ArrayList();
    private int numVacios;
    
    //constructores
    
    public ArrayListFila(){
    }

    public ArrayListFila(int numVacios) {
        this.numVacios = numVacios;
    }

    //-------------
    public void setColor(Color color) {
        colores.add(color);
    }
    
    public Color getColor(String color){
        for(int i=0;i<colores.size();i++){
            if(((Color)colores.get(i)).getColor().equals(color)){
                return ((Color)colores.remove(i));
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
