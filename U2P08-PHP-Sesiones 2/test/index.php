<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
}

if (!isset($_SESSION["nombre"]))
    header("Location: registro.php");
    else
        $correcto=true;
?>
<html>
<head>
	<title>Index</title>
	<meta charset="UTF-8">
</head>
<body>
<?php 
if($correcto){
    echo "<h3>Bienvenido $_SESSION[nombre].</h3>";
    echo '<a href="test1.php">Enlace a la primera pregunta.</a>';
}
?>
</body>
</html>
