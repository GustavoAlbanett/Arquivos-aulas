<?php 
// conexão banco de dados
{
    $host = "bo9m0gim6u6i5eoicow2-mysql.services.clever-cloud.com";
    $user = "ubmohnfap3nnmhx9";
    $senha = "N4n4OXxBxqGYiAk2zxr6";
    $banco = "bo9m0gim6u6i5eoicow2";
}
    $conexao = new mysqli($host, $user, $senha, $banco);

    if($conexao->connect_error){
        die("Falha na conexão com o banco " . $conexao->connect_error);
    }

    $tarefas = [];

    //Pegar tarefas do banco
    $sqlSelect  = "SELECT * FROM tarefas ORDER BY data_criacao DESC";
    $result = $conexao->query($sqlSelect);

    if($result->num_rows > 0){
        while($row = $result->fetch_assoc()){
            $tarefas[] = $row;
        }
    }

    // criar tarefas
    if($_SERVER['REQUEST_METHOD'] === "POST" && isset($_POST['descricao'])){
        $descricao = trim($conexao->real_escape_string($_POST['descricao']));

        if($descricao == ""){
            header("Location: todoList.php");
            exit;
        }

        $sqlInsert = "INSERT INTO tarefas (descricao) VALUES ('$descricao')";

        if($conexao->query($sqlInsert) === TRUE){
            header("Location: todoList.php");
            exit;
        }
    }

    // excluir tarefas
    if(isset($_GET['delete'])){
        $id = intval($_GET['delete']);
    
        $sqlDelete = "DELETE FROM tarefas WHERE id = $id";

        if($conexao->query($sqlDelete) === TRUE){
            header("Location: todoList.php");
            exit;
        }
    }

    // update de tarefas
    if(isset($_GET['update']) && isset($_POST['updatevalue'])){

        $id = intval($_GET['update']);
        $novadesc = trim($conexao->real_escape_string($_POST['updatevalue']));

        $sqlUpdate = "UPDATE tarefas SET descricao = '$novadesc' WHERE id = $id";

        if($conexao->query($sqlUpdate) === TRUE){
            header("Location: todoList.php");
            exit;
        }
    }


?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TodoList</title>
</head>
<body>
    <h1>Todo List</h1>

    <form action = "todoList.php" method = "POST">
        <input type="text" placeholder="Descrição da Tarefa" name="descricao" required>
        <button type = "submit">Adicionar</button>
    </form>

    <h2>Suas tarefas</h2>
    <?php if(!empty($tarefas)): ?>
        <ul>
            <?php foreach($tarefas as $tarefa): ?>
                <li>
                  <?php  echo $tarefa['descricao']; ?>
                  <a href= "todoList.php?delete=<?php echo $tarefa['id'] ?>"> - Excluir</a>
                  <a href = "todolist.php?update=<?php echo $tarefa['id'] ?>"> - Atualizar </a>

                  <?php if(isset($_GET['update']) && $_GET['update'] == intval($tarefa['id'])): ?>
                    <form action="todolist.php?update=<?php echo $tarefa['id'] ?>" method = "POST">
                        <input type = "text" placeholder = "Nova descricao" name = 'updatevalue' required>
                        <button type = "submit">Atualizar</button>
                    </form>
                    <?php endif;?> 
                    

                </li>
            <?php endforeach; ?>
        </ul>
    <?php else: ?>
        <p>Não existem tarefas</p>

    <?php endif; ?>
</body>
</html>