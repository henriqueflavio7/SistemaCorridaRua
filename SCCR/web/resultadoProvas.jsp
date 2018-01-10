
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Administrador"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Resultado Provas</title>

        <script>
            function pesquisa(input) {

                var pesquisa = document.getElementById('search');
                location.href = 'PesquisaProvaController?acao=pesquisa&nome=' + pesquisa.value;
            }
        </script>


    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <c:if test="${tipo == null}"><a class="navbar-brand" href="index.jsp">Sistema de Corrida de Rua</a></c:if>
            
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
        
  
        
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        
          <li class="nav-item">
          <a class="nav-link" href="${tipo}Home.jsp">
              <i class="fa fa-user-o"></i></a>
                                
        </li>
        
       
      </ul>
    </div>
  </nav>
        <div class="container">
            
            <div id="main" class="container-fluid" style="margin-top: 50px">

            </div>
        </div>
        <hr />
        <div class="container">
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Nome do atleta</th>
                                <th>Número peito</th>
                                <th>Tempo</th>
                                <th>Prova</th>


                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${resultadoProva}" var="resultadoProva">
                                <tr>
                                    <td><c:out value = "${resultadoProva.nomeAtleta}" /></td>
                                    <td><c:out value = "${resultadoProva.numeroPeito}" /></td>
                                    <td><c:out value = "${resultadoProva.tempo}" /></td>
                                    <td><c:out value = "${resultadoProva.prova}" /></td>


                                </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div> <!-- /#list -->
        </div>


        <!-- Modal -->
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir este item?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Sim</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

      <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Sccr 2017</p>
      </div>
      <!-- /.container -->
    </footer>
        <!-- Logout Modal-->
     <!-- Logout Modal-->
    

    </body>
</html>


