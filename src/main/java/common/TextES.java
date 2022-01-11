package common;

/**
 * Texts in Spanish
 * @author Armando
 *
 */
public final class TextES {

	private static String main_menu_login = "Iniciar Sesión";
	
	private static final String ButtonNewMailSendListenerConfigset = "ConfigSet";
	private static final String ButtonNewMailSendListenerErrorMessageIncorrectAddress = "La dirección de correo introducida no es válida";
	private static final String ButtonNewMailSendListenerErrorMessageMessageNotSent = "Error enviando el mensaje";
	private static final String ButtonNewMailSendListenerFrom = "ialonsocalzado.sanjose@alumnado.fundacionloyola.net";
	private static final String ButtonNewMailSendListenerFromName = "Sandalphon";
	private static final String ButtonNewMailSendListenerHost = "smtp.gmail.com";
	private static final String ButtonNewMailSendListenerMessageMessageSentOK = "Mensaje enviado";
	private static final String ButtonNewMailSendListenerProtocolHostProperty = "mail.smtp.host";
	private static final String ButtonNewMailSendListenerProtocolHostValue = "smtp.gmail.com";
	private static final String ButtonNewMailSendListenerProtocolPortProperty = "mail.smtp.port";
	private static final int ButtonNewMailSendListenerProtocolPortValue = 587;
	private static final String ButtonNewMailSendListenerSMTPAuthProperty = "mail.smtp.auth";
	private static final String ButtonNewMailSendListenerSMTPAuthValue = "false";
	private static final String ButtonNewMailSendListenerSMTPUsername = "ialonsocalzado.sanjose@alumnado.fundacionloyola.net";
	private static final String ButtonNewMailSendListenerSMTPPassword = "5C0rp1u5";
	private static final String ButtonNewMailSendListenerStartTLSProperty = "mail.smtp.starttls.enable";
	private static final String ButtonNewMailSendListenerStartTLSValue = "true";
	private static final String ButtonNewMailSendListenerTo = "info@universidadhogwarts.com";
	private static final String ButtonNewMailSendListenerTransportProtocolProperty = "mail.transport.protocol";
	private static final String ButtonNewMailSendListenerTransportProtocolValue	= "smtp";
	
	private static String controllerMailInboundTargetFolder = "inbox";
	private static String controllerMailInboundHost = "imap.gmail.com";
	private static String controllerMailInboundPassword = "5C0rp1u5";
	private static String controllerMailInboundPort = "993";
	private static String controllerMailInboundProtocol = "imap";
	private static String controllerMailInboundSocketFactoryFallback = "false";
	private static String controllerMailInboundSocketFactoryPort = "993";
	private static String controllerMailInboundSSLSocketFactoryClass = "javax.net.ssl.SSLSocketFactory";
	private static String controllerMailInboundUserName = "ialonsocalzado.sanjose@alumnado.fundacionloyola.net";
	
	private static String emailStringNewMail = "Crear mensaje";
	private static String emailStringSend ="Enviar";
	private static String emailStringCancel = "Cancelar";
	private static String emailStringSubject = "Asunto";
	private static String emailStringFrom = "Remitente";
	private static String emailStringTo = "Destinatario";
	
	private static String ftpcreateStringConfirm = "Confirmar";
	private static String ftpStringUpload = "Subir archivo";
	private static String ftpStringDownload = "Bajar archivo";
	private static String ftpStringCreate = "crear carpeta";
	private static String ftpStringRename = "Renombrar";
	private static String ftpStringDelete = "Eliminar";
		
	private static String mainStringFTP = "FTP";
	private static String mainStringMail ="Correo";
	private static String mainStringDisconnect = "Desconectar";
	private static String mainStringTitle = "Principal";
	
