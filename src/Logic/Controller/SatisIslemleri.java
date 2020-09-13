/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Gui.satisYap;
import Logic.Model.stok;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class SatisIslemleri extends stok{

    SessionFactory sessionfac=Business.HibernateUtil.getSessionFactory();
    Session session=sessionfac.openSession();
    Transaction t=session.beginTransaction();
   

    public void satisYap(stok ss) {
        session.saveOrUpdate(ss);
         String QUERY = "select urun_adedi from urun where urun_no= :urunkod";
         org.hibernate.Query sorgu = session.createQuery(QUERY);
         sorgu.setParameter("urunkod",ss);
         Iterator it = sorgu.iterate();
         session.saveOrUpdate(ss);
         t.commit();
    }
    
}
