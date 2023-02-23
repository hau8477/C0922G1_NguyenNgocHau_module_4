package com.example.dto.contractdto;

public class ContractDetailDTO {
    private String attachFacilityName;
    private Long contractId;
    private int quantity;

    public ContractDetailDTO() {
    }

    public ContractDetailDTO(String attachFacilityName, Long contractId, int quantity) {
        this.attachFacilityName = attachFacilityName;
        this.contractId = contractId;
        this.quantity = quantity;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
