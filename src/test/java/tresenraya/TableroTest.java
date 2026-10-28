package tresenraya;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TableroTest {

    @Test
    void colocarPieza_fueraDelEjeX_lanzaExcepcion() {
        // Arrange (preparar)
        Tablero tablero = new Tablero();

        // Act + Assert (actuar y verificar)
        assertThrows(IllegalArgumentException.class,
                () -> tablero.colocarPieza(3, 0, 'X'));
    }
    @Test
    void colocarPieza_fueraDelEjeY_lanzaExcepcion() {
        Tablero tablero = new Tablero();

        assertThrows(IllegalArgumentException.class,
                () -> tablero.colocarPieza(0, 3, 'X'));
    }
    @Test
    void colocarPieza_dentroDelTablero_noLanzaExcepcion() {
        Tablero tablero = new Tablero();

        assertDoesNotThrow(() -> tablero.colocarPieza(1, 1, 'X'));
    }
    @Test
    void colocarPieza_posicionOcupada_lanzaExcepcion() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(1, 1, 'X');

        assertThrows(IllegalArgumentException.class,
                () -> tablero.colocarPieza(1, 1, '+'));
    }

    @Test
    void siguienteTurno_alInicio_esX() {
        Tablero tablero = new Tablero();

        assertEquals('X', tablero.siguienteTurno());
    }

    @Test
    void siguienteTurno_despuesDeX_esMas() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');

        assertEquals('+', tablero.siguienteTurno());
    }

    @Test
    void siguienteTurno_despuesDeO_esX() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');
        tablero.colocarPieza(0, 1, '+');

        assertEquals('X', tablero.siguienteTurno());
    }
    
    @Test
    void hayGanador_sinLineaCompleta_esNull() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');
        tablero.colocarPieza(1, 1, '+');

        assertNull(tablero.ganador());
    }
    @Test
    void hayGanador_lineaHorizontalX_gana() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');
        tablero.colocarPieza(1, 0, '+');
        tablero.colocarPieza(0, 1, 'X');
        tablero.colocarPieza(1, 1, '+');
        tablero.colocarPieza(0, 2, 'X');

        assertEquals('X', tablero.ganador());
    }
    
    @Test
    void hayGanador_lineaVerticalX_gana() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');
        tablero.colocarPieza(0, 1, '+');
        tablero.colocarPieza(1, 0, 'X');
        tablero.colocarPieza(1, 1, '+');
        tablero.colocarPieza(2, 0, 'X');

        assertEquals('X', tablero.ganador());
    }
    @Test
    void hayGanador_diagonalX_gana() {
        Tablero tablero = new Tablero();
        tablero.colocarPieza(0, 0, 'X');
        tablero.colocarPieza(0, 1, '+');
        tablero.colocarPieza(1, 1, 'X');
        tablero.colocarPieza(0, 2, '+');
        tablero.colocarPieza(2, 2, 'X');

        assertEquals('X', tablero.ganador());
    }
}