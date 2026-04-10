package Ejercicios;

public class eje4 {
    private int N, M;

    public void resolver(int[][] laberinto) {
        N = laberinto.length;
        M = laberinto[0].length;
        int[][] sol = new int[N][M];

        if (explorar(laberinto, 0, 0, sol)) {
            System.out.println("Salida: true");
            imprimirMatriz(sol);
        } else {
            System.out.println("Salida: false");
            System.out.println("No hay camino posible.");
        }
    }

    private boolean explorar(int[][] laberinto, int x, int y, int[][] sol) {
        // CASO BASE
        if (x == N - 1 && y == M - 1 && laberinto[x][y] == 0) {
            sol[x][y] = 1;
            return true;
        }

        if (esSeguro(laberinto, x, y, sol)) {
            sol[x][y] = 1;

            // 1. Abajo
            if (explorar(laberinto, x + 1, y, sol))
                return true;
            // 2. Derecha
            if (explorar(laberinto, x, y + 1, sol))
                return true;
            // 3. Arriba
            if (explorar(laberinto, x - 1, y, sol))
                return true;
            // 4. Izquierda
            if (explorar(laberinto, x, y - 1, sol))
                return true;

            // BACKTRACKING
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    private boolean esSeguro(int[][] laberinto, int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < M &&
                laberinto[x][y] == 0 && sol[x][y] == 0);
    }

    private void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        eje4 solver = new eje4();

        // Ejemplo 1
        int[][] laberinto1 = {
                { 0, 0, 1 },
                { 1, 0, 1 },
                { 1, 0, 0 }
        };
        System.out.println("--- Ejemplo 1 ---");
        solver.resolver(laberinto1);

        // Ejemplo 2
        int[][] laberinto2 = {
                { 0, 1 },
                { 1, 0 }
        };
        System.out.println("\n--- Ejemplo 2 ---");
        solver.resolver(laberinto2);
    }
}
