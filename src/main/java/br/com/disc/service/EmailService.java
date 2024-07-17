package br.com.disc.service;

import br.com.disc.model.dto.AuthenticationCodeRequestDTO;
import br.com.disc.model.entity.AuthenticationCode;
import br.com.disc.model.entity.UserEntity;
import br.com.disc.model.enums.EmailEnum;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import java.io.IOException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender emailSender;
    private final freemarker.template.Configuration fmConfiguration;
    private final AuthenticationCodeService authenticationCodeService;
    @Value("${spring.mail.username}")
    private String from;

    public void sendAuthenticationCodeEmail(AuthenticationCodeRequestDTO authenticationCodeRequestDTO, UserEntity userEntity) throws MessagingException, TemplateException, IOException {
        AuthenticationCode authenticationCode = authenticationCodeService.getAuthenticationCode(userEntity);

        HashMap<String, String> emailData = new HashMap<>();
        emailData.put("code", authenticationCode.getCode());
        sendEmail(authenticationCodeRequestDTO.getEmail(), emailData, authenticationCodeRequestDTO.getEmailType());
    }

    public void sendAccountConfirmationEmail(UserEntity userEntity) throws MessagingException, TemplateException, IOException {
        HashMap<String, String> emailData = new HashMap<>();
        emailData.put("username", userEntity.getUsername());
        sendEmail(userEntity.getEmail(), emailData, EmailEnum.VERIFY_ACCOUNT);
    }

    public void sendEmail(String sendTo, HashMap<String, String> data, EmailEnum emailEnum) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(sendTo);
        mimeMessageHelper.setSubject(emailEnum.getSubject());

        mimeMessageHelper.setText(getContentFromTemplate(data, emailEnum), true);
        mimeMessageHelper.addInline("logo.png", new ClassPathResource("logo.png"));
        emailSender.send(mimeMessageHelper.getMimeMessage());
    }

    public String getContentFromTemplate(HashMap<String, String> data, EmailEnum emailEnum) throws IOException, TemplateException {
        Template template;
        template = fmConfiguration.getTemplate(emailEnum.getEmailTemplate());
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
    }
}
