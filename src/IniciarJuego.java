public class IniciarJuego {

    public static void main(String[] args){
        Partida p = new Partida();

        System.out.println("Bienvenido al Conecta 4!");
        System.out.println("Conectad 4 piezas en vertical, horizontal o diagonal para ganar!");
        System.out.println("Suerte jugadores! Que comience el juego: ");
        p.ejecutarPartida();
    }
}
