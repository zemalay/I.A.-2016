package br.edu.uepb.tabuleiro;

import java.util.Arrays;

/**
 * @author geovanniovinhas
 *
 *         Jul 15, 2016
 */

public class No implements Cloneable {
	private static final int TAM = 3;
	private int[] m = new int[TAM * TAM];
	static int solucao[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
	private No pai;
	private int index;
	private String move;
	private int num;

	public No(int ma[]) {
		this.m = ma;
		this.pai = null;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMove() {
		return move;
	}

	public No getPai() {
		return pai;
	}

	public void setMove(String c) {
		this.move = c;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int[] getM() {
		return m;
	}

	public void setM(int[] m) {
		this.m = m;
	}

	public static No baixo(No no) {
		int pos = no.getIndex();
		int matriz[] = new int[no.m.length];
		System.arraycopy(no.m, 0, matriz, 0, no.m.length);

		int valor = matriz[pos - TAM];
		matriz[pos - TAM] = 0;
		matriz[pos] = valor;

		No noBaixa = new No(matriz);
		noBaixa.setIndex(pos - TAM);
		noBaixa.setMove("Baixo");
		noBaixa.setNum(valor);
		noBaixa.setPai(no);
		return noBaixa;

	}

	public static No cima(No no) {
		int pos = no.getIndex();
		int matriz[] = new int[no.m.length];
		System.arraycopy(no.m, 0, matriz, 0, no.m.length);

		int valor = matriz[pos + TAM];
		matriz[pos + TAM] = 0;
		matriz[pos] = valor;

		No noCima = new No(matriz);
		noCima.setIndex(pos + TAM);
		noCima.setNum(valor);
		noCima.setMove("Cima");
		noCima.setPai(no);
		return noCima;
	}

	public static No esquerda(No no) {
		int pos = no.getIndex();
		// int matriz[] = clonar(no.m);
		int matriz[] = new int[no.m.length];
		System.arraycopy(no.m, 0, matriz, 0, no.m.length);

		int valor = matriz[pos + 1];
		matriz[pos + 1] = 0;
		matriz[pos] = valor;

		No noEsquerda = new No(matriz);
		noEsquerda.setIndex(pos + 1);
		noEsquerda.setMove("Esquerda");
		noEsquerda.setNum(valor);
		noEsquerda.setPai(no);
		return noEsquerda;
	}

	public static No direita(No no) {
		int pos = no.getIndex();
		int matriz[] = new int[no.m.length];
		System.arraycopy(no.m, 0, matriz, 0, no.m.length);

		int valor = matriz[pos - 1];
		matriz[pos - 1] = 0;
		matriz[pos] = valor;

		No noDireita = new No(matriz);
		noDireita.setIndex(pos - 1);
		noDireita.setMove("Direita");
		noDireita.setNum(valor);
		noDireita.setPai(no);
		return noDireita;
	}

	public static boolean isSolucao(No no) {
		int matriz[] = no.m;
		for (int i = 0; i < (TAM * TAM) - 1; i++) {
			if (matriz[i] != i + 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof No)) {
			return false;
		}
		No outro = (No) obj;
		return Arrays.equals(m, outro.m);
	}

}
