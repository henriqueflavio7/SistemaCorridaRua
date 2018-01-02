
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>MResultado Ranking</title>

       

    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <div id="main" class="container-fluid" style="margin-top: 50px">

            <h2>Ranking JF 2017</h2>
        </div>
        <div id="main" class="container-fluid" style="margin-top: 50px">
            <h3> Resultados</h3>
        </div>
        <hr />
        <div id="list" class="row">

            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <th>Classificação</th>
                            <th>Atleta</th>
                            <th>Pontuação</th> 
                           

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${resultadoRanking}" var="resultadoRanking">
                            <tr>
                                <td><c:out value = "${resultadoRanking.classificacao}" /></td>
                                <td><c:out value = "${resultadoRanking.nomeAtleta}" />
                                </td>


                                <td><c:out value = "${resultadoRanking.pontuacao}" /></td>
                              
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </div> <!-- /#list -->



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

        <jsp:include page="footer.jspf"/>

    </body>
</html>


