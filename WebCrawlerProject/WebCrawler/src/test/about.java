package test;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class about extends JDialog
{
    private JScrollPane jsp;
    private JEditorPane helpfile;
    
    public about(JFrame owner)
    {
        super(owner, "About Us");
        URL fileurl=null;
        File file=null;
        helpfile = new JEditorPane();
        helpfile.setEditable(false);
        helpfile.setContentType("text/html");
        try
        {
            fileurl = MainGui.class.getResource("contact.html");
            helpfile.setPage(fileurl);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        jsp = new JScrollPane();
        jsp.getViewport().add(helpfile, BorderLayout.CENTER);
        setSize(800, 700);
        getContentPane().add(jsp);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

