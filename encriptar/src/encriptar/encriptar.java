package encriptar;

import java.util.Scanner;

public class encriptar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mensaje,mensajeEncriptado;
		
		System.out.println("Ingrese el mensaje que desea encriptar:");
		mensaje=sc.nextLine();
		mensajeEncriptado=encriptarTransposicion(mensaje);
		mensajeEncriptado=encriptarSustitucion(mensaje);
		System.out.println(mensajeEncriptado);
	}
	public static String encriptarTransposicion(String mensaje) {
		char[] mensajeChar =mensaje.toCharArray();
		int filasMensaje= (mensajeChar.length/6)+1;
		char metodoEncriptar1 [][] = new char[filasMensaje][6];
		int desplazar=0;
		for (int i = 0,j=0,k=0; i < mensajeChar.length; i++,k++) {
			if (k==6) {
				k=0;
				j++;
			}
			metodoEncriptar1[j][k]=mensajeChar[i];
		}
		
		String mensajeEncriptado="";
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < filasMensaje; j++) {
				int dato = metodoEncriptar1[j][i];
				if (dato==32) {
					mensajeEncriptado+='$';
				}else if (dato!=0) {
					mensajeEncriptado+=metodoEncriptar1[j][i];
				}
			}
		}
		return mensajeEncriptado;
	}
	public static String encriptarSustitucion(String mensaje) {
		String mensajeEncriptado="";
		String abecedario = "abcdefghijklmnñopqrstuvwxyz$ ";
		String abecedarioEncriptado="tuvenwfoyizlxhspmjrñcagkbqd&&";
		for (int i = 0; i < mensaje.length(); i++) {
			char letra=mensaje.charAt(i);
			int posicion= abecedario.indexOf(letra);
			mensajeEncriptado+=abecedarioEncriptado.charAt(posicion);		
		}
		return mensajeEncriptado;
	}

}
