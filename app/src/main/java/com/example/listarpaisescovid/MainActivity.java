package com.example.listarpaisescovid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.example.listarpaisescovid.Modelo.Pais;
import com.example.listarpaisescovid.Modelo.adaptadorPais;
import com.example.listarpaisescovid.WebService.*;
import org.json.*;


public class MainActivity extends AppCompatActivity  implements Asynchtask, AdapterView.OnItemClickListener {

    Map<String,String> datos;
    ListView ltvPaises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ltvPaises=(ListView)findViewById(R.id.ltvPaises);
        this.Paises();

    }
    public void Paises(){
        datos=new HashMap<String, String>();
        WebService ws= new WebService("https://api.covid19api.com/summary",datos,MainActivity.this,MainActivity.this);
        ws.execute("GET");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject respuestaJSON = new JSONObject(result.toString());
        JSONArray PaisesJSON = respuestaJSON.getJSONArray("Countries");
        Pais [] arrayPais=new Pais[PaisesJSON.length()];
        for(int i=0;i<PaisesJSON.length();i++){
            JSONObject paisInfo=  PaisesJSON.getJSONObject(i);
            arrayPais[i]=new Pais();
            arrayPais[i].setNombre(paisInfo.getString("Country").toString());
            arrayPais[i].setTotalMuertes(Integer.parseInt(paisInfo.getString("TotalDeaths").toString()));
            arrayPais[i].setTotalRecuperados(Integer.parseInt(paisInfo.getString("TotalRecovered").toString()));
            arrayPais[i].setTotalConfirmados(Integer.parseInt(paisInfo.getString("TotalConfirmed").toString()));
        }
        View header = getLayoutInflater().inflate(R.layout.ly_headerpais, null);
        adaptadorPais adaptadorpais=new adaptadorPais(this, arrayPais);
        ltvPaises.addHeaderView(header);
        ltvPaises.setAdapter(adaptadorpais);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}