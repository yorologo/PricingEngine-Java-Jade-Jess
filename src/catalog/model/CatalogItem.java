package catalog.model;

import java.sql.*;
import java.util.List;
//import java.util.*;
import java.text.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/* 
*  Java Hibernate - Model Class - Catalog.CatalogItem
*  
*/
@Entity
@Table(name = "CatalogItem")
public class CatalogItem {

    // fields
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int m_id;

    @Column(name = "description", nullable = false)
    private String m_description;

    @Column(name = "partNumber")
    private int m_partNumber;

    @Column(name = "price", nullable = false)
    private double m_price;

    /**
     * Constructor
     * 
     * Example: CatalogItem myCatalogItem = new CatalogItem();
     */
    public CatalogItem() {
        // empty constructor
    }

    /**
     * Constructor
     * 
     * Example: CatalogItem myCatalogItem = new CatalogItem( val1, val2,.. );
     */
    public CatalogItem(int id, String description, int partNumber, double price) {
        this.setId(id);
        this.setDescription(description);
        this.setPartNumber(partNumber);
        this.setPrice(price);
    }

    /**
     * Getters and Setters
     */

    public int getId() {
        return this.m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getDescription() {
        return this.m_description;
    }

    public void setDescription(String description) {
        this.m_description = description;
    }

    public int getPartNumber() {
        return this.m_partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.m_partNumber = partNumber;
    }

    public double getPrice() {
        return this.m_price;
    }

    public void setPrice(double price) {
        this.m_price = price;
    }

    /**
     * Methods
     */

    @Override
    public String toString() {
        return "";
    }

}