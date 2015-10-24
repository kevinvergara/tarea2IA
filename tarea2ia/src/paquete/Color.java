
package paquete;

public class Color {
    private String color;
    private int numero;
    private boolean seguido;

    public Color(String color, int numero, boolean seguido) {
        this.color = color;
        this.numero = numero;
        this.seguido = seguido;
    }

    public Color() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isSeguido() {
        return seguido;
    }

    public void setSeguido(boolean seguido) {
        this.seguido = seguido;
    }   
}
