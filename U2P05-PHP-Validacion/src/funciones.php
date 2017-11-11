<?php
function comprobarCorreo($param) {
    $valido=false;
    if (!filter_var($param, FILTER_VALIDATE_EMAIL) === false) {
        $valido=true;
    }else{
        echo 'Fecha no válida';
    }
    
    return $valido;
}
function comprobarFecha ($param) {
    $regexFecha = '/^([0-2][0-9]|3[0-1])(\/|-)(0[1-9]|1[0-2])\2(\d{4})(\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])$/';
    $valido=true;
    
    if ( !preg_match($regexFecha, $param) ) {
        echo 'Fecha no válida';
        $valido=false;
    }
    return $valido;
}

function comprobarPostal ($param) {
    $regexPostal = '/(0[1-9]|5[0-2]|[0-4][0-9])[0-9]{3}/';
    $valido=true;
    
    if ( !preg_match($regexPostal, $param) ) {
        echo 'CP no válido';
        $valido=false;
    }
    return $valido;
}

function comprobarFrase($param){
    $regexFrase='/^[a-zA-Z]+(\s*[a-zA-Z]*)*[a-zA-Z]+$/';
    $valido=true;
    
    if ( !preg_match($regexFrase, $param) ) {
        echo 'Campo inválido.';
        $valido=false;
    }
    return $valido;
}
function comprobarPalabra($param){
    $regexPalabra='//';
    $valido=true;
    
    
    if ( !preg_match($regexPalabra, $param) ) {
        echo 'Campo inválido.';
        $valido=false;
    }
    return $valido;
}

function comprobarPass($param){
    /*$valido;
    if (preg_match("/*\w*\c/", $param)) {
        $valido=false;
        echo "No es un numero";
    }else{
        $valido=true;
    }
    return  $valido;
    */
}

function comprobarTelefono($param){
    
}

function comprobarDireccion($param){
    
}
?>
