package ba.unsa.etf.rpr;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Board {
    public ChessPiece[] tabla;

    public static boolean daliImaNaOdredistuFigure(ChessPiece[] tabla, String odrediste) {
        boolean ima = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i].getPozicija().equals(odrediste)) {
                ima = true;
                break;
            }
        }
        return ima;
    }

    public static boolean daliJeFiguraDrugeBoje(ChessPiece[] tabla, ChessPiece figura, String odrediste) {
        boolean drugeBoje = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i].getPozicija() == odrediste) {
                if (tabla[i].getBoja() != figura.getBoja()) {
                    drugeBoje = true;
                }
            }
        }
        return drugeBoje;
    }

    public static List<String> daliimafiguraizmedjupozicija(ChessPiece[] tabla, String novaPozicija, String staraPozicija) {
        char slovoNovePozicije = novaPozicija.charAt(0);
        char slovoStarePozicije = staraPozicija.charAt(0);
        char brojNoveP = novaPozicija.charAt(1);
        char brojStareP = staraPozicija.charAt(1);
        char a;
        char b;
        if (slovoNovePozicije > slovoStarePozicije) {
            a = slovoStarePozicije;
            b = slovoNovePozicije;
        } else {
            a = slovoNovePozicije;
            b = slovoStarePozicije;
        }
        slovoStarePozicije = a;
        slovoNovePozicije = b;

        if (brojNoveP > brojStareP) {
            a = brojStareP;
            b = brojNoveP;
        } else {
            a = brojNoveP;
            b = brojStareP;
        }
        brojStareP = a;
        brojNoveP = b;

        List<String> tacke = new ArrayList<>();
        boolean ima = false;

        if (abs(slovoNovePozicije - slovoStarePozicije) == 0) {//za isto slovo tacke
            for (int i = brojStareP + 1; i < brojNoveP; i++) { //mora se naci veci
                char slovo = (char) i;
                String x = slovoNovePozicije + Character.toString(slovo);
                tacke.add(x);
            }
        } else if (abs(brojNoveP - brojStareP) == 0) {
            for (int i = slovoStarePozicije + 1; i < slovoNovePozicije; i++) {
                String x = Character.toString((char) i) + Character.toString(brojNoveP);
                tacke.add(x);
            }
        } else if (abs(brojNoveP - brojStareP) == abs(slovoNovePozicije - slovoStarePozicije)) {
            System.out.println("XD");
            for (int i = brojStareP + 1; i < brojNoveP; i++) {
                String x = Character.toString(++slovoStarePozicije) + (char) i;
                tacke.add(x);
            }
        }
        return tacke;
//        for (int i = 0; i < tabla.length; i++) {
//            for (int j = 0; j < tacke.size(); j++) {
//                if (tabla[i].getPozicija().equals(tacke.get(j))) {
//                    ima = true;
//                    break;
//                }
//            }
//            if (ima)
//                break;
//        }
//        return ima;

    }


    Board() {
        int counter = 0;//za bijele
        int counter2 = 0;//za crne
        tabla = new ChessPiece[32];
        tabla[0] = new Rook("A1", ChessPiece.Color.WHITE);
        tabla[1] = new Knight("B1", ChessPiece.Color.WHITE);
        tabla[2] = new Bishop("C1", ChessPiece.Color.WHITE);
        tabla[3] = new Queen("D1", ChessPiece.Color.WHITE);
        tabla[4] = new King("E1", ChessPiece.Color.WHITE);
        tabla[5] = new Bishop("F1", ChessPiece.Color.WHITE);
        tabla[6] = new Knight("G1", ChessPiece.Color.WHITE);
        tabla[7] = new Rook("H1", ChessPiece.Color.WHITE);
        for (int i = 8; i <= 23; i++) {
            if (i < 16) {
                char x = (char) ('A' + counter++);
                String s = x + Integer.toString(2);
                tabla[i] = new Pawn(s, ChessPiece.Color.WHITE);

            } else {

                char x = (char) ('A' + counter2++);
                String s = x + Integer.toString(7);
                tabla[i] = new Pawn(s, ChessPiece.Color.BLACK);

            }
        }
        tabla[24] = new Rook("A8", ChessPiece.Color.BLACK);
        tabla[25] = new Knight("B8", ChessPiece.Color.BLACK);
        tabla[26] = new Bishop("C8", ChessPiece.Color.BLACK);
        tabla[27] = new Queen("D8", ChessPiece.Color.BLACK);
        tabla[28] = new King("E8", ChessPiece.Color.BLACK);
        tabla[29] = new Bishop("F8", ChessPiece.Color.BLACK);
        tabla[30] = new Knight("G8", ChessPiece.Color.BLACK);
        tabla[31] = new Rook("H8", ChessPiece.Color.BLACK);


    }

    void move(Class type, ChessPiece.Color color, String position)
            throws IllegalArgumentException, IllegalChessMoveException, CloneNotSupportedException {
        String staraPozicija;
        boolean proslo = false;
        List<ChessPiece> figure;

        for (int i = 0; i < this.tabla.length; i++) {
            ChessPiece pomocna = (ChessPiece) tabla[i].clone();
            staraPozicija = tabla[i].getPozicija();
            if (tabla[i].getClass() == type && tabla[i].getBoja() == color) {

                try {
                    pomocna.move(position);
                    System.out.println(tabla[i].getPozicija());
                    /*moze se pomjeriti ali da vidimo da li smeta šta*/

                } catch (Exception e) {
                    continue;

                }
                proslo = true;


                if (daliImaNaOdredistuFigure(tabla, position)) {

                    System.out.println("Ima figura");
                    if (daliJeFiguraDrugeBoje(tabla, tabla[i], position)) {
                        System.out.println("druge je boje pojestiii");
                        System.out.println("pojedena figura");
                        tabla[i].move(position);
                        for (int j = 0; j < tabla.length; j++) {
                            if (tabla[j].getPozicija() == position) {
                                tabla[j] = null;
                            }
                        }
                    } else {
                        System.out.println(" NIJE druge je boje!");
                        break;
                    }
                } else {
                    System.out.println("uspjesno pomjerena bez jedenja!!");
                }
                System.out.println(type);
//                if (daliimafiguraizmedjupozicija(tabla, position, staraPozicija)) {
//                    System.out.println("ne moguce odigrati potez IMA FIGURA ISPRED");
//                    throw new IllegalChessMoveException("greska");
//                } else {
//                    System.out.println("XD");
//                    tabla[i].move(position);
//                }

            }
            if (proslo) break;

        }

    }

}
