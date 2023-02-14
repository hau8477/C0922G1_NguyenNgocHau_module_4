package com.example.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    //Kiểm tra xem sản phẩm đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    //Tìm kiếm sản phẩm trong giỏ hàng
    public Map.Entry<Product, Integer> selectItemInCard(Product product) {
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    //Thêm mới sản phẩm
    public void addProduct(Product product) {
        //Nếu sản phẩm chưa tồn tại thì thêm sản phẩm vào với số lượng là 1
        if (!checkItemInCart(product)) {
            this.products.put(product, 1);
        } else {
            //Tìm sản phẩm trong giỏ hàng
            Map.Entry<Product, Integer> itemEntry = selectItemInCard(product);
            assert itemEntry != null;
            // tăng giá trị của số lượng lên 1
            Integer newQuantity = itemEntry.getValue() + 1;
            // cập nhật số lượng sản phẩm
            this.products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //Xóa sản phẩm
    public void removeProduct(Product product) {
        if (!checkItemInCart(product)) {
            return;
        }
        Map.Entry<Product, Integer> itemEntry = selectItemInCard(product);
        assert itemEntry != null;
        this.products.remove(itemEntry.getKey());
    }

    //Xóa tất cả sản phẩm
    public boolean removeAllProduct(){
        if(this.products.isEmpty()){
            return false;
        }
        this.products.clear();
        return true;
    }

    //Giảm số lượng sản phẩm
    public void decreaseQuantity(Product product){
        //Nếu sản phẩm chưa tồn tại thì thêm sản phẩm vào với số lượng là 1
        if (!checkItemInCart(product)) {
            return;
        } else {
            //Tìm sản phẩm trong giỏ hàng
            Map.Entry<Product, Integer> itemEntry = selectItemInCard(product);
            assert itemEntry != null;
            if(itemEntry.getValue() == 1){
                removeProduct(product);
                return;
            }
            // Giảm giá trị của số lượng đi 1
            Integer newQuantity = itemEntry.getValue() - 1;
            // cập nhật số lượng sản phẩm
            this.products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //Đếm tổng số lượng của từng loại sản phẩm có trong giỏ hàng
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //Đếm số lượng sản phẩm có trong giỏ hàng
    public Integer countItemQuantity() {
        return this.products.size();
    }

    //Tính tổng số tiền của tất cả sản phẩm có trong giỏ hàng
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }


}
