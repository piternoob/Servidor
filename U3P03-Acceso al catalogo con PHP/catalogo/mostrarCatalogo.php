<?php 
require "Obra.php"; 
$resultado="";
$orden ="";
$id="";
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
<th>Nombre Obra<a href="<?php echo $_SERVER['PHP_SELF']."?ordenObra=ASC"?>">&#9650</a><a href="<?php echo $_SERVER['PHP_SELF']."?ordenObra=DESC"?>">&#9660</a></th>
<th>Nombre Autor<a href="<?php echo $_SERVER['PHP_SELF']."?ordenAutor=ASC"?>">&#9650</a><a href="<?php echo $_SERVER['PHP_SELF']."?ordenAutor=DESC"?>">&#9660</a></th>
</tr>
<?php
if (! isset($_REQUEST["ordenObra"]) && ! isset($_REQUEST["ordenAutor"]) && !isset($_REQUEST["idAutor"]))
    $resultado = $conexion->query("SELECT idObra, obra.idAutor, obra.nombre AS nombre, autor.nombre AS nomAutor from obra,autor WHERE autor.idAutor=obra.idAutor ORDER BY idObra");
elseif (isset($_REQUEST["ordenObra"])) {
    $orden = $_REQUEST["ordenObra"];
    $resultado = $conexion->query("SELECT idObra, obra.nombre AS nombre, autor.nombre AS nomAutor from obra,autor WHERE autor.idAutor=obra.idAutor ORDER BY obra.nombre $orden");
} elseif (isset($_REQUEST["ordenAutor"])) {
    $orden = $_REQUEST["ordenAutor"];
    $resultado = $conexion->query("SELECT idObra, obra.nombre AS nombre, autor.nombre AS nomAutor from obra,autor WHERE autor.idAutor=obra.idAutor ORDER BY autor.nombre $orden");
} elseif(isset($_REQUEST["idAutor"])){
    $id=$_REQUEST['idAutor'];
    $_SESSION["idAutor"]=$id;
    echo "<p>$id</p>";
    $resultado = $conexion->query("SELECT idObra, obra.idAutor, obra.nombre AS nombre, autor.nombre AS nomAutor, autor.imagen AS imagenAutor from obra,autor WHERE obra.idAutor=$id AND obra.idAutor=autor.idAutor ORDER BY idObra");
    while($obra=$resultado->fetch_object("Obra")){
        echo "<tr style='background-color:lightgreen'>";
        echo "<td>Nombre Obra: " . $obra->getNombre() . "</td>";
        echo "<td>Nombre Autor: ".$obra->getNomAutor()."</td>";
        echo "<td>".$obra->getImagenAutor()."</td>";
        echo "</tr>";
        
    }
    
    echo "<a href='mostrarCatalogo.php'>Cerrar filtros</a>";
}

if(!isset($_SESSION["idAutor"])){
    if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
    while($obra=$resultado->fetch_object("Obra")) {
        echo "<tr style='background-color:lightgreen'>";
        echo "<td><a href='mostrarObra.php?idObra=".$obra -> getIdObra()."'>".$obra -> getNombre()."</a></td>";
        echo "<td><a href=mostrarCatalogo.php?idAutor=".$obra -> getIdAutor().">".$obra->getNomAutor()."</a></td>";
        echo "</tr>";
    }
echo "<a href='mostrarCatalogo.php'>Cerrar filtros</a>";
}
?>
</table>
<!-- <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	Introduce el identificador de un autor: <input type="text" name="autor" required>
	<input type="submit" name="enviar" value="Enviar Datos">
	</form>
-->
<?php
/*if(isset($_POST['enviar'])){
    $idAutor=$_POST['autor'];
    $resultadoAutor=$coenxion->query("SELECT idObra, obra.nombre AS nombre, autor.nombre AS nomAutor from obra,autor WHERE obra.idAutor=$idAutor ORDER BY idObra");
    if($resultado->num_rows === 0) echo "<p>No existe el autor en la base de datos</p>";
    while($obra=$resultado->fetch_object("Obra")) {
        echo "<tr style='background-color:lightgreen'>";
        echo "<td><a href='mostrarObra.php?idObra=".$obra -> getIdObra()."'>".$obra -> getNombre()."</a></td>";
        echo "<td>".$obra->getNomAutor()."</td>";
        echo "</tr>";
    }
}*/
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>