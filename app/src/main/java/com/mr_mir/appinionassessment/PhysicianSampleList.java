package com.mr_mir.appinionassessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicianSampleList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sample")
    @Expose
    private String sample;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhysicianSampleList withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public PhysicianSampleList withSample(String sample) {
        this.sample = sample;
        return this;
    }

}

