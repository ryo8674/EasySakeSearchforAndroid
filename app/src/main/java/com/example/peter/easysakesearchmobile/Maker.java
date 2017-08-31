package com.example.peter.easysakesearchmobile;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * MakerDto
 */
class Maker implements Serializable{

    @SerializedName("maker_id")
    private int id;

    @SerializedName("maker_name")
    private String name;

    @SerializedName("maker_address")
    private String address;

    @SerializedName("maker_url")
    private String makerUrl;

    private String url;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets maker url.
     *
     * @return the maker url
     */
    public String getMakerUrl() {
        return makerUrl;
    }

    /**
     * Sets maker url.
     *
     * @param makerUrl the maker url
     */
    public void setMakerUrl(String makerUrl) {
        this.makerUrl = makerUrl;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
