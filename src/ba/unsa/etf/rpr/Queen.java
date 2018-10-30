package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Queen extends ChessPiece {


    public static boolean legalan_za_kraljiicu(char slovo, char broj, char slovo2, char broj2) {
        boolean x = false;
//        if((slovo==slovo2&&broj==broj2)||())
        return x;
    }

    Queen(String pozicija, Color boja) throws IllegalArgumentException {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        if (position.length() > 2) throw new IllegalArgumentException(); //provjera da li je dobra pozicija

        String s = this.getPozicija();
        System.out.println(s);
        char slovo = s.charAt(0);
        char broj = s.charAt(1);
        char slovo2 = position.charAt(0);
        char broj2 = position.charAt(1);



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
