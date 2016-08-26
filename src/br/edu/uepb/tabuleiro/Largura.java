package br.edu.uepb.tabuleiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author geovanniovinhas
 *
 *         Jul 27, 2016
 */
public class Largura {
	long totalMemoria;
	int totalExpancoes;
	Queue<No> fila = new LinkedList<>();;
	Set<No> nosExplorados = new HashSet<>();;
	List<No> listaDeSolucao = new ArrayList<>();;

	

	public long getTotalMemoria() {
		return totalMemoria;
	}

	public void setTotalMemoria(long totalMemoria) {
		this.totalMemoria = totalMemoria;
	}

	public int getTotalExpancoes() {
		return totalExpancoes;
	}

	public void setTotalExpancoes(int totalExpancoes) {
		this.totalExpancoes = totalExpancoes;
	}

	public List<No> listaSolucao(No no) {

		if (no.getPai() != null) {
			listaDeSolucao.add(no);
			return listaSolucao(no.getPai());
		}
		Collections.reverse(listaDeSolucao);
		return listaDeSolucao;
	}

	public No resultado(No noInicial) {
		if (No.isSolucao(noInicial)) {
			return noInicial;
		} else {
			fila.add(noInicial);
			totalExpancoes = 0;
			totalMemoria = 0;
			No no = null;
			
			while (!fila.isEmpty()) {
				noInicial = fila.remove();
				if (No.isSolucao(noInicial)) {
					totalMemoria = Runtime.getRuntime().totalMemory();
					return noInicial;
				}
				nosExplorados.add(noInicial);
				totalExpancoes++;

				// cima
				if (noInicial.getIndex() < 6) {
					no = No.cima(noInicial);
					if (!nosExplorados.contains(no)) {
						fila.add(no);
					}
				}
				// baixa
				if (noInicial.getIndex() > 2) {
					no = No.baixo(noInicial);
					if (!nosExplorados.contains(no)) {
						fila.add(no);
					}
				}
				// esquerda
				if (noInicial.getIndex() != 2 && noInicial.getIndex() != 5 && noInicial.getIndex() != 8) {
					no = No.esquerda(noInicial);
					if (!nosExplorados.contains(no)) {
						fila.add(no);
					}
				}
				// direita
				if (noInicial.getIndex() != 0 && noInicial.getIndex() != 3 && noInicial.getIndex() != 6) {
					no = No.direita(noInicial);
					if (!nosExplorados.contains(no)) {
						fila.add(no);
					}
				}

			}
			return null;
		}

	}

}
