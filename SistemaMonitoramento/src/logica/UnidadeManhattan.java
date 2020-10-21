package logica;


public class UnidadeManhattan extends UnidadeMovel{
	
	public UnidadeManhattan(float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(latitude, longitude, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeManhattan(int id, float latitude, float longitude, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(id, latitude, longitude, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeManhattan(float latitude, float longitude) {
		super(latitude, longitude);
	}

	@Override
	public double calcularDistancia(float latitude, float longitude) {
		
		float latitudeAtual = this.getLatitude();
		float longitudeAtual = this.getLongitude();
		float x = Math.abs(latitudeAtual - Math.abs(latitude));	
		float y = Math.abs(longitudeAtual - Math.abs(longitude));
		return x + y;
	}	
}
