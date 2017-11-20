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