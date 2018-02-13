package com.findeng.mvc.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.ProductSeries;
import com.findeng.hibernate.entity.User;

public interface ProductService {

    public Product save(Product product);

    public void delete(int productId);

    public Product findById(int id);

    public JSONObject addProduct(User user, Product product);

    public String generateProductName(User user, Product product);

    public String generateProductAliasName(Product product);

    public Page<Product> findByPaging(Product product, int offset, int limit, String field, String sort);

    public Map<String, Object> updateProducts(Integer[] ids, Integer status);

    public Map<String, Object> updataProductKind(Integer[] ids, Integer productKind);

    public JSONObject deleteProduct(int id);

    public JSONObject modifyProductStock(int productId, int productStock);

    public JSONObject modifyDeliveryTime(int productId, int deliveryTime);

    public JSONObject modifyProduct(User user, Product product);

    public Page<Product> findHotProducts(Integer offset, Integer limit);

    public void updataSeries(Integer[] ids, Integer id);

    public List<Product> findSeriesProduct(ProductSeries productSeries);
}
