package com.example.garong.networking.model;

import com.google.gson.annotations.SerializedName;


public class PostPutDelPembelian {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pembelian mPembelian;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pembelian getmPembelian() {
        return mPembelian;
    }

    public void setmPembelian(Pembelian mPembelian) {
        this.mPembelian = mPembelian;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