	private static String signinStringUserName = "Usuario";
	private static String signinStringName = "Nombre";
	private static String signinStringSurname = "Apellidos";
	private static String signinStringTeacher = "¿Eres Profesor?";
	private static String signinStringEmail = "Correo Electrónico";
	private static String signinStringPassword = "Contraseña";
	private static String signinStringLogin = "Iniciar Sesión";
	private static String signinStringSignin = "Registrarse";
	private static String signinStringInfo;
	private static String loginStringInfo;
	public static String getMain_menu_login() {
		return main_menu_login;
	}
	public static String getButtonnewmailsendlistenerconfigset() {
		return ButtonNewMailSendListenerConfigset;
	}
	public static String getButtonnewmailsendlistenererrormessageincorrectaddress() {
		return ButtonNewMailSendListenerErrorMessageIncorrectAddress;
	}
	public static String getButtonnewmailsendlistenererrormessagemessagenotsent() {
		return ButtonNewMailSendListenerErrorMessageMessageNotSent;
	}
	public static String getButtonnewmailsendlistenerfrom() {
		return ButtonNewMailSendListenerFrom;
	}
	public static String getButtonnewmailsendlistenerfromname() {
		return ButtonNewMailSendListenerFromName;
	}
	public static String getButtonnewmailsendlistenerhost() {
		return ButtonNewMailSendListenerHost;
	}
	public static String getButtonnewmailsendlistenermessagemessagesentok() {
		return ButtonNewMailSendListenerMessageMessageSentOK;
	}
	public static String getButtonnewmailsendlistenerprotocolhostproperty() {
		return ButtonNewMailSendListenerProtocolHostProperty;
	}
	public static String getButtonnewmailsendlistenerprotocolhostvalue() {
		return ButtonNewMailSendListenerProtocolHostValue;
	}
	public static String getButtonnewmailsendlistenerprotocolportproperty() {
		return ButtonNewMailSendListenerProtocolPortProperty;
	}
	public static int getButtonnewmailsendlistenerprotocolportvalue() {
		return ButtonNewMailSendListenerProtocolPortValue;
	}
	public static String getButtonnewmailsendlistenersmtpauthproperty() {
		return ButtonNewMailSendListenerSMTPAuthProperty;
	}
	public static String getButtonnewmailsendlistenersmtpauthvalue() {
		return ButtonNewMailSendListenerSMTPAuthValue;
	}
	public static String getButtonnewmailsendlistenersmtpusername() {
		return ButtonNewMailSendListenerSMTPUsername;
	}
	public static String getButtonnewmailsendlistenersmtppassword() {
		return ButtonNewMailSendListenerSMTPPassword;
	}
	public static String getButtonnewmailsendlistenerstarttlsproperty() {
		return ButtonNewMailSendListenerStartTLSProperty;
	}
	public static String getButtonnewmailsendlistenerstarttlsvalue() {
		return ButtonNewMailSendListenerStartTLSValue;
	}
	public static String getButtonnewmailsendlistenerto() {
		return ButtonNewMailSendListenerTo;
	}
	public static String getButtonnewmailsendlistenertransportprotocolproperty() {
		return ButtonNewMailSendListenerTransportProtocolProperty;
	}
	public static String getButtonnewmailsendlistenertransportprotocolvalue() {
		return ButtonNewMailSendListenerTransportProtocolValue;
	}
	public static String getControllerMailInboundTargetFolder() {
		return controllerMailInboundTargetFolder;
	}
	public static String getControllerMailInboundHost() {
		return controllerMailInboundHost;
	}
	public static String getControllerMailInboundPassword() {
		return controllerMailInboundPassword;
	}
	public static String getControllerMailInboundPort() {
		return controllerMailInboundPort;
	}
	public static String getControllerMailInboundProtocol() {
		return controllerMailInboundProtocol;
	}
	public static String getControllerMailInboundSocketFactoryFallback() {
		return controllerMailInboundSocketFactoryFallback;
	}
	public static String getControllerMailInboundSocketFactoryPort() {
		return controllerMailInboundSocketFactoryPort;
	}
	public static String getControllerMailInboundSSLSocketFactoryClass() {
		return controllerMailInboundSSLSocketFactoryClass;
	}
	public static String getControllerMailInboundUserName() {
		return controllerMailInboundUserName;
	}
	public static String getEmailStringNewMail() {
		return emailStringNewMail;
	}
	public static String getEmailStringSend() {
		return emailStringSend;
	}
	public static String getEmailStringCancel() {
		return emailStringCancel;
	}
	public static String getEmailStringSubject() {
		return emailStringSubject;
	}
	public static String getEmailStringFrom() {
		return emailStringFrom;
	}
	public static String getEmailStringTo() {
		return emailStringTo;
	}
	public static String getFtpcreateStringConfirm() {
		return ftpcreateStringConfirm;
	}
	public static String getFtpStringUpload() {
		return ftpStringUpload;
	}
	public static String getFtpStringDownload() {
		return ftpStringDownload;
	}
	public static String getFtpStringCreate() {
		return ftpStringCreate;
	}
	public static String getFtpStringRename() {
		return ftpStringRename;
	}
	public static String getFtpStringDelete() {
		return ftpStringDelete;
	}
	public static String getMainStringFTP() {
		return mainStringFTP;
	}
	public static String getMainStringMail() {
		return mainStringMail;
	}
	public static String getMainStringDisconnect() {
		return mainStringDisconnect;
	}
	public static String getMainStringTitle() {
		return mainStringTitle;
	}
	public static String getSigninStringUserName() {
		return signinStringUserName;
	}
	public static String getSigninStringName() {
		return signinStringName;
	}
	public static String getSigninStringSurname() {
		return signinStringSurname;
	}
	public static String getSigninStringTeacher() {
		return signinStringTeacher;
	}
	public static String getSigninStringEmail() {
		return signinStringEmail;
	}
	public static String getSigninStringPassword() {
		return signinStringPassword;
	}
	public static String getSigninStringLogin() {
		return signinStringLogin;
	}
	public static String getSigninStringSignin() {
		return signinStringSignin;
	}
	public static String getSigninStringInfo() {
		return signinStringInfo;
	}
	public static String getLoginStringInfo() {
		return loginStringInfo;
	}
	
	
}
