package com.findeng.mvc.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.ProductSeries;
import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.model.UploadImgModel;
import com.findeng.mvc.serviceimpl.ProductSeriesServiceImpl;
import com.findeng.mvc.serviceimpl.ProductServiceImpl;
import com.findeng.mvc.serviceimpl.PropertyValueServiceImpl;
import com.findeng.util.CommonUtil;
import com.findeng.util.ImageUtil;
import com.findeng.util.ReturnUtil;
import com.findeng.util.UploadFileUtil;
import com.findeng.util.WebUtil;

@RestController
@RequestMapping(value = "/admin/api")
public class ProductController {

    //本机保存产品图片路径
    @Value("${systemFile.ProductImageSrc}")
    private String systemProductImageSrc;

    //外网访问产品图片路径
    @Value("${httpFile.ProductImageSrc}")
    private String httpProductImageSrc;

    //本机保存产品缩略图路径
    @Value("${systemFile.ProductThumbnailSrc}")
    private String systemProductThumbnailSrc;

    //外网访问产品缩略图路径
    @Value("${httpFile.ProductThumbnailSrc}")
    private String httpProductThumbnailSrc;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductSeriesServiceImpl productSeriesServiceImpl;

    @Autowired
    private PropertyValueServiceImpl propertyValueServiceImpl;

    /**
     * 读取系列分页
     */
    @GetMapping("/productSeries")
    public String productSeriesPagingList(HttpSession session, ProductSeries productSeries,
                                          @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                          @RequestParam(value = "field", required = false) String field,
                                          @RequestParam(value = "sort", required = false) String sort) {
        Page<ProductSeries> list = productSeriesServiceImpl.findByPaging(productSeries, offset, limit, field, sort);
        return WebUtil.resposeTableData(list.getTotalElements(), list.getContent()).toString();
    }

