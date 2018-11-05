package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException {
        Board tabla = new Board();
        Pawn pijun=new Pawn("A3", ChessPiece.Color.WHITE);
        pijun.move("A2");
        System.out.println(pijun.getPozicija());
        try {
            tabla.move(Pawn.class, ChessPiece.Color.WHITE, "A3");

        }catch (Exception e){
            System.out.println("greska");
        }

        }
}
