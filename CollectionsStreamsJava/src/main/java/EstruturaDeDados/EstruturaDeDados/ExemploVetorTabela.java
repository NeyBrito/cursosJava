package EstruturaDeDados;

public class ExemploVetorTabela {
    public static void main(String[] args) {
        String vt1[] = {"Ney", "Diogo", "João", "William"};
        double vt2[] = {1.76 ,1.73 ,1.68 ,1.75 };

        System.out.println("--------------");
        System.out.println("    TABELA    ");
        System.out.println("--------------");

        for(int i = 0; i < vt1.length; i++){
            System.out.print("\t"+ vt1[i] + "\t\t" + vt2[i] + "\n");
        }
    }
}
