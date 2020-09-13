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
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class SifreIslemleri extends kullanici{

    int degis=0;
    SessionFactory sessionfactory=HibernateUtil.getSessionFactory();
    Session session=sessionfactory.openSession();
    Transaction t=session.beginTransaction();


    public int SifreDegistir(String Kadi, Integer eskiSifre, Integer yeniSifre, Integer sifreTekrari) {
        String QUERY = "from user";
        Query query = session.createQuery(QUERY);
        Iterator it = query.iterate();
        
        
        
        ArrayList<kullanici> liste = new ArrayList();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             if(usr.getKAdi().equals(Kadi))
                liste.add(usr);
        }
        
        if(liste.isEmpty()){
            degis=2;//kullanici adi bulunamadi hatasi
            JOptionPane.showMessageDialog(null,liste.get(0).getKId());
        }else if(eskiSifre.equals(liste.get(0).getKSifre())){
            if(yeniSifre.equals(sifreTekrari)){
                String QUERY2 = "UPDATE user set password = :yeni_sifre WHERE username = :k_adi";
                
                Query query2 = session.createQuery(QUERY2);
                query2.setParameter("yeni_sifre",yeniSifre);
                query2.setParameter("k_adi",Kadi);
                query2.executeUpdate();
                t.commit();
                degis =1;                //şifrenin değiştiği durumdur
                
            }
            else
                degis =4;//yeni şifre ile tekrar uyuşmazlığıdır.
        }
        else{
            degis =3;//şifrenin yanlis oldugu durumdur.
        }
        
        return degis;
    
    }
    
}
