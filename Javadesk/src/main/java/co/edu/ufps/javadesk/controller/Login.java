package co.edu.ufps.javadesk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
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
            String respuestaApi = "Bienvenido";
            if(conn.getResponseCode() == 404){
                respuestaApi = "Usuario o contraseña inválidos";
            }else if (conn.getResponseCode() == 400){
                respuestaApi = "El usuario NO existe";
            }
            

            return respuestaApi;
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
