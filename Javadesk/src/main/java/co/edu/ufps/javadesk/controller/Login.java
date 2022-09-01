package co.edu.ufps.javadesk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.*;
import org.json.JSONArray;
import org.json.JSONObject;


public class Login {

    /**
     * Porgramar evento con el button para que llame a esta funcion, capturando
     * los datos de la gui y enviandolos por parametro
     */
    public static String loginUser(String user, String password) throws JsonProcessingException, IOException, InterruptedException {

        try {
            String query = "https://codeqr-generate.herokuapp.com/api/auth/login";
            JSONObject obj = new JSONObject();
            obj.put("username", user);
            obj.put("password", password);
            String json = obj.toString();

            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

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
            Integer idUsuario = 0;
            
            if(conn.getResponseCode() == 200){
                JSONObject jsonObject1 = new JSONObject(respuestaApi);            
                Object usuarioJson = jsonObject1.getJSONObject("usuario");             
                JSONObject jsonObject2 = new JSONObject(usuarioJson.toString());             
                idUsuario = jsonObject2.getInt("id_usuario");
            }

            return conn.getResponseCode()+";"+idUsuario;
            
        } catch (IOException e) {
            e.printStackTrace();
            return "mal";
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // test de login user 
        System.out.println(loginUser("jhoser2", "123456"));
    }
}
