/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Rest;
import com.codename1.ui.events.ActionListener;
import edu.esprit.entities.Cours;
import edu.esprit.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hedi
 */
public class ServiceCours {
        public static ServiceCours instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceCours getInstance() {
        if(instance == null )
            instance = new ServiceCours();
        return instance ;
    }
    
    
    
    public ServiceCours() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutCours(Cours cours) {
        
        String url =Statics.BASE_URL+"/cours/addMobile?nomination="+cours.getNomination()+"&type="+cours.getType()
                +"&duree="+cours.getDuree()+"&matiere="+cours.getMatiere()+"&tuteur="+cours.getTuteur()
                +"&contact="+cours.getContact(); 
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public ArrayList<Cours>affichageCours() {
        ArrayList<Cours> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/cours/mobile";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapCourss = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapCourss.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Cours c = new Cours();
                        float codeCours = Float.parseFloat(obj.get("CodeCours").toString());                        
                        String nom = obj.get("Nomination").toString();
                        String support = obj.get("Support").toString();
                        float duree = Float.parseFloat(obj.get("Duree").toString());
                        String matiere = obj.get("Matiere").toString();
                        
                        c.setCode_cours((int)codeCours);
                        c.setNomination(nom);
                        c.setSupport(support);
                        c.setDuree((int)duree);
                        c.setMatiere(matiere);

                        
                        //Date 
                        String DateConverter =  obj.get("DatePublication").toString().substring(obj.get("DatePublication").toString().indexOf("timestamp") + 10 , obj.get("DatePublication").toString().lastIndexOf("}"));
                        
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        c.setDatePublication(dateString);
                        
                        //insert data into ArrayList result
                        result.add(c);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    public Cours DetailCours( int id , Cours c) {
        
        String url = Statics.BASE_URL+"/cours/recAPI/"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                        float codeCours = Float.parseFloat(obj.get("CodeCours").toString());                        
                        String nom = obj.get("Nomination").toString();
                        String support = obj.get("Support").toString();
                        float duree = Float.parseFloat(obj.get("Duree").toString());
                        String matiere = obj.get("Matiere").toString();
                        
                        c.setCode_cours((int)codeCours);
                        c.setNomination(nom);
                        c.setSupport(support);
                        c.setDuree((int)duree);
                        c.setMatiere(matiere);
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return c;
        
        
    }
    
    
    //Delete 
    public static boolean deleteCours(int id ) {
        Rest.delete(Statics.BASE_URL +"/cours/delAPI/"+id).jsonContent().acceptJson().getAsJsonMap().getResponseData();
        return true;
    }
    
    
    
    //Update 
    public boolean modifierCours(Cours cours) {
        String url = Statics.BASE_URL +"/reclamation/upRecAPI/"+cours.getCode_cours()
        +"?nomination="+cours.getNomination()+"&type="+cours.getType()
                +"&duree="+cours.getDuree()+"&matiere="+cours.getMatiere()+"&tuteur="+cours.getTuteur()
                +"&contact="+cours.getContact();         
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    

    
    
}
