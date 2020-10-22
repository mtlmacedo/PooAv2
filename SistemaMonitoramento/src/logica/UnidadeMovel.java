package logica;

public abstract class UnidadeMovel {
	
	@Override
	public String toString() {
		return "UnidadeMovel [latitude=" + latitude + ", longitude=" + longitude + ", id=" + id + ", medidorCO2="
				+ medidorCO2 + ", cameraDeVideo=" + cameraDeVideo + ", termometro=" + termometro + ", medidorMetano="
				+ medidorMetano + "]";
	}
	private float latitude;
	private float longitude;
	private int id; 
	private boolean medidorCO2;
	private boolean cameraDeVideo;
	private boolean termometro;
	private boolean medidorMetano;
	
	public UnidadeMovel(float latitude, float longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setMedidorCO2(false);
		this.setCameraDeVideo(false);
		this.setTermometro(false);
		this.setMedidorMetano(false);
	}	
	public UnidadeMovel(float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setMedidorCO2(medidorCO2);
		this.setCameraDeVideo(cameraDeVideo);
		this.setTermometro(termometro);
		this.setMedidorMetano(medidorMetano);
	}	
	public UnidadeMovel(int id, float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		this.setId(id);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setMedidorCO2(medidorCO2);
		this.setCameraDeVideo(cameraDeVideo);
		this.setTermometro(termometro);
		this.setMedidorMetano(medidorMetano);
	}	

	abstract public double calcularDistancia(float latitude, float longitude);

	public void setId(int id) {
		this.id = id;
	}
	
    public int getId() {
    	return this.id;
	}	
	public boolean getMedidorCO2() {
		return medidorCO2;
	}
	public void setMedidorCO2(boolean medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}
	public boolean getCameraDeVideo() {
		return cameraDeVideo;
	}
	public void setCameraDeVideo(boolean cameraDeVideo) {
		this.cameraDeVideo = cameraDeVideo;
	}
	public boolean getTermometro() {
		return termometro;
	}
	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}
	public boolean getMedidorMetano() {
		return medidorMetano;
	}
	public void setMedidorMetano(boolean medidorMetano) {
		this.medidorMetano = medidorMetano;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}	
}
