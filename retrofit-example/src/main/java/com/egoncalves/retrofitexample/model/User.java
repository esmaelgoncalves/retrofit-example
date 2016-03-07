package com.egoncalves.retrofitexample.model;

public class User {
	private String name;
	private String url;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", url=" + url + ", id=" + id + "]";
	}
	
	

}
