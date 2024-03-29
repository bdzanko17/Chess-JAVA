package ba.unsa.etf.rpr;

public abstract class ChessPiece implements Cloneable {

    public static enum Color {
        BLACK, WHITE
    }





    protected String pozicija;
    protected Color boja;

    public abstract void move(String position) throws IllegalArgumentException, IllegalChessMoveException;

    public abstract void setPozicija(String pozicija);

    public abstract void setBoja(Color boja);

    public abstract String getPozicija();

    public abstract Color getBoja();

    ChessPiece(String pozicija, Color boja) throws IllegalArgumentException {
        if(pozicija==null)throw new IllegalArgumentException();

        pozicija = pozicija.toUpperCase();
        if (pozicija.length() > 2 || pozicija.length() <= 1) throw new IllegalArgumentException();
        if ((pozicija.charAt(0) >= 'A' && pozicija.charAt(0) <= 'H') && pozicija.charAt(1) >= '1' && pozicija.charAt(1) <= '8') {
            this.pozicija = pozicija;
            this.boja = boja;
        } else throw new IllegalArgumentException();

    }
     @Override
    public Object clone() throws CloneNotSupportedException {

        return  (ChessPiece)super.clone();

        }

    @Override
    public boolean equals(Object obj) {
        ChessPiece x=(ChessPiece)obj;
        if(x.getPozicija().equals(this.pozicija)&&x.getBoja().equals(this.boja)){
            return true;
        }else return false;
    }
}
