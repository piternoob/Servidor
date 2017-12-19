<?php

session_name("autenticacion");
session_start();

$mensajeError="";

$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
$conexion->query("SET NAMES 'UTF8'");
$user="";




if(isset($_POST["enviar"])){
	$user=$_POST["user"];
	$resultado = $conexion->query('SELECT login FROM usuario WHERE login="'.$user.'"');
	
	
	
	if ($resultado->num_rows === 1)
		$mensajeError.="Usuario repetido. ";
	else
	if($_POST["pass"]=="")
		$mensajeError.="Contraseña vacia. ";
	else
	if($_POST["user"]=="")
		$mensajeError.="Usuario vacio. ";
	else{
		$sql="INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES ('".$user."', '".$_POST["pass"]."', '".$user."', '0', NULL)";
		if ($conexion->query($sql)===TRUE)
			header("Location:login.php");
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
<h3 style="color:red;">ALTA </h3>



<h3><?php if ($mensajeError!="") echo $mensajeError ?></h3>

    <form action="./alta.php" method="POST">
        Usuario: <input type="text" name="user"><br>
        Contraseña <input type="password" name="pass"><br>
        <input type="submit" value="Enviar" name="enviar">
    </form>
	<a href="login.php">Haz click aqui para iniciar sesion.</a>

</body>
</html>




