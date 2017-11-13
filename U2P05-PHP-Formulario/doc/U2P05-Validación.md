###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P05 - Validación de formularios
#### Entrega de: *Félix Rojo, Pedro Plaza y Eduardo Garcés*
----
#### 1. Descripción:

El objetivo de la práctica es investigar en grupo las posibilidades de validación de formularios desde el servidor. Ten en cuenta que existen muchos otros métodos para validar directamente en cliente, ahorrando el envío y respuesta de información al servidor.

#### 2. Formato de entrega:

Rellena el apartado Memoria situado al final de este enunciado.

#### 3. Trabajo a realizar:

Codifica una aplicación web que recoja los datos de alta de un alumno, incluyendo nombre, apellidos, password, email, fecha de nacimiento, dirección, teléfono y ciclo formativo. Puedes incluir más datos si lo deseas. Debes incluir dos versiones de la solución: una con dos archivos (formulario y procesamiento) y otra con un solo archivo.

Si el usuario introduce correctamente los datos, se mostrarán en pantalla. Si no los introduce correctamente, se volverá a mostrar el formulario pero:

* Si en un campo ha habido un problema, se mostrará un mensaje de error explicándolo, a ser posible junto al propio campo
* Se recordarán los datos que sí introdujimos correctamente

Indicaciones:

* Utiliza tipos de campos HTML 5 para el email, el teléfono, la contraseña y la fecha de nacimiento. ¿Pueden ayudar a hacer validación en cliente?
* Tú decides los criterios de seguridad que debe cumplir la contraseña para considerarse válida. Sugerencia: mínimo ocho caracteres, y que utilice minúsculas, mayúsculas y algún símbolo de puntuación



* Para recordar los valores, tendrás que recoger lo que escribió el usuario en un campo, e incluirlo como valor inicial de ese mismo campo al mostrar el formulario


* Para ver si un campo está relleno, podemos usar la función booleana *empty()*.
* Aunque la función *isset()* no sirve para campos de texto, sí es útil para botones de radio o de selección

##### Etapa 1: Formación de grupos
Esta práctica la realizaréis en grupos de dos.

##### Etapa 2: Ideas previas
Sin utilizar Internet, discutid posibles ideas para la validación y mejora de los formularios, sin llegar a implementarlas. Tomad nota de las ideas. Intentad plantear la lógica del programa (la estructura del procesamiento)

##### Etapa 3: Investigación
Utilizad Internet para investigar formas aceptadas de validación en PHP. Hablamos de técnicas sencillas, y en ningún caso de técnicas o lenguajes de cliente. A la hora de buscar fuentes, tened en cuenta:
1. La credibilidad de la fuente
2. La fecha de escritura de la información
3. La versión de PHP utilizada


##### Etapa 4: Codificación
Aplicad vuestras ideas para diseñar una aplicación en PHP que recoja datos, algunos de ellos obligatorios, y se comporte de la forma más amigable y útil posible para el usuario.

##### Etapa 5: Resultado
Solución en dos archivos: código del archivo php para formulario:

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php
include("funciones.php");
if (!isset($_POST["enviar"])) {

$nombre = "";
$apellidos = "";
$edad = "";
$fecha = "";
$correo = "";
$telefono = "";
$postal = "";
$pass = "";
$ciclo = "";
$direccion = "";
}else{

    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $edad = $_POST["edad"];
    $fecha = $_POST["fecha"];
    $correo = $_POST["correo"];
    $telefono = $_POST["telefono"];
    $postal = $_POST["postal"];
    $pass = $_POST["pass"];
    $ciclo = $_POST["ciclo"];
    $direccion = $_POST["direccion"];
}
    ?>
    <h2>Introduzca sus datos personales.</h2>
	<form action="validado.php" method="post">
		<table border="1">
			<tr>
				<td>Nombre: <input type="text" name="nombre" value="<?php echo $nombre; ?>" required></td>
				<td>Apellidos: <input type="text" name="apellidos" value="<?php echo $apellidos; ?>" required></td>
			</tr>
			<tr>
				<td>Edad: <input type="number" name="edad" min="18" max="120" value="<?php echo $edad; ?>"></td>
				<td>Fecha de Nacimiento: <input name="fecha" value="<?php echo $fecha; ?>" required></td>
			</tr>
			<tr>
				<td>Correo: <input type="text" name="correo" value="<?php echo $correo; ?>" required></td>
				<td>Telefono móvil
				: <input type="number" name="telefono" value="<?php echo $telefono; ?>"></td>
			</tr>
			<tr>
				<td>Direccion: <input type="text" name="direccion" value="<?php echo $direccion; ?>"></td>
				<td>Codigo Postal: <input type="number" name="postal" min="" max="" value="<?php echo $postal; ?>"></td>
			</tr>
			<tr>
				<td>Contraseña: <input type="password" name="pass" value="<?php echo $pass; ?>"required placeholder="Min 8 caracteres, max 16. Minimo 1 mayuscula,minuscula y numero."></td>
				<td>Ciclo Formativo: <input type="text" name="ciclo" value="<?php echo $ciclo; ?>"required></td>
			</tr>
		</table>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php

