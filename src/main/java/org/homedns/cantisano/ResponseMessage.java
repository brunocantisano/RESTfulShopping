package org.homedns.cantisano;

public class ResponseMessage {
	public static final int RET_OK = 200;
	public static final int RET_ERROR = 400;
	
	String msg = "";
	int codErro = RET_ERROR;
	String errorMessage = "";
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCodErro() {
		return codErro;
	}
	public void setCodErro(int codErro) {
		this.codErro = codErro;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
