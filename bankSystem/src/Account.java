public class Account {
    private int id;
    private String name;
    private String gender;
    private String password;
    private double amount;
    private double quota;

    public Account(){

    }

    public Account(int id, String name, String gender, String password, double amount, double quota) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.amount = amount;
        this.quota = quota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }
}
