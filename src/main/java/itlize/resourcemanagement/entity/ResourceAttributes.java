package itlize.resourcemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "resource_attributes")
public class ResourceAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "col_name")
    private String colName;

    @Column(name = "col_val")
    private String colVal;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Resource res;

    public ResourceAttributes(){}

    public String getColName() {
        return colName;
    }

    public String getColVal(){
        return colVal;
    }

    public void setColName(String colName){
        this.colName = colName;
    }

    public void setColVal(String colVal){
        this.colVal = colVal;
    }

    public void setRes(Resource res){
        this.res = res;
    }

    public Long getId() {
        return this.id;
    }

    public Resource getRes() {
        return this.res;
    }
}
