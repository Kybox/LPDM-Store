package com.lpdm.msstore.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Department {

    private int id;
    @JsonIgnore
    private String regionCode;
    private String code;
    private String name;
    private String slug;
    private Region region;

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", regionCode='" + regionCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", region=" + region +
                '}';
    }
}
