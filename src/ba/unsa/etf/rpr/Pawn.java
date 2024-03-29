package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Pawn extends ChessPiece {
    Pawn(String pozicija, Color boja) throws IllegalArgumentException {
        super(pozicija, boja);
    }

    public Boolean diran = false;

    private static boolean legalan_za_piuna(char slovo, char broj, char slovo2, char broj2, Color boja) {
        boolean x = false;


        if (boja == Color.WHITE) {
            if ((slovo == slovo2 && abs(broj2 - broj) == 1 && broj2 > broj) || (abs(slovo - slovo2) == 1 && broj2 > broj && abs(broj - broj2) == 1)
                    || (slovo == slovo2 && abs(broj2 - broj) == 2 && broj2 > broj)) {
                if (abs(slovo - slovo2) > 1 && abs(broj2 - broj) > 1) {
                    x = false;
                } else
                    x = true;
            }
        } else if (boja == Color.BLACK) {
            if ((slovo == slovo2 && abs(broj2 - broj) == 1 && broj2 < broj) || (abs(slovo - slovo2) == 1 && broj2 < broj && abs(broj - broj2) == 1)
                    || (slovo == slovo2 && abs(broj2 - broj) == 2 && broj2 < broj)) {
                if (abs(slovo - slovo2) > 1 && abs(broj2 - broj) > 1) {
                    x = false;
                } else
                    x = true;
            }
        }


        return x;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (position.length() > 2 || position.length() <= 1)
            throw new IllegalArgumentException(); //provjera da li je dobra pozicija

        if (((position.charAt(0) >= 'A' && position.charAt(0) <= 'H' || (position.charAt(0) >= 'a' && position.charAt(0) <= 'h'))
                && position.charAt(1) >= '1' && position.charAt(1) <= '8')) {
            String s = this.getPozicija();
            s.toUpperCase();
            if(!(this.pozicija.equals("A2")||this.pozicija.equals("B2")||this.pozicija.equals("A2")
                    ||this.pozicija.equals("C2")||this.pozicija.equals("D2")||this.pozicija.equals("E2")
                    ||this.pozicija.equals("F2")||this.pozicija.equals("G2")||this.pozicija.equals("H2")
                    ||this.pozicija.equals("A7")||this.pozicija.equals("B7")||this.pozicija.equals("C7")
                    ||this.pozicija.equals("C7")||this.pozicija.equals("D7")||this.pozicija.equals("E7")
                    ||this.pozicija.equals("F7")||this.pozicija.equals("G7")||this.pozicija.equals("H7")
            ))
            {
             if(abs(position.charAt(1)-s.charAt(1))>1){
                 throw new IllegalChessMoveException("greska");
             }
            }
            char slovo = s.charAt(0);
            char broj = s.charAt(1);
            char slovo2 = position.charAt(0);
            char broj2 = position.charAt(1);
            if (legalan_za_piuna(slovo, broj, slovo2, broj2, this.getBoja())) {
                this.setPozicija(position);
                diran = true;
            } else {
                throw new IllegalChessMoveException("Nemoguc potez");  //izuzetak
            }
        } else throw new IllegalArgumentException();
    }


    @Override
    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public void setBoja(Color boja) {
        this.boja = boja;
    }

    @Override
    public String getPozicija() {
        return this.pozicija;
    }

    @Override
    public Color getBoja() {
        return this.boja;
    }
}
