package ba.unsa.etf.rpr;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.api.model.CheckedException;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import sun.rmi.runtime.NewThreadAction;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Board {
    public ChessPiece[] tabla;

    private static boolean daliImaNaOdredistuFigure(ChessPiece[] tabla, String odrediste) {
        boolean ima = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getPozicija().equals(odrediste)) {
                    ima = true;
                    break;
                }
            }
        }
        return ima;
    }

    private static boolean daliJeFiguraDrugeBoje(ChessPiece[] tabla, ChessPiece figura, String odrediste) {
        boolean drugeBoje = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getPozicija().equals(odrediste)) {
                    if (tabla[i].getBoja() != figura.getBoja()) {
                        drugeBoje = true;
                    }
                }
            }
        }
        return drugeBoje;
    }


    private static boolean daliimafiguraizmedjupozicija(ChessPiece[] tabla, String novaPozicija, String staraPozicija) {
        char slovoNovePozicije = novaPozicija.charAt(0);
        char slovoStarePozicije = staraPozicija.charAt(0);
        char brojNoveP = novaPozicija.charAt(1);
        char brojStareP = staraPozicija.charAt(1);

        char slovoNovePozicije1 = novaPozicija.charAt(0);
        char slovoStarePozicije1 = staraPozicija.charAt(0);
        char brojNoveP1 = novaPozicija.charAt(1);
        char brojStareP1 = staraPozicija.charAt(1);
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
            if (brojNoveP1 < brojStareP1 && slovoNovePozicije1 < slovoStarePozicije1) {
                for (int i = brojNoveP1 + 1; i < brojStareP1; i++) {
                    String x = Character.toString(++slovoNovePozicije1) + (char) i;
                    tacke.add(x);

                }
            } else if (slovoNovePozicije1 > slovoStarePozicije1 && brojNoveP1 > brojStareP1) {
                for (int i = brojNoveP1 - 1; i > brojStareP1; i--) {
                    String x = Character.toString(--slovoNovePozicije1) + (char) i;
                    tacke.add(x);
                }

            } else if (slovoNovePozicije1 < slovoStarePozicije1 && brojNoveP1 > brojStareP1) {
                for (int i = brojNoveP1 - 1; i > brojStareP1; i--) {
                    String x = Character.toString(++slovoNovePozicije1) + (char) i;
                    tacke.add(x);
                }

            } else if (slovoNovePozicije1 > slovoStarePozicije1 && brojNoveP1 < brojStareP1) {
                for (int i = brojNoveP1 + 1; i < brojStareP1; i++) {
                    String x = Character.toString(--slovoNovePozicije1) + (char) i;
                    tacke.add(x);
                }

            }
        }
        //return tacke;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                for (int j = 0; j < tacke.size(); j++) {
                    if (tabla[i].getPozicija().equals(tacke.get(j))) {
                        return true;
                    }
                }

            }
        }
        return ima;

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
        boolean xa=false;
        position = position.toUpperCase();

        for (int i = 0; i < this.tabla.length; i++) {
            if (tabla[i] != null) {
                ChessPiece pomocna = (ChessPiece) tabla[i].clone();
                staraPozicija = tabla[i].getPozicija();
                if (tabla[i].getClass() == type && tabla[i].getBoja() == color) {
                    try {
                        pomocna.move(position);
                        proslo = true;
                        /*moze se pomjeriti ali da vidimo da li smeta šta*/

                    } catch (Exception e) {
                        proslo=false;
                        continue;

                    }


                    if (daliImaNaOdredistuFigure(tabla, position)) {

                        if (daliJeFiguraDrugeBoje(tabla, tabla[i], position)) {
                            if (tabla[i].getClass() == Pawn.class) {
                                if (DaliPijunJedePravo(position, tabla[i].getPozicija())) {
                                    throw new IllegalChessMoveException("Ne moze jesti pravo");
                                }
                            }


                            for (int j = 0; j < tabla.length; j++) {
                                if (tabla[j] != null) {
                                    if (tabla[j].getPozicija().equals(position)) {
                                        tabla[j] = null;
                                        break;
                                    }
                                }
                            }
                        } else {
                            throw new IllegalChessMoveException("Iste boje");

                        }
                    } else {
                        if (type == Pawn.class) {
                            if (!DaliPijunJedePravo(position, tabla[i].getPozicija())) {
                                if (!daliImaNaOdredistuFigure(tabla, position)) {
                                    continue;
                                }
                            }
                        }
                    }
                    System.out.println("proslo");

                    if (daliimafiguraizmedjupozicija(tabla, position, staraPozicija) && type != Knight.class) {
                        throw new IllegalChessMoveException("ima figura");
                    } else {

                        if (tabla[i] != null) {
                            tabla[i].move(position);
                        }
                    }

                }
                if (proslo) break;

            }
        }
        if (!proslo) {
            throw new IllegalChessMoveException("Greska");
        }

    }

    void move(String oldPosition, String newPosition) throws IllegalArgumentException, IllegalChessMoveException, CloneNotSupportedException {
        if (oldPosition.length() > 2 || oldPosition.length() <= 1 || newPosition.length() > 2 || newPosition.length() <= 1)
            throw new IllegalArgumentException();

        oldPosition = oldPosition.toUpperCase();
        newPosition = newPosition.toUpperCase();
        boolean ima = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getPozicija().equals(oldPosition)) {
                    ima = true;
                }
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getPozicija().equals(oldPosition)) {
                    this.move(tabla[i].getClass(), tabla[i].getBoja(), newPosition);
                    break;
                }
            }

        }
        if (!ima) {
            throw new IllegalArgumentException("greskica");
        }
    }

    boolean isCheck(ChessPiece.Color boja) throws CloneNotSupportedException {
        boolean sah = false;
        String s = "benjo";
        ChessPiece prva = null;
        ChessPiece druga = null;
        int indeks = 0;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null && tabla[i].getClass() == King.class && tabla[i].getBoja() == boja) {
                s = tabla[i].getPozicija();
                indeks = i;
                prva = (ChessPiece) tabla[i].clone();
                break;
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            try {
                if (tabla[i] != null && tabla[i].getBoja() != boja) {
                    druga = (ChessPiece) tabla[i].clone();

                    move(tabla[i].getPozicija(), s);
                    sah = true;
                    tabla[i] = druga;
                    tabla[indeks] = prva;//vratiit na staro
                    break;
                }
            } catch (Exception e) {

            }
        }
        return sah;
    }


    private static boolean DaliPijunJedePravo(String pozicija_kralja, String pozicija_pijuna) {
        char slovoKralja = pozicija_kralja.charAt(0);
        char slovoPijuna = pozicija_pijuna.charAt(0);
        char brojKralja = pozicija_kralja.charAt(1);
        char brojPijuna = pozicija_pijuna.charAt(1);
        boolean x= (abs(slovoKralja - slovoPijuna) == 0 && abs(brojKralja - brojPijuna) > 0 )||
                (abs(slovoKralja - slovoPijuna) != 0 && abs(brojKralja - brojPijuna) == 0);
        return  x;
    }


}
