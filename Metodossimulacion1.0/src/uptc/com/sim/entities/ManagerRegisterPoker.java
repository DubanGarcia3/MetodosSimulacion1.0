package uptc.com.sim.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerRegisterPoker {

	private ArrayList<String> registerPokerList;
	private int values[] ;
	private int valuesFinal[] ;
	int countOne = 0, countTwo = 0, countThree = 0;

	public ManagerRegisterPoker() {
		registerPokerList = new ArrayList<String>();
		values = new int[10];
		valuesFinal = new int[3];
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public ArrayList<String> getRegisterPokerList() {
		return registerPokerList;
	}


	public void addRegister(String register) {
		registerPokerList.add(register);
	}


	public Type valueType() {
		for (int i = 0; i < values.length; i++) {
		}
		return Type.P;
	}

	public void value(String value) throws IOException {
		String texto;
		char caracter = 0;
		int numeroDeVeces = 0;
		do {
			texto = value.substring(2, registerPokerList.get(0).length());
		} while (texto.isEmpty());

		for (int i = 0; i < 9; i++) {
			caracter = Character.forDigit(i, 10);
			numeroDeVeces = contarCaracteres(texto, caracter);
			if(caracter == '0') {
				values[0] = numeroDeVeces ;
			} 

			if(caracter == '1') {
				values[1] = numeroDeVeces;
			} 

			if(caracter == '2') {
				values[2] = numeroDeVeces;
			} 

			if(caracter == '3') {
				values[3] = numeroDeVeces;
			} 

			if(caracter == '4') {
				values[4] = numeroDeVeces;
			} 

			if(caracter == '5') {
				values[5] = numeroDeVeces;
			} 

			if(caracter == '6') {
				values[6] = numeroDeVeces;
			} 

			if(caracter == '7') {
				values[7] = numeroDeVeces;
			}

			if(caracter == '8') {
				values[8] = numeroDeVeces;
			} 

			if(caracter == '9') {
				values[9] = numeroDeVeces;
			} 
		}
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

	public int[] getMinAndMax() {
		int[] list = new int[2] ;
		int min, max;
		min = max = valuesFinal[0];
		for(int i = 0; i < valuesFinal.length; i++)
		{
			if(min>valuesFinal[i] && valuesFinal[i]!=0)
			{
				min=valuesFinal[i];
			}
			if(max<valuesFinal[i] && valuesFinal[i]!=0)
			{
				max=valuesFinal[i];
			}
		}
		list[0] = min;
		list[1] = max;
		return list;
	}

	public void getCant() {
		for (int i = 0; i < values.length; i++) {
			System.out.println(i+":"+values[i]);
			if(values[i]==1) {
				this.countOne++;
			}else if(values[i]==2) {
				this.countTwo ++;
			}else if(values[i]==3) {
				this.countThree++;
			}
		}
		valuesFinal[0] = countOne;
		valuesFinal[1] = countTwo;
		valuesFinal[2] = countThree;
		System.out.println(countOne+""+countTwo+""+countThree);
	}

	public Type type(int value, int valueTwo) {
		if(value == 2) {
			return Type.O;
		}else if(value == 5) {
			return Type.D;
		} else if(value == 3) {
			return Type.T;
		}else if(value == 3 && valueTwo == 2) {
			return Type.F;
		}else if(value == 1) {
			return Type.P;
		}else if(value == 4) {
			return Type.S;
		}
			return Type.Q;
		}
}
