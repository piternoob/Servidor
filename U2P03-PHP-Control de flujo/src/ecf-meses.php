<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 7</title>
</head>
<body>
<a href="index.php">index.php</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Mes: <input type="text" name="mes">
    Bisiesto Sí<input type="radio" name="bisiesto" value="si">
    Bisiesto No<input type="radio" name="bisiesto" value="no">
    <input type="submit" name="enviar">
    <?php
    } else {
        $mes=$_POST["mes"];
        $bisiesto=$_POST["bisiesto"];
        $mes=strtolower($mes);
        switch ($mes) {
            case 1: case "enero":
            case 3: case "marzo":
            case 5: case "mayo":
            case 7: case "julio":
            case 8: case "agosto":
            case 10: case "octubre":
            case 12: case "diciembre":
                echo "<p>El mes tiene 31 días.</p>";
                
            break;
            case 2: case "febrero":
               
                if ($bisiesto=="si") {
                    echo "<p>El mes tiene 29 días.</p>";
                } else {
                   echo "<p>El mes tiene 28 días.</p>";
                }
                
                break;
                
             case 4: case "abril":
             case 6: case "junio":
             case 9: case "septiembre":
             case 11: case "noviembre":
                echo "<p>El mes tiene 30 días.</p>";
                break;
                 
            default:
                echo "<p>Error</p>";
            break;
        }
    }
    ?>
</body>
</html>