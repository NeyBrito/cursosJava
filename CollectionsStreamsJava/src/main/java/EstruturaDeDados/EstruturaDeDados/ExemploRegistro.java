package EstruturaDeDados;

public class ExemploRegistro {
    public static void main(String[] args) {
        SubRegistro[] reg = new SubRegistro[5];

        for(int i=0;i< reg.length;i++){
            reg[i] = new SubRegistro();
            reg[i].codigo = i;
            reg[i].nome = Integer.toString(i);

            System.out.println("Código\tNome");

        }

        for(int k=0;k< reg.length;k++){
            System.out.println(reg[k].codigo+"/t"+reg[k].nome);
        }
    }
 }

