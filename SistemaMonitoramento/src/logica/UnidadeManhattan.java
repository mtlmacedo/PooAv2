package logica;

import math.Vector2;

public class UnidadeManhattan extends UnidadeMovel{
	
	public UnidadeManhattan(float abcissa, float ordenada, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(new Vector2(abcissa, ordenada), medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeManhattan(Vector2 posicao, boolean medidorCO2, boolean cameraDeVideo, boolean termometro, boolean medidorMetano) {
		super(posicao, medidorCO2, cameraDeVideo, termometro, medidorMetano);
	}
	public UnidadeManhattan(float abcissa, float ordenada) {
		super(new Vector2(abcissa, ordenada));
	}
	public UnidadeManhattan(Vector2 posicao) {
		super(posicao);
	}
	
	@Override
	public double calcularDistancia(Vector2 objetivo) {
		
		Vector2 posicaoAtual = this.getPosicao();
		float x = Math.abs(posicaoAtual.getX()) - Math.abs(objetivo.getX());	
		float y = Math.abs(posicaoAtual.getY()) - Math.abs(objetivo.getY());
		return x + y;
	}	
	@Override
	public double calcularDistancia(float abcissa, float ordenada) {
		
		Vector2 posicaoAtual = this.getPosicao();
		float x = Math.abs(posicaoAtual.getX()) - Math.abs(abcissa);	
		float y = Math.abs(posicaoAtual.getY()) - Math.abs(ordenada);
		return x + y;
	}	
}
