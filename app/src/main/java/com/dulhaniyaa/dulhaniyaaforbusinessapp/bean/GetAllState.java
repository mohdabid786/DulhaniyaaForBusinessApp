package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllState {

    @SerializedName("state_name")
    private String stateName;

    @SerializedName("state_id")
    private String stateId;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
}
