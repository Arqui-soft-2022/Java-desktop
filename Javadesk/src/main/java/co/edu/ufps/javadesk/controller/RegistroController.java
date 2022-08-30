/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Usuario
 */
public class RegistroController {
    
    public static String registroUser(String username, String password, String email, String name) throws JsonProcessingException, IOException, InterruptedException {

        try {
            String query = "https://codeqr-generate.herokuapp.com/api/auth/register";
            JSONObject obj = new JSONObject();
            obj.put("username", username);
            obj.put("password", password);
            obj.put("email", email);
            obj.put("name", name);
            String json = obj.toString();

            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            return ""+conn.getResponseCode();
        } catch (IOException e) {
            return (e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
       
        System.out.println(registroUser( "sam",  "123456",  "sam@hotmail.com",  "Sam Zamora"));
    }
    
}
