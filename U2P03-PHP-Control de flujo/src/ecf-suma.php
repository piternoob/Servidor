<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 2</title>
</head>
<body>
<a href="index.php">index.php</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Número: <input type="text" name="numero">
    <input type="submit" name="enviar">
    <?php
    } else {
        $numero=$_POST["numero"];
        $suma=0;
        if($numero<0) {
            $numero*=-1;
        }
        for ($i=0; $i<=$numero;$i++){
           $suma+=$i;
        }
        echo "<p>La suma de los $numero primeros números es: $suma</p>";
    }
    ?>
</form>
</body>
</html>