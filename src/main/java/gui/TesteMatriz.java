package gui;

import java.util.Random;
import java.util.Scanner;

public class TesteMatriz {

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		System.out.println("Digite o valor do tamanho da matriz");
		int numero = sc.nextInt();
		matriz(numero);
		
		
		
	}
	
	public static void printMatriz(int numero, int matriz[][]) {
		System.out.println("===================================");
		for(int i = 0; i < numero;i++ ) {
			for(int j = 0;j < numero;j++ ) {
				if(j == numero - 1) {
					System.out.print(matriz[i][j]);
				}else {
					System.out.print(matriz[i][j] + ", ");
				}
				
			}
			System.out.println("");
		}
	}
	
	public static void matriz(int numero) {
		
		int array [] [] = new int [numero][numero];
		int contador = 0;
		int lista [] = new int [numero * numero];
		Random random = new Random();
		for(int i = 0; i < numero;i++ ) {
			for(int j = 0;j < numero;j++ ) {
				array[i][j] = random.nextInt(101);
				lista [contador] = array[i][j];
				contador++;
			}
		}
		
		printMatriz(numero, array);
		
		substituirPorMedia(array, lista, numero);
		
	}
	
	public static void substituirPorMedia(int[][] matriz, int[] lista, int numero) {
		int listaMedia[] = new int[lista.length];
		int contadorMedia = 0;
        for(int i = 0; i < lista.length - 1; i++) {
        	int contador = 0;
        	int soma = 0;
        	for(int j = i + 1; j < lista.length; j++) {
        		soma+= lista[j];
        		contador++;
        	}
        	int media = soma / contador;
        	listaMedia[contadorMedia] = media;
        	contadorMedia++;
        	
        }
        contadorMedia = 0;
        
        for(int i = 0; i < numero;i++ ) {
			for(int j = 0;j < numero;j++ ) {
				matriz[i][j] = listaMedia[contadorMedia];
				contadorMedia++;
			}
		}
        
        matriz[numero - 1][numero - 1] = 0;
        
        printMatriz(numero, matriz);
	}

}
