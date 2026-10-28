package tresenraya;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
                () -> tablero.colocarPieza(1, 1, 'O'));
    }
}