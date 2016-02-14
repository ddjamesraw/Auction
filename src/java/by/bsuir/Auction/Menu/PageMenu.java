/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Menu;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PageMenu extends AbstractMenu{
    
    public PageMenu()
    {
        menuItems = new ArrayList<MenuItem>();
    }
    
    private ArrayList<MenuItem> menuItems = null;
    
    
    public PageMenu(ArrayList<MenuItem> menu)
    {
        menuItems = menu;
    }
    
    
    
    
    public boolean addMenuItem(MenuItem item)
    {
        if(!item.isValid())
            return false;
        
        menuItems.add(item);
        
        return true;
    }
    
    public boolean isEmpty()
    {
        return menuItems.isEmpty();
    }
    
    
    @Override
    public String toHtml()
    {
        String out = "";
        
        out+="<font face=\"Arial\" size=\"2\">";
        for (MenuItem item: menuItems)
            out+=String.format("<a class=\"%s\" href=\"%s\">%s</a><br><br>\n", item.getClassName(), item.getUrl(), item.getName());

        out+="</font>";
        return out;
    }
}
