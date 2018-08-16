package scripts;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DriverScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		      URL url = new URL ("http://localhost:8080/job/JTest/build"); // Jenkins URL localhost:8080, job named 'test'
		      String user = "neo"; // username
		      String pass = "b89e3b4b8cabda771a2528c610798565"; // password or API token
		      String authStr = user +":"+  pass;
		      String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      connection.setRequestMethod("POST");
		      connection.setDoOutput(true);
		      connection.setRequestProperty("Authorization", "Basic " + encoding);
		      InputStream content = connection.getInputStream();
		      BufferedReader in   =
		          new BufferedReader (new InputStreamReader (content));
		      String line;
		      while ((line = in.readLine()) != null) {
		        System.out.println(line);
		      }
		    } catch(Exception e) {
		      e.printStackTrace();
		    }

	}

}
