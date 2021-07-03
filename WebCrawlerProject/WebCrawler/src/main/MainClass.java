package main;
import test.MainGui;

public class MainClass
{

    public static void main(String[] args) throws Exception
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                MainGui mg = new MainGui();
                mg.setTitle("Web Crawler");
                mg.setVisible(true);
            }
        });
    }
}