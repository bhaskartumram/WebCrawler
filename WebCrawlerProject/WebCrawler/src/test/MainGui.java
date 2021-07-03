package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/*
 * Class that creates the main window for the program.
 */
public class MainGui extends JFrame implements MouseListener, ActionListener
{


	/* getter and setter methods for private class variables */

	private JPopupMenu popup;
	public JPopupMenu getpopup()
	{ 
		return popup;
	}
	public void setpopup(JPopupMenu jpm)
	{ 
		popup = jpm; 
	}

	int type;
	public int getType1()
	{
		return type; 
	}
	public void setType(int tprm)
	{
		type=tprm; 
	}

	private JScrollPane jsp1;
	public JScrollPane getScrollPane1()
	{ 
		return jsp1; 
	}
	public void setScrollPane1(JScrollPane pjsp)
	{
		jsp1=pjsp; 
	}


	public JTextArea jt1;
	private UIManager.LookAndFeelInfo[] landf;
	public UIManager.LookAndFeelInfo[] getLandF()
	{
		return landf; 
	}
	public void setLandF(UIManager.LookAndFeelInfo[] plandf)
	{ 
		landf=plandf; 
	}

	private mainmenuhandler mmh;
	public mainmenuhandler getMenuHandler()
	{ 
		return mmh; 
	}
	public void setMenuHandler(mainmenuhandler pmmh)
	{ 
		mmh=pmmh; 
	}

	private JButton b1,b2,b3,b4,b5,b6;
	private JTable tabl;
	private ArrayList columnNamesList;
	private JPanel panel,panel1,pan;
	JTextField jtf,jtf1;
	private JLabel lbl,l1,l2,l3;
	private ImageIcon i1,i2,i3,i4,i5,i6,i7,i8;
	JTable table;
	private JScrollPane scrollPane;
	JButton onoff;
	String clickv=null;
	int row;


	/* The class constructor */

	public MainGui()
	{

		java.net.URL imageURL=null;
		ImageIcon img=null;
		JMenuItem menuItem=null;
		popup=null;
		jsp1=null;
		landf=null;
		mmh=null;
		type=-1;
		b1=null;
		int i=0;
		try
		{
			imageURL = MainGui.class.getResource("images//22.png");
			img = new ImageIcon(imageURL);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel=new JPanel();
		panel1=new JPanel();
		pan=new JPanel();

		pan.setLayout( new BoxLayout(pan,BoxLayout.Y_AXIS) );
		pan.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setLayout( new FlowLayout(FlowLayout.LEFT) );


		panel.setPreferredSize(new Dimension(80,60));
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);

		panel1.setPreferredSize(new Dimension(80,750));
		panel1.setVisible(true);
		panel1.setOpaque(true);
		panel1.setBackground(Color.BLACK);

		pan.add(panel);
		pan.add(panel1);
		pan.setVisible(true);
		this.add(pan);

		i1=new ImageIcon(getClass().getResource("images//start.jpg"));
		i3=new ImageIcon(getClass().getResource("images//save.jpg"));
		i4=new ImageIcon(getClass().getResource("images//open.jpg"));
		i5=new ImageIcon(getClass().getResource("images//find.jpg"));
		i6=new ImageIcon(getClass().getResource("images//3.jpg"));
		i7=new ImageIcon(getClass().getResource("images//off.jpg"));
		i8=new ImageIcon(getClass().getResource("images//on.jpg"));

		jtf1=new JTextField("http://",30);
		panel.add(jtf1);
		b1=new JButton("",i1);
		panel.add(b1);

		b3=new JButton("",i3);
		panel.add(b3);
		b4=new JButton("",i4);
		panel.add(b4);

		jtf=new JTextField(20);
		panel.add(jtf);
		b5=new JButton("",i5);
		panel.add(b5);

		b6=new JButton("",i6);
		panel.add(b6);


		jtf.setPreferredSize(new Dimension(40,35));
		jtf1.setPreferredSize(new Dimension(40,35));

		b1.setBackground(Color.GREEN);
		b1.setPreferredSize(new Dimension(40,40));

		b3.setBackground(Color.YELLOW);
		b3.setPreferredSize(new Dimension(40,40));

		b4.setBackground(Color.ORANGE);
		b4.setPreferredSize(new Dimension(40,40));

		b5.setBackground(Color.WHITE);
		b5.setPreferredSize(new Dimension(40,40));

		b6.setBackground(Color.RED);
		b6.setPreferredSize(new Dimension(40,40));


		b1.addActionListener(this);	
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

		//panel.addActionListener(this);

		panel1.setLayout( new BorderLayout() );

		jt1 = new JTextArea();
		jt1.addMouseListener(this);
		jt1.setLineWrap(true);
		jt1.setMinimumSize(new Dimension(2, 2));
		jsp1=new JScrollPane(jt1);




		panel1.add(jsp1);
		setIconImage(img.getImage());
		mmh = new mainmenuhandler(this);
	}	//end constructor



