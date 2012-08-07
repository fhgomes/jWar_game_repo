<html>
	<head>
		<title>...::: Editar Usuario :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
	<div id="form">
	<?php
	if ($_GET["id"])
	{
		include('IXR_Library.inc.php');

		include('ip.php');
		$client = new IXR_Client(getUrl());
		$client->query('servidorAdm.getDados', $_GET["id"]);
		$resultado = $client->getResponse();
		?>
		<form action="editar.php?id=<?php print $_GET['id'] ?>" method="POST">
			<p>ID: <?php print $_GET["id"] ?></p><br/>
			<p>Nick: <input type="text" name="nick" value="<?php print $resultado[0] ?>"/></p><br/>
			<p>Nome: <input type="text" name="nome" value="<?php print $resultado[1] ?>"/></p><br/>
			<p>Email: <input type="text" name="email" value="<?php print $resultado[2] ?>"/></p><br/>
			<p>Senha: <input type="password" name="senha" /></p><br/>
			<p><input type="submit"></p>
		</form>
	<?php
	}
	?>
	<p class="link"><a href="listusuarios.php" title="Voltar para a Lista">listar</a></p>
	</div>
	</body>
</html>
