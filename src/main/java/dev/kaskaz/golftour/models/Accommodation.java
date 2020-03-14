package dev.kaskaz.golftour.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.opencsv.bean.CsvBindByName;

@DatabaseTable
public class Accommodation {

    @DatabaseField(generatedId = true)
    private int id;
    @CsvBindByName(column = "NAME")
    @DatabaseField(canBeNull = false)
    private String name;
    @CsvBindByName(column = "TYPE")
    @DatabaseField
    private String type;
    @CsvBindByName(column = "NUM_OF_GUESTS")
    @DatabaseField
    private Integer numOfGuests;
    @CsvBindByName(column = "ADDRESS")
    @DatabaseField
    private String address;
    @CsvBindByName(column = "POSTAL_CODE")
    @DatabaseField
    private String postalCode;
    @CsvBindByName(column = "LOCAL")
    @DatabaseField
    private String local;
    @CsvBindByName(column = "PARISH")
    @DatabaseField
    private String parish;
    @CsvBindByName(column = "COUNTY")
    @DatabaseField
    private String county;
    @CsvBindByName(column = "IS_GEO_RELIABLE")
    @DatabaseField
    private Boolean isGeoReliable;
    @CsvBindByName(column = "IS_COASTAL_PARISH")
    @DatabaseField
    private Boolean isCoastalParish;
    @CsvBindByName(column = "LATITUDE")
    @DatabaseField
    private Double latitude;
    @CsvBindByName(column = "LONGITUDE")
    @DatabaseField
    private Double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Boolean getGeoReliable() {
        return isGeoReliable;
    }

    public void setGeoReliable(Boolean geoReliable) {
        isGeoReliable = geoReliable;
    }

    public Boolean getCoastalParish() {
        return isCoastalParish;
    }

    public void setCoastalParish(Boolean coastalParish) {
        isCoastalParish = coastalParish;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
