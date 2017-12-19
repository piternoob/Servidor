<?php

session_name("autenticacion");
session_start();
$mensaje="Sesion no iniciada";

if($_SESSION["login"]!=1){
    header("Location:login.php");
}
$mensajeError="";

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
$conexion->query("SET NAMES 'UTF8'");




$resultado = $conexion->query('SELECT login,nombre FROM usuario WHERE login="'.$_SESSION["usuario"].'"');
if ($resultado->num_rows === 0)
header("Location:logout.php");
else{
    $log= $resultado->fetch_assoc();
	$nom=$log["nombre"];
}

?>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h3 style="color:red;">INDEX </h3>

<p>Hola <?php echo $nom ?></p>
<a href="baja.php">Haz click aqui para borrar la cuenta.</a>

<a href="logout.php">Haz click aqui para cerrar sesion.</a>

</body>
</html>




