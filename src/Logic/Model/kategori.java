package Logic.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="kat",catalog="stoktakip")
public class kategori  implements java.io.Serializable {


     
     @Id 
     @GeneratedValue(strategy = IDENTITY)
     @Column(name = "kategori_id")
     private Integer kategoriId;
     @Column(name="kategori_adi")
     private String kategoriAdi;

    public kategori() {
    }

    public kategori(String kategoriAdi) {
       this.kategoriAdi = kategoriAdi;
    }
   
    public Integer getKategoriId() {
        return this.kategoriId;
    }
    
    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }
    public String getKategoriAdi() {
        return this.kategoriAdi;
    }
    
    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }




}


