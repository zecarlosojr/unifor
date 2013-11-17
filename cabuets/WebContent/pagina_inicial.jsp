<!-- DECLARAÇÃO DE UTILIZAÇÃO DE JSP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- IMPORTANDO A BIBLIOTECA JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- PÁGINA -->
<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- TAGS DE CONFIGURAÇÃO -->
<meta name="author" content="Dennis Fernandes">
<meta name="description" content="">
<meta name="reply-to" content="dennis.fernandes_100@hotmail.com">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- FIM DAS TAGS DE CONFIGURAÇÃO -->

<title>Início</title>

<!-- ESTILOS DA PÁGINA - CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>

<!-- Fav - ÍCONE QUE APARECE NO TÍTULO DA PÁGINA -->
<link rel="shortcut icon"
	href="http://globocom.github.io/bootstrap/assets/ico/favicon.ico">
<!-- FIM DOS ESTILOS DA PÁGINA -->

<!-- SCRIPTS DA PÁGINA -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./Bootstrap, from Twitter_files/jquery.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-transition.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-alert.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-modal.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-dropdown.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-scrollspy.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-tab.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-tooltip.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-popover.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-button.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-collapse.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-carousel.js"></script>
<script src="./Bootstrap, from Twitter_files/bootstrap-typeahead.js"></script>
<!-- FIM DOS SCRIPTS DA PÁGINA -->
</head>

<body>

	<!-- 
  		VERIFICAR SE A SESSÃO É NULL, CASO SEJA
  		REDIRECIONA PARA PÁGINA DE LOGIN
  	 -->
	<c:if test="${pessoa.nome == null}">
		<jsp:forward page="login.html"></jsp:forward>
	</c:if>

	<!-- RECUPERANDO UMA PESSOA DA SESSÃO -->
	<jsp:useBean id="pessoa" class="model.Pessoa" scope="session"></jsp:useBean>

	<!-- UTILIZANDO TODAS AS PROPRIEDADES DE PESSOA -->
	<jsp:setProperty name="pessoa" property="*" />





	<!-- BARRA DE MENU PRINCIPAL -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<!-- NOME DO PROJETO QUE APARECE NA BARRA PRINCIPAL -->
				<a class="brand" href="pagina_inicial.jsp">Cabuet's</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						<a href="perfil.jsp" class="navbar-link"> <jsp:getProperty
								property="nome" name="pessoa" /> <jsp:getProperty
								property="sobrenome" name="pessoa" />
						</a>
					</p>
					<ul class="nav">
						<li class="span9"></li>

						<!-- ITEM DA BARRA PRINCIPAL COM PÁGINA INCIAL SELECIONADA -->
						<li class="active"><a href="pagina_inicial.jsp">Página
								Inicial</a></li>

						<!-- ITEM DA BARRA PRINCIPAL -->
						<li><a href="perfil.jsp">Perfil</a></li>

						<!-- ITEM DA BARRA PRINCIPAL -->
						<li><a href="login.html">Sair</a></li>

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- FIM DA BARRA DE MENU PRINCIPAL -->




	<div class="container-fluid">

		<div class="row-fluid">

			<!-- BARRA DE MENU LATERAL OCUPANDO O ESPAÇO DE 3  COLUNAS -->
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Favoritos</li>

						<li class="active"><a href="">Notícias</a></li>
						<li><a href="">Mensagens</a></li>
						<li><a href="">Eventos</a></li>
						<li><a href="">Fotos</a></li>

						<li class="nav-header">Páginas</li>

						<li><a href="">Páginas de Notícias</a></li>
						<li><a href="">Páginas Curtidas</a></li>

						<li class="nav-header">Grupos</li>

						<li><a href="">Ciência da Computação</a></li>
						<li><a href="">Compras e Vendas</a></li>
						<li><a href="">Terceirão 2011</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<!-- FIM DA BARRA DE MENU LATERAL -->

			<!-- ESPAÇO PARA O CONTEÚDO GERAL DA PÁGINA -->
			<div class="span9">

				<!-- ESPAÇO DE UMA LINHA COM CARACTERÍSTICA DE LINHA PRINCIPAL -->
				<div class="hero-unit">
					<textarea rows="3" cols="20"
						style="min-height: 150px; max-height: 150px; min-width: 800px; max-width: 800px"></textarea>
					<input type="button" value="Postar" id="inputEnviarPostagem"
						name="enviarPostagem" onclick="">
				</div>

				<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<!-- PRIMERIRA COLUNA DA LINHA -->

					<c:forEach var="postagem" begin="0" end="2" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->

				<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="3" end="5" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->

				<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="6" end="8" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->

				<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="9" end="11" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->

				<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="12" end="14" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->
								<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="15" end="17" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->
								<!-- ESPAÇO DE UMA LINHA -->
				<div class="row-fluid">

					<c:forEach var="postagem" begin="18" end="19" items="${postagens}">
						<div class="span4">
							<h2>${postagem.nome}${postagem.sobrenome}</h2>

							<c:forEach var="post" items="${ postagem.postagem }">
								<p>${ post.mensagem } as ${ post.data }</p>
							</c:forEach>

						</div>
						<!--/span-->
					</c:forEach>

				</div>
				<!--/row-->
				<hr>

				<footer>
					<p>© Cabuet's</p>
				</footer>

			</div>
			<!--/.fluid-container-->
</body>
</html>
