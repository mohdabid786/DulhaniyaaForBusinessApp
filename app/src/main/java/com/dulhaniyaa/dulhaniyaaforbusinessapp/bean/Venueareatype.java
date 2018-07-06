package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venueareatype {
    @SerializedName("vat_name")
    private String vatName;

    @SerializedName("vat_id")
    private String vatId;

    public String getVatName() {
        return vatName;
    }

    public void setVatName(String vatName) {
        this.vatName = vatName;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }
}
