package operacao;

import operacao.interno.DivHelper;
import operacao.interno.MultHelper;
import operacao.interno.SubHelper;
import operacao.interno.SumHelper;

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
