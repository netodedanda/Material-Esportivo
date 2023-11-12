package br.com.material.model;

public class Material {
	
	public String nome;
	public String preco;
	public String quantidade;

	public Material() {}
	
	public Material(String nome, String preco, String quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	@Override
    public String toString() {
        return "Material [Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade + "]";
	}
	
}

