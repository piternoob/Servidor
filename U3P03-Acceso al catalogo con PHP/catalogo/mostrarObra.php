<?php 
require "Obra.php"; 
?>
<html>
<head>
<title>Conexión a BBDD con PHP</title>
<meta charset="UTF-8"/>
</head>
<body>
<h2>Mostrar datos de las obras:</h2>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";

if (!isset($_REQUEST["idObra"])){
    echo "<h3>Desconectando...</h3>";
    mysqli_close($conexion);
    echo "<a href='mostrarCatalogo.php'>Volver</a>";
    die ("<h3>ERROR en la petición. Falta identificador de la obra</h3>");
    
}
$id = $_REQUEST["idObra"];
$imagen = "/U3P03-Acceso%20al%20catalogo%20con%20PHP/img/";
// $resultado = $conexion -> query("SELECT * from obra ORDER BY idObra");
$resultado = $conexion->query("SELECT * from obra WHERE idObra=$id");
if ($resultado->num_rows === 0)
    echo "<p>No hay obras en la base de datos</p>";
else{
$obra=$resultado->fetch_object("Obra");
echo "<p>Id Obra: " . $obra->getIdObra() . "</p>";
echo "<p>Id Autor: " . $obra->getIdAutor() . "</p>";
echo "<p>Nombre Obra: " . $obra->getNombre() . "</p>";
$img = $obra->getImagen();
echo "<p><img src=$imagen$img height=200px width=200px></p>";
$resultado2 = $conexion->query("SELECT * from autor WHERE " . $obra->getIdAutor() . "=idAutor");
$autor = $resultado2->fetch_assoc();
echo "<p>Nombre Autor: $autor[nombre]</p>";
echo "<p><img src=$imagen$autor[imagen] height=200px width=200px></p>";
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
echo "<a href='mostrarCatalogo.php'>Volver</a>";
?>
</body>
</html>

</body>
</html>