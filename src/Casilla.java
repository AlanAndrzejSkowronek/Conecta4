public class Casilla {
    private String casilla;
    private boolean estado;

    public Casilla(String ficha){

        this.casilla = ficha;
    }

    public String getCasilla(){ return casilla; }
    public void setCasilla(String ficha){ this.casilla = ficha; }

}
