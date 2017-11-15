###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P03 - Control de flujo
#### Entrega de: *Pedro Plaza Ramos*
----
#### 1. Descripción:

Vamos a practicar las sentencias de control de flujo en PHP

#### 2. Formato de entrega:

Este u otro documento en el que se incluya el codigo fuente del archivo o archivos generados, así como una captura de pantalla de una ejecución.

#### 3. Trabajo a realizar:

Crea un nuevo proyecto PHP *U2P03-PHP-Control de flujo* que consistirá en una página web “index.php” o “index.html” con enlaces a las siguientes páginas, que resolverán diferentes problemas. En cada una de las páginas se incluirá un enlace “Volver” para regresar a la página principal.
```html
<!doctype html>
<html>
    <meta charset="UTF-8"/>
    <meta name="author" content="Pedro Plaza Ramos" />
    <title>Index</title>
</head>
<body>
    <ol>
        <li><a href="ecf-diferencia.php">diferencia</a></li>
        <li><a href="ecf-suma.php">suma</a></li>
        <li><a href="ecf-potencia.php">potencia</a></li>
        <li><a href="ecf-factorial.php">factorial</a></li>
        <li><a href="ecf-multiplicacion.php">multiplicacion</a></li>
        <li><a href="ecf-recorte.php">recorte</a></li>
        <li><a href="ecf-meses.php">meses</a></li>
        <li><a href="ecf-acumulador.php">acumulador</a></li>
        <li><a href="ecf-multiplos.php">multiplos</a></li>
        <li><a href="ecf-cuadrado.php">cuadrado</a></li>
    </ol>
</body>
</html>
```
##### Parte 1: “ecf-diferencia.php”


Pedir al usuario dos números A y B entre el 1 y el 10. Escribir en pantalla tantos asteriscos como diferencia haya entre los números (resolviéndolo con while, mientras uno sea menor que otro se escribe asterisco) y repetir con almohadillas (resolviéndolo con for utilizando la diferencia entre a y b como número de repeticiones).
```PHP
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 1</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir al usuario dos números A y B entre el 1 y el 10. Escribir en pantalla tantos asteriscos
	como diferencia haya entre los números (resolviéndolo con while, mientras uno sea menor que otro
	se escribe asterisco) y repetir con almohadillas (resolviéndolo con for utilizando la diferencia
	entre a y b como número de repeticiones).</p>
    Número A: <input type="text" name="menor">
    <br/>
    Número B: <input type="text" name="mayor">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif (is_numeric($_POST["menor"]) && is_numeric($_POST["mayor"])) {
            $menor = $_POST["menor"];
            $mayor = $_POST["mayor"];
            $aux;
            $auxMenor;
            $auxMayor;
            echo "<p>Numeros elegidos: $menor y $mayor.</p>";
            if ($menor < 1 || $menor > 10 || $mayor < 1 || $mayor > 10) {
                echo "<p>Los números tienen que estar comprendidos entre 1 y 10.</p>";
            } else {
                if ($mayor < $menor) {
                    $aux = $menor;
                    $menor = $mayor;
                    $mayor = $aux;
                }
                $auxMenor = $menor;
                $auxMayor = $mayor;
                echo "<p>";
                while ($mayor != $menor) {
                    echo "*";
                    $mayor --;
                }
                echo "</p>";
                echo "<p>";
                for ($i = $auxMenor; $i < $auxMayor; $i ++) {
                    echo "#";
                }
                echo "</p>";
            }
        } else {
            echo "<p>No has introducido dos números.</p>";
        }
?>
</form>
</body>
</html>
```
##### Parte 2: “ecf-suma.php”

Pedir un número X y calcular la suma de los X primeros números naturales (1 + 2 + 3 + …).
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 2</title>
</head>
<body>
	<a href="index.php">Volver</a>
	<?php
if (! isset($_POST["enviar"])) {
    ?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		<p>Pedir un número X y calcular la suma de los X primeros números
			naturales (1 + 2 + 3 + …).</p>
		Número: <input type="text" name="numero"> <br /> <input type="submit"
			name="enviar">
    <?php
} elseif (is_numeric($_POST["numero"])) {
        $numero = $_POST["numero"];
        $suma = 0;
        if ($numero < 0) {
            $numero *= - 1;
        }
        for ($i = 0; $i <= $numero; $i ++) {
            $suma += $i;
        }
        echo "<p>La suma de los $numero primeros números es: $suma</p>";
    } else {
        echo "<p>No has introducido un número.</p>";
    }
    ?>
