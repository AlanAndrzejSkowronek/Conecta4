import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUsuario {
    private Tablero t = Partida.t;
    private int numMinimo = 1;

    public int EleccionCasilla(){
        int numElegido = 0;

        do {
            Scanner leer = new Scanner(System.in);
            try {
                numElegido = leer.nextInt();
                if (numElegido > t.getAltura() || numElegido < numMinimo){
                    System.out.println("No existe esa columna. Porfavor introduzca una en el rango: " + "[" + numMinimo + " - " + t.getAltura() + "]");
                }

            } catch (InputMismatchException e){
                System.out.print("No has introducido un número. Porfavor, introduzca uno... ");
            }

        } while (numElegido > t.getAltura() || numElegido < numMinimo);

        return numElegido;
    }
}
