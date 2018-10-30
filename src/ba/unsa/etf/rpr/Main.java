package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
        ChessPiece kralj=new King("A1",ChessPiece.Color.WHITE);
        kralj.move("C2");
        System.out.println(((King) kralj).getPosition());
     }
}
