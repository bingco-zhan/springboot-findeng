package com.findeng.hibernate.model;

import java.io.Serializable;
import java.util.List;

/**
 * 做为商城商品的搜索属性 - JavaBean
 *
 * @author bingco
 * @verson v1.0
 */
public class MobileProductModel implements Serializable {

    /**
     * 页码
     */
    private Integer offset;

    /**
     * 数据量
     */
    private Integer limit;

    /**
     * 排序字段
     */
    private String ok;

    /**
     * 排序顺序
     */
    private String ov;

    /**
     * 风格
     */
    private List<Integer> styles;

    /**
     * 类型
     */
    private List<Integer> types;

    /**
     * 空间
     */
    private List<String> rooms;

    /**
     * 材质
     */
    private List<String> materials;

    /**
     * 形状
     */
    private List<Integer> shapes;

    /**
     * 层数
     */
    private List<Integer> plies;

    /**
     * 直径
     */
    private List<String> diameters;

    /**
     * 长度
     */
    private List<String> lengths;

    /**
     * 高度
     */
    private List<String> widths;

    /**
     * 价格
     */
    private List<String> prices;

    /**
     * 灯源类型
     */
    private List<Integer> lightTypes;

    private String like;

    /**
     * 标签
     */
    private String productTag;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getOv() {
        return ov;
    }

    public void setOv(String ov) {
        this.ov = ov;
    }

    public List<Integer> getStyles() {
        return styles;
    }

    public void setStyles(List<Integer> styles) {
        this.styles = styles;
    }

    public List<Integer> getTypes() {
        return types;
    }

    public void setTypes(List<Integer> types) {
        this.types = types;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public List<Integer> getShapes() {
        return shapes;
    }

    public void setShapes(List<Integer> shapes) {
        this.shapes = shapes;
    }

    public List<Integer> getPlies() {
        return plies;
    }

    public void setPlies(List<Integer> plies) {
        this.plies = plies;
    }

    public List<String> getDiameters() {
        return diameters;
    }

    public void setDiameters(List<String> diameters) {
        this.diameters = diameters;
    }

    public List<String> getLengths() {
        return lengths;
    }

    public void setLengths(List<String> lengths) {
        this.lengths = lengths;
    }

    public List<String> getWidths() {
        return widths;
    }

    public void setWidths(List<String> widths) {
        this.widths = widths;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }

    public List<Integer> getLightTypes() {
        return lightTypes;
    }

    public void setLightTypes(List<Integer> lightTypes) {
        this.lightTypes = lightTypes;
    }

    public String getProductTag() {
        return productTag;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }
}
