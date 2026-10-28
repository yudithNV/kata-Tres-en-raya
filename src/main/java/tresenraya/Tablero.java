package tresenraya;

public class Tablero {

    private final char[][] casillas = new char[3][3];
    private char ultimaPieza = '\0';

    public void colocarPieza(int fila, int columna, char pieza) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            throw new IllegalArgumentException("Posición fuera del tablero");
        }
        if (casillas[fila][columna] != '\0') {
            throw new IllegalArgumentException("Posición ocupada");
        }
        casillas[fila][columna] = pieza;
        ultimaPieza = pieza;
    }

    public char siguienteTurno() {
        if (ultimaPieza == 'X') {
            return '+';
        }
        return 'X';
    }

    public Character ganador() {
        return null;
    }
}