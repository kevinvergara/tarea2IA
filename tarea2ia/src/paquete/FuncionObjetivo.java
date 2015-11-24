
package paquete;


public class FuncionObjetivo {
    public boolean solucion (Nodo nodo){
        
        //verifica qe la matriz tenga espacios vacios
        Operadores operadores = new Operadores();
        if(operadores.matrizLlena(nodo.getMatriz())==false) return false;
        //----
        return true;
    }
}
