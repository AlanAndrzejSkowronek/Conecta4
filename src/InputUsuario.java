// import java.util.InputMismatchException; Para luego
import java.util.Scanner;

public class InputUsuario {
    private Scanner leer = new Scanner(System.in);
    private Tablero t = Partida.t;
    private int numMinimo = 1;

    public int EleccionCasilla(){
        int numElegido = 0;

        do {
            /*
            try {
                numElegido = leer.nextInt();
            } catch (InputMismatchException e){
                System.out.print("No has introducido un número. Porfavor, introduzca uno... ");
            }
            PARA LUEGO (No funciona).
            */
            numElegido = leer.nextInt();

            if (numElegido > t.getAltura() || numElegido < numMinimo){
                System.out.println("No existe esa columna. Porfavor introduzca una en el rango: " + "[" + numMinimo + " - " + t.getAltura() + "]");
            }

        } while (numElegido > t.getAltura() || numElegido < numMinimo);

        return numElegido;
    }
}
