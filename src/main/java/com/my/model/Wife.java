package com.my.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "wife")
public class Wife implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091602122698339709L;
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "wid")
	private Long wid;
	@Column(name = "wname")
	private String wname;
	@Column(name = "wid_card")
	private String widCard;
	
	 @OneToOne(mappedBy = "wife",cascade=CascadeType.ALL)
	 @JsonBackReference
	 private  Husband husband;

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWidCard() {
		return widCard;
	}

	public void setWidCard(String widCard) {
		this.widCard = widCard;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "{\"wid\":\"" + wid + "\",\"wname\":\"" + wname
				+ "\",\"widCard\":\"" + widCard + "\"} ";
	}
	


//	@Override
//	public String toString() {
//		return "'{'wid':" + wid + ", 'wname':" + wname + ", 'widCard':" + widCard
//				+ "}'";
//	}
//	

//	@Override
//	public String toString() {
//		return "Wife [wid=" + wid + ", wname=" + wname + ", widCard=" + widCard
//				+ "]";
//	}
//	
	 
}
