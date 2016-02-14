/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Menu;

/**
 *
 * @author User
 */
public class MenuItem {
    private String name;
    private String url;
    private String className;
    public MenuItem(String name, String url, String className)
    {
        this.name = name;
        this.url = url;
        this.className = className;
    }
    
    public boolean isValid()
    {
        return (!name.isEmpty() && !url.isEmpty() && !className.isEmpty());
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getUrl()
    {
        return this.url;
    }
    
    public String getClassName()
    {
        return this.className;
    }
}
