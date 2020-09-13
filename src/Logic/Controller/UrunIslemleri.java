/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Business.HibernateUtil;
import Logic.Model.urun;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class UrunIslemleri extends urun{

    SessionFactory sf = Business.HibernateUtil.getSessionFactory();
     Session session = sf.openSession();
     Transaction ts = session.beginTransaction();
     
    public String[] urunGetir() {
        String QUERY = "from urun";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<String> liste = new ArrayList();
        while (it.hasNext()) {            
              urun urun = (urun) it.next();
             liste.add(urun.getUrunAdi());
        }
        String str[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             str[i]= liste.get(i);
             
         }
         return str;
         
    }

    public void urunEkle(urun urun) {
        String QUERY = "from urun";
        int ekle=0;
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        while (it.hasNext()) {            
             urun urunn = (urun) it.next();
             liste.add(urunn);
        }
        for(int i=0;i<liste.size();i++){
            if(Objects.equals(liste.get(i).getUrunNo(), urun.getUrunNo())){
                JOptionPane.showMessageDialog(null,"Bu Urun Zaten Mevcut");
                ekle=1;
            }
        }
        
        if(ekle==0){
        session.saveOrUpdate(urun);
        ts.commit();
        }
    }
    public DefaultTableModel urunGetir(String u_adi,DefaultTableModel tm){
         
         
        String QUERY = "from src.Logic.Model.urun where u_adi =:u_adi";
       
        Query sorgu = (Query) session.createQuery(QUERY).setString("u_adi",u_adi).uniqueResult();
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        
        while (it.hasNext()) {            
             urun urn = (urun) it.next();

             liste.add(urn);
        }
         
        
         for(int i=0;i<liste.size();i++){
             tm.addRow(new Object[]{liste.get(i).getUrunNo(),liste.get(i).getUrunAdi(),liste.get(i).getUrunMarkasi(),
             liste.get(i).getUrunKategorisi(),liste.get(i).getFiyat()});
         }
         
         return tm;
    }
    public DefaultTableModel urunAdiGetir(){
        String QUERY = "from urun";
       
        org.hibernate.Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<urun> liste = new ArrayList();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             urun urun = (urun) it.next();

             liste.add(urun);
        }
         tm.addColumn("Ürün Numarası");
         tm.addColumn("Ürün Adı");
         tm.addColumn("Marka");
         tm.addColumn("Kategori");
         tm.addColumn("Fiyat");
         tm.addColumn("Ürün Adedi");
        
         for(int i=0;i<liste.size();i++){
             tm.addRow(new Object[]{liste.get(i).getUrunNo(),liste.get(i).getUrunAdi(),liste.get(i).getUrunMarkasi(),
             liste.get(i).getUrunKategorisi(),liste.get(i).getFiyat()});
         }
         
         
         return tm;
     }
    public void urunSil(int urunNo) {
        String QUERY = "from urun";
        int sil=0;
        Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        List<urun> liste =sorgu.list();
        while (it.hasNext()) {            
             urun ur = (urun) it.next();
             liste.add(ur);
        }
        
        if(sil==1){
           
        Query query = session.createQuery("delete from urun where urunNo=:urun_no");
        query.setInteger("urunNo", urunNo);
        query.executeUpdate();
        System.out.println(query.executeUpdate());  
            ts.commit();
            }
    }

}
  