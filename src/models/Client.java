package models;

import java.io.BufferedReader;
import java.io.DataOutputStream;

public class Client {
	private String IP;
	private int id;
	private BufferedReader inputStream;
	private DataOutputStream outputStream;
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BufferedReader getInputStream() {
		return inputStream;
	}
	public void setInputStream(BufferedReader inputStream) {
		this.inputStream = inputStream;
	}
	public DataOutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(DataOutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
