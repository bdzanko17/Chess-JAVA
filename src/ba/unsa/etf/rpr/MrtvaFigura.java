package ba.unsa.etf.rpr;

public class MrtvaFigura extends ChessPiece {

    MrtvaFigura(String pozicija, Color boja) throws IllegalArgumentException {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalArgumentException, IllegalChessMoveException {
        this.pozicija = position;
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

    @Override
    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }
}
