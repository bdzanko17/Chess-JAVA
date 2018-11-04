package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) throws ChessPiece.IllegalChessMoveException {
       Board tabla=new Board();

       for(int i=0;i<tabla.tabla.length;i++){
           System.out.println(tabla.tabla[i].getPozicija());
       }
                    }
}
