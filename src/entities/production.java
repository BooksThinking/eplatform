package entities;

public class production {
    /*
        productionName：表示产品名称
        productionPrice：表示产品价格
        productionNnumber:表示产品数量
     */

    private String productionName;
    private String productionPrice;
    private String productionNumber;

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public String getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(String productionPrice) {
        this.productionPrice = productionPrice;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }
}
