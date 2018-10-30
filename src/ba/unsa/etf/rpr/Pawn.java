package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Pawn extends ChessPiece {
    Pawn(String pozicija, Color boja) throws IllegalArgumentException {
        super(pozicija, boja);
    }
    public static boolean legalan_za_piuna(char slovo, char broj, char slovo2, char broj2) {
        boolean x = false;
        if((slovo==slovo2 &&broj!=broj2&&broj2==broj+1 )||(slovo+1==slovo2&&broj2==broj+1))x=true;
        return x;
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (position.length() > 2 &&position.length()<=1) throw new IllegalArgumentException(); //provjera da li je dobra pozicija

        String s = this.getPozicija();
        System.out.println(s);
        char slovo = s.charAt(0);
        char broj = s.charAt(1);
        char slovo2 = position.charAt(0);
        char broj2 = position.charAt(1);
        if ((position.charAt(0) >= 'A' && position.charAt(0) <= 'H') && position.charAt(1) >= '1' && position.charAt(1) <= '8') {
            if (legalan_za_piuna(slovo, broj, slovo2, broj2)) {
                this.setPozicija(position);
            } else {
                throw new IllegalChessMoveException("Nemoguc potez");  //izuzetak
            }
        } else throw new IllegalArgumentException();
    }


    @Override
    public void setPozicija(String pozicija) {
        this.pozicija=pozicija;
    }

    @Override
    public void setBoja(Color boja) {
        this.boja=boja;
    }

    @Override
    public String  getPozicija() {
        return this.pozicija;
    }

    @Override
    public Color getBoja() {
        return this.boja;
    }
}
