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

    void constructor1() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pawn(null, ChessPiece.Color.WHITE)

        );
    }
    @Test

    void constructor2() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pawn("", ChessPiece.Color.WHITE)

        );
    }
    @Test

    void constructor3() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pawn("BEBEBEBE", ChessPiece.Color.WHITE)

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
    @Test
    void setBoja() {
        Pawn b=new Pawn("A3", ChessPiece.Color.WHITE);
        b.setBoja(ChessPiece.Color.BLACK);
        assertEquals(ChessPiece.Color.BLACK,b.getBoja());
    }
    @Test
    void clonee() throws CloneNotSupportedException {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        Pawn x=(Pawn) p.clone();
        assertEquals(p,x);
    }
    @Test
    void equals2() throws CloneNotSupportedException {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        Pawn x=new Pawn("E5", ChessPiece.Color.WHITE);
        assertNotEquals(p,x);
    }




}