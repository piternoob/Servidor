<?php
include "header.php";
include "conexion.php";
include "Temas.php";


$mensajeError="";
$idioma="Is";

if(!isset($_REQUEST["disc"]))
    $mensajeError="No hay identificador.";
else{
    $disco=$_REQUEST["disc"];
    $resultado = $conexion->query("SELECT temas.nombre_i AS nombreIs, temas.nombre_e AS nombreEs, discos.id AS idDisco, nombre AS nombreDisco, discografica, year AS ano, soporte, imagen, texto, numero, minutos, segundos FROM discos, temas WHERE discos.id='$disco' AND discos.id=temas.id_disco ORDER BY numero");
}
if(isset($_POST["enviar"])){
    $idioma=$_POST["idioma"];

}
?>
<html>
<head>
	<meta charset="UTF-8">
	<title>Disco</title>
</head>
<body>
	<ol style='background-color:lightgreen'>
	<?php 
	if($resultado->num_rows === 0) echo "<p>No hay temas en la base de datos de ese tipo.</p>";
	$canciones=$resultado->fetch_object("Temas") ?>
		<li>Nombre del disco: <?php  echo $canciones -> getNombreDisco();?></li>
	    <li>Discográfica: <?php echo $canciones -> getDiscografica(); ?></li>
	    <li>Año: <?php echo $canciones -> getAno(); ?></li>
	    <li>Formato: <?php echo $canciones -> getSoporte(); ?></li>
	    <li><?php echo $canciones -> getImagen(); ?></li>
   </ol>
   <h2>Comentario:</h2>
   <p><?php echo $canciones -> getTexto(); ?></p>

	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
        Español: <input type="radio" name="idioma" value="ES"><img src="/Examen-1ev-PHP-Pedro%20Plaza%20Ramos/img/banderas/es.png" height=100px width=100px>
        Islandes <input type="radio" name="idioma" value="IS" checked="checked"><img src="/Examen-1ev-PHP-Pedro%20Plaza%20Ramos/img/banderas/is.png" height=100px width=100px>
        <input type="submit" value="Enviar" name="enviar">
    </form>

   	
	

   <h2>Listado de canciones:</h2>
   <table style='border:0'>
		<tr style='background-color:lightblue'>
			<th>Numero de Pista</th>
			<th>Titulo</th>
			<th>Duracion</th>
		</tr>
		
			<?php 
	        if($resultado->num_rows === 0) echo "<p>No hay temas en la base de datos de ese tipo.</p>";
	        while($canciones=$resultado->fetch_object("Temas")) { 
	            $id=$canciones -> getIdDisco(); ?>
	        	<tr style='background-color:lightgreen'>
	        	<td><?php echo $canciones -> getNumero();?></td>
	        	<td><?php 
	        	  //no funciona por el idioma
	        	  if($idioma=="Is")
	        	      echo $canciones -> getNombreIs(); 
	        	  else 
	        	    echo $canciones -> getNombreEs();
	        	?></td>
	        	<td>Minutos: <?php echo $canciones -> getMinutos(); ?>
	        	Segundos: <?php echo $canciones -> getSegundos(); ?></td>
	        	
        </tr>
        <?php 
    }
    ?>
    </table>
   <br/>
   <a href="index.php">Volver al listado de discos</a>
</body>
</html>