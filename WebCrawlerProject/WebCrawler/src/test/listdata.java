package test;

public class listdata
{
	public void listdata1(String DATA, String url)
	{

				MainGui mg = new MainGui();         /* MainClass */
				mg.jtf1.setText(url);
				mg.jt1.setText(DATA);
                mg.setVisible(true);
	}

}
