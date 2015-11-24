
package paquete;

import java.util.ArrayList;

public class Nodo {
    private ArrayList<ArrayListFila> filas = new ArrayList<ArrayListFila>();
    private ArrayList<ArrayListColumna> columnas = new ArrayList<ArrayListColumna>();
    private ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    private String [][] matriz;
    private int nColumnas;
    private int nFilas;
    private int nColores;
    private int nivel;

    public Nodo(ArrayList<Nodo> hijos,ArrayList<ArrayListColumna> columnas,ArrayList<ArrayListFila> filas,String[][] matriz, int nColumnas, int nFilas, int nColores, int nivel) {
        this.matriz = matriz;
        this.nColumnas = nColumnas;
        this.nFilas = nFilas;
        this.nColores = nColores;
        this.nivel = nivel;
        this.filas = filas;
        this.columnas = columnas;
        this.hijos = hijos;
    }
    
    
    public Nodo() {
    }

    public ArrayList<ArrayListFila> getFilas() {
        return filas;
    }

    public void setFilas(ArrayList<ArrayListFila> filas) {
        this.filas = (ArrayList<ArrayListFila>) filas.clone();
    }

    public ArrayList<ArrayListColumna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<ArrayListColumna> columnas) {
        
        this.columnas = (ArrayList<ArrayListColumna>) columnas.clone();
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz.clone();
    }

    public int getnColumnas() {
        return nColumnas;
    }

    public void setnColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }

    public int getnFilas() {
        return nFilas;
    }

    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
    }

    public int getnColores() {
        return nColores;
    }

    public void setnColores(int nColores) {
        this.nColores = nColores;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void addHijo(Nodo nodo){
        this.hijos.add(nodo);
    }
    
    public Nodo getHijo(int index){
        return this.hijos.get(index);
    }
    
    public int cantidadHijos(){
        return this.hijos.size();
    }
    
    public ArrayList<Nodo> getHijos(){
        return this.hijos;
    }
}
