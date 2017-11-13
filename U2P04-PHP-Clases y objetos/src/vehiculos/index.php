<!doctype html>
<html>
<head>
	<title>Objetos</title>
	<meta charset="UTF-8"/>
	<meta name="author" content="Pedro Plaza Ramos"/>
</head>
<body>
<?php
include("clases.php");
if(!isset($_POST["enviar"])){
?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	Matricula: <input type="text" name="matricula" required>
	<br/>
	Color: <input type="text" name="color" required>
	<br/>
	Marca: <input type="text" name="marca" required>
	<br/>
	Modelo: <input type="text" name="modelo" required>
	<br/>
	<input type="submit" name ="enviar">
	</form>
	<?php 
} else {
    $matricula=$_POST["matricula"];
    $color=$_POST["color"];
    $marca=$_POST["marca"];
    $modelo=$_POST["modelo"];
    $vehiculo=new Coche($matricula, $color, $marca, $modelo);
    echo $vehiculo;
    
}
?>
</body>
</html>