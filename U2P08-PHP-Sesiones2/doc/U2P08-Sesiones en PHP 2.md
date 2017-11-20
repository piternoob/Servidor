###### *Desarrollo Web en Entorno Servidor - Curso 20176/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P08 - Sesiones en PHP 2
----
#### 1. Descripción:

Vamos a aplicar nuestros conocimientos de sesiones en PHP para resolver dos problemas.

#### 2. Formato de entrega:

Incluye el código generado y capturas de la ejecución, o bien muestra tu trabajo al profesor.

#### 3. Trabajo a realizar:

Crea un proyecto PHP para esta actividad. Cada parte se resolverá en una carpeta: 'saludo' y 'test'

##### Parte 1: Saludo

1. Crea un archivo `saludo.php` y codifica un único archivo PHP con el siguiente comportamiento:
   * Si no hay sesión iniciada, se mostrará un formulario para pedir nuestro nombre. Al enviar el formulario se iniciará una sesión almacenando el nombre como variable de sesión
   * Si hay sesión iniciada, se mostrará un texto como este: *Damos la bienvenida a Alberto*

Se sugiere el siguiente esquema para el archivo. Recuerda que todo el código relativo a cookies, sesiones y redirecciones se debe incluir antes de emitir código HTML:

* Antes de escribir la cabecera HTML
    * Recuperar la sesión actual o crear una nueva
    * Inicializar vacía una variable de mensaje de error
    * Si el usuario ha enviado el formulario...
      * ¿El campo de usuario del formulario está vacío?
          * Sí: Actualizar la variable de error con un mensaje explicativo
          * No: Crear una variable de sesión con el nombre del usuario
* Después de la cabecera HTML
    * ¿Tiene valor la variable de sesión que contiene al usuario?
        * Sí: Mostrar el saludo al usuario
        * No: Mostrar un formulario para introducir tu nombre

    * Si el mensaje de error no está vacío, escribirlo

        ​

Cuando lo tengas funcionando, añade un enlace de "cerrar sesión" para "olvidar" al usuario. El enlace se construirá con un parámetro *cerrarSesion=true*. El posible procesamiento de este parámetro será ahora lo primero que hagas en tu programa.

```PHP
<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
    $error = "";
}
if (isset($_REQUEST["cerrarSesion"]))
    $_SESSION=array();

if (isset($_POST["enviar"]))
    if (empty($_POST["nombre"]))
        $error= "Nombre vacío.";
    else
        $_SESSION["nombre"] = $_POST["nombre"];
?>
<html>
<head>
<title>Sesiones 2</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php
if (isset($_SESSION["nombre"])) {
    ?><h3><?php echo "Hola $_SESSION[nombre]";?></h3>
    <p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
    <?php
} else{
    ?>
    <form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Introduce tu nombre: <input type="text" name="nombre"> <input
			type="submit" name="enviar" value="Enviar Datos">
	</form>
    <?php
}
if(!empty ($error)){
    echo $error;
}
?>


</body>
</html>
```

##### Parte 2: Test

En este caso vamos a trabajar con varias páginas. El objetivo es presentar al usuario un test con tres preguntas: una de cine o televisión, otra de música y otra de literatura. Tú escoges las preguntas: cada una ofrecerá tres posibilidades de respuesta. Te puede ayudar poner un fondo de colores diferentes para cada pregunta.

En esta práctica se incluye un plan, pero menos detallado. Se trata de una práctica importante porque vemos una aplicación compleja, compuesta por más de una página, en la que intervienen varios formularios.

Pista: para saber en qué fase del juego está el usuario, tienes dos alternativas que puedes combinar:

* Llevar una variable de sesión que indique en qué fase del juego estás
* Tener una variable para almacenar la respuesta de cada fase: consultando si tienen valor sabrás en qué fase estamos

Debes crear los siguientes archivos:

