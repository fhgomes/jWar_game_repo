<html>
	<head>
		<title>...::: Excluir Usuario :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
		<div id="resposta">
			<p class="what">ID do usuario excluido: </p><?php echo ($_GET["id"]); ?>.<br/>
			<?php
				include('IXR_Library.inc.php');
				include('ip.php');
				$client = new IXR_Client(getUrl());
				$client->query('servidorAdm.excluir', $_GET["id"]);

				if ($client->getResponse() == 1)
					echo ("<p class='what'>Usuario foi excluido.</p>");
			?>
			<p class="link"><a href="listusuarios.php" title="Voltar para a Lista">listar</a></p>
		</div>
	</body>
</html>
