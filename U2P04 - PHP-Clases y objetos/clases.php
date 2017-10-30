<?php
class Triangulo{
    private $base;
    private $altura;
    
    public function __construct($base, $altura){
           $this->base=$base;
           $this->altura=$altura;
    }
    
    public function getAltura(){
        return $this->altura;
    }
    
    public function getBase(){
        return $base;
    }
    
    /*
    public function setBase($base){
        $this->base =$base;
    }
    
    public function setAltura($altura){
        $this->altura =$altura;
    }
    */
}
?>