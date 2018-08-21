package com.manulife.msadv18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	/*
	 * 由于Spring Boot的starter模块提供了自动化配置，所以在引入了spring-boot-starter-mail依赖之后，
	 * 会根据配置文件中的内容去创建JavaMailSender实例，
	 * 因此我们可以直接在需要使用的地方直接@Autowired来引入邮件发送对象。
	 */
	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.from.account}")
	private String fromMail;
	@Value("${mail.to.account}")
	private String toMail;

	@Test
	public void testSendSimpleEmail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromMail);
		message.setTo(toMail);
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		mailSender.send(message);
	}

	@Test
	public void testSendMimeEmail() throws Exception {
		MimeMessage mimeMailMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

		helper.setFrom(fromMail);
		helper.setTo(toMail);
		helper.setSubject("主题：有附件的邮件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("MSL_LOGO.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMailMessage);
	}

	@Autowired
	private TemplateEngine templateEngine;

	@Test
	public void testSendInlineEmail() throws Exception {
		MimeMessage mimeMailMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

		helper.setFrom(fromMail);
		helper.setTo(toMail);
		helper.setSubject("主题：嵌入静态资源的邮件");
		helper.setText("<html><body><img src=\"cid:logo\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("MSL_LOGO.jpg"));
		helper.addInline("logo", file);

		mailSender.send(mimeMailMessage);
	}

	@Test
	public void testSendTemplateEmail() throws Exception {
		MimeMessage mimeMailMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

		helper.setFrom(fromMail);
		helper.setTo(toMail);
		helper.setSubject("主题：模板邮件");

		Context context = new Context();
		context.setVariable("id", "20180821001");
		String text = templateEngine.process("template", context);
		helper.setText(text, true);

		mailSender.send(mimeMailMessage);
	}
}
