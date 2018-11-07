package org.medion.mk_dev.tabs;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;

import org.medion.mk_dev.tabs.list.ChatItem;
import org.medion.mk_dev.tabs.list.Contacto;
import org.medion.mk_dev.tabs.list.Llamada;
import org.medion.mk_dev.tabs.list.adapters.ChatAdapter;
import org.medion.mk_dev.tabs.list.adapters.ContactoAdapter;
import org.medion.mk_dev.tabs.list.adapters.LlamadaAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
	private ListView chatList;
	private ListView contactList;
	private ListView llamadaList;

	@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
		setSupportActionBar( toolbar );
		/**
		FloatingActionButton fab = ( FloatingActionButton ) findViewById( R.id.fab );
		fab.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
						.setAction( "Action", null ).show();
			}
		} );*/
		setTabs();
		setList();
		setContactos();
		setLlamadas();

	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		getMenuInflater().inflate( R.menu.menu_main, menu );
		return true;
	}

	@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
	private void setContactos(){
		contactList = findViewById( R.id.contactos );
		Contacto[] data = {
				new Contacto()
						.setUserImg( getDrawable( R.mipmap.ic_user_none ) )
						.setUserName( "Ana" )
						.setUserState( "Durmiendo" ),
				new Contacto().setUserImg( getDrawable( R.mipmap.ic_user_1 ) )
						.setUserState( "Hey there, I'm using WhatsApp!" )
						.setUserName( "Goio" ),
				new Contacto().setUserName( "Juan" )
						.setUserState( "?????" )
						.setUserImg( getDrawable( R.mipmap.ic_user_none ) )};
		ContactoAdapter c = new ContactoAdapter( getApplicationContext(), data );
		contactList.setAdapter( c );
	}


	@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
	private void setList() {
		chatList = findViewById( R.id.chatList );

		ArrayList<ChatItem> its = new ArrayList<ChatItem>();
		its.add( new ChatItem().setLastMesage( "Hola" )
				.setLastTime( new Date() )
				.setUserName( "Juan" )
				.setUserImg( getDrawable( R.mipmap.ic_user_none ) ));
		its.add( new ChatItem().setLastMesage( "Que tal?" )
				.setLastTime( new Date( 18,9, 8 ) )
				.setUserName( "Ana" )
				.setMsgCount( 3 )
				.setUserImg( getDrawable( R.mipmap.ic_user_none ) ));
		its.add( new ChatItem().setLastMesage( "Good Morning!" )
				.setLastTime( new Date( 18,10, 6 ) )
				.setUserName( "Goio" )
				.setMsgCount( 1 )
				.setUserImg( getDrawable( R.mipmap.ic_user_1 ) ));

		ChatItem[] datos = new ChatItem[its.size()];
		its.toArray( datos );
		ChatAdapter ad = new ChatAdapter( getApplicationContext(), datos );
		chatList.setAdapter( ad );

	}

	private void setTabs(){
		Resources res = getResources();
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		TabHost.TabSpec spec=tabs.newTabSpec("chat");
		spec.setContent(R.id.tab1);
		spec.setIndicator("CHATS");
		tabs.addTab(spec);
		spec=tabs.newTabSpec("estados");
		spec.setContent(R.id.tab2);
		spec.setIndicator("ESTADOS");
		tabs.addTab(spec);
		spec = tabs.newTabSpec( "llamadas" );
		spec.setContent( R.id.tab3 );
		spec.setIndicator( "LLAMADAS" );
		tabs.addTab( spec );
		tabs.setCurrentTab(0);
		// evento para las pestañas
		tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			@SuppressLint( "RestrictedApi" )
			@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
			@Override
			public void onTabChanged(String s) {
				ActionMenuItemView v = findViewById( R.id.add );
				if( s.equals( "chat" ) ){
					v.setIcon( getDrawable( R.drawable.ic_msg ) );
				} else if ( s.equals( "estados" ) )
					v.setIcon( getDrawable( R.drawable.ic_add ) );
				else if ( s.equals( "llamadas" ) )
					v.setIcon( getDrawable( R.drawable.ic_call ) );
			}
		});
	}

	@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
	private void setLlamadas(){
		llamadaList = findViewById( R.id.llamadas );
		Llamada[] datos;
		datos = new Llamada[]{
				new Llamada().setCallDate( new Date( 2018,9,20 ) )
						.setCallUserName( "Ana" )
						.setCallUserImg( getDrawable( R.mipmap.ic_user_none ) ),
				new Llamada().setCallUserImg( getDrawable( R.mipmap.ic_user_1 ) )
						.setCallUserName( "Goio" )
						.setCallDate( new Date() )
		};
		LlamadaAdapter a = new LlamadaAdapter( getApplicationContext(), datos );
		llamadaList.setAdapter( a );

	}

}
