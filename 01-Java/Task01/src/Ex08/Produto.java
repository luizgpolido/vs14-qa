package Ex08;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void aplicarDesconto(double desconto){
        double descontoAplicado = (desconto / 100) * this.preco;
        this.preco -= descontoAplicado;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + '\'' +
                ", Descricao='" + descricao + '\'' +
                ", Preco=" + preco +
                ", Estoque=" + estoque;
    }
}
