package com.slpl.web.entity.member;

import java.sql.Date;
import java.sql.Timestamp;

public class MessageSend {
	private int id;
	private int senderId;
	private int receiverId;
    private int messageId;
    private Timestamp regdate;
    
	public MessageSend(int id, int senderId, int receiverId, int messageId, Timestamp regdate) {
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageId = messageId;
		this.regdate = regdate;
	}

	public MessageSend(int senderId, int receiverId, int messageId) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageId = messageId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MessageSend [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", messageId="
				+ messageId + ", regdate=" + regdate + "]";
	}
	
}
