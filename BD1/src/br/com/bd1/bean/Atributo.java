package br.com.bd1.bean;

public class Atributo {

	private Object atributo;
	private Object classe;
	private String nomeAtributo;
	private float probabilidade;
	public String getNomeAtributo() {
		return nomeAtributo;
	}
	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	public Object getAtributo() {
		return atributo;
	}
	public void setAtributo(Object atributo) {
		this.atributo = atributo;
	}
	public Object getClasse() {
		return classe;
	}
	public void setClasse(Object classe) {
		this.classe = classe;
	}
	public void setProbabilidade(float probabilidade) {
		this.probabilidade = probabilidade;
	}
	public float getProbabilidade() {
		return probabilidade;
	}
	
}

