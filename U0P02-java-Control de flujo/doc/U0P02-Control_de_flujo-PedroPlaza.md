###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P02 - Repaso: estructuras de control de flujo
#### Entrega de: *Pedro Plaza Ramos*
----
#### 1. Descripción:

Vamos a instalar el Java Develompent Kit (JDK) y el entorno de desarrollo Eclipse. A continuación crearemos un proyecto Java en el que practicaremos las estructuras de control de flujo (tanto de selección como de iteración) a través de diferentes programas.

#### 2. Formato de entrega:

Completa este documento incluyendo tras cada apartado el código necesario para resolver el problema (sin incluir el método `main`, sólo el código correspondiente a la solución) y el resultado de una ejecución.

* Para el código utiliza bloques de código Markdown
* Para el resultado puedes utilizar también bloques, o bien incluir capturas de pantalla de Eclipse

#### 3. Trabajo a realizar:

Antes de comenzar, escribe tu / vuestros nombres en la cabecera de este documento

##### Parte 1: Configuración del espacio de trabajo en la máquina virtual de Windows

1. Desinstala la versión actual de Java. Recuerda que normalmente cuando decimos que un ordenador "tiene instalado Java" lo que en realidad tiene instalado es el Java Runtime Environment (JRE).
2. Descarga la última versión del [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java 8 Update 144. Localiza la descarga en la web oficial, pero si lo deseas puedes descargar el archivo desde el FTP del instituto. **Utilizaremos esta versión de Java durante todo el curso. Es muy importante que tengas la misma en casa y no la actualices para evitar problemas al compartir proyectos posteriormente**.
3. Desde el menú de inicio, abre el panel de configuración de Java (`Configurar Java`). Recuerda: hablamos del JRE. El JDK no tiene ninguna aplicación gráfica
4. Comprueba que la versión es la esperada haciendo clic en el botón `Acerca de` en la pestaña `General`
5. En la pestaña `Actualizar` desmarca la casilla *Comprobar actualizaciones automáticamente*. Esto garantizará que todos tengamos la misma versión de Java a lo largo del curso.
6. Descarga la última versión de Eclipse, llamada Oxygen. Como más adelante desarrollaremos aplicaciones Java EE, no queremos el paquete básico de instalación: en la [web de descargas de Eclipse](http://www.eclipse.org/downloads/) debes hacer clic en *Download Packages* y escoger la edición para desarrolladores Java EE. Tienes el archivo disponible en el servidor FTP del instituto.
7. Descomprime el archivo de forma que la carpeta llamada `eclipse` (sin la versión) quede donde desees, por ejemplo en la raíz `C:\`
8. Crea un acceso directo al ejecutable de Eclipse en el escritorio y/o en la barra de tareas
9. Ejecuta Eclipse: la primera decisión será la ubicación de la carpeta de espacio de trabajo o *workspace*: puedes dejar la que viene por defecto o escoger otra a tu gusto
10. Inicialmente aparecerá la pantalla de bienvenida: desmarca la casilla para que no vuelva a aparecer en el futuro

#####Parte 2: Creación y organización de un proyecto

1. Crea un nuevo proyecto Java: `File` → `New` → `Project` → `Java Project`. El nombre es importante, puesto que seguiremos la misma nomenclatura durante todo el curso: *Número de práctica - Lenguaje utilizado - Título o descripción*, en este caso: *U0P02-Java-Control de flujo*
2. Crea desde Eclipse una carpeta `doc` en la raíz del proyecto (junto a la carpeta `src`) y copia en ella el archivo de este enunciado (arrastra el archivo a la carpeta de Eclipse). A lo largo del curso seguiremos este esquema para agrupar cada proyecto con su correspondiente enunciado.
3. Indica que queremos editar los archivos Markdown con Typora: *clic secundario sobre el archivo → Open with → Other → Browse → Localizar el ejecutable de Typora en la carpeta de archivos de programa*. No olvides marcar la casilla para indicar que queremos utilizar este programa para abrir todos los archivos Markdown
4. Comprueba que al hacer doble clic sobre un archivo Markdown en Eclipse, se abre con Typora
5. Crea una clase *HolaMundo* con un código sencillo para probar que tu instalación de Java es correcta y puedes compilar y ejecutar programas en Java.
6. Recuerda que dispones de plantillas de código para escribir rápidamente sentencias o bloques. Por ejemplo si escribes "sout" y pulsas Ctrl + Espacio, se escribirá `System.out.println();`. También hay plantillas para escribir un bloque if-else, while, try-catch... Consulta las plantillas en `Window` → `Preferences` → `Java` → `Editor` → `Templates`


#####Parte 3: Repaso de Java: estructuras de control de flujo

Crea un paquete llamado `ControlDeFlujo` y codifica en una o varias clases los siguientes programas:

- *Método main*:

```java
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;

		do {
			System.out.println("Elige una opción\n"
					+ "1. Ejercicio 1. \n"
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
```

- *Método para comprobar si metemos un entero válido*:

```java
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
```

- *Método para comprobar si metemos un entero válido dentro de un rango de valores*:

```java
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
```

1) Preguntar al usuario el día de la semana e indicar si es laborable o no. Resolver utilizando la estructura `switch`.

- *Código*:

```java
public static void ejercicio1() {
	String dia;

	System.out.println("Introduce el día de la semana:");
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
			System.out.println("Día incorrecto.");
			break;
	}
}
```

- *Ejecución*:

		Introduce el día de la semana:
		lunes
		Es laborable.

2) Pedir al usuario cinco cadenas de texto y generar una sola cadena uniéndolas todas. Escribir esa cadena por pantalla.

- *Código*:

```java
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
```

- *Ejecución*:

		Introduce la cadena 1:
		hola
		Introduce la cadena 2:
		me
		Introduce la cadena 3:
		llamo
		Introduce la cadena 4:
		pedro
		Introduce la cadena 5:
		plaza
		La cadena resultante es: holamellamopedroplaza


3) Ir pidiendo por teclado una serie de números enteros e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir por pantalla la suma de todos los números introducidos.

- *Código*:

```java
public static void ejercicio3() {
		int suma=0, numero;

		while(suma<=50) {
			System.out.println("Introduce un número para sumarlo:");
			numero=validarEntero();
			suma+=numero;
		}

		System.out.println("La suma es: "+suma);
	}
```

- *Ejecución*:

		Introduce un número para sumarlo:
		24
		Introduce un número para sumarlo:
		26
		Introduce un número para sumarlo:
		7
		La suma es: 57

4) Pedir al usuario un número. Si introduce un valor inválido (por ejemplo una letra), se le volverá a solicitar que introduzca el número.

Cuando termines, añade a continuación una expansión de este problema: pedir al usuario un número entre el 1 y el 10, pidiéndolo de nuevo si lo introduce mal.

Observa que estos dos bloques de código pueden ser reutilizados en cualquier punto de tus futuros programas en el que desees leer un número.


- *Código*:

```java
public static void ejercicio4() {
		int numero;
		boolean correcto=false;

		do {
			System.out.println("Introduce un número:");
			try {
				numero=sc.nextInt();
				correcto=true;
			}catch (InputMismatchException e) {
				System.out.println("Valor incorrecto.");
				sc=new Scanner(System.in);
			}
		}while(!correcto);

		do {
			System.out.println("Introduce un número entre el 1 y el 10:");
			numero=sc.nextInt();
		}while(numero<1 || numero>10);

	}
```

- *Ejecución*:

		Introduce un número:
		o6
		Valor incorrecto.
		Introduce un número:
		45
		Introduce un número entre el 1 y el 10:
		11
		Introduce un número entre el 1 y el 10:
		1

5) Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es bisiesto (sí o no). Escribir su número de días. Si los datos no están bien introducidos se volverán a pedir. Utilizar estructura `switch`.

- *Código*:

```java
public static void ejercicio5() {
		int mes;
		String bis;
		boolean bisiesto;

		System.out.println("Introduce el número del mes:");
		mes=validarValoresEntero(1, 12);
		sc=new Scanner(System.in);
		System.out.println("¿El año es bisiesto?");
		bis=sc.nextLine();
		if(bis.equalsIgnoreCase("si"))
			bisiesto=true;
		else
			bisiesto=false;

		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("El mes "+mes+" tiene 31 días.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("El mes "+mes+" tiene 30 días.");
			break;
		case 2:
			if(bisiesto)
				System.out.println("El mes 2 tiene 29 días.");
			else
				System.out.println("El mes "+mes+" tiene 28 días.");
			break;
		default:
			break;
		}
	}
```

- *Ejecución*:

		Introduce el número del mes:
		2
		¿El año es bisiesto?
		si
		El mes 2 tiene 29 días.

6) Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e incrementar en una unidad el número menor.

- *Código*:

```java
public static void ejercicio6() {
		int a, b, aux;

		System.out.println("Introduce un número:");
		a=validarValoresEntero(1, 10);
		System.out.println("Introduce otro número:");
		b=validarValoresEntero(1, 10);

		if(a>b) {
			aux=a;
			a=b;
			b=aux;
		}

		while(a<b) {
			System.out.print("*");
			a++;
		}

	}
```

- *Ejecución*:

		Introduce un número:
		8
		Introduce otro número:
		4
		****

7) Pedir al usuario un número entero y calcular el factorial de dicho número usando la estructura “do-while”. Repetir el ejercicio usando la estructura “while”, y repetirlo una vez más usando la estructura “for”.

- *Código (las tres versiones seguidas)*:

```java
public static void ejercicio7() {
		int numero, aux, factorial=1;

		System.out.println("Introduce un número:");
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
```

- *Ejecución*:

		Introduce un número:
		12
		El factorial de 12 es: 479001600
		El factorial de 12 es: 479001600
		El factorial de 12 es: 479001600

8) Basándote en la estructura `do-while`, diseña un menú de dos niveles, es decir: en un primer momento se pedirá escoger entre varias opciones, y en cada una de ellas se pedirá de nuevo escoger entre un nuevo conjunto. La temática es libre (cálculo de áreas, enciclopedia, etc). Es importante que tu programa reaccione correctamente ante entradas erróneas del usuario, y que en todos los menús haya una opción para volver.

  Ten en cuenta que codificar un menú correctamente no es trivial, conviene que pienses lo que vas a hacer antes de empezar a codificar.

- *Código*:

```java
public static void ejercicio8() {
		int opcion1, opcion2, lado, base, altura, area, perimetro;

		do {

			System.out.println("Elige una opción\n"
					+ "1. Calcular áreas.\n"
					+ "2. Calcular perímetros.\n"
					+ "3. Salir.");
			opcion1=validarValoresEntero(1, 3);

			switch (opcion1) {
			case 1:
				do {
					System.out.println("Elige una opción\n"
							+ "1. Área del cuadrado.\n"
							+ "2. Área del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						area=(int)Math.pow(lado, 2);
						System.out.println("El área del cuadrado de lado "+lado+" es: "+area+".");
						break;
					case 2:
						System.out.println("Introduce la base del rectángulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rectángulo:");
						altura=validarEntero();
						area=base*altura;
						System.out.println("El área del rectángulo de base "+base+" y altura "+altura+" es: "+area+".");
						break;

					default:
						break;
					}
				}while(opcion2!=3);
				break;
			case 2:
				do {
					System.out.println("Elige una opción\n"
							+ "1. Perímetro del cuadrado.\n"
							+ "2. Perímetro del rectangulo.\n"
							+ "3. Volver.");
					opcion2=validarValoresEntero(1, 3);

					switch (opcion2) {
					case 1:
						System.out.println("Introduce el lado del cuadrado:");
						lado=validarEntero();
						perimetro=lado*4;
						System.out.println("El perímetro del cuadrado de lado "+lado+" es: "+perimetro+".");
						break;
					case 2:
						System.out.println("Introduce la base del rectángulo:");
						base=validarEntero();
						System.out.println("Introduce la altura del rectángulo:");
						altura=validarEntero();
						perimetro=(base+altura)*2;
						System.out.println("El perímetro del rectángulo de base "+base+" y altura "+altura+" es: "+perimetro+".");
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
```

- *Ejecución*:

		Elige una opción
		1. Calcular áreas.
		2. Calcular perímetros.
		3. Salir.
		1
		Elige una opción
		1. Área del cuadrado.
		2. Área del rectangulo.
		3. Volver.
		1
		Introduce el lado del cuadrado:
		4
		El área del cuadrado de lado 4 es: 16.
		Elige una opción
		1. Área del cuadrado.
		2. Área del rectangulo.
		3. Volver.
		3
		Elige una opción
		1. Calcular áreas.
		2. Calcular perímetros.
		3. Salir.
		2
		Elige una opción
		1. Perímetro del cuadrado.
		2. Perímetro del rectangulo.
		3. Volver.
		2
		Introduce la base del rectángulo:
		4
		Introduce la altura del rectángulo:
		5
		El perímetro del rectángulo de base 4 y altura 5 es: 18.
		Elige una opción
		1. Perímetro del cuadrado.
		2. Perímetro del rectangulo.
		3. Volver.
		3
		Elige una opción
		1. Calcular áreas.
		2. Calcular perímetros.
		3. Salir.
		3

9) (opcional) Inventa un problema sencillo sobre estructuras de control de flujo. Resuélvelo para comprobar que el nivel de dificultad es adecuado y comparte el enunciado con tu compañer@ de al lado. Incluye aquí tanto tu enunciado como la solución.

- *Enunciado*:
- Introduce una cadena y di si es o no palíndroma.

- *Código de la solución*

```java
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
			System.out.println("La cadena "+cadena+" es palíndroma.");
		else
			System.out.println("La cadena "+cadena+" no es palíndroma.");
	}
```

- *Ejecución*:

		Introduce una cadena:
		alojavaavaj ola
		La cadena alojavaavaj ola es palíndroma.

10) (opcional) Resuelve el problema que tu compañer@ plantee.

- *Enunciado de tu compañer@:*
- Pide por teclado las notas de 10 alumnos de la clase, e indica  la nota media de eso 10 alumnos y si la media esta aprobada o suspensa.

- *Código de la solución*

```java
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
```

- *Ejecución*:
		Introduce la nota de los alumnos:
		Alumno 1:
		4
		Alumno 2:
		5
		Alumno 3:
		6
		Alumno 4:
		7
		Alumno 5:
		8
		Alumno 6:
		9
		Alumno 7:
		5
		Alumno 8:
		1
		Alumno 9:
		10
		Alumno 10:
		6
		La media de la clase es 6.1. Media aprobado.
