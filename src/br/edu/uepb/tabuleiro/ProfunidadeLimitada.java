package br.edu.uepb.tabuleiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author geovanniovinhas
 *
 * Jul 29, 2016
 */
public class ProfunidadeLimitada {
	Stack<No> pilha;
	Set<No> nosExplorados;
	List<No> listaDeSolucao;
	int totalExpancoes;
	long totalMemoria;


	public ProfunidadeLimitada() {
		pilha = new Stack<No>();
		nosExplorados = new HashSet<>();
		listaDeSolucao = new ArrayList<>();
	}
	
	
	public int getTotalExpancoes() {
		return totalExpancoes;
	}

	public void setTotalExpancoes(int totalExpancoes) {
		this.totalExpancoes = totalExpancoes;
	}

	public long getTotalMemoria() {
		return totalMemoria;
	}


	public void setTotalMemoria(long totalMemoria) {
		this.totalMemoria = totalMemoria;
	}


	public List<No> listaSolucao(No no) {

		if (no.getPai() != null) {
			listaDeSolucao.add(no);
			return listaSolucao(no.getPai());
		}
		Collections.reverse(listaDeSolucao);
		return listaDeSolucao;
	}
	
	public static int getNivelNo(No no) {
		int count = 0;
		No atual = no;
		while (atual.getPai() != null) {
			atual = atual.getPai();
			count++;
		}
		return count;
	}
	
	public No resultado(No noInicial) {
		if(No.isSolucao(noInicial))
		{
			return noInicial;
		}else {
			pilha.push(noInicial);
			No no = null;
			totalExpancoes = 0;
			
			while(!pilha.isEmpty())
			{
				noInicial = pilha.pop();
				if(getNivelNo(noInicial) < 10000) {
					nosExplorados.add(noInicial);
					if (No.isSolucao(noInicial)) {
						totalMemoria = Runtime.getRuntime().totalMemory();
						return noInicial;
					}
					totalExpancoes++;
					// cima
					if (noInicial.getIndex() < 6) {
						no = No.cima(noInicial);
						if (!nosExplorados.contains(no)) {
							pilha.add(no);
						}
					}
					// baixa
					if (noInicial.getIndex() > 2) {
						no = No.baixo(noInicial);
						if (!nosExplorados.contains(no)) {
							pilha.add(no);
						}
					}
					// esquerda
					if (noInicial.getIndex() != 2 && noInicial.getIndex() != 5 && noInicial.getIndex() != 8) {
						no = No.esquerda(noInicial);
						if (!nosExplorados.contains(no)) {
							pilha.add(no);
						}
					}
					// direita
					if (noInicial.getIndex() != 0 && noInicial.getIndex() != 3 && noInicial.getIndex() != 6) {
						no = No.direita(noInicial);
						if (!nosExplorados.contains(no)) {
							pilha.add(no);
						}
					}
				}else {
					return null;
				}
				
			}
		}
		return null;
	}

}
