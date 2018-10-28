package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static enum Color {
        BLACK ,WHITE
    };
    private String pozicija;
    private Color boja;
    public abstract String getPosition();
    public abstract Color getColor();
    public abstract void move(String position)throws IllegalArgumentException;

    ChessPiece(String pozicija,Color boja)throws IllegalArgumentException{
        if(pozicija.length()>2)throw new IllegalArgumentException();
        if((pozicija.charAt(0)>='A'||pozicija.charAt(0)<='H')&&pozicija.charAt(1)>='1'&&pozicija.charAt(1)<='8'){
            this.pozicija=pozicija;
            this.boja=boja;
        }else throw new IllegalArgumentException();

    }




}
