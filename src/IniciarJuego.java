public class IniciarJuego {
    public static Tablero tablero = new Tablero(7, 7);

    public static void main(String[] args){
        InputUsuario inpus = new InputUsuario();

        // Testeos temporales
        tablero.initTablero();
        tablero.printTablero();
        inpus.EleccionCasilla();
    }
}
