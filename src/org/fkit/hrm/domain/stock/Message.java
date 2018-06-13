package org.fkit.hrm.domain.stock;

import java.util.List;

import org.fkit.hrm.util.tag.PageModel;
import org.springframework.stereotype.Component;

@Component
public class Message<T> {
	private Integer code;
	private String msg;
	private PageModel pageModel;
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

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	public void clean() {
		code = null;
		msg = null;
		pageModel = null;
		content = null;
		contentList = null;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", pageModel=" + pageModel + ", content=" + content
				+ ", contentList=" + contentList + "]";
	}

}
