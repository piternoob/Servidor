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
<th>Nombre Libro</th>
<th>ID Autor</th>
<th>Nombre Autor</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT * from obra ORDER BY idObra");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while($fila=$resultado->fetch_assoc()) {
    echo "<tr style='background-color:lightgreen'>";
    echo "<td>$fila[idObra]</td>";
    echo "<td>$fila[nombre]</td>";
    echo "<td>$fila[idAutor]</td>";
    $resultado2=$conexion -> query("SELECT nombre from autor WHERE $fila[idAutor]=idAutor");
    $autor=$resultado2->fetch_assoc();
    echo "<td>$autor[nombre]</td>";
    echo "</tr>";
}
?>
</table>
<?php
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>