/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Business.HibernateUtil;
import Logic.Model.marka;
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
public class MarkaIslemleri extends marka{

    SessionFactory sesfac=HibernateUtil.getSessionFactory();
    Session s=sesfac.openSession();
    Transaction t=s.beginTransaction();
    
    public void markaEkle(marka mrk) {
       String QUERY = "from marka";
        int ekle=0;
        org.hibernate.Query sorgu = s.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<marka> liste = new ArrayList();
        while (it.hasNext()) {            
             marka mrk2 = (marka) it.next();
             liste.add(mrk2);
        }
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getMarkaAdi().equals(mrk.getMarkaAdi())){
                JOptionPane.showMessageDialog(null,"Bu Marka Zaten Mevcut");
                ekle=1;
            }
        }
        
        if(ekle==0){
        s.saveOrUpdate(mrk);
        t.commit();
        }
    }

    public String[] markaGetir() {
        String QUERY = "from marka";
        int ekle=0;
        org.hibernate.Query sorgu = s.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<marka> liste = new ArrayList();
        while (it.hasNext()) {            
             marka marka2 = (marka) it.next();
             liste.add(marka2);
        }
        String obj[] = new String[liste.size()];
         for (int i = 0; i < liste.size(); i++) {
             obj[i]= liste.get(i).getMarkaAdi();
             
         }
         return obj;
     }
    }

