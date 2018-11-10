package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void constt() {
        Bishop b=new Bishop("A3", ChessPiece.Color.WHITE);

        assertThrows(IllegalArgumentException.class,
                ()->{
                   b.move("ASDSADAS");
                   b.move(null);
                }
                );
    }



    @Test
    void setBoja() {
        Bishop b=new Bishop("A3", ChessPiece.Color.WHITE);
        b.setBoja(ChessPiece.Color.BLACK);
        assertEquals(ChessPiece.Color.BLACK,b.getBoja());
    }


}