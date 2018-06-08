package org.fkit.hrm.domain.stock;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Message<T> {
	private Integer code;
	private String msg;
	private T content;
	private List<T> contentList;

	public Message() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public List<T> getContentList() {
		return contentList;
	}

	public void setContentList(List<T> contentList) {
		this.contentList = contentList;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", content=" + content + ", contentList=" + contentList + "]";
	}

	public void clean() {
		code = null;
		msg = null;
		content = null;
		contentList = null;

	}

}
