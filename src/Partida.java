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

        int colMin = ((lastColumna - 3) < 0) ? 0 : lastColumna - 3;
        int colMax = ((lastColumna + 3) >= (t.getLongitud() - 1)) ? (t.getLongitud() - 1) : lastColumna + 3;

        int altMin = ((lastAlt - 3) < 0) ? 0 : lastAlt - 3;
        int altMax = ((lastAlt + 3) >= (t.getAltura() - 1)) ? (t.getAltura() - 1) : lastAlt + 3;

        if (
            comprobarCasillaHorizontal(contadorGanador, posibleGanador, colMin, colMax)                        ||
            comprobarCasillaVertical(contadorGanador, posibleGanador, altMin, altMax)                          ||
            comprobarCasillaDiagonalDerecha(contadorGanador, posibleGanador)   ||
            comprobarCasillaDiagonalIzquierda(contadorGanador, posibleGanador)
           ){
            return true;
        }

        return false;
    }

    private boolean comprobarCasillaHorizontal(int contGanador, char posibleGanador, int colMin, int colMax){

        for(int i = colMin; i <= colMax - 1; i++){
            if (t.getFicha(lastAlt, i) == t.getFicha(lastAlt, i + 1)){
                contGanador++;
            } else {
                contGanador = 1;
            }
            if (contGanador == 4){ return true; }
        }

        return false;
    }

    private boolean comprobarCasillaVertical(int contGanador, char posibleGanador, int altMin, int altMax){

        for(int i = altMin; i <= altMax - 1; i++){
            if (t.getFicha(i, lastColumna) == t.getFicha(i + 1, lastColumna)){
                contGanador++;
            } else {
                contGanador = 1;
            }
            if (contGanador == 4){ return true; }
        }
        return false;
    }

    private boolean comprobarCasillaDiagonalDerecha(int contGanador, char posibleGanador){

        return false;
    }

    private boolean comprobarCasillaDiagonalIzquierda(int contGanador, char posibleGanador){

        return false;
    }

    private boolean estaEnRango(int alt, int lon){

        if (
                alt < (t.getAltura() - 1)   ||
                alt > 0                     ||
                lon < (t.getLongitud() - 1) ||
                lon > 0
        )   { return true; }

        return false;
    }

    private boolean compara(char fichaAComparar, int alt, int lon){
        if (fichaAComparar == t.getFicha(alt, lon)){ return true; }
        return false;
    }

}
