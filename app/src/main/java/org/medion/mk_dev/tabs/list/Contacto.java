package org.medion.mk_dev.tabs.list;

import android.graphics.drawable.Drawable;

public class Contacto {
	private String userName;
	private Drawable userImg;
	private String userState;

	public Contacto(){}

	public String getUserName() {
		return userName;
	}

	public Contacto setUserName( String userName ) {
		this.userName = userName;
		return  this;
	}

	public Drawable getUserImg() {
		return userImg;
	}

	public Contacto setUserImg( Drawable userImg ) {
		this.userImg = userImg;
		return this;
	}

	public String getUserState() {
		return userState;
	}

	public Contacto setUserState( String userState ) {
		this.userState = userState;
		return this;
	}
}
