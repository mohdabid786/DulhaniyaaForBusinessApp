package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CommonResponse {

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("requestKey")
    private String requestKey;

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    @SerializedName("text")
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @SerializedName("sendotp")
    private String sendotp;

    public String getSendotp() {
        return sendotp;
    }

    public void setSendotp(String sendotp) {
        this.sendotp = sendotp;
    }

    @SerializedName("VendorSignup")
    @Expose
    private VendorSignup vendorSignup;

    public VendorSignup getVendorSignup() {
        return vendorSignup;
    }

    public void setVendorSignup(VendorSignup vendorSignup) {
        this.vendorSignup = vendorSignup;
    }

    @SerializedName("login")
    private LoginResponse login;

    public LoginResponse getLogin() {
        return login;
    }

    public void setLogin(LoginResponse login) {
        this.login = login;
    }

    @SerializedName("verificationCode")
    private String verificationCode;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @SerializedName("get_all_cateogry")
    private List<GetAllCateogry> getAllCateogry = null;

    public List<GetAllCateogry> getGetAllCateogry() {
        return getAllCateogry;
    }

    public void setGetAllCateogry(List<GetAllCateogry> getAllCateogry) {
        this.getAllCateogry = getAllCateogry;
    }

    @SerializedName("paymentmode")
    private List<Paymentmode> paymentmode = null;

    public List<Paymentmode> getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(List<Paymentmode> paymentmode) {
        this.paymentmode = paymentmode;
    }

    @SerializedName("venueareatype")
    private List<Venueareatype> venueareatype = null;

    public List<Venueareatype> getVenueareatype() {
        return venueareatype;
    }

    public void setVenueareatype(List<Venueareatype> venueareatype) {
        this.venueareatype = venueareatype;
    }

    @SerializedName("workdays")
    private List<Workday> workdays = null;

    public List<Workday> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(List<Workday> workdays) {
        this.workdays = workdays;
    }

    @SerializedName("get_all_state")
    private List<GetAllState> getAllState = null;

    public List<GetAllState> getGetAllState() {
        return getAllState;
    }

    public void setGetAllState(List<GetAllState> getAllState) {
        this.getAllState = getAllState;
    }

    @SerializedName("VendorReview")
    private List<VendorReview> vendorReview = null;

    public List<VendorReview> getVendorReview() {
        return vendorReview;
    }

    public void setVendorReview(List<VendorReview> vendorReview) {
        this.vendorReview = vendorReview;
    }

    @SerializedName("VendorProfile")
    @Expose
    private VendorProfile vendorProfile;

    public VendorProfile getVendorProfile() {
        return vendorProfile;
    }

    public void setVendorProfile(VendorProfile vendorProfile) {
        this.vendorProfile = vendorProfile;
    }

    @SerializedName("ShortlistMe")
    private List<ShortlistMe> shortlistMe = null;

    public List<ShortlistMe> getShortlistMe() {
        return shortlistMe;
    }

    public void setShortlistMe(List<ShortlistMe> shortlistMe) {
        this.shortlistMe = shortlistMe;
    }

    @SerializedName("loveMyImg")
    private List<LoveMyImg> loveMyImg = null;

    public List<LoveMyImg> getLoveMyImg() {
        return loveMyImg;
    }

    public void setLoveMyImg(List<LoveMyImg> loveMyImg) {
        this.loveMyImg = loveMyImg;
    }

    @SerializedName("vendorViews")
    private List<VendorViews> vendorViews = null;

    public List<VendorViews> getVendorViews() {
        return vendorViews;
    }

    public void setVendorViews(List<VendorViews> vendorViews) {
        this.vendorViews = vendorViews;
    }

    @SerializedName("VendorPortfolioImg")
    private List<VendorPortfolioImg> vendorPortfolioImg = null;

    public List<VendorPortfolioImg> getVendorPortfolioImg() {
        return vendorPortfolioImg;
    }

    public void setVendorPortfolioImg(List<VendorPortfolioImg> vendorPortfolioImg) {
        this.vendorPortfolioImg = vendorPortfolioImg;
    }

    @SerializedName("add_portfolio")
    private List<AddPortfolio> addPortfolio = null;

    public List<AddPortfolio> getAddPortfolio() {
        return addPortfolio;
    }

    public void setAddPortfolio(List<AddPortfolio> addPortfolio) {
        this.addPortfolio = addPortfolio;
    }
}
