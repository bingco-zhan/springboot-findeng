package com.findeng.mvc.serviceimpl;

import com.findeng.hibernate.dao.ProductDao;
import com.findeng.hibernate.dao.ShopcartDao;
import com.findeng.hibernate.dao.ShopcartItemDao;
import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.Shopcart;
import com.findeng.hibernate.entity.ShopcartItem;
import com.findeng.mvc.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 购物车服务层
 * @author bingco
 * @version v1.0
 */
@Service
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShopcartDao shopcartDao;

    @Autowired
    private ShopcartItemDao shopcartItemDao;

    @Override
    public Shopcart findShopcartBy(Integer sellerId, Integer buyerId, Integer deleteFlag) {
        List<Shopcart> shopcarts = shopcartDao.findShopcartBy(sellerId, buyerId, deleteFlag);
        return shopcarts != null && shopcarts.size() > 0 ?  shopcarts.get(0) : null;
    }

    @Override
    public void addShopcart(Integer userId, Integer pid, Integer count) {
        Product product = productDao.findOne(pid);
        if (product == null) return; // 查询用户添加的商品

        List<Shopcart> shopcarts = shopcartDao.findShopcartBy(product.getUserId(), userId, 0);
        Shopcart shopcart;
        if (shopcarts == null || shopcarts.size() == 0) { // 如果购物车不存在,则构建一个
            shopcart = new Shopcart();
            shopcart.setBuyerId(userId);
            shopcart.setSellerId(product.getUserId());
            shopcart.setDeleteFlag(0);
            shopcartDao.save(shopcart);
        } else {
            shopcart = shopcarts.get(0);
        }

        List<ShopcartItem> shopcartItems = shopcartItemDao.findByShoopcartIdAndDeleteFlag(shopcart.getShopcartId(), 0);
        for (ShopcartItem sci : shopcartItems)
        {
            if (sci.getProductId().intValue() == pid.intValue()) { // 已添加过相同的商品,累计添加的数量
                sci.setProductNumber(sci.getProductNumber() + count);
                shopcartItemDao.save(sci);
                return; // 直接退出;
            }
        }

        ShopcartItem shopcartItem = new ShopcartItem(); // 在购物车中添加清单
        shopcartItem.setShopcartId(shopcart.getShopcartId());
        shopcartItem.setProductId(pid);
        shopcartItem.setProductNumber(count);
        shopcartItem.setDeleteFlag(0);
        shopcartItem.setAddtime(new Timestamp(System.currentTimeMillis()));
        shopcartItemDao.save(shopcartItem);
    }

    @Override
    public List<Shopcart> findShopcart(Integer userId) {
        return shopcartDao.findShopcartBy(userId, 0);
    }
}
