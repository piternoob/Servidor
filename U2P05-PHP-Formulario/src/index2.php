<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php
include("funciones.php");
if (!isset($_POST["enviar"])) {
    
$nombre = "";
$apellidos = "";
$edad = "";
$fecha = "";
$correo = "";
$telefono = "";
$postal = "";
$pass = "";
$ciclo = "";
$direccion = "";
}else{
    
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $edad = $_POST["edad"];
    $fecha = $_POST["fecha"];
    $correo = $_POST["correo"];
    $telefono = $_POST["telefono"];
    $postal = $_POST["postal"];
    $pass = $_POST["pass"];
    $ciclo = $_POST["ciclo"];
    $direccion = $_POST["direccion"];
}
    ?>
    <h2>Introduzca sus datos personales.</h2>
	<form action="validado.php" method="post">
		<table border="1">
			<tr>
				<td>Nombre: <input type="text" name="nombre" value="<?php echo $nombre; ?>" required></td>
				<td>Apellidos: <input type="text" name="apellidos" value="<?php echo $apellidos; ?>" required></td>
			</tr>
			<tr>
				<td>Edad: <input type="number" name="edad" min="18" max="120" value="<?php echo $edad; ?>"></td>
				<td>Fecha de Nacimiento: <input type="date" name="fecha" value="<?php echo $fecha; ?>" required></td>
			</tr>
			<tr>
				<td>Correo: <input type="text" name="correo" value="<?php echo $correo; ?>" required></td>
				<td>Telefono móvil
				: <input type="number" name="telefono" value="<?php echo $telefono; ?>"></td>
			</tr>
			<tr>
				<td>Direccion: <input type="text" name="direccion" value="<?php echo $direccion; ?>"></td>
				<td>Codigo Postal: <input type="number" name="postal" min="" max="" value="<?php echo $postal; ?>"></td>
			</tr>
			<tr>
				<td>Contraseña: <input type="password" name="pass" value="<?php echo $pass; ?>"required placeholder="Min 8 caracteres, max 16. Minimo 1 mayuscula,minuscula y numero."></td>
				<td>Ciclo Formativo: <input type="text" name="ciclo" value="<?php echo $ciclo; ?>"required></td>
			</tr>
		</table>
		<input type="submit" name="enviar" value="Enviar Datos">
	</form>
	<?php

?>
</body>
</html>