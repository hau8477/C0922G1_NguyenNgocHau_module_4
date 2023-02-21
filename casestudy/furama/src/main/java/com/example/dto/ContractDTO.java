package com.example.dto;

import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;

import java.util.List;

public class ContractDTO {
    private Long id;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private String startDate;
    private String endDate;
    private double deposit;
    private List<ContractDetail> contractDetail;
    private boolean flag = true;
    private double totalCost;

    public ContractDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
