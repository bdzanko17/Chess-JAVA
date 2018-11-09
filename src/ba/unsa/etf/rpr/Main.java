package ba.unsa.etf.rpr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static boolean provjera(String tekst) {
        if(tekst==null || tekst.length()>3||tekst.length()<2){
            return false;
        }
        if(tekst.length()==2){
            char slovo1=tekst.charAt(0);
            char slovo2=tekst.charAt(1);
            if(slovo1>='A'&&slovo1<='H' &&slovo2>='1'&&slovo2<='8'){
                return true;
            }else return false;

        }else {
            char slovo1=tekst.charAt(0);
            char slovo2=tekst.charAt(1);
            char slovo3=tekst.charAt(2);
            if((slovo2>='A'&&slovo2<='H') &&(slovo3>='1'&&slovo3<='8')&&(slovo1=='K'||slovo1=='Q'
            ||slovo1=='R'||slovo1=='B'||slovo1=='N')){
                return true;
            }else return false;
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




    while (true){
        if(bijeli){
            System.out.print("White move:");
            tekst=unos.nextLine();
            tekst=tekst.toUpperCase();
            if(!provjera(tekst)){
                continue;
            }
            if(tekst.length()==2){
                try {
                    ploca.move(Pawn.class, ChessPiece.Color.WHITE, tekst);
                    System.out.println("uspjeno pomjereno");
                }
                catch (Exception e){
                    System.out.println("illegal move");
                    bijeli=true;
                    continue;
                }
                }else{
                String pozicija=Character.toString(tekst.charAt(1))+Character.toString(tekst.charAt(2));
                Class klasa=mapa.get(tekst.charAt(0));
                try {
                    ploca.move(klasa, ChessPiece.Color.WHITE, pozicija);
                }
                catch (Exception e){
                    System.out.println("illegal move");
                    bijeli=true;
                    continue;
                }

            }

        }

    }

}}

