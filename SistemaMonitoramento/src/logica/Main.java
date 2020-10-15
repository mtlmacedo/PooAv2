package logica;

import math.Vector2;

public class Main {

	public static void main(String[] args) {
		
		Vector2 posicao = new Vector2(3, 11);
		Vector2 objetivo = new Vector2(1, 1);
		Area area = new Area();
		UnidadeManhattan um1 = new UnidadeManhattan(posicao, true, true, true, true);
		UnidadeEuclidiana um2 = new UnidadeEuclidiana(-3, -11, true, true, true, true);
		UnidadeEuclidiana um3 = new UnidadeEuclidiana(3, 11, true, true, true, true);
		System.out.println(um1.calcularDistancia(2, 2));
		System.out.println(um2.calcularDistancia(2, 2));
		System.out.println(um3.calcularDistancia(2, 2));
		area.AdicionarUnidade(um1);
		area.AdicionarUnidade(um2);
		area.AdicionarUnidade(um3);
		System.out.println(area.monitorar(2, 2, true, true, true, false));
	}

}
