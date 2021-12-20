package common;

/**
 * Texts in Spanish
 * @author Armando
 *
 */
public final class TextES {

	private static String main_menu_login;
	
	private static String controllerMailInboundTargetFolder;
	private static String controllerMailInboundHost;
	private static String controllerMailInboundPassword;
	private static String controllerMailInboundPort;
	private static String controllerMailInboundProtocol;
	private static String controllerMailInboundSocketFactoryFallback;
	private static String controllerMailInboundSocketFactoryPort;
	private static String controllerMailInboundSSLSocketFactoryClass;
	private static String controllerMailInboundUserName;
	
	
	public TextES() {
		main_menu_login = "Iniciar Sesión";
		
		controllerMailInboundTargetFolder = "INBOX";
		controllerMailInboundHost = "pop.gmail.com";
		controllerMailInboundPassword = "*****";
		controllerMailInboundPort = "995";
		controllerMailInboundProtocol = "pop3";
		controllerMailInboundSocketFactoryFallback= "false";
		controllerMailInboundSocketFactoryPort = "995";
		controllerMailInboundSSLSocketFactoryClass = "javax.net.ssl.SSLSocketFactory";
		controllerMailInboundUserName = "ialonsocalzado.sanjose@alumnado.fundacionloyola.net";
		
		
	}


	public static String getMain_menu_login() {
		return main_menu_login;
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


	public static String getControllerMailInboundSSLSocketFactoryClass() {
		return controllerMailInboundSSLSocketFactoryClass;
	}


	public static String getControllerMailInboundUserName() {
		return controllerMailInboundUserName;
	}


	public static String getControllerMailInboundSocketFactoryPort() {
		return controllerMailInboundSocketFactoryPort;
	}


	public static void setControllerMailInboundSocketFactoryPort(String controllerMailInboundSocketFactoryPort) {
		TextES.controllerMailInboundSocketFactoryPort = controllerMailInboundSocketFactoryPort;
	}


	public static void setMain_menu_login(String main_menu_login) {
		TextES.main_menu_login = main_menu_login;
	}


	public static void setControllerMailInboundHost(String controllerMailInboundHost) {
		TextES.controllerMailInboundHost = controllerMailInboundHost;
	}


	public static void setControllerMailInboundPassword(String controllerMailInboundPassword) {
		TextES.controllerMailInboundPassword = controllerMailInboundPassword;
	}


	public static void setControllerMailInboundPort(String controllerMailInboundPort) {
		TextES.controllerMailInboundPort = controllerMailInboundPort;
	}


	public static void setControllerMailInboundProtocol(String controllerMailInboundProtocol) {
		TextES.controllerMailInboundProtocol = controllerMailInboundProtocol;
	}


	public static void setControllerMailInboundSocketFactoryFallback(String controllerMailInboundSocketFactoryFallback) {
		TextES.controllerMailInboundSocketFactoryFallback = controllerMailInboundSocketFactoryFallback;
	}


	public static void setControllerMailInboundSSLSocketFactoryClass(String controllerMailInboundSSLSocketFactoryClass) {
		TextES.controllerMailInboundSSLSocketFactoryClass = controllerMailInboundSSLSocketFactoryClass;
	}


	public static void setControllerMailInboundUserName(String controllerMailInboundUserName) {
		TextES.controllerMailInboundUserName = controllerMailInboundUserName;
	}


	public static String getControllerMailInboundTargetFolder() {
		return controllerMailInboundTargetFolder;
	}

	
}
