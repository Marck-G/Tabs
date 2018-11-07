package org.medion.mk_dev.tabs.list;

import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Llamada {
	private String callUserName;
	private String callDate;
	private static SimpleDateFormat format = new SimpleDateFormat( "dd MMMM hh:mm" );
	private Date date;
	private Drawable callUserImg;
	private boolean direction;
	private boolean callTaken;

	public Llamada(){}

	public String getCallUserName() {
		return callUserName;
	}

	public Llamada setCallUserName( String callUserName ) {
		this.callUserName = callUserName;
		return this;
	}

	public String getCallDate() {
		String d = format.format( date );
		d = d.substring( 0, d.indexOf( " " ) ) + " de "+
				d.substring( d.indexOf( " " ) + 1 );
		return d;
	}

	public Llamada setCallDate( Date callDate ) {
		this.date = callDate;
		return this;
	}

	public boolean getDirection() {
		return direction;
	}

	public Llamada setDirection( String direction ) {
		this.direction = direction.equalsIgnoreCase( "in" );
		return this;
	}

	public boolean isCallTaken() {
		return callTaken;
	}

	public Llamada setCallTaken( String callTaken ) {
		this.callTaken = callTaken.equalsIgnoreCase( "yes" );
		return this;
	}

	public Drawable getCallUserImg() {
		return callUserImg;
	}

	public Llamada setCallUserImg( Drawable callUserImg ) {
		this.callUserImg = callUserImg;
		return this;
	}
}
