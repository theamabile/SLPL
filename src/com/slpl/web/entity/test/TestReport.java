package com.slpl.web.entity.test;

import java.sql.Date;

public class TestReport {
	private int id;
	private int testId;
	private int memberId;
	private String reason;
	private Date regdate;
	private int type;
	private String warringMsgDate;
	private String state;
	private String memberNicname;

	public TestReport() {
		// TODO Auto-generated constructor stub
	}
	
	public TestReport(int id, String stateType) {
		this.id = id;
		this.state = stateType;
	}
	
	public TestReport(int id, int testId, int memberId, String reason, Date regdate, int type, String warringMsgDate,
			String state) {
		this.id = id;
		this.testId = testId;
		this.memberId = memberId;
		this.reason = reason;
		this.regdate = regdate;
		this.type = type;
		this.warringMsgDate = warringMsgDate;
		this.state = state;
	}
	
	public TestReport(int id, int testId, int memberId, String reason, Date regdate, int type, String warringMsgDate,
			String state, String memberNicname) {
		this.id = id;
		this.testId = testId;
		this.memberId = memberId;
		this.reason = reason;
		this.regdate = regdate;
		this.type = type;
		this.warringMsgDate = warringMsgDate;
		this.state = state;
		this.memberNicname = memberNicname;
	}

	public String getMemberNicname() {
		return memberNicname;
	}

	public void setMemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getWarringMsgDate() {
		return warringMsgDate;
	}

	public void setWarringMsgDate(String warringMsgDate) {
		this.warringMsgDate = warringMsgDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TestReport [id=" + id + ", testId=" + testId + ", memberId=" + memberId + ", reason=" + reason
				+ ", regdate=" + regdate + ", type=" + type + ", warringMsgDate=" + warringMsgDate + ", state=" + state
				+ ", memberNicname=" + memberNicname + "]";
	}

}
