package Logic.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marka")
public class marka  implements java.io.Serializable {

    @Id
     private Integer markaId;
    @Column(name="markaAdi")
     private String markaAdi;

    public marka() {
    }

    public marka(String markaAdi) {
       this.markaAdi = markaAdi;
    }
   
    public Integer getMarkaId() {
        return this.markaId;
    }
    
    public void setMarkaId(Integer markaId) {
        this.markaId = markaId;
    }
    public String getMarkaAdi() {
        return this.markaAdi;
    }
    
    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }




}


