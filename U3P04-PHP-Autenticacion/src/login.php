<?php

    session_name("autenticacion");
    session_start();
    $mensaje="Sesion no iniciada";
	
	
	
if(isset($_SESSION["login"]))
	if($_SESSION["login"]==1){
		header("Location:index.php");
	}

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
$conexion->query("SET NAMES 'UTF8'");

$mensajeError="";
$pass="";
$user="";







if (isset($_POST["enviar"])) {

    $pass = $_POST["pass"];
    $user=$_POST["user"];
    $resultado = $conexion->query('SELECT login,password FROM usuario WHERE login="'.$user.'" AND password="'.$pass.'"');
    if ($resultado->num_rows === 1) {
        $log= $resultado->fetch_assoc();


        if ($pass == $log["password"])
            $_SESSION["login"]=1;
            $_SESSION["usuario"]=$user;
            header("Location:index.php");
        } else{
            $mensajeError="La contraseña no coincide.";
            echo "$mensajeError";
        }

}
?>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h3 style="color:red;">LOGIN </h3>
    <form action="./login.php" method="POST">
        Usuario: <input type="text" name="user"><br>
        Contraseña <input type="password" name="pass"><br>
        <input type="submit" value="Enviar" name="enviar">
    </form>
<a href="alta.php">Haz click aqui para crear una nueva cuenta.</a>
</body>
</html>
