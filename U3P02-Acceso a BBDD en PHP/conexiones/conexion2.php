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
$conexion = new mysqli($servidor,$usuario,$clave,"animales");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";
echo "<p>Animales:</p>";
$resultado = $conexion -> query("select * FROM Animal ORDER BY Nombre");
if($resultado->num_rows === 0) 
    echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
    echo "<hr>";
    echo "Nombre:" . $fila['nombre'];
    echo "<br>Especie: $fila[especie]"; // observa la diferencia en el uso de comillas
    $fila=$resultado->fetch_assoc();
}
mysqli_free_result($resultado);
echo "<p>Cuidadores:</p>";
$resultado = $conexion -> query("select * FROM cuidador ORDER BY Nombre");
if($resultado->num_rows === 0)
    echo "<p>No hay cuidadores en la base de datos</p>";
    $fila=$resultado->fetch_assoc();
    while($fila!=null) {
        echo "<hr>";
        echo "Nombre:" . $fila['Nombre'];
        $fila=$resultado->fetch_assoc();
    }
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<ul>
<li><a href="conexion1.php">Conexión 1</a></li>
<li><a href="conexion3.php">Conexión 3</a></li>
<li><a href="conexion4.php">Conexión 4</a></li>
<li><a href="conexion5.php">Conexión 5</a></li>
<li><a href="conexion6.php">Conexión 6</a></li>
</ul>
</body>
</html>