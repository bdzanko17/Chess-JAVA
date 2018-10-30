package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static enum Color {
        BLACK ,WHITE
    };
    protected String pozicija;
    protected Color boja;
    public abstract void move(String position)throws IllegalArgumentException;
    public abstract void setPozicija(String pozicija) ;
    public abstract void setBoja(Color boja);

    ChessPiece(String pozicija,Color boja)throws IllegalArgumentException{
        if(pozicija.length()>2)throw new IllegalArgumentException();
        if((pozicija.charAt(0)>='A'&&pozicija.charAt(0)<='H')&&pozicija.charAt(1)>='1'&&pozicija.charAt(1)<='8'){
            this.pozicija=pozicija;
            this.boja=boja;
        }else throw new IllegalArgumentException();

    }



}
