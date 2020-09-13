/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Business.HibernateUtil;
import Logic.Model.kategori;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class KategoriIslemleri extends kategori {

    SessionFactory sf=HibernateUtil.getSessionFactory();
    Session s=sf.openSession();
    Transaction t=s.beginTransaction();
    
    public void kategoriEkle(kategori kat) {
        String QUERY = "from kat";
        int ekle=0;
        org.hibernate.Query sorgu = s.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kategori> liste = new ArrayList();
        while (it.hasNext()) {            
             kategori kat2 = (kategori) it.next();
             liste.add(kat2);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getKategoriId().equals(kat.getKategoriAdi())){
                JOptionPane.showMessageDialog(null,"Bu Kategori Zaten Mevcut");
                ekle=1;
            }
        }
        if(ekle==0){
        s.saveOrUpdate(kat);
        t.commit();
        }
    }

    public String[] kategoriGetir() {
        String QUERY = "from kat";
        int ekle=0;
        org.hibernate.Query sorgu = s.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kategori> liste = new ArrayList();
        while (it.hasNext()) {            
             kategori ktgr2 = (kategori) it.next();
             liste.add(ktgr2);
        }
        String obj[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             obj[i]= liste.get(i).getKategoriAdi();
             
         }
         return obj;
     }
    }
    
