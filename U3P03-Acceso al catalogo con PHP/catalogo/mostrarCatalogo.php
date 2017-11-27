<?php 
require "Obra.php"; 
?>
<html>
<head>
<title>Conexión a BBDD con PHP</title>
<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de animales</h2>
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
echo "<p>A continuación mostramos algunos registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>ID Libro</th>
<th>ID Autor</th>
<th>Nombre Libro</th>
<th>Nombre Autor</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT * from obra ORDER BY idObra");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while($obra=$resultado->fetch_object("Obra")) {
    echo "<tr style='background-color:lightgreen'>";
    echo "<td>".$obra -> getIdObra()."</td>";
    echo "<td>".$obra -> getIdAutor()."</td>";
    echo "<td>".$obra -> getNombre()."</td>";
    $resultado2=$conexion -> query("SELECT nombre from autor WHERE ".$obra -> getIdAutor()."=idAutor");
    $autor=$resultado2->fetch_assoc();
    echo "<td>$autor[nombre]</td>";
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