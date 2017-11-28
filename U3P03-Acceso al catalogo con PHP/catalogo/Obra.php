<?php 
class Obra{
    private $idObra;
    private $idAutor;
    private $nombre;
    private $imagen;
    
    public function getIdObra(){
        return $this->idObra;
    }
    public function getIdAutor(){
        return $this->idAutor;
    }
    public function getNombre(){
        return $this->nombre;
    }
    
    public function getImagen(){
        return $this->imagen;
    }
}
?>