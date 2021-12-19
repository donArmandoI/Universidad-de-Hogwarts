package common;

/**
 * Texts in Spanish
 * @author Armando
 *
 */
public class TextES {

	private static String signinStringUserName;
	private static String signinStringName;
	private static String signinStringSurname;
	private static String signinStringTeacher;
	private static String signinStringEmail;
	private static String signinStringPassword;
	private static String signinStringLogin;
	private static String signinStringSignin;
	private static String signinStringInfo;
	private static String loginStringInfo;
	
	private static String mainStringFTP;
	private static String mainStringCorreo;
	private static String mainStringDisconnect;
	private static String mainStringTitle;
	
	private static String ftpcreateStringConfirm;
	private static String ftpStringSubir;
	private static String ftpStringBajar;
	private static String ftpStringCrear;
	private static String ftpStringRenombrar;
	private static String ftpStringEliminar;
	
	private static String emailStringNuevoCorreo;
	private static String emailStringEnviar;
	private static String emailStringCancelar;
	private static String emailStringSubject;
	private static String emailStringDe;
	private static String emailStringPara;
	
	public TextES() {
		signinStringLogin = "Iniciar Sesión";
		signinStringSignin = "Registrarse";
		signinStringUserName = "Usuario";
		signinStringPassword = "Contraseña";
		signinStringEmail = "Correo Electrónico";
		signinStringTeacher = "¿Eres Profesor?";
		signinStringSurname = "Apellidos";
		signinStringName = "Nombre";
		
		mainStringFTP = "FTP";
		mainStringCorreo="Correo";
		mainStringDisconnect = "Desconectar";
		mainStringTitle = "Principal";
		
		ftpcreateStringConfirm = "Confirmar";
		ftpStringSubir ="Subir";
		ftpStringBajar = "Bajar";
		ftpStringCrear = "Crear";
		ftpStringRenombrar = "Renombrar";
		ftpStringEliminar = "Eliminar";
		
		emailStringNuevoCorreo= "Escribir nuevo correo";
		emailStringEnviar = "Enviar";
		emailStringCancelar = "Cancelar";
		emailStringSubject = "Asunto";
		emailStringDe = " De ";
		emailStringPara = "Para";
	}

	public static String getEmailStringCancelar() {
		return emailStringCancelar;
	}

	public static String getEmailStringDe() {
		return emailStringDe;
	}

	public static String getEmailStringEnviar() {
		return emailStringEnviar;
	}

	public static String getEmailStringNuevoCorreo() {
		return emailStringNuevoCorreo;
	}

	public static String getEmailStringPara() {
		return emailStringPara;
	}

	public static String getEmailStringSubject() {
		return emailStringSubject;
	}

	public static String getFtpcreateStringConfirm() {
		return ftpcreateStringConfirm;
	}

	public static String getFtpStringBajar() {
		return ftpStringBajar;
	}

	public static String getFtpStringCrear() {
		return ftpStringCrear;
	}

	public static String getFtpStringEliminar() {
		return ftpStringEliminar;
	}

	public static String getFtpStringRenombrar() {
		return ftpStringRenombrar;
	}

	public static String getFtpStringSubir() {
		return ftpStringSubir;
	}

	public static String getMainStringCorreo() {
		return mainStringCorreo;
	}

	public static String getMainStringDisconnect() {
		return mainStringDisconnect;
	}

	public static String getMainStringFTP() {
		return mainStringFTP;
	}

	public static String getMainStringTitle() {
		return mainStringTitle;
	}

	/**
	 * @return the loginStringInfo
	 */
	public String getLoginStringInfo() {
		return loginStringInfo;
	}

	/**
	 * @return the signinStringEmail
	 */
	public String getSigninStringEmail() {
		return signinStringEmail;
	}

	/**
	 * @return the signinStringInfo
	 */
	public String getSigninStringInfo() {
		return signinStringInfo;
	}

	/**
	 * @return the signinStringLogin
	 */
	public String getSigninStringLogin() {
		return signinStringLogin;
	}

	/**
	 * @return the signinStringName
	 */
	public String getSigninStringName() {
		return signinStringName;
	}

	/**
	 * @return the signinStringPassword
	 */
	public String getSigninStringPassword() {
		return signinStringPassword;
	}

	/**
	 * @return the signinStringSignin
	 */
	public String getSigninStringSignin() {
		return signinStringSignin;
	}

	/**
	 * @return the signinStringSurname
	 */
	public String getSigninStringSurname() {
		return signinStringSurname;
	}

	/**
	 * @return the signinStringTeacher
	 */
	public String getSigninStringTeacher() {
		return signinStringTeacher;
	}

	/**
	 * @return the signinStringUserName
	 */
	public String getSigninStringUserName() {
		return signinStringUserName;
	}
	
}
