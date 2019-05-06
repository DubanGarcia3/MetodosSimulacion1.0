package uptc.com.sim.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerRegisterPoker {

	private ArrayList<String> registerPokerList;
	private int input0, input1, input2, input3, input4, input5, input6, input7, input8, input9;
	private ArrayList<Integer> a;

	public ManagerRegisterPoker() {
		registerPokerList = new ArrayList<String>();
		a = new ArrayList<Integer>();
		
		input0 = 0;
		input1 = 0;
		input2 = 0;
		input3 = 0;
		input4 = 0;
		input5 = 0;
		input6 = 0;
		input7 = 0;
		input8 = 0;
		input9 = 0;
	}
	
	public ArrayList<String> getRegisterPokerList() {
		return registerPokerList;
	}

	public int getInput0() {
		return input0;
	}

	public int getInput1() {
		return input1;
	}

	public int getInput2() {
		return input2;
	}

	public int getInput3() {
		return input3;
	}

	public int getInput4() {
		return input4;
	}

	public int getInput5() {
		return input5;
	}

	public int getInput6() {
		return input6;
	}

	public int getInput7() {
		return input7;
	}

	public int getInput8() {
		return input8;
	}

	public int getInput9() {
		return input9;
	}

	public void addRegister(String register) {
		registerPokerList.add(register);
	}

	public Type valueType() {
		for (int i = 0; i < a.size(); i++) {
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
		        	input0 = numeroDeVeces ;
		        } 
		        
		        if(caracter == '1') {
		        	input1 = numeroDeVeces;
		        } 
		        
		        if(caracter == '2') {
		        	input2 = numeroDeVeces;
		        } 
		        
		        if(caracter == '3') {
		        	input3 = numeroDeVeces;
		        } 
		        
		        if(caracter == '4') {
		        	input4 = numeroDeVeces;
		        } 
		        
		        if(caracter == '5') {
		        	input5 = numeroDeVeces;
		        } 
		        
		        if(caracter == '6') {
		        	input6 = numeroDeVeces;
		        } 
		        
		        if(caracter == '7') {
		        	input7 = numeroDeVeces;
		        }
		        
		        if(caracter == '8') {
		        	input8 = numeroDeVeces;
		        } 
		        
		        if(caracter == '9') {
		        	input9 = numeroDeVeces;
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
}
