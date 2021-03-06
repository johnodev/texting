package com.johnpoulakos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer replyToTextId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date createTimeStamp;
	
    @PrePersist
    protected void onCreate() {
    	this.createTimeStamp = new Date();
    }

	private String messageText;
	
	private String userName;
	
	private String city;
	
	private String latitiude;
	
	private String longitude;
	
	private String temperature;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReplyToTextId() {
		return replyToTextId;
	}

	public void setReplyToTextId(Integer replyToTextId) {
		this.replyToTextId = replyToTextId;
	}

	public Date getCreateTimeStamp() {
		return createTimeStamp;
	}

	public void setCreateTimeStamp(Date createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String message) {
		this.messageText = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitiude() {
		return latitiude;
	}

	public void setLatitiude(String latitiude) {
		this.latitiude = latitiude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}
