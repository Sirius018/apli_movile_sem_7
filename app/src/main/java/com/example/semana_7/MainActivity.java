package com.example.semana_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.semana_7.adapter.ProductoAdapter;
import com.example.semana_7.entity.Producto;
import com.example.semana_7.service.ServiceProducto;
import com.example.semana_7.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Boton
    Button btnListar;

    // ListView
    ListView lstProductos;
    ArrayList<Producto> data = new ArrayList<Producto>();
    ProductoAdapter adaptador;

    // Servicio
    ServiceProducto servicioProducto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListar = findViewById(R.id.btnListar);
        lstProductos = findViewById(R.id.lstProductos);
        adaptador = new ProductoAdapter(this, R.layout.activity_item_producto, data);
        lstProductos.setAdapter(adaptador);

        servicioProducto = ConnectionRest.getConnection().create(ServiceProducto.class);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaProducto();

            }
        });
    }


    public void listaProducto(){
        Call<List<Producto>> call = servicioProducto.listaProducto();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()){
                    List<Producto> lista = response.body();
                    data.clear();
                    data.addAll(lista);
                    adaptador.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }
}