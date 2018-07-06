
package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorSocialmedia {

    @SerializedName("vs_id")
    @Expose
    private String vsId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("vs_facebook")
    @Expose
    private String vsFacebook;
    @SerializedName("vs_instagram")
    @Expose
    private String vsInstagram;
    @SerializedName("vs_website")
    @Expose
    private String vsWebsite;
    @SerializedName("vs_youtube")
    @Expose
    private String vsYoutube;
    @SerializedName("vs_vimeo")
    @Expose
    private String vsVimeo;
    @SerializedName("vs_pinterest")
    @Expose
    private String vsPinterest;
    @SerializedName("vs_twitter")
    @Expose
    private String vsTwitter;

    public String getVsId() {
        return vsId;
    }

    public void setVsId(String vsId) {
        this.vsId = vsId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVsFacebook() {
        return vsFacebook;
    }

    public void setVsFacebook(String vsFacebook) {
        this.vsFacebook = vsFacebook;
    }

    public String getVsInstagram() {
        return vsInstagram;
    }

    public void setVsInstagram(String vsInstagram) {
        this.vsInstagram = vsInstagram;
    }

    public String getVsWebsite() {
        return vsWebsite;
    }

    public void setVsWebsite(String vsWebsite) {
        this.vsWebsite = vsWebsite;
    }

    public String getVsYoutube() {
        return vsYoutube;
    }

    public void setVsYoutube(String vsYoutube) {
        this.vsYoutube = vsYoutube;
    }

    public String getVsVimeo() {
        return vsVimeo;
    }

    public void setVsVimeo(String vsVimeo) {
        this.vsVimeo = vsVimeo;
    }

    public String getVsPinterest() {
        return vsPinterest;
    }

    public void setVsPinterest(String vsPinterest) {
        this.vsPinterest = vsPinterest;
    }

    public String getVsTwitter() {
        return vsTwitter;
    }

    public void setVsTwitter(String vsTwitter) {
        this.vsTwitter = vsTwitter;
    }

}
