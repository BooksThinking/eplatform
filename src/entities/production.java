package entities;

public class production {
    /*
        productionName：表示产品名称
        productionPrice：表示产品价格
        productionNnumber:表示产品数量
     */

    private String productionName;
    private int productionPrice;
    private int productionNumber;

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public int getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(int productionPrice) {
        this.productionPrice = productionPrice;
    }

    public int getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }
}
