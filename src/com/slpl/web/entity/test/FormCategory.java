package com.slpl.web.entity.test;

public class FormCategory {
	private int id;
	private String name;
	
	public FormCategory() {
		// TODO Auto-generated constructor stub
	}

	public FormCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FormCategory [id=" + id + ", name=" + name + "]";
	}
	
}
