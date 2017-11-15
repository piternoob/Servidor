<?php
if (! isset($_POST["enviar"]))
    header("Location: index2.php");

    include("funciones.php");
$completado = false;
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
$vNombre = comprobarNombre($nombre);
$vApellidos = comprobarNombre($apellidos);
$vEdad = true;
$vFecha=comprobarFecha($fecha);
$vCorreo = comprobarCorreo($correo);
if (! empty($telefono))
    $vTelefono = comprobarTelefono($telefono);
else
    $vTelefono = true;
if (! empty($postal))
    $vPostal = comprobarPostal($postal);
else
    $vPostal = true;
$vPass = comprobarPass($pass);
$vCiclo = true;
$vDireccion = true;
if ($vNombre && $vApellidos && $vEdad && $vFecha && $vCorreo && $vTelefono && $vPostal && $vPass && $vCiclo && $vDireccion) {
    $completado = true;
}
if (!$completado){
    header("Location: index2.php");
}

?>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body><?php

echo "<p>Datos:</p>";
echo "<ul>";
echo "<li>Nombre: $nombre</li>";
echo "<li>Apellidos: $apellidos</li>";
if (! empty($edad))
    echo "<li>Edad: $edad</li>";
echo "<li>Fecha: $fecha</li>";
echo "<li>Correo: $correo</li>";
if (! empty($telefono))
    echo "<li>Telefono: $telefono</li>";
if (! empty($postal))
    echo "<li>Postal: $postal</li>";
echo "<li>Pass: $pass</li>";
echo "<li>Ciclo: $ciclo</li>";
if (! empty($direccion))
    echo "<li>Direccion: $direccion</li>";
echo "</ul>";

?>
</body>
</html>