package com.example.dto.customerdto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class CustomerDTO implements Validator {
    private Long id;
    private CustomerType customerType;
    @Size(max = 45)
    @NotNull
    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    @Pattern(regexp = "^(?!.*\\d)[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$|^([\\p{Lu}][\\p{Ll}]*)$\n", message = "Tên khách hàng chưa đúng định dạng")
    private String name;
    private String dateOfBirth;
    private boolean gender;
    @Size(max = 45)
    @NotNull
    private String idCard;
    @Size(max = 45)
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(\\(84\\)\\+)?(09|01)\\d{8}$", message = "Số điện thoại chưa đúng định dạng, số điện thoại phải có dạng: " +
            "090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @Size(max = 45)
    @Email
    private String email;
    @Size(max = 45)
    private String address;
    private boolean flag = true;

    public CustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
