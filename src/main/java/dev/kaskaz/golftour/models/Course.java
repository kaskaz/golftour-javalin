package dev.kaskaz.golftour.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.opencsv.bean.CsvBindByName;

@DatabaseTable
public class Course {

    @DatabaseField(generatedId = true)
    private int id;
    @CsvBindByName(column = "NAME")
    @DatabaseField(canBeNull = false)
    private String name;
    @CsvBindByName(column = "OPENING_YEAR")
    @DatabaseField
    private String openingYear;
    @CsvBindByName(column = "ARCHITECT")
    @DatabaseField
    private String architect;
    @CsvBindByName(column = "HOLES")
    @DatabaseField
    private Integer holes;
    @CsvBindByName(column = "PAIRS")
    @DatabaseField
    private Integer pairs;
    @CsvBindByName(column = "FACILITIES")
    @DatabaseField
    private String facilities;
    @CsvBindByName(column = "IS_CLUB_HOUSE")
    @DatabaseField
    private Boolean isClubHouse;
    @CsvBindByName(column = "IS_ACADEMY")
    @DatabaseField
    private Boolean isAcademy;
    @CsvBindByName(column = "WEBSITE")
    @DatabaseField
    private String website;
    @CsvBindByName(column = "LOCAL")
    @DatabaseField
    private String local;
    @CsvBindByName(column = "COUNTY")
    @DatabaseField
    private String county;
    @CsvBindByName(column = "DISTRICT")
    @DatabaseField
    private String district;
    @CsvBindByName(column = "LATITUDE")
    @DatabaseField
    private Double latitude;
    @CsvBindByName(column = "LONGITUDE")
    @DatabaseField
    private Double longitude;

    public Course() {}

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getOpeningYear() {
        return openingYear;
    }

    public void setOpeningYear(String openingYear) {
        this.openingYear = openingYear;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public Integer getHoles() {
        return holes;
    }

    public void setHoles(Integer holes) {
        this.holes = holes;
    }

    public Integer getPairs() {
        return pairs;
    }

    public void setPairs(Integer pairs) {
        this.pairs = pairs;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public Boolean getClubHouse() {
        return isClubHouse;
    }

    public void setClubHouse(Boolean clubHouse) {
        isClubHouse = clubHouse;
    }

    public Boolean getAcademy() {
        return isAcademy;
    }

    public void setAcademy(Boolean academy) {
        isAcademy = academy;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
