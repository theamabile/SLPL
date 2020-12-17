package com.slpl.web.entity.member;

import java.sql.Timestamp;

public class MessageSendView extends MessageSend{
	String senderName;
	String receiverName;
	String title;
	String content;
	String type;
	
	public MessageSendView(int id, int senderId, int receiverId, int messageId, Timestamp regdate, String senderName,
			String receiverName, String title, String content, String type) {
		super(id, senderId, receiverId, messageId, regdate);
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.title = title;
		this.content = content;
		this.type = type;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		type = type;
	}

	@Override
	public String toString() {
		return "MessageSendView [senderName=" + senderName + ", receiverName=" + receiverName + ", title=" + title
				+ ", content=" + content + ", type=" + type + "]";
	}
}
