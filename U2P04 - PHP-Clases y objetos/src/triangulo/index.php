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
	Base: <input type="number" name="base" required>
	<br/>
	Altura: <input type="number" name="altura" required>
	<br/>
	<input type="submit" name ="enviar">
	</form>
	<?php 
} else {
    $base=$_POST["base"];
    $altura=$_POST["altura"];
    $triangulo=new Triangulo($base, $altura);
    echo $triangulo;
    echo $triangulo->calcularArea();
    echo $triangulo;
    
}
?>
</body>
</html>