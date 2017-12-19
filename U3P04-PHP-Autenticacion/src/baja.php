<?php

session_name("autenticacion");
session_start();

$mensajeError="";

$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
$conexion->query("SET NAMES 'UTF8'");



if(isset($_POST["enviar"])){
	
	if($_POST["pass"]=="")
		$mensajeError.="Contraseña vacia. ";
	else{
		
			$resultado = $conexion->query('SELECT login,password FROM usuario WHERE login="'.$_SESSION["usuario"].'" AND password="'.$_POST["pass"].'"');

	
	if ($resultado->num_rows !=1)
		$mensajeError.="Usuario no encontrado o contraseña incorrecta. ";
	else
		if ($conexion->query("delete from `usuario` where login='".$_SESSION["usuario"]."'")===TRUE)
			header("Location:logout.php");
		else
			$mensajeError.=$conn->error;
	}
}
?>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h3 style="color:red;">BAJA </h3>

<h3><?php if ($mensajeError!="") echo $mensajeError ?></h3>
    <form action="./baja.php" method="POST">
        Contraseña <input type="password" name="pass"><br>
        <input type="submit" value="Enviar" name="enviar">
    </form>

</body>
</html>




