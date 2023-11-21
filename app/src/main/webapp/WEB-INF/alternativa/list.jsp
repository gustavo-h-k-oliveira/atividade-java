<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tag.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alternativas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/disst/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>
                Alternativas
            </h1>
            <a href="/alternativa/insert" class="btn btn-primary">Nova Alternativa</a>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Texto</th>
                    <th>Correta</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach var="item" items="${alternativas}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.texto}</td>
                        <td>${item.correta}</td>
                        <td>
                            <a href="/alternativa/update?id=${item.id}" class="btn btn-warning">Editar</a>
                            <a href="/alternativa/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>