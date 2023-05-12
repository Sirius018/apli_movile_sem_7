package com.example.semana_7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.semana_7.R;
import com.example.semana_7.entity.Producto;
import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    private Context context;
    private List<Producto> lista;
    public ProductoAdapter(@NonNull Context context, int resource, @NonNull List<Producto> lista) {
        super(context, resource, lista);
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_item_producto, parent, false);

        TextView txtId = row.findViewById(R.id.txtIdProducto);
        TextView txtTitutlo = row.findViewById(R.id.txtTituloProducto);
        TextView txtPrecio = row.findViewById(R.id.txtPrecio);
        TextView txtCategoria = row.findViewById(R.id.txtCategoria);
        ImageView imgFoto = row.findViewById(R.id.idImagenProducto);


        Producto objProducto = lista.get(position);
        txtId.setText(String.valueOf(objProducto.getId()));
        txtTitutlo.setText(objProducto.getTitle());
        txtPrecio.setText(String.valueOf(objProducto.getPrice()));
        txtCategoria.setText(String.valueOf(objProducto.getCategory()));
        Glide.with(context).load(objProducto.getImage()).into(imgFoto);










        //return super.getView(position, convertView, parent);
        return row;
    }
}
