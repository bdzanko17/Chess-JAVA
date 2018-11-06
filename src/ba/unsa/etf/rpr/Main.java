package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board b = new Board();

       b.move("A4","A3");

//        try {
//            tabla.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
//            tabla.move(Bishop.class, ChessPiece.Color.WHITE, "A6");
//
//        }catch (Exception e){
//            System.out.println("greskaaaaaaa");
//        }
for(int i=0;i<b.tabla.length;i++){
    if(b.tabla[i]!=null)
    System.out.println(b.tabla[i].getPozicija());
}
        }
}
