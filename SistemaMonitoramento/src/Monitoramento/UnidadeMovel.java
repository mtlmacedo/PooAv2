package Monitoramento;
import Math.Vector2;

public abstract class UnidadeMovel {
	
	private Vector2 posicao;
	private static int idBase;
	private int id; 
	private boolean medidorCO2;
	private boolean cameraDeVideo;
	private boolean termometro;
	private boolean medidorMetano;
	
	public UnidadeMovel(Vector2 posicao) {
		this.id = UnidadeMovel.idBase; 
		UnidadeMovel.idBase++;  
		this.posicao = posicao;
		this.medidorCO2 = false;
		this.cameraDeVideo = false;
		this.termometro = false;
		this.medidorMetano = false;
	}	
	public UnidadeMovel(Vector2 posicao, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		this.id = UnidadeMovel.idBase; 
		UnidadeMovel.idBase++;  
		this.posicao = posicao;
		this.medidorCO2 = medidorCO2;
		this.cameraDeVideo = cameraDeVideo;
		this.termometro = termometro;
		this.medidorMetano = medidorMetano;
	}	
	public UnidadeMovel(float abcissa, float ordenada, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		this.id = UnidadeMovel.idBase; 
		UnidadeMovel.idBase++;  
		this.posicao = new Vector2(abcissa, ordenada);
		this.medidorCO2 = medidorCO2;
		this.cameraDeVideo = cameraDeVideo;
		this.termometro = termometro;
		this.medidorMetano = medidorMetano;
	}	
	public UnidadeMovel(float abcissa, float ordenada) {
		this.id = UnidadeMovel.idBase; 
		UnidadeMovel.idBase++;  
		this.posicao = new Vector2(abcissa, ordenada);
	}
	
	abstract public double calcularDistancia(Vector2 objetivo);	
	abstract public double calcularDistancia(float abcissa, float ordenada);
	
    public int getId() {
    	return this.id;
	}	
	public Vector2 getPosicao() {
		return posicao;
	}
	protected void setPosicao(Vector2 posicao) {
		this.posicao = posicao;
	}
	protected void setPosicao(float abcissa, float ordenada) {
		this.posicao = new Vector2(abcissa, ordenada);
	}
	public boolean hasMedidorCO2() {
		return medidorCO2;
	}
	public void setMedidorCO2(boolean medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}
	public boolean hasCameraDeVideo() {
		return cameraDeVideo;
	}
	public void setCameraDeVideo(boolean cameraDeVideo) {
		this.cameraDeVideo = cameraDeVideo;
	}
	public boolean hasTermometro() {
		return termometro;
	}
	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}
	public boolean hasMedidorMetano() {
		return medidorMetano;
	}
	public void setMedidorMetano(boolean medidorMetano) {
		this.medidorMetano = medidorMetano;
	}	
}
