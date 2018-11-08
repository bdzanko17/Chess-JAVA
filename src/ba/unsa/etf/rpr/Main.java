package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board b = new Board();
        try{
b.move(Rook.class, ChessPiece.Color.WHITE,"E5");
        }catch (Exception e){
            System.out.println("izuzetak");
        }
}
        }

