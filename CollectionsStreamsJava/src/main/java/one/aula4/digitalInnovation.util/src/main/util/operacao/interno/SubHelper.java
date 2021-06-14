package one.aula4.operacao.interno;

import one.aula4.operacao.Operacao;

public class SubHelper implements Operacao {

    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
