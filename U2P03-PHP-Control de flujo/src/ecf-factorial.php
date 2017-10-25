<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 4</title>
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
        $factorial=1;
        if ($numero<0){
            $numero*=-1;
        }
        for($i=1; $i<=$numero; $i++){
            $factorial*=$i;
        }
        echo "<p>El factorial del número $numero es: $factorial</p>";
    }
    ?>
</form>
</body>
</html>