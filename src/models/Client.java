package models;

import java.io.InputStream;
import java.io.OutputStream;

public class Client {
	private String IP;
	private String id;
	private InputStream inputStream;
	private OutputStream outputStream;
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public OutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
