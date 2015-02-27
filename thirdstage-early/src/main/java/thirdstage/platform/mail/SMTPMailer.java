package thirdstage.platform.mail;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Sends messages containing  plain text or HTML.
 * The contents of the mail can have muliple body parts which are text type MIME
 * such as plain text or HTML.
 * This mailer supports only SMTP protocol, so you should specify SMTP
 * host to construct an object.
 *
 * @author Sang-Moon Oh
 * @version 2.0, 2002/03/14
 * @version 1.5, 2000/03/13
 * @since 1999/09/10
 */
public final class SMTPMailer {
	
	/**
	 * the mail client session to send messages for this mailer
	 */
	private javax.mail.Session mailSess = null;
	
	//test
	
	/**
	 * the message transport of this mailer
	 */
	private javax.mail.Transport transport = null;
	
	/**
	 * Constructs a mailer using the specified SMTP host.
	 *
	 * @param host full qualified domain name or IP address of the SMTP host for this
	 * mailer to use
	 * @throws java.lang.Exception if there's a problem to get SMTP transport to the
	 * specified host
	 */
	public SMTPMailer(String host) throws Exception {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.debug", "false");
		
		mailSess = javax.mail.Session.getDefaultInstance(props, null);
		//mailSess.setDebug(false);
		
		transport = mailSess.getTransport();
	}
	
	/**
	 * Constructs a mialer using the specified SMTP host, user ID, and password. You
	 * can use a full qualified domain name or IP address for the SMTP host.
	 *
	 * @param host full qualified domain name or IP address of the SMTP host for this
	 * mailer to use
	 * @param id user ID at the specified host to connect and request for relaying
	 * the message
	 * @param passwd password for the specified user ID
	 * @throws java.lang.Exception if there's a problem to get SMTP transport to the
	 * specified host
	 */
	public SMTPMailer(String host, String id, String passwd) throws Exception {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", id);
		props.put("mail.smtp.password", passwd);
		props.put("mail.debug", "false");
		
		mailSess = javax.mail.Session.getDefaultInstance(props, null);
		//mailSess.setDebug(false);
		
		transport = mailSess.getTransport();
	}
	
