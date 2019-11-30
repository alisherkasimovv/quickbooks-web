package uz.qb.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    private String listID;
    private String name;
    private String fullName;
    private boolean isActive;
    private String salesDesc;
    private double salesPrice;
 }