* `index.php`: Si no hay sesión redirigimos a `registro.php`. Si la hay, obtenemos su nombre de la sesión, le damos la bienvenida con su nombre, y aportamos un enlace para comenzar el test. Este enlace accede a `test1.php`.
```PHP
<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (!isset($_SESSION["nombre"]))
    header("Location: registro.php");

?>
<html>
<head>
	<title>Index</title>
	<meta charset="UTF-8">
</head>
<body>
<?php echo "<h3>Bienvenido $_SESSION[nombre].</h3>"; ?>
<a href="test1.php">Enlace a la primera pregunta.</a>
</body>
</html>
```
* `registro.php`: Si ya hay sesión iniciada se redirige directamente a `index.php`. En caso contrario se muestra un formulario pidiendo nuestro nombre. El formulario es procesado por este mismo archivo: su misión será iniciar la sesión y crear una variable para almacenar el nombre del usuario.
```PHP
<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
    $error="";
}

if (isset($_POST["enviar"]))
    if (empty($_POST["nombre"]))
        $error = "Nombre no válido.";
    else
        $_SESSION["nombre"] = $_POST["nombre"];

if (isset($_SESSION["nombre"]))
    header("Location: index.php");
?>
<html>
<head>
<title>Registro</title>
<meta charset="UTF-8">
</head>
<body>

	<form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Introduce tu nombre: <input type="text" name="nombre">
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
if(!empty($error)){
    echo "<h2>$error</h2>";
}
?>
</body>
</html>
```
* `test1.php`: si no hay sesión iniciada se redirige a `registro.php`. Si la hay, se muestra la pregunta. El formulario será procesado por esta misma página: se almacenará el acierto o fallo de esta pregunta en sesión (sin decirle aún nada al usuario) y se redirigirá a la siguiente página de test.
```PHP
<?php
$vacio=false;
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (! isset($_SESSION["nombre"]))
    header("Location: registro.php");

if (isset($_POST["enviar"]))
    if (! empty($_POST["primera"]))
        if ($_POST["primera"] == "frozen") {
            $_SESSION["primera"] = "Correcta.";
            header("Location: test2.php");
        } else {
            $_SESSION["primera"] = "Incorrecta.";
            header("Location: test2.php");
        }
    else
        $vacio = true;
?>
<html>
<head>
<title>Test 1</title>
<meta charset="UTF-8">
</head>
<body>
	<p>Pregunta 1:</p>
	<p>¿De qué película es la canción de "hazme un muñeco de nieve"?</p>
	<form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Ice Age 2<input type="radio" name="primera" value="age"><br/>
		El Rey Leon <input type="radio" name="primera" value="leon"><br/>
		Frozen <input type="radio" name="primera" value="frozen"><br/>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
if ($vacio){
    echo "<h2>Debes elegir una opción.</h2>";
}
?>
</body>
</html>
```
* `test2.php`: Igual que la anterior, pero se debe comprobar no sólo que estemos registrados sino que hayamos respondido ya la primera pregunta, en otro caso seremos redireccionados a la página adecuada.
```PHP
<?php
$vacio = false;
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (! isset($_SESSION["nombre"]))
    header("Location: registro.php");

if (! isset($_SESSION["primera"]))
    header("Location: test1.php");

if (isset($_POST["enviar"]))
    if (! empty($_POST["segunda"]))
        if ($_POST["segunda"] == "siete") {
            $_SESSION["segunda"] = "Correcta.";
            header("Location: test3.php");
        } else {
            $_SESSION["segunda"] = "Incorrecta.";
            header("Location: test3.php");
        }
    else
        $vacio = true;

?>
<html>
<head>
<title>Test 2</title>
<meta charset="UTF-8">
</head>
<body>
	<p>Pregunta 2:</p>
	<p>¿Cuántos libros tiene la saga de Harry Potter?</p>
	<form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		6<input type="radio" name="segunda" value="seis"><br/>
		7<input type="radio" name="segunda" value="siete"><br/>
		8<input type="radio" name="segunda" value="ocho"><br/>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
if ($vacio){
    echo "<h2>Debes elegir una opción.</h2>";
}
?>
</body>
</html>
```
* `test3.php`: Igual que la anterior (podrías añadir más páginas de preguntas si lo deseas). En este caso al procesar la respuesta se redirigirá a `resultados.php`
```PHP
<?php
$vacio=false;
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (!isset($_SESSION["nombre"]))
    header("Location: registro.php");

if (! isset($_SESSION["primera"]))
        header("Location: test1.php");

if (! isset($_SESSION["segunda"]))
            header("Location: test2.php");

if (isset($_POST["enviar"]))
    if (! empty($_POST["tercera"]))
        if ($_POST["tercera"] == "pt") {
            $_SESSION["tercera"] = "Correcta.";
            header("Location: resultados.php");
        } else {
            $_SESSION["tercera"] = "Incorrecta.";
            header("Location: resultados.php");
        }
    else
        $vacio = true;

?>
<html>
<head>
<title>Test 3</title>
<meta charset="UTF-8">
</head>
<body>
	<p>Pregunta 3:</p>
	<p>¿Quién país ganó Eurovisión el año pasado?</p>
	<form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Portugal<input type="radio" name="tercera" value="pt"><br/>
		España<input type="radio" name="tercera" value="es"><br/>
		Francia<input type="radio" name="tercera" value="fr"><br/>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
if ($vacio){
    echo "<h2>Debes elegir una opción.</h2>";
}
?>
</body>
</html>
```
* `resultados.php`: Como siempre, si no hay sesión o nos faltan preguntas por responder, seremos redireccionados. En otro caso mostraremos el número de respuestas acertadas al usuario. Incluiremos un enlace para comenzar de nuevo (en este caso borraremos la sesión y redireccionaremos a `registro.php`)
```PHP
<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (isset($_REQUEST["cerrarSesion"]))
    $_SESSION=array();

if (! isset($_SESSION["nombre"]))
    header("Location: registro.php");

if (! isset($_SESSION["primera"]))
    header("Location: test1.php");

if (! isset($_SESSION["segunda"]))
    header("Location: test2.php");

if (! isset($_SESSION["tercera"]))
    header("Location: test3.php");
?>
<html>
<head>
<title>Resultados</title>
<meta charset="UTF-8">
</head>
<body>
	<?php echo "<p>Estos son tus resultados $_SESSION[nombre] :</p>"; ?>
	<ul>
		<li>Pregunta 1: <?php echo $_SESSION["primera"]; ?></li>
		<li>Pregunta 2: <?php echo $_SESSION["segunda"]; ?></li>
		<li>Pregunta 3: <?php echo $_SESSION["tercera"]; ?></li>
	</ul>
	<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
</body>
</html>
```
