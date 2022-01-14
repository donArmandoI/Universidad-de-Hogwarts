package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

	public static void showConsoleText(String msg) {
		System.out.println(msg);
	}
	
	public static boolean comprobarEmail(String email) {
		boolean correcto = false;
		
		Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)\\.(.+)$");
		Matcher m = p.matcher(email);
		
		correcto = m.find();
		
		return correcto;
	}

	public static boolean comprobarNameSurName(String name) {
		boolean correcto = false;

		Pattern p = Pattern.compile("[A-Za-z ]*");
		Matcher m = p.matcher(name);

		if (!name.isEmpty() && name != null && m.find()) {

			correcto = true;
		}

		return correcto;
	}

	public static boolean comprobarPassword(String password) {
		boolean correcto = false;

		String[] restricciones = { "[A-Z]*", "[a-z]*", "[0-9]*" };

		Pattern p = Pattern.compile(restricciones[0]);
		Matcher m = p.matcher(password);

		if (password.length() >= 8) {

			if (m.find()) {

				p.compile(restricciones[1]);

				if (m.find()) {

					p.compile(restricciones[2]);

					if (m.find()) {
						correcto = true;
					}
				}
			}
		}

		return correcto;
	}

	public static boolean comprobarUserName(String userName) {
		boolean correcto = false;

		Pattern p = Pattern.compile("^[A-Za-z0-9][A-Za-z0-9_-]*[A-Za-z0-9]$");
		Matcher m = p.matcher(userName);

		if (!userName.isEmpty() && userName != null && m.find()) {

			correcto = true;
		}

		return correcto;
	}
}
