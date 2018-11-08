package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @Test
//pijun unazad
    void move2() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("E1")
        );


    }

    @Test
        //pijun naprijed
    void move3() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("E8")
        );
    }
    @Test
        //pijun ukoso
    void move4() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("G4")
        );
    }
    @Test
        //pijun ukoso dva polja !! ne moze
    void move5() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("G4")
        );
    }



}