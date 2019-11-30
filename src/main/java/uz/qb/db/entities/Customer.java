package uz.qb.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private String fullName;
    private String firstName;
    private String lastName;
    private boolean  isActive;
    private String salutation;
    private Address billAddress;
    private List<Address> shipAddress;

}
