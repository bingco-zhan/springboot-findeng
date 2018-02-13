package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.ProductSeries;

/**
 * 产品表dao层
 *
 * @author Alien
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    /**
     * 根据产品风格查询热销产品按照上线时间排序
     *
     * @param ProductStyle 产品风格
     * @param item         查询条数
     * @return 产品list
     */
    @Query(value = "select * from product where product_status=5 and is_popular=1 and product_style=?1 ORDER BY online_time DESC LIMIT 0,?2", nativeQuery = true)
    List<Product> findIsPopularByProductType(int ProductStyle, int item);

    /**
     * 按照产品类型查询产品返回指定条数
     *
     * @param item 查询条数
     * @return List 产品列表
     */
    @Query(value = "select * from product where product_status=5 and product_type=?1 ORDER BY product_sales DESC LIMIT 0,?2", nativeQuery = true)
    List<Product> findByproductType(String productType, int item);

    /**
     * 按照产品系列查询产品
     *
     * @return List 产品列表
     */
    @Query(value = "select * from product where product_status=5 and product_series_id=?1 ORDER BY series_index", nativeQuery = true)
    List<Product> findBySeriesId(int seriesId);

    /**
     * 通过userid字段查询产品
     *
     * @return List 产品列表
     */
    @Query(value = "select * from product where product_status=5 and user_id=?1 ORDER BY product_sales desc LIMIT 0,?2", nativeQuery = true)
    List<Product> findByUserId(int userId, int items);

    /**
     * 更新商品状态
     *
     * @param status 商品状态
     * @param ids    product_id 集合
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Product SET productStatus = ?1 WHERE productId IN (?2)")
    void updateProducts(Integer status, Integer[] ids);

    /**
     * 更新商品的现/定货状态
     *
     * @param productKind 状态
     * @param ids         product_id 集合
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Product SET productKind = ?1 WHERE productId IN (?2)")
    void updataProductKind(Integer productKind, Integer[] ids);

    /**
     * 查询活动商品分页集
     *
     * @param pageRequest 分页以及排序的对象
     */
    @Query(value = "FROM Product p WHERE p.productTag='活动' AND p.productStatus=5")
    Page<Product> findHotProducts(Pageable pageRequest);


    /**
     * 通过产品ID批量设置系列
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Product SET productSeries.id = ?1 WHERE productId IN (?2)")
    void updataSeries(Integer id, Integer[] ids);

    @Query(value = "SELECT new Product(p.productId,p.productColor,p.lightColor,p.productName) FROM Product p WHERE p.productSeries = ?1 AND p.productStatus = 5")
    List<Product> findByProductSeriesAndProductStatus(ProductSeries productSeries);

    /**
     * 统计该系列ID下有多少个产品
     */
    int countByProductSeriesId(int productSeriesId);
}
