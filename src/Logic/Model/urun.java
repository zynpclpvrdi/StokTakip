package Logic.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="urun")
public class urun  implements java.io.Serializable {

    @Id
    private int urunNo;
    @Column
    private String urunAdi;
    @Column
    private int fiyat;
    @Column
    private String urunKategorisi;
    @Column
    private int urunAdedi;
    @Column
    private String urunMarkasi;
   // private Set stoks = new HashSet(0);

    public urun() {
    }

    public urun(String urunAdi, int fiyat, String urunMarkasi,String urunKategorisi, int urunAdedi) {
       this.urunAdi = urunAdi;
       this.fiyat = fiyat;
       this.urunKategorisi = urunKategorisi;
       this.urunAdedi = urunAdedi;
       //this.stoks = stoks;
       this.urunMarkasi=urunMarkasi;
    }
   
    public Integer getUrunNo() {
        return this.urunNo;
    }
    
    public void setUrunNo(Integer urunNo) {
        this.urunNo = urunNo;
    }
     public String getUrunMarkasi() {
        return urunMarkasi;
    }

    public void setUrunMarkasi(String urunMarkasi) {
        this.urunMarkasi = urunMarkasi;
    }
    public String getUrunAdi() {
        return this.urunAdi;
    }
    
    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
    public int getFiyat() {
        return this.fiyat;
    }
    
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    public String getUrunKategorisi() {
        return this.urunKategorisi;
    }
    
    public void setUrunKategorisi(String urunKategorisi) {
        this.urunKategorisi = urunKategorisi;
    }
    public Integer getUrunAdedi() {
        return this.urunAdedi;
    }
    
    public void setUrunAdedi(Integer urunAdedi) {
        this.urunAdedi = urunAdedi;
    }
    /*public Set getStoks() {
        return this.stoks;
    }
    
    public void setStoks(Set stoks) {
        this.stoks = stoks;
    }*/




}