    /**
     * 添加系列
     */
    @PostMapping("/productSeries")
    public String addProductSeries(HttpSession session, ProductSeries productSeries) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(7), "", null, null).toString();
        }
        productSeries.setUserId(user.getUserId());
        productSeriesServiceImpl.save(productSeries);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null).toString();
    }

    /**
     * 删除系列
     */
    @DeleteMapping("/productSeries/{seriesId}")
    public String deleteProductSeries(HttpSession session,
                                      @PathVariable int seriesId) {
        return productSeriesServiceImpl.delete(seriesId).toString();
    }

    /**
     * 产品分页接口
     */
    @GetMapping("/product")
    public String productPagingList(HttpSession session, Product product,
                                    @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                    @RequestParam(value = "field", required = false) String field,
                                    @RequestParam(value = "sort", required = false) String sort) {
        Page<Product> page = productServiceImpl.findByPaging(product, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 厂家产品分页接口
     */
    @GetMapping("/factoryProduct")
    public String factoryProductPagingList(HttpSession session, Product product,
                                           @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "field", required = false) String field,
                                           @RequestParam(value = "sort", required = false) String sort) {
        product.setUserId(((User) session.getAttribute("user")).getUserId());
        Page<Product> page = productServiceImpl.findByPaging(product, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 平台修改产品
     */
    @PutMapping("/product")
    public String modifyProduct(HttpSession session, Product product) {
        return productServiceImpl.modifyProduct((User) session.getAttribute("user"), product).toString();
    }

    /**
     * 厂家修改产品
     */
    @PutMapping("/factoryProduct")
    public String modifyfactoryProduct(HttpSession session, Product product) {
        User user = (User) session.getAttribute("user");//当前登陆用户
        Integer productUserId = productServiceImpl.findById(product.getProductId()).getUserId();//当前商品拥有者ID
        if (user.getUserId() != productUserId) WebUtil.resposeJSONObject(ReturnUtil.retParam(206), "", null, null);
        return productServiceImpl.modifyProduct(user, product).toString();
    }

    /**
     * 批量修改产品系列
     *
     * @param productIds[] 产品ID
     * @param 系列ID
     */
    @PutMapping("/product/productSeries")
    public String modifySeries(HttpSession session,
                               @RequestParam("productIds[]") Integer productIds[],
                               @RequestParam("seriesId") Integer seriesId) {
        //如果系列ID不为空验证是否有该系列
        if (seriesId != null) {
            ProductSeries ps = productSeriesServiceImpl.findById(seriesId);
            if (ps == null) {
                return WebUtil.resposeJSONObject(ReturnUtil.retParam(401), "", null, null).toString();
            }
        }
        productServiceImpl.updataSeries(productIds, seriesId);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null).toString();
    }

    /**
     * 批量设置商品状态
     *
     * @param ids
     * @param status
     */
    @PutMapping("/product/productStatus")
    public Map<String, Object> updataProduct(@RequestParam("ids[]") Integer ids[],
                                             @RequestParam("status") Integer status) {
        if (ids != null && ids.length > 0 && status != null)
            return productServiceImpl.updateProducts(ids, status);
        else
            return WebUtil.resposeAjax(false, "数据不全！");
    }

    /**
     * 批量设置商品定/现货
     *
     * @param ids
     * @param productKind
     */
    @PutMapping("/product/productKind")
    public Map<String, Object> productKind(@RequestParam("ids[]") Integer ids[],
                                           @RequestParam("productKind") Integer productKind) {
        if (ids != null && ids.length > 0 && productKind != null)
            return productServiceImpl.updataProductKind(ids, productKind);
        else
            return WebUtil.resposeAjax(false, "数据不全！");
    }

    /**
     * 添加产品
     */
    @PostMapping("/product")
    public String addProduct(HttpSession session, Product product) {
        return productServiceImpl.addProduct((User) session.getAttribute("user"), product).toString();
    }

    /**
     * 上传产品图片
     */
    @PostMapping("/product/uploadImage")
    public String productUploadImage(HttpSession session, @RequestParam("file") MultipartFile[] images) throws IOException {
        //如果用户没有登录
        if (session.getAttribute("user") == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(156), "", null, null);
        //开始保存上传图片
        List<UploadImgModel> list = UploadFileUtil.UploadImg(images,
                systemProductImageSrc,
                httpProductImageSrc,
                CommonUtil.getUUID());
        //生成缩略图
        for (UploadImgModel imgModel : list) {
            File file = imgModel.getFile();
            ImageUtil.thumbnailImage(file, systemProductThumbnailSrc, file.getName(), "jpg");
        }
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", "", list).toString();
    }

    /**
     * 删除未审核产品
     */
    @DeleteMapping("/product/{productId}")
    public String deleteProduct(HttpSession session, @PathVariable int productId) {
        return productServiceImpl.deleteProduct(productId).toString();
    }

    /**
     * 修改产品库存
     */
    @PutMapping("/product/productStock")
    public String modifyProductStock(HttpSession session
            , @RequestParam Integer productId
            , @RequestParam Integer productStock) {
        return productServiceImpl.modifyProductStock(productId, productStock).toString();
    }

    /**
     * 修改交货期
     */
    @PutMapping("/product/deliveryTime")
    public String modifyDeliveryTime(HttpSession session
            , @RequestParam Integer productId
            , @RequestParam Integer deliveryTime) {
        return productServiceImpl.modifyDeliveryTime(productId, deliveryTime).toString();
    }

    /**
     * 获取产品系列表
     */
    @GetMapping(value = "/select/productSeries")
    public List<ProductSeries> productSeriesList(HttpSession session, @RequestParam(value = "userId") Integer userId) {
        if (userId == 0)
            userId = ((User) session.getAttribute("user")).getUserId();
        return productSeriesServiceImpl.findSelectData(userId);
    }

    /**
     * 通过产品属性表ID获取产品属性
     */
    @GetMapping("/property/value")
    public String propertyValues(@RequestParam("propertyId") Integer propertyId) {
        return propertyValueServiceImpl.findByPropertyId(propertyId).toString();
    }
}