</form>
</body>
</html>
```
##### Parte 3: “ecf-potencia.php”

Pedir dos números A y B y calcular la potencia A elevado a B utilizando iteraciones (no una función matemática predefinida).
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 3</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>Pedir dos números A y B y calcular la potencia A elevado a B utilizando iteraciones (no una función matemática predefinida).</p>
    Número: <input type="text" name="numero">
    <br/>
    Exponente: <input type="text" name="exponente">
    <br/>
    <input type="submit" name="enviar">
    <?php
} elseif (is_numeric($_POST["numero"]) && is_numeric($_POST["exponente"])) {
        $numero = $_POST["numero"];
        $exponente = $_POST["exponente"];
        $potencia = 1;
        for ($i = 1; $i <= $exponente; $i ++) {
            $potencia *= $numero;
        }
        echo "<p>La pontencia de $numero al $exponente es: $potencia</p>";
    } else {
        echo "<p>No has introducido dos números.</p>";
    }
?>
</form>
</body>
</html>
```
##### Parte 4: “ecf-factorial.php”

Pedir un número X y calcular su factorial utilizando iteraciones.
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 4</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y calcular su factorial utilizando iteraciones.</p>
    Número: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(is_numeric($_POST["numero"])) {
        $numero=$_POST["numero"];
        $factorial=1;
        if ($numero<0){
            $numero*=-1;
        }
        for($i=1; $i<=$numero; $i++){
            $factorial*=$i;
        }
        echo "<p>El factorial del número $numero es: $factorial</p>";
    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    ?>
</form>
</body>
</html>
```
##### Parte 5: “ecf-multiplicacion.php”

Pedir un número X y mostrar su tabla de multiplicar.
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 5</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y mostrar su tabla de multiplicar.</p>
    Número: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(is_numeric($_POST["numero"])) {
        $numero=$_POST["numero"];
        $multiplicacion;
        if($numero<0){
            $numero*=-1;
        }
        echo "<p>Tabla de multiplicar del $numero:</p>";
        for($i=0; $i<=10; $i++){
            $multiplicacion=$numero*$i;
            echo "<p>$numero x $i = $multiplicacion</p>";
        }
    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    ?>
</body>
</html>
```
##### Parte 6: “ecf-recorte.php”

Pedir una cadena de texto y mostrarla varias veces: en cada línea se mostrará un carácter menos que en la anterior. Sólo se puede usar una función de strings: “strlen()”

```
Mi casa
Mi cas
Mi ca
Mi c
Mi
Mi
M
```
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 6</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>Pedir una cadena de texto y mostrarla varias veces: en cada línea se mostrará un carácter menos que en la anterior. Sólo se puede usar una función de strings: “strlen()”</p>
    Cadena: <input type="text" name="cadena">
    <br/>
    <input type="submit" name="enviar">
    <?php
} elseif(!empty ($_POST["cadena"])  || $_POST["cadena"]==0) {
        $cadena=$_POST["cadena"];
        $aux;
        for ($i = 0; $i < strlen($cadena); $i++) {
            $aux;
            echo "<p>";
            for ($j = 0; $j < (strlen($cadena)-$i); $j++) {
                echo "$cadena[$j]";
            }
            echo "</p>";
        }
    } else {
        echo "<p>No se ha introducido una cadena.</p>";
    }
    ?>
</body>
</html>
```
##### Parte 7: “ecf-meses”

En un formulario se recogerá un valor en un cuadro de texto y un radio group para indicar si el año actual es bisiesto o no. Habrá que comprobar si el valor leído corresponde al número de un mes (de 1 a 12) o a su nombre (“enero”, “febrero”). Si es así se mostrará el número de días que tiene ese mes, y si no es así se mostrará un error. Nota:para comparar String, busca referencia de las funciones *strcmp* y *strcasecmp*.
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 7</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>En un formulario se recogerá un valor en un cuadro de texto y un radio group para indicar si el año actual es bisiesto o no. Habrá que comprobar si el valor leído corresponde al número de un mes (de 1 a 12) o a su nombre (“enero”, “febrero”). Si es así se mostrará el número de días que tiene ese mes, y si no es así se mostrará un error. Nota:para comparar String, busca referencia de las funciones strcmp y strcasecmp.</p>
    Mes: <input type="text" name="mes">
    <br/>
    Es bisiesto: <input type="radio" name="bisiesto" value="si">
    <br/>
    No es bisiesto: <input type="radio" name="bisiesto" value="no" checked="checked">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(!empty($_POST["mes"])) {
        $mes=$_POST["mes"];
        $bisiesto=$_POST["bisiesto"];
        $mes=strtolower($mes);
        switch ($mes) {
            case 1: case "enero":
            case 3: case "marzo":
            case 5: case "mayo":
            case 7: case "julio":
            case 8: case "agosto":
            case 10: case "octubre":
            case 12: case "diciembre":
                echo "<p>El mes tiene 31 días.</p>";

            break;
            case 2: case "febrero":

                if ($bisiesto=="si") {
                    echo "<p>El mes tiene 29 días.</p>";
                } else {
                   echo "<p>El mes tiene 28 días.</p>";
                }

                break;

             case 4: case "abril":
             case 6: case "junio":
             case 9: case "septiembre":
             case 11: case "noviembre":
                echo "<p>El mes tiene 30 días.</p>";
                break;

            default:
                echo "<p>No es un mes válido.</p>";
            break;
        }
    } else {
        echo "<p>No ha introducido un valor.</p>";
    }
    ?>
</body>
</html>
```
##### Parte 8: “ecf-acumulador”

