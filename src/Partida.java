public class Partida {
    static Tablero t = new Tablero(7, 7);
    private InputUsuario inpus = new InputUsuario();
    private int lastAlt, lastColumna;

    public void ejecutarPartida(){
        int turno = 0;
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
            comprobarCasillaHorizontal(contadorGanador)        ||
            comprobarCasillaVertical(contadorGanador)          ||
            comprobarCasillaDiagonalDerecha(contadorGanador)   ||
            comprobarCasillaDiagonalIzquierda(contadorGanador)
           ){
            return true;
        }

        return false;
    }

    private boolean comprobarCasillaHorizontal(int contGanador){
        int[] direccioHorizontalDerecha = {0, 1};
        int[] direccioHorizontalIzquierda = {0, -1};

        if (busqueda(direccioHorizontalIzquierda, lastAlt, lastColumna, contGanador) ||
                busqueda(direccioHorizontalDerecha, lastAlt, lastColumna, contGanador))
        {
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaVertical(int contGanador){
        int[] direccioVerticalDerecha = {1, 0};
        int[] direccioVerticalIzquierda = {-1, 0};

        if (busqueda(direccioVerticalIzquierda, lastAlt, lastColumna, contGanador) ||
            busqueda(direccioVerticalDerecha, lastAlt, lastColumna, contGanador))
        {
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaDiagonalDerecha(int contGanador){
        int[] direccioDiagonalDerechaArriba = {1, -1};
        int[] direccioDiagonalIzquierdaAbajo = {-1, 1};

        if (busqueda(direccioDiagonalDerechaArriba, lastAlt, lastColumna, contGanador) ||
                busqueda(direccioDiagonalIzquierdaAbajo, lastAlt, lastColumna, contGanador))
        {
            return true;
        }
        return false;
    }

    private boolean comprobarCasillaDiagonalIzquierda(int contGanador){
        int[] direccioDiagonalIzquierdaArriba = {1, 1};
        int[] direccioDiagonalDerechaAbajo = {-1, -1};

        if (busqueda(direccioDiagonalIzquierdaArriba, lastAlt, lastColumna, contGanador) ||
            busqueda(direccioDiagonalDerechaAbajo, lastAlt, lastColumna, contGanador))
        {
            return true;
        }
        return false;
    }

    private boolean estaEnRango(int alt, int lon){
        return  alt <= (t.getAltura() - 1)   &&
                alt >= 0                     &&
                lon <= (t.getLongitud() - 1) &&
                lon >= 0;
    }

    private boolean compara(char fichaAComparar, int alt, int lon){ return fichaAComparar == t.getFicha(alt, lon); }

    private boolean busqueda(int[] direccio, int alt, int lon, int contGanador){

        char ficha = t.getFicha(alt, lon);
        alt += direccio[0];
        lon += direccio[1];

        while (estaEnRango(alt, lon) && compara(ficha, alt, lon)){
            alt += direccio[0];
            lon += direccio[1];
            contGanador++;
        }
        alt -= direccio[0];
        lon -= direccio[1];

        if (contGanador == 4){
            return true;
        }
        contGanador = 1;
        return false;
    }
}
