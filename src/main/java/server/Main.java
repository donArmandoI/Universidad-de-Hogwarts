package server;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		String rootUrl = "C://UNIVERSIDAD";

		File f = new File(rootUrl);
		File f2 = new File(rootUrl + File.separator + "alumnos");
		File f3 = new File(rootUrl + File.separator + "profesores");

		if (!f.exists()) {
			f.mkdir();
			f2.mkdir();
			f3.mkdir();
		}

		if (!f2.exists()) {
			f2.mkdir();
		}

		if (!f3.exists()) {
			f3.mkdir();
		}

		FTPServer ftpServer = new FTPServer(rootUrl);

	}

}
