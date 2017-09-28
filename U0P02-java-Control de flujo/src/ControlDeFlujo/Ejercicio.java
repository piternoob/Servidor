package ControlDeFlujo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio {

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;

		do {
			System.out.println("Elige una opci�n\n"
					+ "1. Ejercicio 1.\n"
					+ "2. Ejercicio 2.\n"
					+ "3. Ejercicio 3.\n"
					+ "4. Ejercicio 4.\n"
					+ "5. Ejercicio 5.\n"
					+ "6. Ejercicio 6.\n"
					+ "7. Ejercicio 7.\n"
					+ "8. Ejercicio 8.\n"
					+ "9. Ejercicio 9.\n"
					+ "10. Ejercicio 10.\n"
					+ "11. Salir.");
			opcion=validarValoresEntero(1, 11);

			switch (opcion) {
			case 1:
				ejercicio1();
				break;
			case 2:
				ejercicio2();
				break;
			case 3:
				ejercicio3();
				break;
			case 4:
				ejercicio4();
				break;
			case 5:
				ejercicio5();
				break;
			case 6:
				ejercicio6();
				break;
			case 7:
				ejercicio7();
				break;
			case 8:
				ejercicio8();
				break;
			case 9:
				ejercicio9();
				break;
			case 10:
				ejercicio10();
				break;
			default:
				break;
			}

		}while(opcion!=11);

	}

	public static void ejercicio1() {
		String dia;

		System.out.println("Introduce el d�a de la semana:");
		dia=sc.nextLine();
		dia=dia.toLowerCase();

		switch (dia) {
		case "lunes":
		case "martes":
		case "miercoles":
		case "jueves":
		case "viernes":
			System.out.println("Es laborable.");
			break;
		case "sabado":
		case "domingo":
			System.out.println("No es laborable.");
			break;
		default:
			System.out.println("D�a incorrecto.");
			break;
		}
	}

	public static void ejercicio2() {
		String s1, s2, s3, s4, s5, cadena;

		System.out.println("Introduce la cadena 1:");
		s1=sc.nextLine();
		System.out.println("Introduce la cadena 2:");
		s2=sc.nextLine();
		System.out.println("Introduce la cadena 3:");
		s3=sc.nextLine();
		System.out.println("Introduce la cadena 4:");
		s4=sc.nextLine();
		System.out.println("Introduce la cadena 5:");
		s5=sc.nextLine();

		cadena=s1+s2+s3+s4+s5;
		System.out.println("La cadena resultante es: "+cadena);
	}

	public static void ejercicio3() {
		int suma=0, numero;

		while(suma<=50) {
			System.out.println("Introduce un n�mero para sumarlo:");
			numero=validarEntero();
			suma+=numero;
		}

		System.out.println("La suma es: "+suma);
	}

	public static void ejercicio4() {
		int numero;
		boolean correcto=false;

		do {
			System.out.println("Introduce un n�mero:");
			try {
				numero=sc.nextInt();
				correcto=true;
			}catch (InputMismatchException e) {
				System.out.println("Valor incorrecto.");
				sc=new Scanner(System.in);
			}
		}while(!correcto);
		
		do {
			System.out.println("Introduce un n�mero entre el 1 y el 10:");
			numero=sc.nextInt();
		}while(numero<1 || numero>10);

	}

	public static void ejercicio5() {
		int mes;
		//int array[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		String bis;
		boolean bisiesto;

		System.out.println("Introduce el n�mero del mes:");
		mes=validarValoresEntero(1, 12);
		sc=new Scanner(System.in);
		System.out.println("�El a�o es bisiesto?");
		bis=sc.nextLine();
		if(bis.equalsIgnoreCase("si"))
			bisiesto=true;
		else
			bisiesto=false;

		/*
		if(mes==2 && bisiesto)

			System.out.println("El mes 2 tiene 29 d�as.");
		else
			System.out.println("El mes "+mes+" tiene "+array[mes-1]+" d�as.");
		*/
		
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("El mes "+mes+" tiene 31 d�as.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("El mes "+mes+" tiene 30 d�as.");
			break;
		case 2:
			if(bisiesto)
				System.out.println("El mes 2 tiene 29 d�as.");
			else
				System.out.println("El mes "+mes+" tiene 28 d�as.");
			break;
		default:
			break;
		}
		
	}

	public static void ejercicio6() {
		int a, b, aux;

		System.out.println("Introduce un n�mero:");
		a=sc.nextInt();
		System.out.println("Introduce otro n�mero:");
		b=sc.nextInt();

		if(a>b) {
			aux=a;
			a=b;
			b=aux;
		}

		while(a<b) {
			System.out.println("*");
			a++;
		}

	}

	public static void ejercicio7() {
		int numero, aux, factorial=1;

		System.out.println("Introduce un n�mero:");
		numero=sc.nextInt();
		aux=numero;

		//do while
		do {
			factorial*=numero;
			numero--;
		}while(numero!=1);

		numero=aux;
		factorial=1;

		//while
		while(numero!=1) {
			factorial*=numero;
			numero--;
		}

		numero=aux;
		factorial=1;

		//for
		for(int i=numero; i>1; i--) 
			factorial*=i;

		System.out.println("El factorial de "+aux+" es: "+factorial);
	}

	public static void ejercicio8() {
		int opcion1, opcion2, lado, base, altura, area, perimetro;

		do {

			System.out.println("Elige una opci�n\n"
					+ "1. Calcular �reas.\n"
					+ "2. Calcular per�metros.\n"
					+ "3. Salir.");
			opcion1=validarValoresEntero(1, 3);

			switch (opcion1) {
			case 1:
				do {
					System.out.println("Elige una opci�n\n"
							+ "1. �rea del cuadrado.\n"
							+ "2. �rea del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						area=(int)Math.pow(lado, 2);
						System.out.println("El �rea del cuadrado de lado "+lado+" es: "+area+".");
						break;
					case 2:
						System.out.println("Introduce la base del rect�ngulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rect�ngulo:");
						altura=validarEntero();
						area=base*altura;
						System.out.println("El �rea del rect�ngulo de base "+base+" y altura "+altura+" es: "+area+".");
						break;

					default:
						break;
					}
				}while(opcion2!=3);
				break;
			case 2:
				do {
					System.out.println("Elige una opci�n\n"
							+ "1. Per�metro del cuadrado.\n"
							+ "2. Per�metro del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						perimetro=lado*4;
						System.out.println("El per�metro del cuadrado de lado "+lado+" es: "+perimetro+".");
						break;
					case 2:
						System.out.println("Introduce la base del rect�ngulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rect�ngulo:");
						altura=validarEntero();
						perimetro=(base+altura)*2;
						System.out.println("El per�metro del rect�ngulo de base "+base+" y altura "+altura+" es: "+perimetro+".");
						break;

					default:
						break;
					}
				}while(opcion2!=3);

				break;
			default:
				break;

			}
		}while(opcion1!=3);
	}

	public static void ejercicio9() {
		String cadena, cadenaFinal;
		boolean palindromo=true;
		
		System.out.println("Introduce una cadena:");
		cadena=sc.nextLine();
		cadenaFinal=cadena.replace(" ", "");
		
		for(int i=0, j=cadenaFinal.length()-1; i<=j && palindromo; i++, j--) 
			if(cadenaFinal.charAt(i)!=cadenaFinal.charAt(j))
				palindromo=false;
		if(palindromo)
			System.out.println("La cadena "+cadena+" es pal�ndroma.");
		else
			System.out.println("La cadena "+cadena+" no es pal�ndroma.");
	}

	public static void ejercicio10() {
		double media;
		int suma=0;
		int notas[]=new int[10];
		
		System.out.println("Introduce la nota de los alumnos:");
		for(int i=0; i<notas.length; i++) {
			System.out.println("Alumno "+(i+1)+":");
			notas[i]=validarValoresEntero(1, 10);
			suma+=notas[i];
		}
		
		media=(double)suma/notas.length;
		if(media>=5)
			System.out.println("La media de la clase es "+media+". Media aprobado.");
		else
			System.out.println("La media de la clase es "+media+". Media suspenso.");
	}
	
	public static int validarEntero() {
		int numero=-1;
		boolean correcto=false;

		do {
			try {
				numero=sc.nextInt();
				sc.nextLine();
				correcto=true;
			}catch (InputMismatchException e) {
				System.out.println("Valor incorrecto, vuelve a intentarlo.");
				sc=new Scanner(System.in);
			}
		}while(!correcto);

		return numero;
	}

	public static int validarValoresEntero(int a, int b) {
		int numero=-1;
		boolean correcto=false;

		do {
			try {
				numero=sc.nextInt();
				sc.nextLine();
				if(numero>=a && numero<=b)
					correcto=true;
				else
					System.out.println("Valor incorrecto, vuelve a intentarlo.");
			}catch (InputMismatchException e) {
				System.out.println("Valor incorrecto, vuelve a intentarlo.");
				sc=new Scanner(System.in);
			}
		}while(!correcto);

		return numero;
	}
	
}