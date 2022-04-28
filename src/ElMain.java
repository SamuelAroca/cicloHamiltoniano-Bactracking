public class ElMain {
    static int[][] A = {{0,1,0,1,0}, {1,0,1,1,1}, {0,1,0,0,1}, {1,1,0,0,1}, {0,1,1,1,0}};
    static int n = A.length;
    static boolean[] visitado = new boolean[n];
    static int[] camino = new int[n];

    public static void main(String[] a) {
        if (ciclo(3, 0)) {
            imprimirCamino();
        } else {
            System.out.println("No contiene ciclo hamiltoniano");
        }
    }

    public static boolean ciclo(int v, int pos) {
        boolean fin = false;
        visitado[v] = true;
        camino[pos] = v;
        if (pos < n-1) {
            //llamada recursiva
            for (int i=0; i<n; i++) {
                if (A[v][i] == 1 && !visitado[i]) {
                    if (ciclo(i, pos+1)) {
                        return true;
                    }
                    // Backtracking
                    visitado[i] = false;
                    camino[pos+1] = 0;
                }
            }
        } else {
            // fin recursión
            if (A[camino[n-1]][camino[0]] == 1) {
                fin = true;
            }
        }
        return fin;
    }

    public static void imprimirCamino() {
        for (int i=0; i<n; i++) {
            System.out.print(camino[i] + " ");
        }
        System.out.print(camino[0]);
    }
}
