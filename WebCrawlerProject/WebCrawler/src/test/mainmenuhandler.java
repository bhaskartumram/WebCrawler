package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class mainmenuhandler implements ActionListener
{
    private UIManager.LookAndFeelInfo[] landf;
    private MainGui frame;
    private JMenuBar menubar;
    private JMenu landfmenu;


    private JMenu aboutmenu1;
    private JPopupMenu popup;



    /* class constructor */

    public mainmenuhandler(MainGui frm)
    {
        JMenuItem menuItem=null;
        landf = UIManager.getInstalledLookAndFeels();
        frame = frm;
        menubar = new JMenuBar();
        popup = new JPopupMenu();


         aboutmenu1 = new JMenu("About Us");
        aboutmenu1.setMnemonic(KeyEvent.VK_U);

        landfmenu = new JMenu("Theme");
        landfmenu.setMnemonic(KeyEvent.VK_L);


          menuItem = new JMenuItem("Contact Us");
		        menuItem.addActionListener(this);
        aboutmenu1.add(menuItem);
        landf = UIManager.getInstalledLookAndFeels();
        for(int j = 0; j < landf.length; j++)
        {
            menuItem = new JMenuItem(getclassname(landf[j].getClassName()));
            menuItem.addActionListener(this);
            landfmenu.add(menuItem);
        }




        menubar.add(landfmenu);

         menubar.add(aboutmenu1);
          aboutmenu1.addActionListener(this);
        frame.setpopup(popup);
        frame.setJMenuBar(menubar);


    }

    /* Function that strips of the actual class name from a fully-qualified java class name */

    String getclassname(String originalname)
    {
        return originalname.substring(originalname.lastIndexOf(".")+1);
    }

    /* Function that handles menu events. */

    public void actionPerformed(ActionEvent e)
    {
        FileOutputStream out=null;
        int sz=0;
        listdata lst=null;
        String dst=null;
        JFileChooser fs=null;
        File tmpfl=null;
        File selectedFile=null;
        String strtmp=null;
        String savdir=null;

        about ad1 = null;

        try
        {
            for(int i = 0; i < landf.length; i++)
            {
                if(getclassname(landf[i].getClassName()).equals(e.getActionCommand()))
                {
                    UIManager.setLookAndFeel(landf[i].getClassName());
                    SwingUtilities.updateComponentTreeUI(frame);
                    break;
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

         if(e.getActionCommand().equals("Contact Us"))
	                  {
		 	ad1 = new about(frame);
        		}
    }
}
