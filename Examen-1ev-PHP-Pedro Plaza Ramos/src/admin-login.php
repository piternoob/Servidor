<?php
include "header.php";
session_name('sesion');
session_start();

$pass="";
$user="";
$mensajeError="";
$mensaje="";

if(isset($_SESSION["admin"]))
    $mensaje="Bienvenido administrador.";

   

if (isset($_POST["enviar"])) {
    $pass = $_POST["pass"];
    $user=$_POST["user"];
    if($pass=="secreto" && $user=="admin"){
        $_SESSION["admin"]=1;
        header("Location:admin-login.php");
    }
    elseif(!empty($pass) && !empty($user))
        $mensajeError="Usuario incorrecto";
    }
    
?>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<?php if(!empty($mensajeError)) ?>
	<p><?php echo $mensajeError; ?></p>
<?php if(!empty($mensaje)) {?>
	<p><?php echo $mensaje;?></p>
	<?php }else{?>
<h3 style="color:red;">LOGIN </h3>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
        Usuario: <input type="text" name="user"><br>
        Contraseña <input type="password" name="pass"><br>
        <input type="submit" value="Enviar" name="enviar">
    </form>
    <?php }?>
    <a href="admin-baja.php">Ir a admin-baja</a>
	<a href="index.php?borrarSesion=true">Cerrar sesión y regresar a index</a>
</body>
</html>