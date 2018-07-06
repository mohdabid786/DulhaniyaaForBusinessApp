package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.SerializedName;

class AddPortfolio {

    @SerializedName("vp_id")
    private String vpId;
    @SerializedName("vp_img")
    private String vpImg;
    @SerializedName("vp_created")
    private String vpCreated;
    @SerializedName("vendor_id")
    private String vendorId;

    public String getVpId() {
        return vpId;
    }

    public void setVpId(String vpId) {
        this.vpId = vpId;
    }

    public String getVpImg() {
        return vpImg;
    }

    public void setVpImg(String vpImg) {
        this.vpImg = vpImg;
    }

    public String getVpCreated() {
        return vpCreated;
    }

    public void setVpCreated(String vpCreated) {
        this.vpCreated = vpCreated;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
