package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );


    }

    @Test
    void move2() {
        Knight k = new Knight("H8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("G6")

        );

    }
    @Test
    void move3() {
        Knight k = new Knight("A1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C2")
        );

    }
}