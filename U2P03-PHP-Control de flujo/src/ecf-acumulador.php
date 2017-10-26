<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 8</title>
</head>
<body>
<a href="index.php">Volver</a>
<p>Ir pidiendo por formulario una serie de números enteros (de uno en uno) e irlos sumando. Se deja de 
pedir números al usuario cuando la cantidad supera el valor 50. Escribir entonces la suma de todos los 
números introducidos. Pista: para poder mantener el valor acumulado (antes de estudiar técnicas más avanzadas) 
utilizar un campo de formulario de tipo oculto (“hidden”).</p>
<?php
if (! isset($_POST["enviar"])) {
    $acumulador = 0;
    $numero = 0;
} else {
    
    
    $numero = $_POST["numero"];
    $acumulador = $_POST["acumulador"]+$numero;
    /*if (is_numeric($_POST["numero"])) {
        
    
    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    */
}
if ($acumulador > 50) {
        echo "<p>Valor del acumulador final: " . $acumulador . "</p>";
    } else {
        ?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
		Numero: <input type="text" name="numero"> 
		<input type="hidden" name="acumulador" value=<?php echo $acumulador?>> 
		<br /> 
		<input
			type="submit" name="enviar">
	</form>
		
	<?php
       echo "<p>Valor del acumulador: " . $acumulador . "</p>";
    
}
?>
</body>
</html>