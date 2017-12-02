<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter elemento Kit</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form action="ManterElementoKitController?acao=confirmar${operacao}" method="post" name="frmManterElementoKit">
            <table>
                <tr>
                    <td>Codigo:</td> 
                    <td><input type="text" name="txtId" value="${elementoKit.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    
                     <tr>
                        <td>Item:</td> 
                        <td>
                         <select name="optItem" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${elementoKit.item_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${item}" var="item">
                                <option value="${item.id}" <c:if test="${item.id == elementoKit.item_id}"> selected</c:if>>${item.nomeItem}</option>  
                            </c:forEach>
                        </select>
                    </td>
                    </tr>
                   
                    <tr>
                        <td>Kit:</td> 
                        <td>
                         <select name="optKit" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${elementoKit.kit_id == null}"> selected</c:if>></option>  
                            <c:forEach items="${kit}" var="kit">
                                <option value="${kit.id}" <c:if test="${kit.id == elementoKit.kit_id}"> selected</c:if>>${kit.nomeKit}</option>  
                            </c:forEach>
                        </select>
                    </td>
                         </tr>
             
                   
             <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
