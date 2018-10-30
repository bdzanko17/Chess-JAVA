package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) throws ChessPiece.IllegalChessMoveException {
        ChessPiece kralj=new Pawn("A2",ChessPiece.Color.WHITE);
        kralj.move("A4");
        System.out.println(kralj.getPozicija());
     }
}
