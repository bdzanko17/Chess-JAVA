package ba.unsa.etf.rpr;

public class maintest {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board b=new Board();
        try{
            b.move(Pawn.class, ChessPiece.Color.WHITE,"H4");
        }catch (Exception e){
            System.out.println("greska");
        }
    }}
