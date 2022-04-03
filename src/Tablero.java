public class Tablero {
    private Casilla[][] tablero;
    private int altura, longitud;

    public Tablero(int altura, int longitud){
        this.altura = altura;
        this.longitud = longitud;
        tablero = new Casilla[altura][longitud];
    }

    public int getAltura(){ return altura; }
    public int getLongitud(){ return longitud; }


    public void initTablero(){

        for (int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                tablero[i][j] = new Casilla("_");
            }
        }
    }

    public void printTablero(){

        for (int i = 0; i < tablero.length; i++){
            System.out.print(" | ");
            for(int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j].getCasilla() + " | ");
            }
            System.out.println();
        }
    }
}