	/**
	 * Sends a message containing one plain text("text/plain" MIME type) to multiple
	 * recipients. The cc recipients and bcc recipients can be not specified, but
	 * sender and primary recipeints should be specified.
	 *
	 * @param from the email address of the sender; cann't  be <code>null</code>
	 * @param to the email addresseses of primary recipients; cann't be
	 * <code>null</code>
	 * @param cc the email addresseses of carbon copy(cc) recipients; can be
	 * <code>null</code>
	 * @param bcc the email addresses of blind carbon copy(bcc) recipients; can be
	 * <code>null</code>
	 * @param subj the subject of the message
	 * @param content the contents of the message; is supposed to be plain text
	 * @throws javax.mail.MessagingException when there occurs a problem to send
	 * message
	 * @throws javax.mail.internet.AddressException if sender or any of recipient
	 * address has
	 * wrong format, the sender is not specified(<code>from</code> is
	 * <code>null</code>), or the primary recipients are not specified(<code>to</code>
	 * is <code>null</code>)
	 * @see #sendPlainTextMail(String, String, String, String)
	 */
	public void sendPlainTextMail(String from, String[] to, String[] cc, String[] bcc, String subj, String content) throws AddressException, MessagingException {
		
		javax.mail.Address[] toAddrs = null, ccAddrs = null, bccAddrs = null;
		
		if(from == null) throw new AddressException("The sender address should be specified");
		if(to == null) throw new AddressException("The recipeint address should be specified");
		toAddrs = new javax.mail.internet.InternetAddress[to.length];
		for(int i = 0, n = to.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(to[i]);
		
		if(cc != null){
			ccAddrs = new javax.mail.internet.InternetAddress[cc.length];
			for(int i = 0, n = cc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(cc[i]);
		}
		
		if(bcc != null){
			bccAddrs = new javax.mail.internet.InternetAddress[bcc.length];
			for(int i = 0, n = bcc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(bcc[i]);
		}
		
		Message msg = new MimeMessage(mailSess);
		
		//specifies sender
		msg.setFrom(new InternetAddress(from));
		//specifies primary recipient
		msg.setRecipients(Message.RecipientType.TO, toAddrs);
		//specifies carbon copy recipient
		if(cc != null) msg.setRecipients(Message.RecipientType.CC, ccAddrs);
		//specifies blind carbon copy recipient
		if(bcc != null) msg.setRecipients(Message.RecipientType.BCC, bccAddrs);
		//specifies date
		msg.setSentDate(new java.util.Date());
		
		//specifies the subject of the mail
		msg.setSubject(subj);
		//specifies the contents of the mail
		msg.setContent(content, "text/plain;charset=EUC-KR");
		
		//sends mail
		String passwd = mailSess.getProperty("mail.smtp.password");
		if(passwd != null){
			transport.connect(mailSess.getProperty("mail.smtp.host"), mailSess.getProperty("mail.smtp.user"), passwd);
		} else transport.connect();
		transport.sendMessage(msg, toAddrs);
		transport.close();
	}
	
	/**
	 * Sends a message containing one plain text("text/plain" MIME type) to a single
	 * primary recipient.
	 *
	 * @param from the email address of the sender; cann't  be <code>null</code>
	 * @param to the email address of primary recipient; cann't be <code>null</code>
	 * @param subj the subject of the message
	 * @param content the contents of the message; is supposed to be plain text
	 * @throws javax.mail.MessagingException when there occurs a problem to send
	 * message
	 * @throws javax.mail.internet.AddressException if sender or recipient address has
	 * wrong format, the sender is not specified(<code>from</code> is
	 * <code>null</code>), or the primary recipient is not specified(<code>to</code>
	 * is <code>null</code>)
	 * @see #sendPlainTextMail(String, String[], String[], String[], String, String)
	 */
	public void sendPlainTextMail(String from, String to, String subj, String content) throws AddressException, MessagingException {
		
		if(to == null) throw new AddressException("The recipeint address should be specified");
		
		String[] tos = new String[1];
		tos[0] = to;
		
		sendPlainTextMail(from, tos, null, null, subj, content);
	}
	
	/**
	 * Sends a message containing one HTML("text/html" MIME type) to multiple
	 * recipients. The cc recipients and bcc recipients can be not specified, but
	 * sender and primary recipeints should be specified.
	 *
	 * @param from the email address of the sender; cann't  be <code>null</code>
	 * @param to the email addresseses of primary recipients; cann't be
	 * <code>null</code>
	 * @param cc the email addresseses of carbon copy(cc) recipients; can be
	 * <code>null</code>
	 * @param bcc the email addresses of blind carbon copy(bcc) recipients; can be
	 * <code>null</code>
	 * @param subj the subject of the message
	 * @param content the contents of the message; is supposed to be html
	 * @throws javax.mail.MessagingException when there occurs a problem to send
	 * message
	 * @throws javax.mail.internet.AddressException if sender or any of recipient
	 * address has
	 * wrong format, the sender is not specified(<code>from</code> is
	 * <code>null</code>), or the primary recipients are not specified(<code>to</code>
	 * is <code>null</code>)
	 * @see #sendHTMLMail(String, String, String, String)
	 */
	public void sendHTMLMail(String from, String[] to, String[] cc, String[] bcc, String subj, String content) throws AddressException, MessagingException {
		
		javax.mail.Address[] toAddrs = null, ccAddrs = null, bccAddrs = null;
		
		if(to == null) throw new AddressException("The recipeint address should be specified");
		toAddrs = new javax.mail.internet.InternetAddress[to.length];
		for(int i = 0, n = to.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(to[i]);
		
		if(cc != null){
			ccAddrs = new javax.mail.internet.InternetAddress[cc.length];
			for(int i = 0, n = cc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(cc[i]);
		}
		
		if(bcc != null){
			bccAddrs = new javax.mail.internet.InternetAddress[bcc.length];
			for(int i = 0, n = bcc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(bcc[i]);
		}
		
		Message msg = new MimeMessage(mailSess);
		
		//specifies sender
		msg.setFrom(new InternetAddress(from));
		//specifies primary recipient
		msg.setRecipients(Message.RecipientType.TO, toAddrs);
		//specifies carbon copy recipient
		if(cc != null) msg.setRecipients(Message.RecipientType.CC, ccAddrs);
		//specifies blind carbon copy recipient
		if(bcc != null) msg.setRecipients(Message.RecipientType.BCC, bccAddrs);
		//specifies date
		msg.setSentDate(new java.util.Date());
		
		//specifies the subject of the mail
		msg.setSubject(subj);
		//specifies the contents of the mail
		msg.setContent(content, "text/html;charset=EUC-KR");
		
		//sends mail
		String passwd = mailSess.getProperty("mail.smtp.password");
		if(passwd != null){
			transport.connect(mailSess.getProperty("mail.smtp.host"), mailSess.getProperty("mail.smtp.user"), passwd);
		} else transport.connect();
		transport.sendMessage(msg, toAddrs);
		transport.close();
	}
	
	/**
	 * Sends a message containing one HTML("text/html" MIME type) to a single
	 * primary recipient.
	 *
	 * @param from the email address of the sender; cann't  be <code>null</code>
	 * @param to the email address of primary recipient; cann't be <code>null</code>
	 * @param subj the subject of the message
	 * @param content the contents of the message; is supposed to be html
	 * @throws javax.mail.MessagingException when there occurs a problem to send
	 * message
	 * @throws javax.mail.internet.AddressException if sender or recipient address has
	 * wrong format, the sender is not specified(<code>from</code> is
	 * <code>null</code>), or the primary recipient is not specified(<code>to</code>
	 * is <code>null</code>)
	 * @see #sendHTMLMail(String, String[], String[], String[], String, String)
	 */
	public void sendHTMLMail(String from, String to, String subj, String content) throws AddressException, MessagingException {
		
		if(to == null) throw new AddressException("The recipeint address should be specified");
		
		String[] tos = new String[1];
		tos[0] = to;
		
		sendPlainTextMail(from, tos, null, null, subj, content);
	}
	
	/**
	 * Sends a message containing multiple body parts which are plain
	 * text("text/plain"  MIME type) or HTML("text/html" MIME type) to multiple
	 * recipients. The cc recipients and bcc recipients can be not specified, but
	 * sender and primary recipeints should be specified.
	 *
	 * @param from the email address of the sender; cann't  be <code>null</code>
	 * @param to the email addresseses of primary recipients; cann't be
	 * <code>null</code>
	 * @param cc the email addresseses of carbon copy(cc) recipients; can be
	 * <code>null</code>
	 * @param bcc the email addresses of blind carbon copy(bcc) recipients; can be
	 * <code>null</code>
	 * @param subj the subject of the message
	 * @param parts the array for the contents of all the body parts in the message;
	 * each element is supposed to be plain text or html
	 * @param partNames the array for the names of all the body parts in the message
	 * @param types the array for the content type of all the body parts in the
	 * message; each element is supposed to be "text/plain",
	 * "text/plain;charset=euc-kr",  "text/html", "text/html;charset=euc-kr", or etc.
	 * @throws javax.mail.MessagingException when there occurs a problem to send
	 * message
	 * @throws javax.activation.UnsupportedDataTypeException if the content type is
	 * not text type MIME
	 * @throws javax.mail.internet.AddressException if sender or any of recipient
	 * address has
	 * wrong format, the sender is not specified(<code>from</code> is
	 * <code>null</code>), or the primary recipients are not specified(<code>to</code>
	 * is <code>null</code>)
	 */
	public void sendTextMultiPartMail(String from, String[] to, String[] cc, String[] bcc, String subj, String[] parts, String[] types, String[] partNames) throws AddressException, MessagingException, UnsupportedDataTypeException {
		
		//to, cc, bcc의 주소를 구한다.
		javax.mail.Address[] toAddrs = null, ccAddrs = null, bccAddrs = null;
		
		if(to == null) throw new AddressException("The recipeint address should be specified");
		toAddrs = new javax.mail.internet.InternetAddress[to.length];
		for(int i = 0, n = to.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(to[i]);
		
		if(cc != null){
			ccAddrs = new javax.mail.internet.InternetAddress[cc.length];
			for(int i = 0, n = cc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(cc[i]);
		}
		
		if(bcc != null){
			bccAddrs = new javax.mail.internet.InternetAddress[bcc.length];
			for(int i = 0, n = bcc.length; i < n; i++) toAddrs[i] = new javax.mail.internet.InternetAddress(bcc[i]);
		}
		
		//내용이 전혀 없으면 Exception을 발생한다.
		if((parts == null) || (types == null)) throw new MessagingException();
		
		// 내용을 이루는 부분의 갯수를 구한다.
		int nParts2 = 0;
		int nParts1 = parts.length;
		for(int i = 0; i < nParts1; i++) if(parts[i] != null) nParts2++;
		
		// 각 내용의 MIME type은 null, "text/html" 또는 "text/plain"이어야 한다.
		/*
		for(int i = 0; i < nParts1; i++)
			if((types[i] != null) && (types[i].indexOf("text/plain") == -1) &&
			   (types[i].indexOf("text/html") == -1) &&
			   (types[i].indexOf("application/x-zip-compressed") == -1)) throw new MessagingException(types[i] + " : ������� �ʴ� MIME ����Դϴ�.");
		 */
		
		// 각 Part에 대한 이름이 지정되어 있는지를 살핀다.
		boolean hasPartNames = false;
		if(partNames != null) hasPartNames = true;
		
		// 내용을 먼저 작성한다.
		Multipart body = new MimeMultipart();
		MimeBodyPart[] bodyParts = new MimeBodyPart[nParts2];
		for(int i = 0, cnt = 0; i < nParts1; i++){
			if(parts[i] != null){
				bodyParts[cnt] = new MimeBodyPart();
				
				//MIME type에 따른 각 Part 첨가
				/*
				if(types[i].indexOf("text/plain") != -1) bodyParts[cnt].setText(parts[i], "8859_1");
				else bodyParts[cnt].setDataHandler(new DataHandler(new ByteArrayDataSource(parts[i], types[i])));
				 */
				//modified at ver. 2.0 by Sang-Moon Oh to improve the correct support for plain text and html
				if((types[i].indexOf("text/plain") != -1) || (types[i].indexOf("text/html") != -1)){
					bodyParts[cnt].setContent(parts[i], types[i]);
				} else bodyParts[cnt].setDataHandler(new DataHandler(new ByteArrayDataSource(parts[i], types[i])));
				
				
				//각 Part의 이름 지정
				if(hasPartNames) bodyParts[cnt].setFileName(partNames[i]);
				body.addBodyPart(bodyParts[cnt++]);
			}
		}
		
		Message msg = new MimeMessage(mailSess);
		
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, toAddrs);
		if(cc != null) msg.setRecipients(Message.RecipientType.CC, ccAddrs);
		if(bcc != null) msg.setRecipients(Message.RecipientType.CC, bccAddrs);
		msg.setSentDate(new java.util.Date());
		msg.setSubject(subj);
		msg.setContent(body);
		
		String passwd = mailSess.getProperty("mail.smtp.password");
		if(passwd != null){
			transport.connect(mailSess.getProperty("mail.smtp.host"), mailSess.getProperty("mail.smtp.user"), passwd);
		} else transport.connect();
		transport.sendMessage(msg, toAddrs);
		transport.close();
	}
	
	/**
	 * Gets the SMPT host which this mailer request to relay the message.
	 *
	 * @return the SMPT host which this mailer request to relay the message
	 */
	public String getHost() {
		return mailSess.getProperty("mail.smtp.host");
	}
	
	/**
	 * Gets the user ID this mailer is using to connect the SMTP host.
	 *
	 * @return the user ID this mailer is using to connect the SMTP host; is
	 * <code>null</code>, if this mailer connect anonymously
	 */
	public String getUser() {
		return mailSess.getProperty("mail.smtp.user");
	}
}
