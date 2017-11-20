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