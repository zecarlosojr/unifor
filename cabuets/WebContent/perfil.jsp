<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- IMPORTANDO A BIBLIOTECA JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!-- RECUPERANDO UMA PESSOA DA SESSÃO --> 
<jsp:useBean id="pessoa" class="model.Pessoa" scope="session"></jsp:useBean>
	
<!-- UTILIZANDO TODAS AS PROPRIEDADES DE PESSOA -->
<jsp:setProperty name="pessoa" property="*"/>

<!-- VERIFICAR SE A SESSÃO É NULL, CASO SEJA
  	REDIRECIONA PARA PÁGINA DE LOGIN -->
<c:if test="${pessoa.nome == null}">
	<jsp:forward page="login.html"></jsp:forward>
</c:if>

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
	    
	    <title><jsp:getProperty property="nome" name="pessoa"/> <jsp:getProperty property="sobrenome" name="pessoa"/></title>
	    
	    <!-- ESTILOS DA PÁGINA - CSS -->
	    	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	    
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
		    <link rel="shortcut icon" href="http://globocom.github.io/bootstrap/assets/ico/favicon.ico">
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
	
	
	
	
	<!-- BARRA DE MENU PRINCIPAL -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="pagina_inicial.jsp">Cabuet's</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              <a href="perfil.jsp" class="navbar-link">
              	<jsp:getProperty property="nome" name="pessoa"/> <jsp:getProperty property="sobrenome" name="pessoa"/>
              </a>
            </p>
            <ul class="nav">
              <li class="span9">
           	  </li>
              
              <li>
              	<a href="pagina_inicial.jsp">Página Inicial</a>
              </li>
              
              <li class="active">
              	<a href="perfil.jsp">Perfil</a>
              </li>
           		
           	  <li>
				<a href="login.html">Sair</a>
           	  </li>
           	  
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    <!-- FIM DA BARRA DE MENU PRINCIPAL -->
    
    
    <div class="container-fluid">
    	<div class="row-fluid">
    		
    		<div class="span1"></div>
    		
	        <div class="span8">
          		<div class="hero-unit">
          			<ul class="thumbnails">
					  <li class="span4">
					    <a href="#" class="thumbnail">
					      <img src="images/dennis.jpg" alt="Dennis Fernandes" style="height: 300px; width: 250px;">
					    </a>
					  </li>
					  <li class="span7">
					  	
					  	<br><br>
					  	<h3><jsp:getProperty property="nome" name="pessoa"/> <jsp:getProperty property="sobrenome" name="pessoa"/></h3>
					  	<h6>Sou estudante do curso de Ciência da Computação na Universidade de Fortaleza - UNIFOR
					  	e estagiário em desenvolvimento Web com Java no Núcleo de Aplicações em Tecnologia
					  	da Informação (NATI - UNIFOR). Adoro atividades esportivas, entre elas as que mais
					  	gosto são as radicais e as artes maciais, onde pratico Jiu-jitsu e Muay thai, quando
					  	tenho tempo. Natação também está entre as que mais gosto.</h6>
					  	
					  </li>
					 </ul>
          		</div>
	        </div>
	        
	        <div class="span3">
	        	<div class="hero-unit">
	        		<h2 align="center">Amigos</h2>
	        		<br>
	        		<ul>
	        			<li>
						    <img src="images/dennis.jpg" alt="Dennis Fernandes" style="height: 70px; width: 50px;">
	        				Raul Martins
	        				<br><br>
	        			</li>
	        			
	        		</ul>
	        	</div>
	        </div>
	        
	    </div><!--/row-->
      	<hr>
     	<footer>
        	<p>© Cabuet's</p>
      	</footer>
	
    </div><!--/.fluid-container-->
    
    </body>
</html>