package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.lang.reflect.Type;

@Service
public class UtilImpl<T> implements Util<T> {

	/**
	 * Metodo utilitario para convertir un json a un objeto.
	 * @param objectRes
	 * @param json
	 * @param nodos
	 * @return
	 */
	 private static Util util;
	 
	 /*
	     * M�todo estatico que devuelve instancia del tipo de clase para patr�n singleton.
	     */
	    public static Util getInstance() {
	        if(util == null)
	            util = new UtilImpl();
	        return util;
	    }


	@Override
	public Object jsonToObject(T objectRes, String json, ArrayList<String> nodos) throws ParseException{
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();
        Object objRes = parser.parse(json);
        JSONObject jsonObject  = (JSONObject) objRes;
        for (String nodo : nodos){
            jsonObject = (JSONObject) jsonObject.get(nodo);
        }
        String jsonResponse = jsonObject.toJSONString();
        try {
            return gson.fromJson(jsonResponse, ((T)objectRes).getClass());
        } catch (Exception e) {
            return null;
        }
    }
	
	public String eliminarNodosJson(String json, ArrayList<String> nodos) {
		try {
			JSONParser parser = new JSONParser();
			Object objRes = parser.parse(json);
			JSONObject jsonObject = (JSONObject) objRes;
			for (String nodo : nodos) {
				if(jsonObject.containsKey(nodo)) {
					jsonObject = (JSONObject) jsonObject.get(nodo);
				}
			}
			return jsonObject.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Metodo utilitario para convertir un json a un objeto.
	 * @param objectRes
	 * @param json
	 * @return
	 * @throws ParseException
	 */
	@Override
	public Object jsonToObject(T objectRes, String json) {
		try {
			Gson gson = new Gson();
			JSONParser parser = new JSONParser();
			Object objRes = parser.parse(json);
			JSONObject jsonObject = (JSONObject) objRes;
			String jsonResponse = jsonObject.toJSONString();
			Object response = gson.fromJson(jsonResponse, ((T) objectRes).getClass());
			return response;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Metodo utilitario para convertir un objeto a un json.
	 * @param object
	 * @return
	 */
	@Override
	public String objectToJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	 /*
     * M�todo utilitario para realizar llamada REST por el m�todo POST
     */
	@Override
    public String callRestPost(Object obj, String uri) {
        Util util = UtilImpl.getInstance();
        String output = "";
        try {
            String input = util.objectToJson(obj);
            URL restServiceURL = new URL(uri);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpConnection.getInputStream()), "UTF8"));
            String outputline;
            while ((outputline = responseBuffer.readLine()) != null) {
                output += outputline;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }


	@Override
	public String sendGET(String url) throws IOException {
		// TODO Auto-generated method stub
		URL obj;
		String  output="";
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(
	                    new InputStreamReader((con.getInputStream()), "UTF8"));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				output = new String(response.toString().getBytes(),"ISO-8859-1");
				return output;
			} else {
				System.out.println("GET request not worked");
				return "ERROR AL CARGAR EL CATALOGO";
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		return output;
		
	}


	@Override
	public String sendGetAuth(String url, AuthHeader auth) throws IOException {
		// TODO Auto-generated method stub
		String  output="";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		//String encoded = Base64.getEncoder().encodeToString((auth.getUsername()+":"+auth.getPassword()).getBytes(StandardCharsets.UTF_8));  //Java 8
		String encoded = Base64.getEncoder().encodeToString(("luismarianoazul@gmail.com"+":"+"test1").getBytes(StandardCharsets.UTF_8));  //Java 8
		connection.setRequestProperty("Authorization", "Basic "+encoded);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/json");
		int responseCode = connection.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(
                    new InputStreamReader((connection.getInputStream()), "UTF8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			output = new String(response.toString().getBytes(),"ISO-8859-1");
			return output;
		} else {
			System.out.println("GET request not worked");
			return "ERROR";
		}
		
		
	}
	
	
	@Override
	public String jsonToNode(T objectRes, String json, ArrayList<String> nodos) throws ParseException {
		 Gson gson = new Gson();
	        JSONParser parser = new JSONParser();
	        Object objRes = parser.parse(json);
	        JSONObject jsonObject  = (JSONObject) objRes;
	        for (String nodo : nodos){
	            jsonObject = (JSONObject) jsonObject.get(nodo);
	        }
	        String jsonResponse = jsonObject.toJSONString();
	       return jsonResponse;
	}


	@Override
	public JSONArray stringToArrayJson(String result) {
		   try {
				JSONArray json = new JSONArray(result);
				
				return json;
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		return null;
	}


	@Override
	public String callRestPostAuth(Object obj, String uri, AuthHeader userSession) {
		 Util util = UtilImpl.getInstance();
	        String output = "";
	        try {
	            String input = util.objectToJson(obj);
	            URL restServiceURL = new URL(uri);
	            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
	            //String encoded = Base64.getEncoder().encodeToString((userSession.getUsername()+":"+userSession.getPassword()).getBytes(StandardCharsets.UTF_8));  //Java 8
	            String encoded = Base64.getEncoder().encodeToString(("adrian@gmail.com"+":"+"test2").getBytes(StandardCharsets.UTF_8));  //Java 8
	            httpConnection.setRequestProperty("Authorization", "Basic "+encoded);
	            httpConnection.setDoOutput(true);
	            httpConnection.setRequestMethod("POST");
	            httpConnection.setRequestProperty("Content-Type", "application/json");
	            OutputStream outputStream = httpConnection.getOutputStream();
	            outputStream.write(input.getBytes());
	            outputStream.flush();
	            if (httpConnection.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP error code : " + httpConnection.getResponseCode()+" msj: "+ httpConnection.getResponseMessage());
	            }
	            BufferedReader responseBuffer = new BufferedReader(
	                    new InputStreamReader((httpConnection.getInputStream()), "UTF8"));
	            String outputline;
	            while ((outputline = responseBuffer.readLine()) != null) {
	                output += outputline;
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        	return "ERROR";
	        }
	        return output;
	}


	@Override
	public List<ProductoDto> arrayJsonToList(String arrayJson) {
		 Gson gson = new Gson();
		 Type type = new TypeToken<List<ProductoDto>>(){}.getType();
		 //List<ProductoDto> objects = gson.fromJson(arrayJson, type);
		   
		 return gson.fromJson(arrayJson, type);
	}
	

}