package Logic.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stok")
public class stok  implements java.io.Serializable {

    @Id
    private Integer stokId;
    @Column
    private String urunkod;
    @Column
    private Integer stokAdet;
    @Column
    private Float stokFiyat;
     //private Float stokBirimFiyat;
    @Column
     private String stokTarih;

    public stok() {
    }

    public stok(String urunkod, Integer stokAdet, Float stokFiyat, String stokTarih) {
       this.urunkod = urunkod;
       this.stokAdet = stokAdet;
       this.stokFiyat = stokFiyat;
       //this.stokBirimFiyat = stokBirimFiyat;
       this.stokTarih = stokTarih;
    }
   
    public Integer getStokId() {
        return this.stokId;
    }
    
    public void setStokId(Integer stokId) {
        this.stokId = stokId;
    }
    public String getUrunKod() {
        return this.urunkod;
    }
    
    public void setUrunKod(String urunkod) {
        this.urunkod = urunkod;
    }
    public Integer getStokAdet() {
        return this.stokAdet;
    }
    
    public void setStokAdet(Integer stokAdet) {
        this.stokAdet = stokAdet;
    }
    public Float getStokFiyat() {
        return this.stokFiyat;
    }
    
    public void setStokFiyat(Float stokFiyat) {
        this.stokFiyat = stokFiyat;
    }
   /* public Float getStokBirimFiyat() {
        return this.stokBirimFiyat;
    }
    
    public void setStokBirimFiyat(Float stokBirimFiyat) {
        this.stokBirimFiyat = stokBirimFiyat;
    }*/
    public String getStokTarih() {
        return this.stokTarih;
    }
    
    public void setStokTarih(String stokTarih) {
        this.stokTarih = stokTarih;
    }




}


