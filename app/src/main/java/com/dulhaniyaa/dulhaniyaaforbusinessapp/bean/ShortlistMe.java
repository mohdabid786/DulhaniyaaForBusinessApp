package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortlistMe {

    @SerializedName("vsh_id")
    private String vshId;

    @SerializedName("vendor_id")
    private String vendorId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("vsh_date")
    private String vshDate;

    @SerializedName("id")
    private String id;

    @SerializedName("oauth_provider")
    private String oauthProvider;

    @SerializedName("oauth_uid")
    private String oauthUid;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("gender")
    private String gender;

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("picture_url")
    @Expose
    private String pictureUrl;
    @SerializedName("profile_url")
    private String profileUrl;

    @SerializedName("created")
    private String created;

    @SerializedName("modified")
    private String modified;

    @SerializedName("password")
    private Object password;

    @SerializedName("device_type")
    private Object deviceType;

    @SerializedName("device_token")
    private Object deviceToken;

    @SerializedName("token")
    private Object token;

    @SerializedName("loggedin_from")
    private Object loggedinFrom;

    @SerializedName("phone")
    private Object phone;

    @SerializedName("eventdate")
    private Object eventdate;

    @SerializedName("bride_groom")
    private Object brideGroom;

    @SerializedName("weds_with")
    private Object wedsWith;

    @SerializedName("your_location")
    private Object yourLocation;

    @SerializedName("event_location")
    private Object eventLocation;

    @SerializedName("require_catid")
    private Object requireCatid;

    @SerializedName("user_status")
    private String userStatus;

    public String getVshId() {
        return vshId;
    }

    public void setVshId(String vshId) {
        this.vshId = vshId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVshDate() {
        return vshDate;
    }

    public void setVshDate(String vshDate) {
        this.vshDate = vshDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(String oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getOauthUid() {
        return oauthUid;
    }

    public void setOauthUid(String oauthUid) {
        this.oauthUid = oauthUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Object deviceType) {
        this.deviceType = deviceType;
    }

    public Object getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(Object deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public Object getLoggedinFrom() {
        return loggedinFrom;
    }

    public void setLoggedinFrom(Object loggedinFrom) {
        this.loggedinFrom = loggedinFrom;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getEventdate() {
        return eventdate;
    }

    public void setEventdate(Object eventdate) {
        this.eventdate = eventdate;
    }

    public Object getBrideGroom() {
        return brideGroom;
    }

    public void setBrideGroom(Object brideGroom) {
        this.brideGroom = brideGroom;
    }

    public Object getWedsWith() {
        return wedsWith;
    }

    public void setWedsWith(Object wedsWith) {
        this.wedsWith = wedsWith;
    }

    public Object getYourLocation() {
        return yourLocation;
    }

    public void setYourLocation(Object yourLocation) {
        this.yourLocation = yourLocation;
    }

    public Object getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(Object eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Object getRequireCatid() {
        return requireCatid;
    }

    public void setRequireCatid(Object requireCatid) {
        this.requireCatid = requireCatid;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
