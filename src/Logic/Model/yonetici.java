package Logic.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yonetici")
public class yonetici  implements java.io.Serializable {

    @Id
    private Integer YId;
    @Column
    private String YAdi;
    @Column
    private String YSoyadi;
    @Column
    private String YKadi;
    @Column
    private String YSifre;
    @Column
    private int YTel;

    public yonetici() {
    }

    public yonetici(String YAdi, String YSoyadi, String YKadi, String YSifre, int YTel) {
       this.YAdi = YAdi;
       this.YSoyadi = YSoyadi;
       this.YKadi = YKadi;
       this.YSifre = YSifre;
       this.YTel = YTel;
    }
   
    public Integer getYId() {
        return this.YId;
    }
    
    public void setYId(Integer YId) {
        this.YId = YId;
    }
    public String getYAdi() {
        return this.YAdi;
    }
    
    public void setYAdi(String YAdi) {
        this.YAdi = YAdi;
    }
    public String getYSoyadi() {
        return this.YSoyadi;
    }
    
    public void setYSoyadi(String YSoyadi) {
        this.YSoyadi = YSoyadi;
    }
    public String getYKadi() {
        return this.YKadi;
    }
    
    public void setYKadi(String YKadi) {
        this.YKadi = YKadi;
    }
    public String getYSifre() {
        return this.YSifre;
    }
    
    public void setYSifre(String YSifre) {
        this.YSifre = YSifre;
    }
    public int getYTel() {
        return this.YTel;
    }
    
    public void setYTel(int YTel) {
        this.YTel = YTel;
    }




}


