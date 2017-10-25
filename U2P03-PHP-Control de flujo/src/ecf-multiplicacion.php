<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 5</title>
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
        $multiplicacion;
        if($numero<0){
            $numero*=-1;
        }
        echo "<p>Tabla de multiplicar del $numero:</p>";
        for($i=0; $i<=10; $i++){
            $multiplicacion=$numero*$i;
            echo "<p>$numero x $i = $multiplicacion</p>";
        }
    }
    ?>
</body>
</html>