<?php
class Triangulo{
    private $base=0;
    private $altura=0;
    private $area="No hay área definida todavía.";
    
    public function __construct($base, $altura){
           $this->base=$base;
           $this->altura=$altura;
    }
    
    public function __toString(){
        return "<p>Datos del triángulo: base=".$this->base.", altura=".$this->altura.", area=".$this->area.".</p>";
    }
    
    public function calcularArea(){
        $this->area=$this->base*$this->altura/2;
    }
    
}
?>