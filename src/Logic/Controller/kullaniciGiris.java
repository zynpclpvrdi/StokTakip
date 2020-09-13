/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Business.HibernateUtil;
import Logic.Model.kullanici;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Asus
 */
public class kullaniciGiris extends kullanici{
    
    public kullaniciGiris(){}

    public int kullaniciGiris(String k_adi, Integer k_sifre) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String QUERY = "from user";
       
        Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        int giris=0;
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             liste.add(usr);
        }
        for(int i = 0;i<liste.size();i++){
            if(k_sifre.equals(liste.get(i).getKSifre())&&liste.get(i).getKAdi().equals(k_adi)){
                    giris=1;
            }else{
                    giris=2;
        }
            
        }
        return giris;
    }
    
}
