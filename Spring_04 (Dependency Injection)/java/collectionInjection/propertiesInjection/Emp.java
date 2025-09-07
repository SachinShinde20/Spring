package collectionInjection.propertiesInjection;

import java.util.Properties;

public class Emp {
    int id;
    Properties dbDetails;

    public Emp(){
        super();
    }

    public Emp(int id, Properties dbDetails) {
        this.id = id;
        this.dbDetails = dbDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Properties getDbDetails() {
        return dbDetails;
    }

    public void setDbDetails(Properties dbDetails) {
        this.dbDetails = dbDetails;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", dbDetails=" + dbDetails +
                '}';
    }
}
