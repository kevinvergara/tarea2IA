package paquete;

import java.util.ArrayList;

public class ArrayListColumna {
    private ArrayList<Color> colores = new ArrayList();
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
    
    public Color getColorBorrar(int index){
        return colores.get(index);
    }

    public Color getColor(int index){
        return colores.get(index);
    }
    
    public Color getEspaciosVacios(){
        for(int i=0;i<colores.size();i++){
            if(colores.get(i).getColor().equals("z")){
                return (Color)colores.get(i);
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
