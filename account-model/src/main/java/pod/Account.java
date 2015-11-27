package pod;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author joaomarcos
 */
@Entity
@Table(name = "tbaccount")
public class Account implements Serializable {

    @Id    
    private String id;
    private String name;
    private float balance;
    
    public Account() {
        
    }

    public Account(String id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
