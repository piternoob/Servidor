<!doctype html>
<html>
<head>
	<title>Objetos</title>
	<meta charset="UTF-8"/>
	<meta name="author" content="Pedro Plaza Ramos"/>
</head>
<body>
<?php 
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
    echo $_POST["base"]." ".$_POST["altura"];
}
?>
</body>
</html>