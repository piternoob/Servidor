<?php 
class Obra{
    private $idObra;
    private $idAutor;
    private $nombre;
    
    public function getIdObra(){
        return $this->idObra;
    }
    public function getIdAutor(){
        return $this->idAutor;
    }
    public function getNombre(){
        return $this->nombre;
    }
}
?>