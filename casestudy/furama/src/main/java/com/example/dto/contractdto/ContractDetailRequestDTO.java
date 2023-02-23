package com.example.dto.contractdto;

public class ContractDetailRequestDTO {
    private Long id;
    private int quantity;

    public ContractDetailRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
