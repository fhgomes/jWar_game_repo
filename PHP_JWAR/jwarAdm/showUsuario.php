<html>
	<head>
		<title>...::: Visualizar Usuario :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
		<div id="view">
			<?php
				include('IXR_Library.inc.php');
				include('ip.php');
				$client = new IXR_Client(getUrl());
				$client->query('servidorAdm.getDados', $_GET["id"]);
				$resultado = $client->getResponse();
				echo ("ID: "."<span class='what'>".$_GET["id"]."</span><br/>");
				echo ("Nick: "."<span class='what'>".$resultado[0]."</span><br/>");
				echo ("Nome: "."<span class='what'>".$resultado[1]."</span><br/>");
				echo ("Email: "."<span class='what'>".$resultado[2]."</span><br/>");
			?>
			<a href="listusuarios.php" title="Voltar para a Lista">listar</a>
		</div>
	</body>
</html>
