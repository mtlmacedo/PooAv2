package ui;

public enum EnumTipoUnidade {
	Manhattan("Manhattan"), Euclidiana("Euclidiana");

	private String descricao;
	
	EnumTipoUnidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
	    return descricao;
	 }
}
