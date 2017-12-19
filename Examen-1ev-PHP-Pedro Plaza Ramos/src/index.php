<?php
include "header.php";
include "conexion.php";
include "Temas.php";

session_name('sesion');
session_start();

if(isset($_REQUEST["borrarSesion"])){
    unset($_SESSION["admin"]);
    header("Location: index.php");
}

$tip="Álbumes";
$resultadoTipos = $conexion->query("SELECT DISTINCT tipo FROM discos");

if(isset($_REQUEST["tip"]))
    $tip=$_REQUEST["tip"];
$resultado = $conexion->query("SELECT discos.id AS idDisco, nombre AS nombreDisco, discografica, year AS ano, soporte, imagen FROM discos WHERE tipo='$tip'");
?>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
</head>
<body>
	<h2>Vamos a mostrar <?php echo $tip; ?></h2>
	<ul>
	<?php 
	if($resultadoTipos->num_rows === 0) echo "<p>No hay tipos de temas en la base de datos.</p>";
	   while($tipos=$resultadoTipos->fetch_object("Temas")) { ?>
			<li><a href="<?php echo $_SERVER['PHP_SELF']."?tip=".$tipos -> getTipo()?>"><?php echo $tipos -> getTipo(); ?></a></li><?php 
       }
    ?>
    
    </ul>
	<table style='border:0'>
		<tr style='background-color:lightblue'>
			<!-- 
			<th>Nombre Obra<a href="<?php echo $_SERVER['PHP_SELF']."?ordenObra=ASC"?>">&#9650</a><a href="<?php echo $_SERVER['PHP_SELF']."?ordenObra=DESC"?>">&#9660</a></th>
			<th>Nombre Autor<a href="<?php echo $_SERVER['PHP_SELF']."?ordenAutor=ASC"?>">&#9650</a><a href="<?php echo $_SERVER['PHP_SELF']."?ordenAutor=DESC"?>">&#9660</a></th>
			-->
			<th>Título</th>
			<th>Discografía</th>
			<th>Año</th>
			<th>Formato</th>
			<th>Imagen</th>
		</tr>
		
			<?php 
	        if($resultado->num_rows === 0) echo "<p>No hay temas en la base de datos de ese tipo.</p>";
	        while($canciones=$resultado->fetch_object("Temas")) { 
	            $id=$canciones -> getIdDisco(); ?>
	        	<tr style='background-color:lightgreen'>
	        	<td><?php echo $canciones -> getNombreDisco();?></td>
	        	<td><?php echo $canciones -> getDiscografica(); ?></td>
	        	<td><?php echo $canciones -> getAno(); ?></td>
	        	<td><?php echo $canciones -> getSoporte(); ?></td>
	        	<td><a href= "<?php echo "disco.php?disc=$id"; ?>"><?php echo $canciones -> getImagen(); ?></a></td>
	        	
        </tr>
        <?php 
    }
    ?>
    </table>
    <a href="admin-login.php">Enlace a admin-login</a>
</body>
</html>
