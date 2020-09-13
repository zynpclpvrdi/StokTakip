/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Controller;

import Business.HibernateUtil;
import Logic.Model.kullanici;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class kullaniciIslemleri extends kullanici{

   SessionFactory sf = Business.HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    Transaction ts = session.beginTransaction();
       
    
    public DefaultTableModel KullaniciGetir()
    {
        SessionFactory sef = HibernateUtil.getSessionFactory();
        Session s = sef.openSession();
       
        SQLQuery sorgu = s.createSQLQuery("from user");
        Iterator it = sorgu.iterate();
        List<kullanici> liste = sorgu.list();
        DefaultTableModel tm = new DefaultTableModel();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             
             liste.add(usr);
        }
        tm.addColumn("Kullanıcı no");
        tm.addColumn("Kullanıcı Adı");
        tm.addColumn("Kullanıcı Şifresi");
        
        for(int j=0;j<liste.size();j++){
            tm.addRow(new Object[]{liste.get(j).getKAdi(),liste.get(j).getKSifre()});
        }
        
        return tm;
    }
    
    public void KullaniciSil(String username){
        
        int sil=0;
        SQLQuery sorgu = session.createSQLQuery("from user");
        Iterator it = sorgu.iterate();
        List<kullanici> liste =sorgu.list();
        while (it.hasNext()) {            
             kullanici usr = (kullanici) it.next();
             liste.add(usr);
        }
        
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getKAdi().equals(username)){
                sil=1;
            }
        }
        if(sil==1){
            try{
        SQLQuery query = session.createSQLQuery("delete from user where username=:KAdi");
        query.setString("username", username);
        query.executeUpdate();
        System.out.println(query.executeUpdate());
        if(username.equals("Admin"))
            JOptionPane.showMessageDialog(null,"Admin silinemez!");
        else          
            ts.commit();
            }
            catch(HeadlessException ex){
                JOptionPane.showMessageDialog(null, "Önce bu kullanıcıya ait personeli siliniz\n "+ex);
            }
                }
        else if(sil==0){
            JOptionPane.showMessageDialog(null,"Böyle bir kullanıcı adı mevcut değil");
        }
    }

  

    public void kullaniciEkle(kullanici kul) {
        String QUERY = "from user";
        int ekle=0;
        Query sorgu = session.createQuery(QUERY);
        Iterator it = sorgu.iterate();
        ArrayList<kullanici> liste = new ArrayList();
        while (it.hasNext()) {            
             kullanici kull = (kullanici) it.next();
             liste.add(kull);
        }
        for(int i=0;i<liste.size();i++){
            if(Objects.equals(liste.get(i).getKId(), kul.getKId())){
                JOptionPane.showMessageDialog(null,"Bu kullanıcı numarası kullanılmaktadır..!");
                ekle=1;
            }
        }
    }
}
