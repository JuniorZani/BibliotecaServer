package com.faculdade.library_server.framework.exception_handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    PARAMETRO_INVALIDO("/parametro-invalido", "Parametro Invalido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem Incompreensivel"),
    RECURSO_NAO_ENCONTRADO("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-de-negocio", "Violação de regra de negócio"),
    ERRO_NO_SISTEMA("/erro-no-sistema", "Erro no sistema"),
    ACCESS_FAIL("/erro-de-acesso", "Erro de acesso ao sistema"),
    SIGN_IN_FAIL("/erro-de-sign-in", "Erro ao realizar sign in"),
    SIGN_UP_FAIL("erro-de-sign-up", "Erro ao realizar sign up");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https:localhost:8080" + path;
        this.title = title;
    }
}
