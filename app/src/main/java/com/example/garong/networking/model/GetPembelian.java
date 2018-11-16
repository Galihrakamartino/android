package com.example.garong.networking.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPembelian {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pembelian> listDataPembelian;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pembelian> getListDataPembelian() {
        return listDataPembelian;
    }

    public void setListDataPembelian(List<Pembelian> listDataPembelian) {
        this.listDataPembelian = listDataPembelian;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
