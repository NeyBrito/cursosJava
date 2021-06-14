package operacao.interno;

import operacao.Operacao;

public class SubHelper implements Operacao {

    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
