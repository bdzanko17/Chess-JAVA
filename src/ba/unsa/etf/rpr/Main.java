package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board b = new Board();
        try{
            b.move("A2","C4");
            }catch (Exception e){
            System.out.println("izuzetak");
        }
}
        }

