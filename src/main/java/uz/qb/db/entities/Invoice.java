package uz.qb.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    private Customer customer;
    private String billAddress;
    private String shipAddress;
    private String fullName;
    private List<Item> invoiceLine;
}
