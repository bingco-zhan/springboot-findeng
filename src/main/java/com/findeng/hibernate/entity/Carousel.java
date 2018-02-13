package com.findeng.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 轮播图实体类
 *
 * @author Alien
 */
@Entity
@Table(name = "carousel")
public class Carousel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carousel_id")
    private Integer carouselId;

    @Column(name = "carousel_link")
    private String carouselLink;

    @Column(name = "carousel_pic")
    private String carouselPic;

    public Carousel() {
    }

    public Integer getCarouselId() {
        return this.carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselLink() {
        return this.carouselLink;
    }

    public void setCarouselLink(String carouselLink) {
        this.carouselLink = carouselLink;
    }

    public String getCarouselPic() {
        return this.carouselPic;
    }

    public void setCarouselPic(String carouselPic) {
        this.carouselPic = carouselPic;
    }

    @Override
    public String toString() {
        return "Carousel [carouselId=" + carouselId + ", carouselLink=" + carouselLink + ", carouselPic=" + carouselPic
                + "]";
    }

}