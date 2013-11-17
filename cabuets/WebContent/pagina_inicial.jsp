<!-- DECLARA��O DE UTILIZA��O DE JSP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- IMPORTANDO A BIBLIOTECA JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!-- P�GINA -->
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<!-- TAGS DE CONFIGURA��O -->
			<meta name="author" content="Dennis Fernandes">
			<meta name="description" content="">
			<meta name="reply-to" content="dennis.fernandes_100@hotmail.com">
			
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <!-- FIM DAS TAGS DE CONFIGURA��O -->
	    
	    <title>In�cio</title>
	
	    <!-- ESTILOS DA P�GINA - CSS -->
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
		 
		    <!-- Fav - �CONE QUE APARECE NO T�TULO DA P�GINA -->
		    <link rel="shortcut icon" href="http://globocom.github.io/bootstrap/assets/ico/favicon.ico">
		<!-- FIM DOS ESTILOS DA P�GINA -->
		
		<!-- SCRIPTS DA P�GINA -->
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
		<!-- FIM DOS SCRIPTS DA P�GINA -->
  	</head>

  <body>
  
  	<!-- 
  		VERIFICAR SE A SESS�O � NULL, CASO SEJA
  		REDIRECIONA PARA P�GINA DE LOGIN
  	 -->
	<c:if test="${pessoa.nome == null}">
		<jsp:forward page="login.html"></jsp:forward>
	</c:if>
	
	<!-- RECUPERANDO UMA PESSOA DA SESS�O --> 
	<jsp:useBean id="pessoa" class="model.Pessoa" scope="session"></jsp:useBean>
	
	<!-- UTILIZANDO TODAS AS PROPRIEDADES DE PESSOA -->
	<jsp:setProperty name="pessoa" property="*"/>
	
	
	

           	  
    <!-- BARRA DE MENU PRINCIPAL -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <!-- NOME DO PROJETO QUE APARECE NA BARRA PRINCIPAL -->
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
              
              <!-- ITEM DA BARRA PRINCIPAL COM P�GINA INCIAL SELECIONADA -->
              <li class="active">
              	<a href="pagina_inicial.jsp">P�gina Inicial</a>
              </li>
              
              <!-- ITEM DA BARRA PRINCIPAL -->
              <li>
              	<a href="perfil.jsp">Perfil</a>
              </li>
           	
           	  <!-- ITEM DA BARRA PRINCIPAL -->
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
	    	
	    	<!-- BARRA DE MENU LATERAL OCUPANDO O ESPA�O DE 3  COLUNAS -->
	    	<div class="span3">
	        	<div class="well sidebar-nav">
	           		<ul class="nav nav-list">
		              <li class="nav-header">Favoritos</li>

		              <li class="active"><a href="">Not�cias</a></li>
		              <li><a href="">Mensagens</a></li>
		              <li><a href="">Eventos</a></li>
		              <li><a href="">Fotos</a></li>

		              <li class="nav-header">P�ginas</li>
		              
		              <li><a href="">P�ginas de Not�cias</a></li>
		              <li><a href="">P�ginas Curtidas</a></li>
		              
		              <li class="nav-header">Grupos</li>
		              
		              <li><a href="">Ci�ncia da Computa��o</a></li>
		              <li><a href="">Compras e Vendas</a></li>
		              <li><a href="">Terceir�o 2011</a></li>
		            </ul>
	          	</div><!--/.well -->
	        </div><!--/span-->
      		<!-- FIM DA BARRA DE MENU LATERAL -->
      
      	   <!-- ESPA�O PARA O CONTE�DO GERAL DA P�GINA -->
	       <div class="span9">
	          
	          <!-- ESPA�O DE UMA LINHA COM CARACTER�STICA DE LINHA PRINCIPAL -->
	          <div class="hero-unit">
	            <h1>Hello, world!</h1>
	            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	            <p><a class="btn btn-primary btn-large">Learn more �</a></p>
	          </div>
	          
	          <!-- ESPA�O DE UMA LINHA -->
	          <div class="row-fluid">
	            
	            <!-- PRIMERIRA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	            
	            <!-- SEGUNDA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	            
	            <!-- TERCEIRA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	          
	          </div><!--/row-->
	       
	       	  <!-- ESPA�O DE UMA LINHA -->
	          <div class="row-fluid">
	          	
	          	<!-- PRIMEIRA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	            
	            <!-- SEGUNDA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	            
	            <!-- TERCEIRA COLUNA DA LINHA -->
	            <div class="span4">
	              <h2>Heading</h2>
	              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p><a class="btn" href="http://globocom.github.io/bootstrap/examples/fluid.html#">View details �</a></p>
	            </div><!--/span-->
	          </div><!--/row-->
	       
	        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>� Cabuet's</p>
      </footer>

    </div><!--/.fluid-container-->

</body></html>