<html>
	<head>
		<title>...::: Listar Usuarios :::...</title>
		<link rel="stylesheet" href="style/arquivo.css" type="text/css">
	</head>
	<body>
	<?php
		include('IXR_Library.inc.php');
		include('ip.php');
		$client = new IXR_Client(getUrl());
		$client->query('servidorAdm.listar');
	?>
	<table border="1" align="center">
		<tr>
			<td><b>ID</b></td>
			<td><b>Nick</b></td>
			<td><b>Nome</b></td>
			<td><b>Email</b></td>
			<td><b>Acoes</b></td>
		</tr>
	<?
		$resultado = $client->getResponse();
		foreach ($resultado as $number)
		{
			?><tr>
				<td><?php echo $number[0]; ?></td>
				<td><?php echo $number[1]; ?></td>
				<td><?php echo $number[2]; ?></td>
				<td><?php echo $number[3]; ?></td>
				<td>
				<a href="editUsuario.php?id=<?php print $number[0]; ?>" title="editar usuario">editar</a>
				<a href="showUsuario.php?id=<?php print $number[0]; ?>" title="visualizar usuario">visualizar</a>
				<a href="excluirUsuario.php?id=<?php print $number[0]; ?>" title="excluir usuario">excluir</a>
				</td>
			</tr><?php
		}
	?>
	</table>
	<p class="link"><a href="cadUsuario.php" title="Cadastrar Usuario">cadastrar novo usuario</a></p>
	</body>
</html>
