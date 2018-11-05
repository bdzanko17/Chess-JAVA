package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException {
        Board tabla = new Board();
       try{
           tabla.move(Rook.class, ChessPiece.Color.WHITE,"A2");
       }catch (Exception e){
           System.out.println("greskaAAA");
       }
       for(int i=0;i<tabla.tabla.length;i++){
           System.out.println(tabla.tabla[i].getPozicija());
       }
    }
}
