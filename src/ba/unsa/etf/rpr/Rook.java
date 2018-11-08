package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    Rook(String pozicija, Color boja) throws IllegalArgumentException {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {

        if (position.length() > 2 || position.length() <= 1)
            throw new IllegalArgumentException(); //provjera da li je dobra pozicija


        if ((position.charAt(0) >= 'A' && position.charAt(0) <= 'H' || (position.charAt(0) >= 'a' && position.charAt(0) <= 'h')
                && position.charAt(1) >= '1' && position.charAt(1) <= '8')) {
            String s = this.getPozicija();
            s.toUpperCase();
            char slovo = s.charAt(0);
            char broj = s.charAt(1);
            char slovo2 = position.charAt(0);
            char broj2 = position.charAt(1);
            if (legalan_za_topa(slovo, broj, slovo2, broj2)) {
                this.setPozicija(position);
            } else {
                throw new IllegalChessMoveException("Nemoguc potez");  //izuzetak
            }
        } else throw new IllegalArgumentException();
    }

    private static boolean legalan_za_topa(char slovo, char broj, char slovo2, char broj2) {
        if (broj == broj2 || slovo == slovo2) return true;
        else return false;
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
