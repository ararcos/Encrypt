package encriptar;

import java.util.Scanner;

public class encriptar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mensaje,mensajeEncriptado,mensajeDesencriptado;
		int tama�o;
		int opc;
		do {
			System.out.println("escoja una opcion \n1)Encriptar \n2)Desencriptar \n3)salir");
			opc=sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("Ingrese el mensaje que desea encriptar:");
				sc.nextLine();
				mensaje=sc.nextLine();
				System.out.println("Ingrese el tama�o de la matriz");
				tama�o=sc.nextInt();
				mensajeEncriptado=encriptarTransposicion(mensaje,tama�o);
				mensajeEncriptado=encriptarSustitucion(mensajeEncriptado);
				System.out.println("Mensaje Encriptado: "+mensajeEncriptado);
				break;
			case 2:
				System.out.println("Ingrese el mensaje que desea desencriptar:");
				sc.nextLine();
				mensaje=sc.nextLine();
				System.out.println("Ingrese el tama�o de la matriz");
				tama�o=sc.nextInt();
				mensajeDesencriptado=desencriptarSustitucion(mensaje);
				System.out.println("Desencriptado por sustitucion: "+mensajeDesencriptado);
				mensajeDesencriptado=desencriptarTransposicion(mensajeDesencriptado,tama�o);
				System.out.println("Desencriptado por transposicion: "+mensajeDesencriptado);
				break;
			default:
				System.out.println("!!!!!!!!saliendo!!!!!!!!!!!!!!");
				break;
			}
		}while(opc!=3);
		
		
		/**/
	}
	public static String encriptarTransposicion(String mensaje,int tama�o) {
		char[] mensajeChar =mensaje.toCharArray();
		int filasMensaje= (mensajeChar.length/tama�o)+1;
		char metodoEncriptar1 [][] = new char[filasMensaje][tama�o];
		int desplazar=0,k=0;
		for (int i = 0; i < filasMensaje; i++) {
			for (int j = 0; j < tama�o; j++) {
				if (k<mensajeChar.length) {
					metodoEncriptar1[i][j]=mensajeChar[k];
					k++;
				}else {
					metodoEncriptar1[i][j]='#';
				}
			}
		}
		
		String mensajeEncriptado="";
		for (int i = 0; i < tama�o; i++) {
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
		String abecedario = "abcdefghijklmn�opqrstuvwxyz$#";
		String abecedarioEncriptado="tuvenwfoyizlxhspmjr�cagkbqd&$";
		for (int i = 0; i < mensaje.length(); i++) {
			char letra=mensaje.charAt(i);
			int posicion= abecedario.indexOf(letra);
			mensajeEncriptado+=abecedarioEncriptado.charAt(posicion);		
		}
		return mensajeEncriptado;
	}
	public static String desencriptarTransposicion(String mensaje,int parametro) {
		String mensajeDesencriptado="";
		int incremento=1;
		char[] mensajeChar =mensaje.toCharArray();
		int letras = mensajeChar.length;
		int filas=0;
		int aumentador = parametro;
		while(letras/parametro>0) {
			parametro= parametro+aumentador;
			filas++;
		}
		
		for(int j=0;j<filas;j++) {
			incremento=j;
			mensajeDesencriptado+=mensajeChar[incremento];
			
			for(int i=0;i<aumentador-1;i++) {
				incremento=incremento+filas;
				mensajeDesencriptado+=mensajeChar[incremento];
			}
			
		}
		String mensajeFinal = mensajeDesencriptado.replace("$"," ");
		
		return mensajeFinal.replace("#","");
	}
	public static String desencriptarSustitucion(String mensaje) {
		String mensajeDesEncriptado="";
		String abecedario = "abcdefghijklmn�opqrstuvwxyz$#";
		String abecedarioEncriptado="tuvenwfoyizlxhspmjr�cagkbqd&$";
		for (int i = 0; i < mensaje.length(); i++) {
			char letra=mensaje.charAt(i);
			int posicion= abecedarioEncriptado.indexOf(letra);
			mensajeDesEncriptado+=abecedario.charAt(posicion);		
		}
		return mensajeDesEncriptado;
	}

}
