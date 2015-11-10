
package paquete;

import java.util.ArrayList;

public class nodoPrincipal {
    private ArrayList<ArrayListFila> filas;
    private ArrayList<ArrayListColumna> columnas;
    private String [][] matriz;
    private int nColumnas;
    private int nFilas;
    private int nColores;

    public nodoPrincipal(ArrayList<ArrayListFila> filas, ArrayList<ArrayListColumna> columnas, String[][] matriz, int nColumnas, int nFilas, int nColores) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = matriz;
        this.nColumnas = nColumnas;
        this.nFilas = nFilas;
        this.nColores = nColores;
    }

    public nodoPrincipal() {
    }

    public ArrayList<ArrayListFila> getFilas() {
        return filas;
    }

    public void setFilas(ArrayList<ArrayListFila> filas) {
        this.filas.clear();
        this.filas = (ArrayList<ArrayListFila>) filas.clone();
    }

    public ArrayList<ArrayListColumna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<ArrayListColumna> columnas) {
        this.columnas.clear();
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
    
    
}
