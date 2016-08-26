package br.edu.uepb.tabuleiro;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author geovanniovinhas
 *
 * Jul 15, 2016
 */
public class Teste extends No{
	public Teste(int[] ma) {
		super(ma);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		long time1,time2,time;
		/*
		 * 1,0,2
		 * 3,4,5
		 * 6,7,8
		 */
		//byte tabu[] = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		//int tabu[] = { 1, 0, 3, 4, 2, 5, 7, 8, 6 }; // 03 mov
		//int tabu[] = { 1, 2, 0, 4, 5, 3, 6, 7, 8 }; // 14 mov
		int tabu[] = { 2, 7, 5, 4, 0, 6, 1, 8, 3 };//22 mov
		No no = new No(tabu);
		no.setIndex(2);
		Largura BFS = new Largura();
		//Profunidade BFS = new Profunidade();
		//ProfunidadeLimitada BFS = new ProfunidadeLimitada();
		//ProfunidadeIterativa BFS = new ProfunidadeIterativa();
		time1 = System.currentTimeMillis();
		No noSolucao = BFS.resultado(no);
		time2 = System.currentTimeMillis();
		System.out.println(Arrays.toString(tabu));
		if(noSolucao != null)
		{
			List<No> passos = BFS.listaSolucao(noSolucao);
			for (No n : passos) {
				System.out.println(n.getNum() + " move para " + n.getMove() + " : " + Arrays.toString(n.getM()));
			}
			System.out.println("total de passos " + passos.size());
			System.out.println("Total de Memoria: " + BFS.getTotalMemoria());
			System.out.println("Total de expansoes: " + BFS.getTotalExpancoes());
			
		time = time2-time1;
			System.out.println("minuto:segundo:milis -> " + new SimpleDateFormat("mm:ss:").format(new Date(time2 - time1)) + time);

			
		}else {
			System.out.println("Nao Achou");
		}
		System.out.println();
		
		
	}}
