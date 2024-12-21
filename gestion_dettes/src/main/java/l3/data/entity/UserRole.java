package l3.data.entity;
import lombok.Data;

@Data
public class UserRole {
    private int id;
    private String nomRole;
    
    public UserRole() {
    }
    public UserRole(int id, String nomRole) {
        this.id = id;
        this.nomRole = nomRole;
    }
    
}
