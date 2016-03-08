package com.egoncalves.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class User {
	private String name;
	private String url;
	private int id;
	@SerializedName(value = "followers_url")
	private String followersUrl;
	@SerializedName(value = "repos_url")
	private String repos;

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
	

	public String getFollowersUrl() {
		return followersUrl;
	}

	public void setFollowersUrl(String followersUrl) {
		this.followersUrl = followersUrl;
	}
	
	public String getRepos() {
		return repos;
	}

	public void setRepos(String repos) {
		this.repos = repos;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", url=" + url + ", id=" + id + ", followersUrl=" + followersUrl + ", repos="
				+ repos + "]";
	}

}
