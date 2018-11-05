package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board tabla = new Board();
            tabla.move(Pawn.class, ChessPiece.Color.WHITE, "E4");

        System.out.println(tabla.daliimafiguraizmedjupozicija(tabla.tabla,"A6","F1"));

//        try {
//            tabla.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
//            tabla.move(Bishop.class, ChessPiece.Color.WHITE, "A6");
//
//        }catch (Exception e){
//            System.out.println("greskaaaaaaa");
//        }
//for(int i=0;i<tabla.tabla.length;i++){
//    System.out.println(tabla.tabla[i].getPozicija());
//}
        }
}
