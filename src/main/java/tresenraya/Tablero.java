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

    /***
     * Devuelve el ganador de la partida, si hay uno.
     * @return el ganador, o null si no hay ninguno.
     */
    public Character ganador() {
        for (int fila = 0; fila < 3; fila++) {
            if (lineaCompleta(casillas[fila][0], casillas[fila][1], casillas[fila][2])) {
                return casillas[fila][0];
            }
        }
        for (int columna = 0; columna < 3; columna++) {
            if (lineaCompleta(casillas[0][columna], casillas[1][columna], casillas[2][columna])) {
                return casillas[0][columna];
            }
        }
        if (lineaCompleta(casillas[0][0], casillas[1][1], casillas[2][2])) {
            return casillas[1][1];
        }
        if (lineaCompleta(casillas[0][2], casillas[1][1], casillas[2][0])) {
            return casillas[1][1];
        }
        return null;
    }

    private boolean lineaCompleta(char a, char b, char c) {
        return a != '\0' && a == b && a == c;
    }
}