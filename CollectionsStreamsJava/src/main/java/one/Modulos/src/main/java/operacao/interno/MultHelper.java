package operacao.interno;

import operacao.Operacao;

public class MultHelper implements Operacao {

    @Override
    public int execute(int a, int b) {
        return a*b;
    }
}
