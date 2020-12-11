package com.example.listarpaisescovid.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listarpaisescovid.R;

public class adaptadorPais extends ArrayAdapter<Pais> {
    public adaptadorPais(Context context, Pais[] paises) {
        super(context, R.layout.ly_itempais, paises);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itempais, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getNombre());
        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText("  Casos confirmados:  "+getItem(position).getTotalConfirmados()+" \n   Recuperados:   "+getItem(position).getTotalRecuperados()
        +" \n   Muertes:    "+getItem(position).getTotalMuertes());

        return(item);
    }
}
