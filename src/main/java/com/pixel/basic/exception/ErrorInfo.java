package com.pixel.basic.exception;

public class ErrorInfo <T>{
	public static final String OK = "0";
    public static  final String ERROR = "-1";

    private String code; //行为准则，信号
    private String message;//信息
    private String url;//地址
    private String params;//参数
    private T datas;//数据
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}
    
    


}
