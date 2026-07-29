<?php  // Criação da área de código do php

class Pessoa{
    public string $nome;
    public int $idade;
    public $altura;
    public $tipoS;

    public function __construct($nome, $idade, $altura, $tipoS){
        $this->nome = $nome;
        $this->idade = $idade;
        $this->altura = $altura;
        $this->tipoS = $tipoS;
    }

    public function Ola(){
        echo $this->nome . "\n" . $this->idade;
        print$this->altura . "\n";
        echo "\nOla $this->nome, Você tem $this->idade anos!";
    }

}

$p1 = new Pessoa("Gustavo", 19, 1.85, "O");

// resto = %
// == igual
// == igual e mesmo tipo

if($p1->idade >= 60){
    echo "\nVocê é idoso";
}
else if($p1->idade >= 18){
    echo "\nVocê é maior de idade";
}
else{
    echo "\nVocê é menor de idade";
}

/* 
também é possível especificar retorno e os tipos dos parâmetros

function Exemplo(int $num, string $nome): string {
    return $nome;
}
*/
function verificarSangue(string $tipoS){
    switch ($tipoS){
    case "O":
        echo "\nVocê é doador universal, mas só recebe de O";
        break;

    case "A":
        echo "\nVocê recebe de A e O, podendo doar para AB e A";
        break;

    case "B":
        echo "\nVocê recebe de B e O, podendo doar para AB e B";
        break;

    case "AB":
        echo "\nVocê é receptor universal, podendo doar apenas para AB";
        break;
    }
}
verificarSangue($p1->tipoS);

for($i = 1; $i <=3; $i++){
    echo "\nRepetição $i";
}

//Foreach
$nomes = ["Gustavo", "Arthur", "Ana"];
foreach($nomes as $pessoa){
    echo "\n" . $pessoa;
}

//Array associativo
$aluno = [
    "nome" => "Gustavo",
    "idade" => 19,
    "RA" => "000001-1"
];

//Foreach associativo
foreach($aluno as $chave => $valor){
    echo "\n$chave = $valor";
}


?>