package ba.unsa.etf.rpr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static boolean provjera(String tekst) {
        if(tekst==null || tekst.length()>3||tekst.length()<2){
            throw new IllegalArgumentException("greska");
        }
        if(tekst.length()==2){
            char slovo1=tekst.charAt(0);
            char slovo2=tekst.charAt(1);
            if(slovo1>='A'&&slovo1<='H' &&slovo2>='1'&&slovo2<='8'){
                return true;
            }

        }else {
            char slovo1=tekst.charAt(0);
            char slovo2=tekst.charAt(1);
            char slovo3=tekst.charAt(2);
            if((slovo2>='A'&&slovo2<='H') &&(slovo3>='1'&&slovo3<='8')&&(slovo1=='K'||slovo1=='Q'
            ||slovo1=='R'||slovo1=='B'||slovo1=='N')){
                return true;
            }
        }

    }

    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
     Board ploca= new Board();
     boolean bijeli=true;
     Map<String,Class> mapa=new HashMap<>();
       mapa.put("K", King.class);
        mapa.put("Q", Queen.class);
        mapa.put("R", Rook.class);
        mapa.put("B", Bishop.class);
        mapa.put("N", Knight.class);
    String tekst;
    Scanner unos=new Scanner(System.in);
    tekst=unos.nextLine();
    tekst=tekst.toUpperCase();

    while (!tekst.equals("X")){
        if(bijeli){
            System.out.print("White move:");

        }

    }

}}

