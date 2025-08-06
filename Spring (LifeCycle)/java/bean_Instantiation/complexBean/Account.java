package bean_Instantiation.complexBean;

public class Account {
    int bankId;
    String bankName;

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                '}';
    }

    public static Account getAccountObject(){
        Account account = new Account();
        account.setBankId((int)(Math.random()*1000000));
        account.setBankName("Kolhapur");
        System.out.println("Account Object is Created...");
        return account;
    }
}
