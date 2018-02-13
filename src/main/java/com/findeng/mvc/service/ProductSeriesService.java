package com.findeng.mvc.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.ProductSeries;

public interface ProductSeriesService {

    public Page<ProductSeries> findByPaging(ProductSeries productSeries, Integer offset, Integer limit, String field, String sort);

    public List<ProductSeries> findSelectData(int userId);

    public ProductSeries save(ProductSeries productSeries);

    public JSONObject delete(int id);

    public ProductSeries findById(int id);
}
