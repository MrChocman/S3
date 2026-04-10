package Ejercicios;

public class ViajeRioLAURA {
    public static int[][] costoMinimo(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        // Inicializamos los costos de un embarcadero a sí mismo como 0
        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }

        // Bucle para la longitud del intervalo (distancia entre embarcaderos)
        for (int longitud = 1; longitud < n; longitud++) {
            // i es el origen
            for (int i = 0; i < n - longitud; i++) {
                int j = i + longitud; // j es el destino
                C[i][j] = T[i][j]; // Inicialmente el costo directo

                // Probamos paradas intermedias 'k' para ver si es más barato
                for (int k = i + 1; k < j; k++) {
                    int costo = T[i][k] + C[k][j];
                    if (costo < C[i][j]) {
                        C[i][j] = costo;
                    }
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] T = {
                { 0, 4, 7, 10 },
                { 0, 0, 2, 6 },
                { 0, 0, 0, 3 },
                { 0, 0, 0, 0 }
        };

        int[][] C = costoMinimo(T);

        // Imprimir la matriz de costos mínimos
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nCosto mínimo de 0 a 3: " + C[0][3]);
    }
}