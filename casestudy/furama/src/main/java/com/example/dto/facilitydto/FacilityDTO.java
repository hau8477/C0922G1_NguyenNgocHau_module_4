package com.example.dto.facilitydto;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FacilityDTO {
    private Long id;
    private FacilityType facilityType;
    private RentType rentType;
    @Size(max = 45)
    @NotBlank(message = "Vui lòng nhập tên dịch vụ")
    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*\\s\\d*$", message = "Tên dịch vụ không được chứa kí tự đặc biệt")
    private String name;
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Vui lòng nhập đúng định dạng, vd: 0.5 hoặc 10 và phải là số dương")
    private String area;
    @NotBlank(message = "Vui lòng nhập giá tiền của dịch vụ")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Vui lòng nhập đúng định dạng, vd: 0.5 hoặc 10 và phải là số dương")
    private String cost;
    @Pattern(regexp = "^[1-9][0-9]*|0[1-9][0-9]*$", message = "Số lượng người phải là số nguyên dương")
    private String maxPeople;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String standardRoom;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String descriptionOtherConvenience;
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Vui lòng nhập đúng định dạng, vd: 0.5 hoặc 10 và phải là số dương")
    private String poolArea;
    @Pattern(regexp = "^[0-9]+$|^0$", message = "Số tầng phải là số nguyên dương")
    private String numberOfFloors;
    private String facilityFree;
    private boolean flag = true;

    public FacilityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
