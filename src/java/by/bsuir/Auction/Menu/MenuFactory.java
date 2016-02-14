/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */

public class MenuFactory {  
   private HashMap<String, PageMenu> menuMap = new HashMap<String, PageMenu>();
   
   
   private MenuFactory()
   {
   }
 
   
   public boolean registerMenu(String pageName, PageMenu item)
   {
       if(item == null || item.isEmpty())
           return false;

       if(pageName.isEmpty() || menuMap.containsKey(pageName))
           return false;
       
       menuMap.put(pageName, item);
       
       return true;
   }
   
   
   public PageMenu getMenu(String name)
   {
       return menuMap.get(name);
   }
   
 
   public static MenuFactory getInstance()  {  
      return SingletonHolder.instance;  
   }
   
   private static class SingletonHolder {  
      public static final MenuFactory instance = new MenuFactory();  
   }  
}