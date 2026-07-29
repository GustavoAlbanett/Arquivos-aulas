<div style= "text-align: center">
<?php 

    if(isset($_GET['nome']) && trim($_GET['nome']) != ""){
        $nome = $_GET['nome'];
        echo "Olá, seja bem vindo $nome";
    }

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fomulario</title>
</head>
<body>
    
    <h2>Exemplo Formulario</h2>
    <form action ="formularios.php" method = "GET">     <!-- Cria uma tag formulario, Action define o arquivo que os dados serão processador e o method o método-->
        <label for="nome"> Seu nome: </label>
        <input type = "text" id = "nome" name= "nome">   <!-- Define o input do tipo texto que vai ser referenciado como nome no $_GET -->
        <button type = "submit">Enviar</button>            <!-- Cria um botão do tipo enviar-->
    </form>
    </div>
</body>
</html>