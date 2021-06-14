package operacao.interno;

import operacao.Operacao;

public class SumHelper implements Operacao {

    @Override
    public int execute(int a, int b) {
        return a+b;
    }
}
