
public class Cartaz {
    private String titulo;
    private String tamanho;
    private String tipo;
    private Preco preco;

    public Cartaz(String titulo, String tamanho, String tipo) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.preco = new Preco();
    }

    public void definirPreco(double valor) {
        this.preco.setValor(valor);
    }

    public double obterPreco() {
        return this.preco.getValor();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public String getTipo() {
        return this.tipo;
    }
}
