package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class King extends ChessPiece {

    King(String pozicija, Color boja) {
    super(pozicija,boja);
    }
    public static boolean legalan_za_kralja(char slovo,char broj,char slovo2,char broj2){
        System.out.println(slovo+broj+slovo2+broj2);
        boolean x=false;
        if(abs(slovo-slovo2)<=1){
            if(abs(broj2-broj)<=1){
                x=true;
            }
        }
        return true;
    }




    @Override
    public void move(String position) throws IllegalArgumentException {
        String s=this.getPosition();
        System.out.println(s);
        char slovo=s.charAt(0);
        char broj=s.charAt(1);
        char slovo2=position.charAt(0);
        char broj2=position.charAt(1);
        if ((position.charAt(0) >= 'A' && position.charAt(0) <= 'H') && position.charAt(1) >= '1' && position.charAt(1) <= '8') {
                    if(legalan_za_kralja(slovo,broj,slovo2,broj2)){
                        this.setPozicija(position);
                    }
        }
    }
    @Override
    public void setBoja(Color boja) {
        this.boja=boja;
    }
    @Override
    public void setPozicija(String pozicija) {
        this.pozicija=pozicija;
            }
    public String getPosition() {
        return this.pozicija;
    }

    public Color getColor() {
        return this.boja;
    }
}