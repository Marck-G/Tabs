package org.medion.mk_dev.tabs.list;

import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ChatItem {
	private Drawable userImg;
	private String  userName;
	private String  lastMesage;
	private Date    lastTime;
	private int     msgCount = 0;
	private String  date;
	private SimpleDateFormat toString;

//	Contructor de ChatItem
	public ChatItem( Drawable userImg, String userName, String lastMesage, Date lastTime, int msgCount ) {
		this.userImg = userImg;
		this.userName = userName;
		this.lastMesage = lastMesage;
		this.lastTime = lastTime;
		this.msgCount = msgCount;
		initFormats();
	}
//	comstructor vacio, solo coloca la fecha
	public ChatItem(){
		initFormats();
	}

	private void initFormats(){
		Date hoy = new Date();
		if( lastTime != null ){
			if ( lastTime.before( hoy ) )
				if( lastTime.getMonth() < hoy.getMonth() ||
						( lastTime.getMonth() == hoy.getMonth()
								&& lastTime.getDay() < hoy.getDay() - 1 ) ){
					toString =  new SimpleDateFormat( "dd/MM/yy" );;
				}else{
					date = "ayer";
					toString = null;
				}
				else
					toString = new SimpleDateFormat( "hh:mm" );
		}

	}

	/**
	 * Restablece el string de la fecha
	 * @return ChatItem, el mismo elemento
	 */
	public ChatItem refreshDate(){
//		 no aseguramos que se ha instanciado correctamente
		if ( toString == null ){
			initFormats();
		}
//		si no es null es que hay que formatear la fecha
//		en caso contrario ya esta establecidad la fecha
		if ( toString != null ){
			date = toString.format( lastTime );
		}

		return this;
	}


	public Drawable getUserImg() {
		return userImg;
	}

	public ChatItem setUserImg( Drawable userImg ) {
		this.userImg = userImg;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public ChatItem setUserName( String userName ) {
		this.userName = userName;
		return this;
	}

	public String getLastMesage() {
		return lastMesage;
	}

	public ChatItem setLastMesage( String lastMesage ) {
		this.lastMesage = lastMesage;
		return this;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public ChatItem setLastTime( Date lastTime ) {
		this.lastTime = lastTime;
		refreshDate();
		return this;
	}

	public int getMsgCount() {
		return msgCount;
	}

	public ChatItem setMsgCount( int msgCount ) {
		this.msgCount = msgCount;
		return this;
	}

	public String getDate() {
		refreshDate();
		return date;
	}

	public SimpleDateFormat getToString() {
		return toString;
	}
}
