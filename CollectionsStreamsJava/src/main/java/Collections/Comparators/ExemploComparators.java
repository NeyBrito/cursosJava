package Collections.Comparators;

public class ExemploComparators implements Comparable<ExemploComparators> {

    private final String nome;
    private final Integer idade;

    public ExemploComparators(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() { return nome; }
    public Integer getIdade() { return idade; }

    @Override
    public String toString() { return nome + " -- " + idade;}

    @Override
    public int compareTo(ExemploComparators o) {
        return this.getIdade() - o.getIdade();
    }
}
