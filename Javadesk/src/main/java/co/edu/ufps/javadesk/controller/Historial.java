package co.edu.ufps.javadesk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author SAM
 */
public class Historial {
    
    	static String historial(String user) throws JsonProcessingException, IOException, InterruptedException {

        
        try {
            String query = "https://codeqr-generate2.herokuapp.com/api/code/historial/";
            JSONObject obj = new JSONObject();
            obj.put("user", user);
            String json = obj.toString();

            URL urlqr = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) urlqr.openConnection();


            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            //
            os.write(json.getBytes("UTF-8"));
            os.close();
            String respuestaApi = "";
                        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for (int i = in.read(); i != -1; i = in.read()) {
                            respuestaApi += (char) i;
                        }
            
            if(conn.getResponseCode() == 404){
                respuestaApi = "Error 1";
            }else if (conn.getResponseCode() == 400){
                respuestaApi = "Error 2";
            }
            

            return respuestaApi;
            
        } catch (IOException e) {
            return (e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // test de login user 
        System.out.println(historial("1"));
    }
    
}
