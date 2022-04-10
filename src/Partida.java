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

        } while(turno <= ((t.getAltura() * t.getLongitud()) - 1));
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
        int contadorGanador = 0;
        char posibleGanador = t.getFicha(lastAlt, lastColumna);
        int[] direcciones = {0, 1, 0, -1, 1, 0, -1, 0, 1, -1, -1, 1, 1, 1, -1, -1};

        for (int i = 0; i < direcciones.length - 1; i++){
            if (busqueda(direcciones[i], direcciones[i + 1], lastAlt, lastColumna, contadorGanador)){
                return true;
            }
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

    private boolean busqueda(int direccioAltura, int direccioLongitud, int alt, int lon, int contGanador){

        char ficha = t.getFicha(alt, lon);

        do {

            alt += direccioAltura;
            lon += direccioLongitud;
            contGanador++;

        } while (estaEnRango(alt, lon) && compara(ficha, alt, lon));

        alt -= direccioAltura;
        lon -= direccioLongitud;

        if (contGanador == 4){
            return true;
        }
        contGanador = 1;
        return false;
    }
}
