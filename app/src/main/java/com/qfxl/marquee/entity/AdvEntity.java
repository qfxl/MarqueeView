package com.qfxl.marquee.entity;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AdvEntity {

    private String price;
    private String promotionalPrice;
    private String content;

    public AdvEntity() {
    }

    public AdvEntity(String price, String promotionalPrice, String content) {
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(String promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
