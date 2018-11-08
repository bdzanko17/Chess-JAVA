package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board b = new Board();
        try{
            b.move("A1","A8");
            }catch (Exception e){
            System.out.println("izuzetak");
        }
}
        }