?>
</body>
</html>
```
Solución en dos archivos: código del archivo php para procesar el formulario:

```php+HTML
<?php
if (! isset($_POST["enviar"]))
    header("Location: index2.php");

    include("funciones.php");
$completado = false;
$nombre = $_POST["nombre"];
$apellidos = $_POST["apellidos"];
$edad = $_POST["edad"];
$fecha = $_POST["fecha"];
$correo = $_POST["correo"];
$telefono = $_POST["telefono"];
$postal = $_POST["postal"];
$pass = $_POST["pass"];
$ciclo = $_POST["ciclo"];
$direccion = $_POST["direccion"];
$vNombre = comprobarNombre($nombre);
$vApellidos = comprobarNombre($apellidos);
$vEdad = true;
$vFecha=comprobarFecha($fecha);
$vCorreo = comprobarCorreo($correo);
if (! empty($telefono))
    $vTelefono = comprobarTelefono($telefono);
else
    $vTelefono = true;
if (! empty($postal))
    $vPostal = comprobarPostal($postal);
else
    $vPostal = true;
$vPass = comprobarPass($pass);
$vCiclo = true;
$vDireccion = true;
if ($vNombre && $vApellidos && $vEdad && $vFecha && $vCorreo && $vTelefono && $vPostal && $vPass && $vCiclo && $vDireccion) {
    $completado = true;
}
if (!$completado){
    header("Location: index2.php");
}

?>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body><?php

echo "<p>Datos:</p>";
echo "<ul>";
echo "<li>Nombre: $nombre</li>";
echo "<li>Apellidos: $apellidos</li>";
if (! empty($edad))
    echo "<li>Edad: $edad</li>";
echo "<li>Fecha: $fecha</li>";
echo "<li>Correo: $correo</li>";
if (! empty($telefono))
    echo "<li>Telefono: $telefono</li>";
if (! empty($postal))
    echo "<li>Postal: $postal</li>";
echo "<li>Pass: $pass</li>";
echo "<li>Ciclo: $ciclo</li>";
if (! empty($direccion))
    echo "<li>Direccion: $direccion</li>";
echo "</ul>";

