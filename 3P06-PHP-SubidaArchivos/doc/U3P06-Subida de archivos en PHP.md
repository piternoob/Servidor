###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U3P06 - Subida de archivos en PHP
#### Entrega de: *pon aquí tu nombre*
----
#### 1. Descripción:

El objetivo es practicar la subida de archivos al servidor utilizando PHP. En la primera parte se explica cómo se hace, y en la segunda se te pedirá que lo incluyas en la aplicación que hicimos en la práctica anterior.

#### 2. Formato de entrega:

Incluye en este u otro documento capturas que documenten tu trabajo y el código de tu aplicacion.

#### 3. Trabajo a realizar:

#### Parte 1: Subida de archivos

* Crea un nuevo proyecto PHP llamado U3P06-PHP-SubidaArchivos
* Crea la carpeta *upload* en el directorio de la aplicación
* Codifica un archivo PHP. En este caso utilizaremos un único archivo para presentar el formulario y resolver la subida del archivo, pero podrías separarlo en dos.

```php
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"/></head>
<body>

<form action="subir.php" method="post" enctype="multipart/form-data">
    <label>Escoger archivo:</label>
    <input type="file" name="archivo">
    <input type="submit" value="Subir archivo" name="enviar">
</form>

<?php


if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	$directorio = "upload/";
	$archivo = $directorio . basename($_FILES["archivo"]["name"]);
	$error = false;

	// Comprobar si ya existe
	if (file_exists($archivo)) {
		echo "<h3>Error, ya se ha subido ese archivo</h3>";
		$error = true;
	}

	// Comprobar extensiones
	$extension = pathinfo($archivo,PATHINFO_EXTENSION);
	echo "<h4>La extensión es $extension</h4>";
	if($extension == "jpg" || $extension == "png"
			|| $extension == "jpeg"	|| $extension == "gif" ) {
		echo "<h3>Error, el archivo es una imagen</h3>";
		$error = true;
	}

	// Comprobar tamaño de archivo
	$tamaño =$_FILES["archivo"]["size"];
	echo "<h4>El tamaño del archivo es $tamaño bytes</h4>";
	if ( $tamaño > 1000000) {
		echo "<h3>Error, el archivo es demasiado grande</h3>";
		$error = true;
	}

	// Subir el archivo
	if (!$error)
	{
		if (move_uploaded_file($_FILES["archivo"]["tmp_name"], $archivo)) {
			echo "<h3>El archivo ". basename( $_FILES["archivo"]["name"]). " ha sido subido al servidor.</h3>";
		} else {
			echo "<h3>Ocurrió un error al intentar subir el archivo.</h3>";
		}
	}

}
?>
```
* Prueba a visualizar esta página en diferentes navegadores. Observa que tenemos control sobre el texto `Subir archivo`, pero es el navegador quien se ocupa de escribir el texto del botón para seleccionar el archivo.
* El atributo `enctype` tiene por defecto el valor *application/x-www-form-urlencoded*. Esto hace que se codifiquen los caracteres de los campos del formulario antes de enviarlos: por ejemplo, los espacios en blanco se convierten a símbolos +. Sin embargo, si nuestro formulario contiene un campo de subida de archivo, debemos cambiar el valor del atributo a *multipart/form-data*. Y en todo caso el método debe ser *post*, puesto que vamos a enviar datos al servidor.
* Comprueba que la aplicación funciona
* Examina el código de comprobación de extensiones, y modifícalo para que sólo se permita subir documentos de Word (.doc o .docx)
* Examina el código de comprobación de tamaño: fuerza la aparición del error por intentar subir un archivo demasiado grande.
* Abre el archivo `/xampp/php/php.ini`, y localiza la sección *File upload*. Observa la siguiente directiva: `upload_max_filesize=2M`. Si intentas subir un archivo de más de 2 MB, no verás el mensaje de error de tu programa, sino que el propio servidor web impedirá la subida. Puedes modificar este valor para ajustar tus pruebas. Intenta hacer pruebas para forzar los dos mensajes de error: el de PHP y el de tu código.

#### Parte 2: Integración en una aplicación

Modifica tu aplicación de gestor de nombres para añadir la posibilidad de subir en cualquier momento un archivo de nombres: la aplicación continuará normalmente, pero utilizará a partir de ese momento el nuevo archivo subido.

En una primera aproximación, tú te ocuparás de que el archivo subido tenga exactamente el mismo nombre que el que tu aplicación consulta (por ejemplo "nombres.txt").

Cuando ya funcione, intenta que aunque el usuario suba un archivo con un nombre distinto, se escriba con el nombre que tú deseas. ¿Es posible?
