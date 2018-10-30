package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) throws ChessPiece.IllegalChessMoveException {
        ChessPiece kralj=new King("A1",ChessPiece.Color.WHITE);
        kralj.move("A22222");
        System.out.println(((King) kralj).getPozicija());
     }
}
