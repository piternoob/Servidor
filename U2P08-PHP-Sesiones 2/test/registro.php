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
else
    $mostrar = true;
?>
<html>
<head>
<title>Registro</title>
<meta charset="UTF-8">
</head>
<body>
<?php
if ($mostrar) {
    ?>
	<form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Introduce tu nombre: <input type="text" name="nombre"> 
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php
}
if(!empty($error)){
    echo "<h2>$error</h2>";
}
?>
</body>
</html>