	public void mouseClicked(MouseEvent e)
	{}

	public void mouseEntered(MouseEvent e)
	{}

	public void mouseExited(MouseEvent e)
	{}

	public void mousePressed(MouseEvent e)
	{}

	/* Method that responds to a right-click event. */

	public void mouseReleased(MouseEvent e)
	{
		int i = e.getButton();
		if(i==MouseEvent.BUTTON3)
		{
			popup.show(e.getComponent(),e.getX(), e.getY());
		}
	}


	/* Method that responds to changes in the network interface combo box. */

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

		if(e.getSource()==b1)
		{
			this.jt1.setText("Wait....while Fetching....");
			String searchurl=jtf1.getText();
			try
			{
				new Crawler(searchurl);					/* Crawler */
			}
			catch(Exception excep){}
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,"1000 URLs are Fetched");


		}

		/* save */

		else if(e.getSource()==b3)
		{

			fs = new JFileChooser();
			fs.addChoosableFileFilter(new LogFilter(".log"));
			fs.setAlignmentX(this.getAlignmentX());
			fs.setAlignmentY(this.getAlignmentY());
			fs.setSelectedFile(null);
			if(fs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				savdir=fs.getCurrentDirectory().toString();
				tmpfl=fs.getSelectedFile();
				if(tmpfl!=null)
				{
					strtmp=tmpfl.toString();
					if(strtmp.indexOf('.')>0)
					{
						strtmp=strtmp.substring(0,strtmp.lastIndexOf('.'));
					}
					selectedFile = new File(strtmp + fs.getFileFilter().getDescription());
					try
					{
						if(selectedFile!=null)
						{
							try
							{
								out = new FileOutputStream(selectedFile);
								dst =  this.jt1.getText() + "\r\n\r\n---------------------------------\r\n\r\n";
								out.write(dst.getBytes(),0,dst.length());
								out.close();
								this.jt1.setText("");
							}
							catch(Exception errr)
							{
								System.out.println(errr.toString());
							}
						}
					}
					catch(Exception err)
					{
						System.out.println(err.toString());
					}
				}
			}
		}


		/* open */

		else if(e.getSource()==b4)
		{
			String contents="";
			StringBuilder sb=new StringBuilder();
			fs = new JFileChooser();
			fs.addChoosableFileFilter(new LogFilter(".log"));
			fs.setAlignmentX(this.getAlignmentX());
			fs.setAlignmentY(this.getAlignmentY());
			fs.setSelectedFile(null);
			if(fs.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				savdir=fs.getCurrentDirectory().toString();
				tmpfl=fs.getSelectedFile();
				BufferedReader br=null;
				try
				{
					br=new BufferedReader(new FileReader(tmpfl));
					while((contents=br.readLine())!=null){
						sb.append(contents+"\n");
					}
				}
				catch(IOException ioe){}
				finally
				{
					try
					{
						if(br!=null)
							br.close();}
					catch(Exception cls){}
				}
				this.jt1.setText(sb.toString());
			}
		}

		/* exit */

		else if(e.getSource()==b6)
		{
			int dialogButton=JOptionPane.YES_NO_OPTION;
			int res= JOptionPane.showConfirmDialog(null,"You Really want to Exit???","Warning",dialogButton);
			if(res==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}

		/* search */

		else if(e.getSource()==b5)
		{
			jt1.getHighlighter().removeAllHighlights();
			String a=jtf.getText();
			String b=jt1.getText();
			Highlighter highlighter=jt1.getHighlighter();
			HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
			int k1,k2;
			String[] splited=b.split(a);
			Pattern ptr=Pattern.compile(a,Pattern.CASE_INSENSITIVE+Pattern.MULTILINE);
			Matcher mtr=ptr.matcher(b);
			jt1.requestFocusInWindow();
			try
			{
				while(mtr.find())
				{
					k1=mtr.start();
					k2=mtr.end();
					highlighter.addHighlight(k1,k2,painter);
				}
			}

			catch(BadLocationException ble){}
		}

	}

}



