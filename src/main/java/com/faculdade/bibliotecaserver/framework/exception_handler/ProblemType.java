package com.faculdade.bibliotecaserver.framework.exception_handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    PARAMETRO_INVALIDO("/parametro-invalido", "Parametro Invalido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem Incompreensivel"),
    RECURSO_NAO_ENCONTRADO("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-de-negocio", "Violação de regra de negócio"),
    ERRO_NO_SISTEMA("/erro-no-sistema", "Erro no sistema");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https:localhost:8080" + path;
        this.title = title;
    }
}
