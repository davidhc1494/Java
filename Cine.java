package ejercicio.javaSintaxis;
import java.util.Scanner;
public class Cine {
	private static String [][] butacas;
	private final static int FILA=4;
	private final static int COLUMNA=5;
	private static int numFila;
	private static int numColumna;
	
	private static void cargarSala() {
		butacas=new String[FILA][COLUMNA];
		int  k = 0;	
		int l = 0;
		
		for(int i=0;i<(butacas.length);i++) {
			
			for(int j=0;j<COLUMNA;j++) {	
				
				if(i==0 && j!=0) {
					k = k+1;					
					butacas[i][j]=" "+ k +" ";
				}				
				else if(i!=0 && j==0) { 
					l= l+1;
					butacas[i][j]=" "+ (l)+" ";
				}
				else if(i==0 && j==0){
					
					butacas[i][j]="   ";
				}
				else 
				{
					if(Math.round(Math.random()*1)==1) {
						butacas[i][j]= " L ";
						
					}
					else {
						butacas[i][j]= " O ";
						
					}
				}
			}
		}

	}
	
	private static void reserva() {
		Scanner teclado = new Scanner(System.in);
		
		do {
		
			do {
				System.out.print("Ingrese numero de fila: ");
				numFila= teclado.nextInt();				
				if(!(numFila>=0 && numFila<FILA))
					System.out.println("Numero de fila no valido");					
			}while(!(numFila>=0 && numFila<FILA));
		
			do {
				System.out.print("Ingrese numero de columna: ");				
				numColumna=teclado.nextInt();				
				if(!(numColumna>=0 && numColumna<COLUMNA))
					System.out.println("Numero de columna no valido");				
			}while(!(numColumna>=0 && numColumna<COLUMNA));
			
			if(butacas[numFila][numColumna].equalsIgnoreCase(" L ")) {
				butacas[numFila][numColumna]=" R ";
				System.out.println("");
				System.out.println("RESERVA CONFIRMADA!!");
			}else{			 
				System.out.println("butaca OCUPADA, seleccione otra butaca ");
				mostrarButacas();
			}
		
		}while(!(butacas[numFila][numColumna].equalsIgnoreCase(" R ")));
		teclado.close();
	}
	
	
	private static void mostrarButacas() {
		for(int i=0;i<(butacas.length);i++) {			
			for(int j=0;j<COLUMNA;j++) {
			System.out.print(butacas[i][j]);			
		    }
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {			
		
		cargarSala();	
		mostrarButacas();		
		reserva();		
		mostrarButacas();
		
		
	}
	}


	


