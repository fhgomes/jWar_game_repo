<html>
	<head>
		<title>...::: Cadastro de Usuarios :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
		<div id="resposta">
			<p class="what">Nick do Usuario cadastrado: </p><?php echo ($_POST["nick"]); ?>.<br/>
			<?php
				include('IXR_Library.inc.php');
				include('ip.php');
				$client = new IXR_Client(getUrl());
				$client->query('servidorAdm.cadastrar', $_POST["nick"], $_POST["nome"], $_POST["email"], $_POST["senha"]);

				if ($client->getResponse()=="ok")
					echo ("<p class='what'>Usuario foi cadastrado.</p>");
			?>
			<p class="link"><a href="listusuarios.php" title="Voltar para a Lista">listar</a></p>
		</div>
	</body>
</html>
