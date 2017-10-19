<html>
<head></head>
<body>
	<!-- pregunta 18 -->
	<?php 
	if(!isset($_POST["enviar"])){
	?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		Nombre: <input type="text" name="nombre">
		<input type="submit" name="enviar">
	<?php 
	} else {
	    echo "<p>Bienvenido ".$_POST["nombre"].".</p>";
	}
	?>
	</form>
</body>
</html>