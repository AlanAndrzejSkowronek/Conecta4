public class Partida {
    private Tablero t = IniciarJuego.tablero;
    InputUsuario inpus = new InputUsuario();
    private char Jugador1, Jugador2;

    public Partida(char Jugador1, char Jugador2){

    }

    private void ejecutarPartida(){
        int turno = 0;
    }

    private void rellenarCasilla(char Jugador){
        int columna = inpus.EleccionCasilla();
        int alt = t.getAltura();

        if (t.getFicha(alt, columna) != '_'){
            System.out.println("Esta columna esta llena, prueba otra, jugador " + Jugador);
            return;
        }

        for(int i = t.getAltura(); i >= t.getLongitud(); i--){
            if(t.getFicha(i, columna) == '_'){
                t.setFicha(i, columna, Jugador);
                break;
            }
        }
    }
}
