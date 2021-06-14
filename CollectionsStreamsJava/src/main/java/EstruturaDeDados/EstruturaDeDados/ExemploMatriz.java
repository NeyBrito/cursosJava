package EstruturaDeDados;

import java.util.Arrays;

public class ExemploMatriz {
    private static final int MAX_ALEATORIO = 100;

    public static void main(String[] args) {
        int m[][] = new int[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int x = 0; x < m[i].length; x++) {
                m[i][x] = (int) (Math.random() * MAX_ALEATORIO);
            }

            for (i = 0; i < m.length; i++) {
                for (int x = 0; x < m[i].length; x++) {
                    System.out.print("[" + m[i][x] + "]");
                }
            }


        }

    }
}
