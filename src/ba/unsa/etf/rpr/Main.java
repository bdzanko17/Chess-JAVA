package ba.unsa.etf.rpr;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalChessMoveException {
        Board tabla = new Board();
        List<String> benjo=tabla.daliimafiguraizmedjupozicija(tabla.tabla,"H8","A1");
        benjo.forEach(System.out::println);
    }
}
