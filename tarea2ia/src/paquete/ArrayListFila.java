package paquete;

import java.util.ArrayList;

public class ArrayListFila {
    private ArrayList<Color> colores = new ArrayList();
      
    //constructores
    
    public ArrayListFila(){
    }

    //-------------
    public void setColor(Color color) {
        colores.add(color);
    }
    
    public void setColo(Color color, int index){
        colores.add(index, color);
    }
    
    public Color getColorBorrar(int index){
        return colores.get(index);
    }

    public Color getColor(int index){
        return colores.get(index);
    }
}
