//package com.nlp.learn.mail;
//
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
//
//import freemarker.cache.ClassTemplateLoader;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateExceptionHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @date 2016年4月15日 下午2:46:40
// */
//public class EmailService {
//
//	private EmailMessage messager;
//	private Configuration cfg;
////	public EmailService(EmailMessage messager){
////		this.messager = messager;
////		cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
////        cfg.setTemplateLoader(new ClassTemplateLoader(getClass(),"/"));
////        cfg.setDefaultEncoding("UTF-8");
////        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
////        cfg.setLogTemplateExceptions(false);
////    }
//
//	public void sendMessager(String subject,String templateName,Map<String, Object> placeHolderMap,String... to) {
//		HtmlEmail email = new HtmlEmail();
//		try {
//			// 这里是SMTP发送服务器的名称
//			email.setHostName("smtp.qq.com");
//			email.setSmtpPort(465);
//			//开启 SSL 加密
//			email.setSSLOnConnect(true);
//			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
//			email.setAuthentication("1151738113", "zbfwzpqlkrfvhabj");
//			// 字符编码集的设置
//			email.setCharset("UTF-8");
//			List<String> receivers = new ArrayList<String>();
//			receivers.addAll(Arrays.asList("1151738113@qq.com"));
////			receivers.addAll(Arrays.asList(to));
//			// 收件人的邮箱
//			email.addTo(receivers.toArray(new String[receivers.size()]));
//			// 发送人的邮箱
//			email.setFrom("1151738113@qq.com","1151738113@qq.com");
//			// 字符编码集的设置
//			email.setCharset("utf-8");
//			// 要发送的邮件主题
//			email.setSubject(subject);
//			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
//			// set the html message
//			//替换占位符
////	        String htmlMsg = readMailTemplate(templateName, placeHolderMap);
//	        email.setHtmlMsg("ceshi");
//			// 发送
//			email.send();
//		} catch (EmailException e) {
//			  throw new RuntimeException("发送邮件失败",e);
//		}
//	}
//	/**
//     * 读取邮件模板
//     *
//     * @param
//     * @param @return 设定文件
//     * @return String
//     * @Exception 异常对象
//     */
//    private String readMailTemplate(String mailTemplateName, Map<String, Object> params) {
//
//        StringWriter sw = new StringWriter();
//        try {
//
//            Template t = cfg.getTemplate(mailTemplateName);
//            t.process(params, sw);
//            sw.close();
//        } catch (Exception e) {
//            throw new RuntimeException("读取邮箱模板错误",e);
//        }
//        return sw.toString();
//
//    }
//
//	public static void main(String[] args){
//
////		EmailService emailService = new EmailService();
////
////		emailService.sendMessager("测试",null,null,"");
//
//        HtmlEmail email = new HtmlEmail();
//        try {
//            // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；smtp.exmail.qq.com没测试成功
//            email.setHostName("smtp.qq.com");
//            //设置需要鉴权端口
//            email.setSmtpPort(465);
//            //开启 SSL 加密
//            email.setSSLOnConnect(true);
//            // 字符编码集的设置
//            email.setCharset("utf-8");
//            // 收件人的邮箱
//            email.addTo("1151738113@qq.com");
//            // 发送人的邮箱
//            email.setFrom("1151738113@qq.com", "王伟");
//            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和得到的授权码
//            email.setAuthentication("1151738113@qq.com", "zbfwzpqlkrfvhabj");
//            email.setSubject("下午3：00会议室讨论，请准时参加");
//            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
//            email.setMsg("请准时参加");
//            // 发送
//            email.send();
//
//            System.out.println ( "邮件发送成功!" );
//        } catch (EmailException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println ( "邮件发送失败!" );
//        }
//
//	}
//}
