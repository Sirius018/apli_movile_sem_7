package com.example.semana_7.service;

import com.example.semana_7.entity.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceProducto {

    @GET("/products")
    public abstract Call<List<Producto>> listaProducto();
}
