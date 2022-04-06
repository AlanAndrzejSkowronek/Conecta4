public class Partida {
    static Tablero t = new Tablero(7, 7);
    private InputUsuario inpus = new InputUsuario();
    private int lastAlt, lastColumna;

    public void ejecutarPartida(){
        int turno = 0;
        boolean ganador = false;
        char jugador;
        char[] simbolos = {'x', 'o'};

        t.initTablero();
        t.printTablero();

        do {
            jugador = simbolos[turno % 2];
            System.out.print("Jugador " + jugador + ", elija una columna: ");
            if (rellenarCasilla(jugador)){
                turno++;
            }
            t.printTablero();

            if(comprobarCasilla()){
                System.out.println("Jugador " + jugador + ", HAS GANADO!!! ENHORABUENA!!!");
                break;
            }

        } while(turno <= (t.getAltura() * t.getLongitud()));
    }

    private boolean rellenarCasilla(char player){
        int columna = inpus.EleccionCasilla() - 1;
        int alt = (t.getAltura() - 1);

        if (t.getFicha(0, columna) != '_'){
            System.out.println("Esta columna esta llena, prueba otra, jugador " + player);
            return false;
        }

        for(int i = alt; i >= 0;){
            if(t.getFicha(i, columna) == '_'){
                t.setFicha(i, columna, player);
                lastAlt = i;
                lastColumna = (columna);
                break;
            } else {
                i--;
            }
        }
        return true;
    }

    private boolean comprobarCasilla(){
        int contadorGanador = 1;
        char posibleGanador = t.getFicha(lastAlt, lastColumna);

        if (
            comprobarCasillaHorizontal(contadorGanador, posibleGanador)      ||
            comprobarCasillaVertical(contadorGanador, posibleGanador)        ||
            comprobarCasillaDiagonalDerecha(contadorGanador, posibleGanador) ||
            comprobarCasillaDiagonalIzquierda(contadorGanador, posibleGanador)
           ){
            return true;
        }

        return false;
    }

    private boolean comprobarCasillaHorizontal(int contGanador, char posibleGanador){

        for(int i = lastColumna; i < t.getLongitud() - 1; i++){
            if (posibleGanador == t.getFicha(lastAlt, i + 1)){
                contGanador++;
            } else {
                break;
            }
        }
        for(int j = lastColumna; j > 1; j--){
            if (posibleGanador == t.getFicha(lastAlt, j - 1)){
                contGanador++;
            } else {
                break;
            }
        }

        if (contGanador == 4){
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaVertical(int contGanador, char posibleGanador){

        for(int i = lastAlt; i < t.getAltura() - 1; i++){
            if (posibleGanador == t.getFicha(i + 1, lastColumna)){
                contGanador++;
            } else {
                break;
            }
        }
        for(int j = lastAlt; j > 1; j--){
            if (posibleGanador == t.getFicha(j - 1, lastColumna)){
                contGanador++;
            } else {
                break;
            }
        }

        if (contGanador == 4){
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaDiagonalDerecha(int contGanador, char posibleGanador){



        if (contGanador == 4){
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaDiagonalIzquierda(int contGanador, char posibleGanador){

        return false;
    }
}
