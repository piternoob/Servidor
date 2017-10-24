<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 1</title>
</head>
<body>
<a href="index.php">index.php</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Número 1: <input type="text" name="menor">
    Número 2: <input type="text" name="mayor">
    <input type="submit" name="enviar">
    <?php
    } else {
        $menor=$_POST["menor"];
        $mayor=$_POST["mayor"];
        $aux;
        $auxMenor;
        $auxMayor;
        echo "<p>Numeros elegidos: $menor y $mayor.</p>";
        if ($mayor<$menor){
            $aux=$menor;
            $menor=$mayor;
            $mayor=$aux;
        }
        $auxMenor=$menor;
        $auxMayor=$mayor;
        while($mayor!=$menor){
            echo "<p>*</p>";
            $mayor--;
        }
        for ($i=$auxMenor; $i<$auxMayor; $i++){
            echo "<p>*</p>";
        }
    }
    ?>
</form>
</body>
</html>