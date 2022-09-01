
package co.edu.ufps.javadesk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import co.edu.ufps.javadek.view.GeneradorQr;
import org.json.JSONArray;
/**
 *
 * @author Usuario
 */
public class GenerarQR implements ActionListener {
    
   public static String generarQR(String url, Integer user) throws JsonProcessingException, IOException, InterruptedException {

        try {
            String query = "https://codeqr-generate.herokuapp.com/api/code/";
            JSONObject obj = new JSONObject();
            obj.put("url", url);
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
            os.write(json.getBytes("UTF-8"));
            os.close();

            String respuestaApi = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            for (int i = in.read(); i != -1; i = in.read()) {
                respuestaApi += (char) i;
            }

            JSONArray array = new JSONArray("["+respuestaApi+"]"); 
            
            String dataQR= array.getJSONObject(0).getJSONObject("qr_code").get("url_code").toString();
            
            return dataQR;
        } catch (IOException e) {
            return (e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // test de login user 
        System.out.println(generarQR("", 1));
    }
            
   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
