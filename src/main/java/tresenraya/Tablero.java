package tresenraya;

public class Tablero {

    public void colocarPieza(int fila, int columna, char pieza) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            throw new IllegalArgumentException("Posición fuera del tablero");
        }
    }
}