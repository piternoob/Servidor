<?php
include "header.php";
include "Temas.php";
session_name('sesion');
session_start();
if(!isset($_SESSION["admin"])){
    header("Location: admin-login.php");
}
?>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<a href="admin-login.php">Regresar a admin-login</a>
</body>
</html>