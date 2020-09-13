package Logic.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="user",catalog="stoktakip")
public class kullanici implements Serializable {

    @Id @GeneratedValue
    private Integer KId;
    @Column
    private String KAdi;
    @Column
    private String KSifre;
    @Column
    private String adi;
    @Column
    private String soyadi;

   
    
    public kullanici() {
    }

    public kullanici(String KAdi, String KSifre, String adi, String soyadi) {
       this.KAdi = KAdi;
       this.KSifre = KSifre;
       this.adi = adi;
       this.soyadi = soyadi;
    }
   
    public Integer getKId() {
        return this.KId;
    }
    
    public void setKId(Integer KId) {
        this.KId = KId;
    }
    public String getKAdi() {
        return this.KAdi;
    }
    
    public void setKAdi(String KAdi) {
        this.KAdi = KAdi;
    }
    public String getKSifre() {
        return this.KSifre;
    }
    
    public void setKSifre(String KSifre) {
        this.KSifre = KSifre;
    }
    public String getAdi() {
        return this.adi;
    }
    
    public void setAdi(String adi) {
        this.adi = adi;
    }
    
    public String getSoyadi() {
        return this.soyadi;
    }
    public void setsoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
    
    


}


