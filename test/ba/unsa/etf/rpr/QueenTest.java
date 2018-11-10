package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @Test
    void setBoja() {
        Queen b=new Queen("A3", ChessPiece.Color.WHITE);
        b.setBoja(ChessPiece.Color.BLACK);
        assertEquals(ChessPiece.Color.BLACK,b.getBoja());
    }
}