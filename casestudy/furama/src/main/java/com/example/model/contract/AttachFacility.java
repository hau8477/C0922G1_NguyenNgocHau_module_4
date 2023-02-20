package com.example.model.contract;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String name;
    private double cost;
    @Size(max = 10)
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String unit;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String status;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public AttachFacility() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
