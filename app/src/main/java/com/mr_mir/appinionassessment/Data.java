package com.mr_mir.appinionassessment;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("product_group_list")
    @Expose
    private List<ProductGroupList> productGroupList = null;
    @SerializedName("literature_list")
    @Expose
    private List<LiteratureList> literatureList = null;
    @SerializedName("physician_sample_list")
    @Expose
    private List<PhysicianSampleList> physicianSampleList = null;
    @SerializedName("gift_list")
    @Expose
    private List<GiftList> giftList = null;

    public List<ProductGroupList> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(List<ProductGroupList> productGroupList) {
        this.productGroupList = productGroupList;
    }

    public Data withProductGroupList(List<ProductGroupList> productGroupList) {
        this.productGroupList = productGroupList;
        return this;
    }

    public List<LiteratureList> getLiteratureList() {
        return literatureList;
    }

    public void setLiteratureList(List<LiteratureList> literatureList) {
        this.literatureList = literatureList;
    }

    public Data withLiteratureList(List<LiteratureList> literatureList) {
        this.literatureList = literatureList;
        return this;
    }

    public List<PhysicianSampleList> getPhysicianSampleList() {
        return physicianSampleList;
    }

    public void setPhysicianSampleList(List<PhysicianSampleList> physicianSampleList) {
        this.physicianSampleList = physicianSampleList;
    }

    public Data withPhysicianSampleList(List<PhysicianSampleList> physicianSampleList) {
        this.physicianSampleList = physicianSampleList;
        return this;
    }

    public List<GiftList> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<GiftList> giftList) {
        this.giftList = giftList;
    }

    public Data withGiftList(List<GiftList> giftList) {
        this.giftList = giftList;
        return this;
    }

}
