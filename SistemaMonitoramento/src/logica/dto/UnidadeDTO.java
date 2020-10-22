package logica.dto;

public class UnidadeDTO {

	private float latitude;
	private float longitude;
	private int id; 
	private boolean medidorCO2;
	private boolean cameraDeVideo;
	private boolean termometro;
	private boolean medidorMetano;
	private int tipoUnidade;
	
	public UnidadeDTO(int id, float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo,
			boolean termometro, boolean medidorMetano, int tipoUnidade) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.medidorCO2 = medidorCO2;
		this.cameraDeVideo = cameraDeVideo;
		this.termometro = termometro;
		this.medidorMetano = medidorMetano;
		this.tipoUnidade = tipoUnidade;
	}

	public String getTipoUnidadeTratado() {
		if(this.tipoUnidade == 0) {
			return "Manhattan";
		}else if(this.tipoUnidade == 1) {
			return "Euclidiana";
		}else
			return "ERROR";
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMedidorCO2() {
		return medidorCO2;
	}

	public void setMedidorCO2(boolean medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}

	public boolean isCameraDeVideo() {
		return cameraDeVideo;
	}

	public void setCameraDeVideo(boolean cameraDeVideo) {
		this.cameraDeVideo = cameraDeVideo;
	}

	public boolean isTermometro() {
		return termometro;
	}

	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}

	public boolean isMedidorMetano() {
		return medidorMetano;
	}

	public void setMedidorMetano(boolean medidorMetano) {
		this.medidorMetano = medidorMetano;
	}

	public int getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(int tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
}
