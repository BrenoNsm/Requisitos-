class Requisito {
    String nome;
    String descricao;
    String prioridade;

    public Requisito(String nome, String descricao, String prioridade ) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;

    }

}

class RequisitoNaoFuncional extends Requisito {
    String categoria;

    public RequisitoNaoFuncional(String nome, String descricao, String categoria) {
        super(nome, descricao, null);
        this.categoria = categoria;
    }
}