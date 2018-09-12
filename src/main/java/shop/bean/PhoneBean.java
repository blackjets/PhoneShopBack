package shop.bean;

public class PhoneBean {
    public PhoneBean() {
    }

    public PhoneBean(int id, String companyName, String model, Double cost) {
        this.id = id;
        this.companyName = companyName;
        this.model = model;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    private int id;
    private String companyName;
    private String model;
    private Double cost;
}
