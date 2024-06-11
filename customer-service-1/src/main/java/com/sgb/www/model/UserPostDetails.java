package com.sgb.www.model;


public class UserPostDetails {
    private int id;
    private String lat;
    private String lng;
    private String title;
    private String body;

    public UserPostDetails(int id, String lat, String lng, String title, String body) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.title = title;
        this.body = body;
    }

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    
}