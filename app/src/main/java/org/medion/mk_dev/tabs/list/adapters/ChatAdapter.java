package org.medion.mk_dev.tabs.list.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.medion.mk_dev.tabs.R;
import org.medion.mk_dev.tabs.list.ChatItem;

public class ChatAdapter extends ArrayAdapter<ChatItem> {

	private  ChatItem[] objs;

	public ChatAdapter( Context context, ChatItem[] items ){
		super( context, R.layout.chat_item, items );
		objs = items;
	}

	@NonNull
	@Override
	public View getView( int position, @Nullable View convertView,  @NonNull ViewGroup parent ) {
//		creamos un inflater para "inflar" la vista
		LayoutInflater inflater = LayoutInflater.from( getContext() );
//		guradamos el layout como una vista:
		View item = inflater.inflate( R.layout.chat_item, null );
//		Recuperamos los elementos:
		ImageView userImg = item.findViewById( R.id.userImg );
		TextView userName = item.findViewById( R.id.userName );
		TextView lastMsg = item.findViewById( R.id.lastMsg );
		TextView msgCount = item.findViewById( R.id.msgCount );
		TextView date = item.findViewById( R.id.date );

//		colocamos todos los datos correspondientes en cada vista:
		userImg.setImageDrawable( objs[position].getUserImg() );
		userName.setText( objs[position].getUserName() );
		lastMsg.setText( objs[position].getLastMesage() );
		if ( objs[position].getMsgCount() != 0  )
			msgCount.setText( objs[position].getMsgCount() + "" );
		else
			msgCount.setText( "" );
		date.setText( objs[position].getDate() );

//		devolvemos el objeto
		return item;

	}
}
