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

@Entity
@Table(name = "husband")
public class Husband implements Serializable{
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "hid")
	private Long hid;
	@Column(name = "hname")
	private String hname;
	@Column(name = "hid_card")
	private String hidCard;
	
	@OneToOne(targetEntity = Wife.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "w_id",referencedColumnName="wid")
	private Wife wife;

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHidCard() {
		return hidCard;
	}

	public void setHidCard(String hidCard) {
		this.hidCard = hidCard;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", hname=" + hname + ", hidCard="
				+ hidCard + ", wife=" + wife + "]";
	}



}
