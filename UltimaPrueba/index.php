<?php
$nombre="Pedro";
$apellido="Plaza";
echo "<h1>Funciona</h1>\n";
echo "<h3>Comillas dobles: Mi nombre $nombre y mi apellido $apellido</h3>\n";
echo '<h2>Comillas simples: Mi nombre $nombre y mi apellido $apellido</h2>';
define("NOMBRE", "Pedro Plaza");
echo "<p>Mi nombre es ".Nombre."</p>";
define("NOMBRE", "Pedro Plaza", true);
echo "<p>Mi nombre es ".Nombre."</p>";
?>