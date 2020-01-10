package encriptar;

import java.util.Scanner;

public class encriptar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mensaje,mensajeEncriptado;
		int tamaño;
		System.out.println("Ingrese el mensaje que desea encriptar:");
		mensaje=sc.nextLine();
		System.out.println("Ingrese el tamaño de la matriz");
		tamaño=sc.nextInt();
		mensajeEncriptado=encriptarTransposicion(mensaje,tamaño);
		mensajeEncriptado=encriptarSustitucion(mensajeEncriptado);
		System.out.println(mensajeEncriptado);
	}
	public static String encriptarTransposicion(String mensaje,int tamaño) {
		char[] mensajeChar =mensaje.toCharArray();
		int filasMensaje= (mensajeChar.length/tamaño)+1;
		char metodoEncriptar1 [][] = new char[filasMensaje][tamaño];
		int desplazar=0,k=0;
		for (int i = 0; i < filasMensaje; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (k<mensajeChar.length) {
					metodoEncriptar1[i][j]=mensajeChar[k];
					k++;
				}else {
					metodoEncriptar1[i][j]='#';
				}
			}
		}
		
		String mensajeEncriptado="";
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < filasMensaje; j++) {
				int dato = metodoEncriptar1[j][i];
				if (dato==32) {
					mensajeEncriptado+='$';
				}else {
					mensajeEncriptado+=metodoEncriptar1[j][i];
				}
			}
		}
		return mensajeEncriptado;
	}
	public static String encriptarSustitucion(String mensaje) {
		String mensajeEncriptado="";
		String abecedario = "abcdefghijklmnñopqrstuvwxyz$#";
		String abecedarioEncriptado="tuvenwfoyizlxhspmjrñcagkbqd&$";
		for (int i = 0; i < mensaje.length(); i++) {
			char letra=mensaje.charAt(i);
			int posicion= abecedario.indexOf(letra);
			mensajeEncriptado+=abecedarioEncriptado.charAt(posicion);		
		}
		return mensajeEncriptado;
	}

}
