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

    ChessPiece(String pozicija,Color boja)throws IllegalArgumentException{ //konstruktor!
        this.pozicija=pozicija;
        this.boja=boja;
    }




}
