package common;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String userName;
	private String name;
	private String surName;
	private boolean teacher = false;
	private String email;
	private String password;
	private String url;
	
	private String urlActual;
	private String selectedElement;

	public Usuario(String userName, String name, String surName, boolean teacher, String email, String password,
			String url) {
		this.userName = userName;
		this.name = name;
		this.surName = surName;
		this.teacher = teacher;
		this.email = email;
		this.password = password;
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public boolean isTeacher() {
		return teacher;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlActual() {
		return urlActual;
	}

	public void setUrlActual(String urlActual) {
		this.urlActual = urlActual;
	}

	public String getSelectedElement() {
		return selectedElement;
	}

	public void setSelectedElement(String selectedElement) {
		this.selectedElement = selectedElement;
	}

}
