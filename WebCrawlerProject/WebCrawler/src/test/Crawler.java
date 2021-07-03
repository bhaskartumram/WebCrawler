package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler
{
	public Crawler(String args) throws Exception
	{

		String urls[] = new String[1000];
		String DATA="";
		String url = args;
		String fixedurl = args;
		int i=0,j=0,tmp=0,total=0, MAX = 1000;
		int start=0, end=0;
		String webpage = Web.getWeb(url);
		end = webpage.indexOf("<body");
		for(i=total;i<MAX; i++, total++)
		{
			start = webpage.indexOf("http://", end);
			if(start == -1)
			{
				start = 0;
				end = 0;
				try
				{
					webpage = Web.getWeb(urls[j++]);
				}
				catch(Exception e)
				{
					System.out.println("******************");
					System.out.println(urls[j-1]);
					System.out.println("Exception caught \n"+e);
				}

				/*logic to fetch urls out of body of webpage only */

				end = webpage.indexOf("<body");
				if(end == -1)
				{
					end = start = 0;
					continue;
				}
			}
			end = webpage.indexOf("\"", start);
			tmp = webpage.indexOf("'", start);
			if(tmp < end && tmp != -1)
			{
				end = tmp;
			}
			url = webpage.substring(start, end);
			urls[i] = url;
			System.out.println(urls[i]);
			DATA=DATA+urls[i]+"\r\n\n";
		}

		new listdata().listdata1(DATA,fixedurl);				/* listdata */
	}

}


class Web
{
	public static String getWeb(String address)throws Exception
	{
		String webpage = "";
		String inputLine = "";
		URL url = new URL(address);	//Creates a URL object from the String representation.
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));	//an input stream for reading from the URL connection.
		while ((inputLine = in.readLine()) != null)
			webpage += inputLine;
		in.close();
		return webpage;
	}
}

