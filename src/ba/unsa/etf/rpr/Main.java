package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) throws ChessPiece.IllegalChessMoveException {
        ChessPiece kralj=new Pawn("A7",ChessPiece.Color.WHITE);
        kralj.move("A6");
        System.out.println(kralj.getPozicija());
     }
}
