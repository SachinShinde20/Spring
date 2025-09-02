package bean_Instantiation.complexBean;

public class ObjectFactory {
    Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Emp getEmpObject(){
        Emp emp = new Emp();
        emp.setId((int)(Math.random()*100));
        emp.setName("Sachin");
        emp.setAccount(account);
        return emp;
    }
}
