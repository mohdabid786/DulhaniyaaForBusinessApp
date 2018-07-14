package com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.CommonResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("VendorSignup")
    Call<CommonResponse> getSingupResult(@Field("business_name") String business_name,
                                         @Field("contact_email") String contact_email,
                                         @Field("password") String password,
                                         @Field("contact_phone") String contact_phone,
                                         @Field("cat_id") String cat_id,
                                         @Field("state_id") String state_id,
                                         @Field("device_type") String device_type,
                                         @Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("vendorLogin")
    Call<CommonResponse> getLoginResult(@Field("username") String email,
                                        @Field("password") String password,
                                        @Field("device_type") String device_type,
                                        @Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("checkVendor")
    Call<CommonResponse> getcheckVendorResult(@Field("phone") String phone,
                                            @Field("email") String email);

    @FormUrlEncoded
    @POST("verificationCode")
    Call<CommonResponse> getverificationCodeResult(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("sendotp")
    Call<CommonResponse> getSendotp(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("changePassword")
    Call<CommonResponse> getChangePasswordResult(@Field("token") String token,
                                                 @Field("password") String newPassword);

    @FormUrlEncoded
    @POST("forgotPassword")
    Call<CommonResponse> getForgotResult(@Field("username") String username);

    @FormUrlEncoded
    @POST("resetPassword")
    Call<CommonResponse> getResetPasswordResult(@Field("token") String token,
                                                @Field("newPassword") String newPassword);

    @FormUrlEncoded
    @POST("logout")
    Call<CommonResponse> getLogoutResult(@Field("token") String token);

    @GET("get_all_cateogry")
    Call<CommonResponse> getGetAllCateogryResult();

    @GET("get_all_state")
    Call<CommonResponse> getGetAllStateResult();

    @GET("venueareatype")
    Call<CommonResponse> getVenueareatypeResult();

    @GET("paymentmode")
    Call<CommonResponse> getPaymentmodeResult();

    @GET("workdays")
    Call<CommonResponse> getWorkdayResult();

    @FormUrlEncoded
    @POST("VendorProfile")
    Call<CommonResponse> getVendorProfileResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("VendorReview")
    Call<CommonResponse> getVendorReviewResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("deleteReview")
    Call<CommonResponse> getDeleteReviewResult(@Field("token") String token,
                                               @Field("vr_id") String vr_id);

    @FormUrlEncoded
    @POST("ShortlistMe")
    Call<CommonResponse> getShortlistMeResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("loveMyImg")
    Call<CommonResponse> getLoveMyImgResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("checkportfolio")
    Call<CommonResponse> getCheckportfolioResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("CheckAlbumName")
    Call<CommonResponse> getCheckAlbumNameResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("vendorViews")
    Call<CommonResponse> getVendorViewsResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("VendorPortfolioCount")
    Call<CommonResponse> getVendorPortfolioCountResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("VendorPortfolioImg")
    Call<CommonResponse> getVendorPortfolioImgResult(@Field("token") String token,
                                                     @Field("p_id") String p_id);

    @FormUrlEncoded
    @POST("deleteimg")
    Call<CommonResponse> getDeleteimgResult(@Field("token") String token,
                                            @Field("vp_id") String p_id);

}
