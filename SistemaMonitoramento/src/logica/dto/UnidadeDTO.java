package logica.dto;

public class UnidadeDTO {
	public UnidadeDTO(String latitude, String longitude, String id, String medidorCO2, String cameraDeVideo,
			String termometro, String medidorMetano) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.id = id;
		this.medidorCO2 = medidorCO2;
		this.cameraDeVideo = cameraDeVideo;
		this.termometro = termometro;
		this.medidorMetano = medidorMetano;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMedidorCO2() {
		return medidorCO2;
	}
	public void setMedidorCO2(String medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}
	public String getCameraDeVideo() {
		return cameraDeVideo;
	}
	public void setCameraDeVideo(String cameraDeVideo) {
		this.cameraDeVideo = cameraDeVideo;
	}
	public String getTermometro() {
		return termometro;
	}
	public void setTermometro(String termometro) {
		this.termometro = termometro;
	}
	public String getMedidorMetano() {
		return medidorMetano;
	}
	public void setMedidorMetano(String medidorMetano) {
		this.medidorMetano = medidorMetano;
	}
	private String latitude;
	private String longitude;
	private String id; 
	private String medidorCO2;
	private String cameraDeVideo;
	private String termometro;
	private String medidorMetano;
}