Ir pidiendo por formulario una serie de números enteros (de uno en uno) e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir entonces la suma de todos los números introducidos. Pista: para poder mantener el valor acumulado (antes de estudiar técnicas más avanzadas) utilizar un campo de formulario de tipo oculto (“hidden”).
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 8</title>
</head>
<body>
<a href="index.php">Volver</a>
<p>Ir pidiendo por formulario una serie de números enteros (de uno en uno) e irlos sumando. Se deja de
pedir números al usuario cuando la cantidad supera el valor 50. Escribir entonces la suma de todos los
números introducidos. Pista: para poder mantener el valor acumulado (antes de estudiar técnicas más avanzadas)
utilizar un campo de formulario de tipo oculto (“hidden”).</p>
<?php
if (! isset($_POST["enviar"])) {
    $acumulador = 0;
    $numero = 0;
} else {


    $numero = $_POST["numero"];
    $acumulador = $_POST["acumulador"]+$numero;
    /*if (is_numeric($_POST["numero"])) {


    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    */
}
if ($acumulador > 50) {
        echo "<p>Valor del acumulador final: " . $acumulador . "</p>";
    } else {
        ?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		Numero: <input type="text" name="numero">
		<input type="hidden" name="acumulador" value=<?php echo $acumulador?>>
		<br />
		<input
			type="submit" name="enviar">
	</form>

	<?php
       echo "<p>Valor del acumulador: " . $acumulador . "</p>";

}
?>
</body>
</html>
```
##### Parte 9: “ecf-multiplos”

Mostrar en pantalla los múltiplosde 3 y 5 entre el 1 y el 1000. A continuación mostrar en pantalla los 20 primeros múltiplos de 3 y 5.
```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 9</title>
</head>
<body>
<a href="index.php">Volver</a>

<p>Mostrar en pantalla los múltiplosde 3 y 5 entre el 1 y el 1000. A continuación mostrar en pantalla los 20 primeros múltiplos de 3 y 5.</p>
    <?php
        $tres=3;
        $cinco=5;
        $contadorTres=0;
        $contadorCinco=0;
        echo "<p>Múltiplos de 3:</<p>";
        echo "<p>";
        for ($i = 0; 1000>=$tres*$i; $i++) {
            echo $tres*$i." ";
        }
        echo "</p>";
        echo "<p>Múltiplos de 5:</<p>";
        echo "<p>";
        for ($i = 0; 1000>=$cinco*$i; $i++) {
            echo $cinco*$i." ";
        }
        echo "</p>";

        echo "<p>20 primeros múltiplos de 3:</<p>";
        echo "<p>";
        for ($i = 0; $contadorTres<20; $i++) {
            $contadorTres++;
            echo $tres*$i." ";
        }
        echo "</p>";
        echo "<p>20 primeros múltiplos de 5:</<p>";
        echo "<p>";
        for ($i = 0; $contadorCinco<20; $i++) {
            $contadorCinco++;
            echo $cinco*$i." ";
        }
        echo "</p>";
    ?>
</body>
</html>
```

##### Parte 10: “ecf-cuadrado”

Pedir un número X y generar un cuadrado como el que se muestra en la figura (en este caso X vale 10). Una vez resuelto, mejorarlo para que las filas pares salgan en un color más claro (lightblue por ejemplo) para facilitar la lectura. En la figura se ha usado un “padding” de 3 para los elementos de celda (td).

![U2P03](U2P03.png)

```php
<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 10</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y generar un cuadrado como el que se muestra en la figura (en este caso X vale 10). Una vez resuelto, mejorarlo para que las filas pares salgan en un color más claro (lightblue por ejemplo) para facilitar la lectura. En la figura se ha usado un “padding” de 3 para los elementos de celda (td).
	</p>
	Numero: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(!empty($_POST["numero"])) {
        $numero=$_POST["numero"];
        if ($numero<0) {
            $numero*=-1;
        }

        ?>
		<table cellpadding="3" border="1">
        <?php
    for ($i = 1; $i <= $numero; $i ++) {
        if ($i % 2 == 0) {
            ?>
			<tr bgcolor="lightblue">
        <?php
        } else {
            ?>
        <tr>
			<?php
        }
        for ($j = 1; $j <= $numero; $j ++) {
            ?>
			<td>
        <?php
            echo $i * $j;
            ?>
        </td>
			<?php
        }
        echo "</tr>";
    }

    ?>
        </table>        
        <?php
    } else {
        echo "<p>No ha introducido un valor.</p>";
    }
    ?>
</body>
</html>
```
