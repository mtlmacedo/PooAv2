package logica;

public class UnidadeEuclidiana extends UnidadeMovel{
	
	public UnidadeEuclidiana(float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(latitude, longitude, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeEuclidiana(float latitude, float longitude) {
		super(latitude, longitude);
	}
	public UnidadeEuclidiana(int id, float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(id, latitude, longitude, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	
	@Override
	public double calcularDistancia(float latitude, float longitude) {
		
		float latitudeAtual = this.getLatitude();
		float longitudeAtual = this.getLongitude();
		double x = Math.pow(latitudeAtual - latitude, 2);	
		double y = Math.pow(longitudeAtual - longitude, 2);	
		return Math.sqrt(x + y);
	}	
	
}
