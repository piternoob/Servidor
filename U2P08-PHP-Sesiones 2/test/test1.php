<?php
$vacio=false;
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (!isset($_SESSION["nombre"]))
    header("Location: registro.php");
    
if (isset($_POST["enviar"]))
    if (! empty($_POST["primera"]))
        if ($_POST["primera"] == "frozen") {
            $_SESSION["primera"] = "Pregunta correcta.";
            header("Location: test2.php");
        } else {
            $_SESSION["primera"] = "Pregunta incorrecta.";
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