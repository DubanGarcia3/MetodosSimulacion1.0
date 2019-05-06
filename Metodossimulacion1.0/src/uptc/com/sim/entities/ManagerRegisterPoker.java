package uptc.com.sim.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerRegisterPoker {

	private ArrayList<String> registerPokerList;

	public ManagerRegisterPoker() {
		registerPokerList = new ArrayList<String>();
	}

	public void addRegister(String register) {
		registerPokerList.add(register);
	}

	public Type valueType() {
			 String cadena="";
		        char [] Arraycadena ;
		        char caracter;
		        int contador =0;
		        cadena = registerPokerList.get(0);
		        Arraycadena=cadena.toCharArray();
		        for(int j =2;j<Arraycadena.length;j++){
		            caracter = Arraycadena[j];
		            for(int k=2;k<Arraycadena.length;k++){
		                if(Arraycadena[k]==caracter){
		                    contador++;
		                }//Fin
		            }//Fin 
		            System.out.println(Arraycadena[j]+" "+contador+" veces.");
		            contador= 0;
		        }//Fin 
		return Type.P;
	}
	
	public void value() throws IOException {
	        String texto;
	        char caracter = 0;
	        int numeroDeVeces = 0;
	        do {
	            texto = registerPokerList.get(0);
	        } while (texto.isEmpty());
	        caracter = (char) '0';
	        numeroDeVeces = contarCaracteres(texto, caracter);
	        System.out.println("El caracter " + caracter + " aparece " + numeroDeVeces + " veces");
	    }

	    public static int contarCaracteres(String cadena, char caracter) {
	        int posicion, contador = 0;
	        posicion = cadena.indexOf(caracter);
	        while (posicion != -1) { 
	            contador++;          
	            posicion = cadena.indexOf(caracter, posicion + 1);
	        }
	        return contador;
	   }
}
