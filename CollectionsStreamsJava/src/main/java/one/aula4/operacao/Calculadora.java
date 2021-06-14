package one.aula4.operacao;

import one.aula4.operacao.interno.DivHelper;
import one.aula4.operacao.interno.MultHelper;
import one.aula4.operacao.interno.SubHelper;
import one.aula4.operacao.interno.SumHelper;

import java.util.List;

public class Calculadora{

    private DivHelper divHelper;
    private SubHelper subHelper;
    private MultHelper multHelper;
    private SumHelper sumHelper;

    public Calculadora(){
        divHelper = new DivHelper();
        multHelper = new MultHelper();
        subHelper = new SubHelper();
        sumHelper = new SumHelper();
    }
    public int sum(int a, int b){
        return sumHelper.execute(a,b);
    }
    public int sub(int a, int b){
        return subHelper.execute(a,b);
    }
    public int mult(int a, int b){
        return multHelper.execute(a,b);
    }
    public int div(int a, int b){
        return divHelper.execute(a,b);
    }
}
