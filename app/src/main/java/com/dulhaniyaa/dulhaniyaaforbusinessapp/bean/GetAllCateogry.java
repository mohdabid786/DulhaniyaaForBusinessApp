package com.dulhaniyaa.dulhaniyaaforbusinessapp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllCateogry {

    @SerializedName("cat_name")
    private String catName;

    @SerializedName("cat_id")
    private String catId;

    @SerializedName("subcat_label")
    private String subcatLabel;

    @SerializedName("budget_label")
    private String budgetLabel;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getSubcatLabel() {
        return subcatLabel;
    }

    public void setSubcatLabel(String subcatLabel) {
        this.subcatLabel = subcatLabel;
    }

    public String getBudgetLabel() {
        return budgetLabel;
    }

    public void setBudgetLabel(String budgetLabel) {
        this.budgetLabel = budgetLabel;
    }

}
