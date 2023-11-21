<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Alternativa</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/disst/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>
                Editar Alternativa
            </h1>
            <form action="/alternativa/update" method="post">
                <input type="hidden" name="id" value="${alternativa.id}" />
                <div class="form-group">
                    <label for="nome">
                        Texto:
                    </label>
                    <input type="text" name="nome" class="form-control" value="${questao.nome}" />
                </div>
                <br />
                <a href="/alternativa/list" class="btn btn-primary">
                    Voltar
                </a>
                <button type="submit" class="btn btn-success">
                    Salvar
                </button>
            </form>
        </div>
    </body>
</html>