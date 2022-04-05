public class Partida {
    static Tablero t = new Tablero(7, 7);
    private InputUsuario inpus = new InputUsuario();

    public void ejecutarPartida(){
        int turno = 0;
        boolean ganador = false;
        char Jugador;

        t.initTablero();
        t.printTablero();

        do {
            if(turno % 2 == 0){
                Jugador = 'x';
            } else {
                Jugador = 'o';
            }
            System.out.print("Jugador " + Jugador + ", elija una columna: ");
            rellenarCasilla(Jugador);
            t.printTablero();

            // comprobar casilla llenada con ifs.

            turno++;
        } while(!ganador || turno <= (t.getAltura() * t.getLongitud()));
    }

    private void rellenarCasilla(char Jugador){
        int columna = inpus.EleccionCasilla() - 1;
        int alt = (t.getAltura() - 1);

        if (t.getFicha(0, columna) != '_'){
            System.out.println("Esta columna esta llena, prueba otra, jugador " + Jugador);
        }

        for(int i = alt; i >= 0;){

            if(t.getFicha(i, columna) == '_'){
                t.setFicha(i, columna, Jugador);
                break;
            } else {
                i--;
            }
        }
    }

    private boolean comprobarCasilla(){

        return false;
    }
}
