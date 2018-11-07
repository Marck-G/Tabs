package org.medion.mk_dev.tabs;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TabHost;

import org.medion.mk_dev.tabs.list.ChatItem;
import org.medion.mk_dev.tabs.list.adapters.ChatAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
	private ListView chatList;

	@RequiresApi( api = Build.VERSION_CODES.LOLLIPOP )
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTabs();
		setList();

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
				.setLastTime( new Date( 18,9, 20 ) )
				.setUserName( "Ana" )
				.setMsgCount( 3 )
				.setUserImg( getDrawable( R.mipmap.ic_user_none ) ));

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
		tabs.setCurrentTab(0);
		// evento para las pestañas
		tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			@Override
			public void onTabChanged(String s) {
			}
		});
	}
}
