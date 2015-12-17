package paquete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class BackTracking {
    
    private Stack pila = new Stack();
    
    public String [][] back(Nodo nodo) throws IOException{
        String [][] matriz =  nodo.getMatriz().clone();
        FuncionObjetivo fo = new FuncionObjetivo();
        Operadores op = new Operadores();
        ManejoArchivo ma = new ManejoArchivo();
        String colores = ma.colores();
        System.out.println("f: "+nodo.getnFilas()+" c: "+nodo.getnColumnas());
        if(matriz!=null){
            pila.push((String[][])matriz);
            
            while(!pila.empty()){//mientras la pila no este vacia
                matriz = op.clonarMatriz((String [][])pila.pop());
                
                System.out.println("--back--");
                op.imprimirMatriz(matriz);
                System.out.println("--back--");
                
                if(fo.solucion(matriz)) return matriz;
                
                int [] vectorAux = null;
                vectorAux = op.actualizarPosicion(matriz,nodo.getnColumnas(),nodo.getnFilas());
                
                
                
                for(int i=0;i<nodo.getnColores();i++){
                    System.out.println(colores.charAt(i)+"");
                    
                     //variables de filas y columnas
                    ArrayList<ArrayListColumna> columnas = new ArrayList<ArrayListColumna>();
                    columnas = (ArrayList<ArrayListColumna>)nodo.getColumnas();

                    ArrayList<ArrayListFila> filas = new ArrayList<ArrayListFila>();
                    filas = (ArrayList<ArrayListFila>)nodo.getFilas();
                    
                    
                    ArrayListFila auxListFila = new ArrayListFila();
                    auxListFila = (ArrayListFila)filas.get(vectorAux[0]);

                    for(int n=0;n<colores.length();n++){
                        Color auxColor = new Color();
                        auxColor = auxListFila.getColor(n);
                        if(auxColor.getColor().equals(colores.charAt(i)+"")){
                            ArrayListColumna auxListColumna = new ArrayListColumna();
                            auxListColumna = (ArrayListColumna)columnas.get(vectorAux[1]);

                            for(int j=0;j<colores.length();j++){
                                Color auxColor1 = new Color();
                                auxColor1 = auxListColumna.getColor(j);

                                if(auxColor1.equals(auxColor.getColor())){
                                    pila.push(op.clonarMatriz(op.matrizModificada(matriz, vectorAux, colores.charAt(i)+"")));
                                }
                            }
                        }
                    }
                }
            }
        }
        return matriz;
    } 

    
}