?>
</body>
</html>
```
Captura o capturas de pantalla mostrando su funcionamiento:

Solución en un archivo:

```php+HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php
include("funciones.php");
$completado = false;
if (isset($_POST["enviar"])) {
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $edad = $_POST["edad"];
    $fecha = $_POST["fecha"];
    $correo = $_POST["correo"];
    $telefono = $_POST["telefono"];
    $postal = $_POST["postal"];
    $pass = $_POST["pass"];
    $ciclo = $_POST["ciclo"];
    $direccion = $_POST["direccion"];
    $vNombre=comprobarNombre($nombre);
    $vApellidos=comprobarNombre($apellidos);
    $vEdad = true;
    $vFecha=comprobarFecha($fecha);
    $vCorreo=comprobarCorreo($correo);
    if (! empty($telefono))
        $vTelefono=comprobarTelefono($telefono);
    else
        $vTelefono = true;
    if (! empty($postal))
        $vPostal=comprobarPostal($postal);
    else
        $vPostal = true;
    $vPass = comprobarPass($pass);
    $vCiclo = true;
    $vDireccion = true;
    if ($vNombre && $vApellidos && $vEdad && $vFecha && $vCorreo && $vTelefono && $vPostal && $vPass && $vCiclo && $vDireccion) {
        $completado = true;
    }
} else {
    $nombre = "";
    $apellidos = "";
    $edad = "";
    $fecha = "";
    $correo = "";
    $telefono = "";
    $postal = "";
    $pass = "";
    $ciclo = "";
    $direccion = "";
}
if ($completado) {
    echo "<p>Datos:</p>";
    echo "<ul>";
    echo "<li>Nombre: $nombre</li>";
    echo "<li>Apellidos: $apellidos</li>";
    if (! empty($edad))
        echo "<li>Edad: $edad</li>";
    echo "<li>Fecha: $fecha</li>";
    echo "<li>Correo: $correo</li>";
    if (! empty($telefono))
        echo "<li>Telefono: $telefono</li>";
    if (! empty($postal))
        echo "<li>Postal: $postal</li>";
    echo "<li>Pass: $pass</li>";
    echo "<li>Ciclo: $ciclo</li>";
    if (! empty($direccion))
        echo "<li>Direccion: $direccion</li>";
    echo "</ul>";
} else {
    ?>
    <h2>Introduzca sus datos personales.</h2>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		<table border="1">
			<tr>
				<td>Nombre: <input type="text" name="nombre" value="<?php echo $nombre; ?>" required></td>
				<td>Apellidos: <input type="text" name="apellidos" value="<?php echo $apellidos; ?>" required></td>
			</tr>
			<tr>
				<td>Edad: <input type="number" name="edad" min="18" max="120" value="<?php echo $edad; ?>"></td>
				<td>Fecha de Nacimiento: <input  name="fecha" value="<?php echo $fecha; ?>" required></td>
			</tr>
			<tr>
				<td>Correo: <input type="text" name="correo" value="<?php echo $correo; ?>" required></td>
				<td>Telefono móvil
				: <input type="number" name="telefono" value="<?php echo $telefono; ?>"></td>
			</tr>
			<tr>
				<td>Direccion: <input type="text" name="direccion" value="<?php echo $direccion; ?>"></td>
				<td>Codigo Postal: <input type="number" name="postal" min="" max="" value="<?php echo $postal; ?>"></td>
			</tr>
			<tr>
				<td>Contraseña: <input type="password" name="pass" value="<?php echo $pass; ?>"required placeholder="Min 8 caracteres, max 16. Minimo 1 mayuscula,minuscula y numero."></td>
				<td>Ciclo Formativo: <input type="text" name="ciclo" value="<?php echo $ciclo; ?>"required></td>
			</tr>
		</table>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
}
?>
</body>
</html>
```

Captura o capturas de pantalla mostrando su funcionamiento:
![Captura](Captura.png)

![Captura2](Captura2.png)

**Funciones**
```php+html
<?php
function comprobarCorreo($param) {
    $valido=false;

    if (!filter_var($param, FILTER_VALIDATE_EMAIL) === false) {
        $valido=true;
    }else{
        echo 'Correo no válido';
    }
    return $valido;
}
function comprobarFecha ($param) {

    $exp='/(0[1-9]|1[0-9]|2[0-9]|3[01])(-|\/)([1-9]|0[1-9]|1[012]).[0-9]{4}/';
    $valido=true;

    if ( !preg_match($exp, $param) ) {
        echo 'Fecha inválida';
        $valido=false;
    }
    return $valido;
}

function comprobarPostal ($param) {
    $regexPostal = '/(0[1-9]|5[0-2]|[0-4][0-9])[0-9]{3}/';
    $valido=true;

    if ( !preg_match($regexPostal, $param) ) {
        echo 'CP no válido';
        $valido=false;
    }
    return $valido;
}

function comprobarPass($param){
	$valido=true;
   if(strlen($param) < 8){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if(strlen($param) > 16){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[a-z]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[A-Z]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[0-9]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   return $valido;
}

function comprobarTelefono($param){
    $valido=false;
    $min = 600000000;
	$max = 799999999;
    if (!filter_var($param, FILTER_VALIDATE_INT,	array("options" => array("min_range"=>$min, "max_range"=>$max))) === false)
        $valido=true;

    return $valido;
}


function comprobarNombre($param){
	$valido=true;
    if (!preg_match("/^[a-zA-Z ]*$/",$param)) {
		echo "Se han introducido caracteres no validos en el nombre o los apellidos.";
		$valido=false;
	}
	return $valido;
}


?>
```
