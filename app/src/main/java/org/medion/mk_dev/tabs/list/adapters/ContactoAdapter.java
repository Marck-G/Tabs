package org.medion.mk_dev.tabs.list.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.medion.mk_dev.tabs.R;
import org.medion.mk_dev.tabs.list.Contacto;
import org.w3c.dom.Text;

import java.util.zip.Inflater;

public final class ContactoAdapter extends ArrayAdapter {

	private Contacto[] data;

	public ContactoAdapter( Context context, Contacto[] data ){
		super( context, R.layout.contacto_item, data );
		this.data = data;
	}

	@NonNull
	@Override
	public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
		LayoutInflater inflater = LayoutInflater.from( getContext() );
		View item = inflater.inflate( R.layout.contacto_item, null );

//		Cogemos los views:
		TextView contactName = item.findViewById( R.id.contactName );
		TextView contactState = item.findViewById( R.id.contactState );
		ImageView contactImg = item.findViewById( R.id.contactImg );

		contactImg.setImageDrawable( data[position].getUserImg() );
		contactState.setText( data[position].getUserState() );
		contactName.setText( data[position].getUserName() );

		return item;

	}
}
