<?php

session_name("autenticacion");
session_start();

$_SESSION["login"]=0;
  $_SESSION["usuario"]="";

  
   header("Location:login.php");

  
  ?>