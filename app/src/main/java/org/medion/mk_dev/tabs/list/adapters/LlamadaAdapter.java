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
import org.medion.mk_dev.tabs.list.Llamada;

public final class LlamadaAdapter extends ArrayAdapter {

	private Llamada[] datos;

	public LlamadaAdapter( Context context, Llamada[] datos ){
		super( context, R.layout.llamada_item, datos );
		this.datos = datos;
	}

	@NonNull
	@Override
	public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
		LayoutInflater f = LayoutInflater.from( getContext() );
		View v = f.inflate( R.layout.llamada_item, null );
//		cogemos los elementos:

		TextView userName = v.findViewById( R.id.callUserName );
		ImageView userImg = v.findViewById( R.id.callUserImg );
		TextView callDate = v.findViewById( R.id.callDate );

//		Rellenamos con los datos:
		userName.setText( datos[position].getCallUserName() );
		userImg.setImageDrawable( datos[position].getCallUserImg() );
		callDate.setText( datos[position].getCallDate() );

		return v;
	}
}
