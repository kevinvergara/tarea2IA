
package paquete;


public class FuncionObjetivo {
    public boolean solucion (String [][] matriz){
        
        //verifica qe la matriz tenga espacios vacios
        Operadores operadores = new Operadores();
        if(operadores.matrizLlena(matriz)==false) return false;
        //----
        return true;
    }
}
