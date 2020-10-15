package logica;

import math.Vector2;

public class UnidadeEuclidiana extends UnidadeMovel{
	
	public UnidadeEuclidiana(float abcissa, float ordenada, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(new Vector2(abcissa, ordenada), medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeEuclidiana(Vector2 posicao, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(posicao, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeEuclidiana(float abcissa, float ordenada) {
		super(new Vector2(abcissa, ordenada));
	}
	public UnidadeEuclidiana(Vector2 posicao) {
		super(posicao);
	}
	
	@Override
	public double calcularDistancia(Vector2 objetivo) {
		Vector2 posicaoAtual = this.getPosicao();
		double x =  Math.pow(objetivo.getX() - posicaoAtual.getX(), 2);	
		double y =  Math.pow(objetivo.getY() - posicaoAtual.getY(), 2);	
		return Math.sqrt(x + y);
	}	
	@Override
	public double calcularDistancia(float abcissa, float ordenada) {
		
		Vector2 posicaoAtual = this.getPosicao();
		double x = Math.pow(posicaoAtual.getX() - ordenada, 2);	
		double y = Math.pow(posicaoAtual.getY() - abcissa, 2);	
		return Math.sqrt(x + y);
	}	
	
}
