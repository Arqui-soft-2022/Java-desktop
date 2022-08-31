/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.javadesk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.io.OutputStream;
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
            String respuestaApi = "Bienvenido";
            if(conn.getResponseCode() == 404){
                respuestaApi = "Usuario o contraseña inválidos";
            }else if (conn.getResponseCode() == 400){
                respuestaApi = "El usuario NO existe";
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
