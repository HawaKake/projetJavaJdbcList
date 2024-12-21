package l3.data.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Client {
    
    private String surname;
    private String telephone;
    private String address;
    private User userCompte;
    private User boutiquier;
   private ArrayList<Dette>dettes; 

    public Client(String surname, String telephone, String address) {
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
       
    }

    public Client() {
    }

   
    
    public void AddDette(Dette dette) {
        dettes.add(dette);

    }


}
