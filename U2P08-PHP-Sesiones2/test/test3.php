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