public class Account {
    private int id;
    private String name;
    private String gender;
    private String password;
    private double balance;
    private double quota;

    public Account(){

    }

    public Account(int id, String name, String gender, String password, double quota) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }


}
