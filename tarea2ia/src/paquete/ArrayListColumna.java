package paquete;

import java.util.ArrayList;

public class ArrayListColumna {
    private ArrayList<Color> colores = new ArrayList();

    //constructores
    public ArrayListColumna() {
    }
    //---------------
    public void setColor(Color color){
        colores.add(color);
    }
    
    public void replaceColor(Color color){
        
        for(int i=0;i<this.colores.size();i++){
            if(colores.get(i).getColor().equals(color.getColor())){
                this.colores.get(i).setNumero(color.getNumero());
            }
        }
    }

    public Color getColor(int index){
        return colores.get(index);
    }
    
    public Color getColor(String color){
        Color auxColor = new Color();
        for(int i=0;i<colores.size();i++){
            if(colores.get(i).getColor().equals(color)){
                auxColor = colores.get(i);
            }
        }
        return auxColor;
    }
}
