<?php 
require "Obra.php"; 
?>
<html>
<head>
<title>Conexión a BBDD con PHP</title>
<meta charset="utf-8"/>
</head>
<body>
<h2>Mi base de datos</h2>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
?>
<!-- PRUEBAS: -->
<?php
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo10");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos los registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>ID Obra</th>
<th>ID Autor</th>
<th>Nombre Obra</th>
<th>Imagen Obra</th>
<th>Nombre Autor</th>
<th>Imagen Autor<th>
</tr>
<?php
$imagen="/U3P03-Acceso%20al%20catalogo%20con%20PHP/img/";
$resultado = $conexion -> query("SELECT * from obra ORDER BY idObra");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while($obra=$resultado->fetch_object("Obra")) {
    echo "<tr style='background-color:lightgreen'>";
    echo "<td>".$obra -> getIdObra()."</td>";
    echo "<td>".$obra -> getIdAutor()."</td>";
    echo "<td>".$obra -> getNombre()."</td>";
    $img=$obra->getImagen();
    echo "<td><img src=$imagen$img height=200px width=200px></td>";
    $resultado2=$conexion -> query("SELECT * from autor WHERE ".$obra -> getIdAutor()."=idAutor");
    $autor=$resultado2->fetch_assoc();
    echo "<td>$autor[nombre]</td>";
    echo "<td><img src=$imagen$autor[imagen] height=200px width=200px></td>";
    echo "</tr>";
    mysqli_free_result($resultado2);
}
?>
</table>
<?php
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>