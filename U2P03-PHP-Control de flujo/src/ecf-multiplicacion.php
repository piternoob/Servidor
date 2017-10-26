<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 5</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y mostrar su tabla de multiplicar.</p>
    Número: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(is_numeric($_POST["numero"])) {
        $numero=$_POST["numero"];
        $multiplicacion;
        if($numero<0){
            $numero*=-1;
        }
        echo "<p>Tabla de multiplicar del $numero:</p>";
        for($i=0; $i<=10; $i++){
            $multiplicacion=$numero*$i;
            echo "<p>$numero x $i = $multiplicacion</p>";
        }
    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    ?>
</body>
</html>