<html>
	<head>
		<title>...::: Editar Usuario :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
		<div id="resposta">
			<p class="what">Nick do Usuario atualizado: </p><?php echo ($_POST["nick"]); ?>.<br/>
			<?php
				include('IXR_Library.inc.php');
				include('ip.php');
				$client = new IXR_Client(getUrl());
				$client->query('servidorAdm.editar', $_GET["id"], $_POST["nick"], $_POST["nome"], $_POST["email"], $_POST["senha"]);

				if ($client->getResponse() == 1)
					echo ("<p class='what'>Usuario foi atualizado.</p>");
			?>
			<p class="link"><a href="listusuarios.php" title="Voltar para a Lista">listar</a></p>
		</div>
	</body>
</html>
