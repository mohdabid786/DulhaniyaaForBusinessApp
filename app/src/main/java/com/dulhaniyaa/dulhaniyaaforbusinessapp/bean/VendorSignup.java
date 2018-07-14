package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class VendorSignup {

    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("admin_id")
    @Expose
    private Object adminId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("business_name")
    @Expose
    private String businessName;
    @SerializedName("contact_person")
    @Expose
    private String contactPerson;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("last_login")
    @Expose
    private Object lastLogin;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("other_cat")
    @Expose
    private Object otherCat;
    @SerializedName("other_city")
    @Expose
    private Object otherCity;
    @SerializedName("device_token")
    @Expose
    private String deviceToken;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("token")
    @Expose
    private String token;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public Object getAdminId() {
        return adminId;
    }

    public void setAdminId(Object adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getOtherCat() {
        return otherCat;
    }

    public void setOtherCat(Object otherCat) {
        this.otherCat = otherCat;
    }

    public Object getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(Object otherCity) {
        this.otherCity = otherCity;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
