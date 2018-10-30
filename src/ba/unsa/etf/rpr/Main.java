package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) throws ChessPiece.IllegalChessMoveException {
        ChessPiece kralj=new Bishop("A1",ChessPiece.Color.WHITE);
        kralj.move("B2");
        System.out.println(kralj.getPozicija());
     }
}
