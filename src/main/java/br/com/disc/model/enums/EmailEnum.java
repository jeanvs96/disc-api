package br.com.disc.model.enums;

import lombok.Getter;

@Getter
public enum EmailEnum {
    VERIFY_ACCOUNT("Ative sua conta PERSONA", "email-account-confirmation.ftl"),
    PASSWORD_RECOVERY("Código para recuperação de senha", "email-authentication-code.ftl"),
    AUTHENTICATION_CODE("Código de acesso", "email-authentication-code.ftl");

    private String subject;
    private String emailTemplate;

    EmailEnum(String subject, String emailTemplate) {
        this.subject = subject;
        this.emailTemplate = emailTemplate;
    }
}
