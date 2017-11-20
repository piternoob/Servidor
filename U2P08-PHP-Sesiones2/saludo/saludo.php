<?php
if (session_status() == PHP_SESSION_NONE) {
    session_name('sesion');
    session_start();
    $error = "";
}
if (isset($_REQUEST["cerrarSesion"]))
    $_SESSION=array();

if (isset($_POST["enviar"]))
    if (empty($_POST["nombre"]))
        $error= "Nombre vacío.";
    else
        $_SESSION["nombre"] = $_POST["nombre"];
?>
<html>
<head>
<title>Sesiones 2</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php
if (isset($_SESSION["nombre"])) {
    ?><h3><?php echo "Hola $_SESSION[nombre]";?></h3>
    <p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
    <?php
} else{
    ?>
    <form
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		Introduce tu nombre: <input type="text" name="nombre"> <input
			type="submit" name="enviar" value="Enviar Datos">
	</form>
    <?php 
}
if(!empty ($error)){
    echo $error;
}
?>


</body>
</html>