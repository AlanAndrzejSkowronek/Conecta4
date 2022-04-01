public class IniciarJuego {
    public static Tablero t = new Tablero(7, 7);


    public static void main(String[] args){
        InputUsuario inpus = new InputUsuario();

        t.initTablero();
        t.printTablero();
        inpus.EleccionCasilla();
    }
}
