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
        for (int fila = 0; fila < 3; fila++) {
            char primera = casillas[fila][0];
            if (primera != '\0'
                    && primera == casillas[fila][1]
                    && primera == casillas[fila][2]) {
                return primera;
            }
        }
        for (int columna = 0; columna < 3; columna++) {
            char primera = casillas[0][columna];
            if (primera != '\0'
                    && primera == casillas[1][columna]
                    && primera == casillas[2][columna]) {
                return primera;
            }
        }
        char centro = casillas[1][1];
        if (centro != '\0'
                && centro == casillas[0][0]
                && centro == casillas[2][2]) {
            return centro;
        }
        if (centro != '\0'
                && centro == casillas[0][2]
                && centro == casillas[2][0]) {
            return centro;
        }
        return null;
    }
}