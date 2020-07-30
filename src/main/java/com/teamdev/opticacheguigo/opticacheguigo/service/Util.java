package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.simple.parser.ParseException;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp.CPValidoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaMicas;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;


public interface Util<T> {

    Object jsonToObject(T objectRes, String json, ArrayList<String> nodos) throws ParseException;

    String jsonToNode(T objectRes, String json, ArrayList<String> nodos) throws ParseException;

    Object jsonToObject(T objectRes, String json);

    String objectToJson(Object object);

    String callRestPost(Object obj, String uri);

    String callRestPostAuth(Object obj, String uri, AuthHeader userSession);

    String sendGET(String url) throws IOException;

    String sendGETCP(String url) throws IOException;

    String sendGetAuth(String url, AuthHeader auth) throws IOException;

    JSONArray stringToArrayJson(String result);

    List<ProductoDto> arrayJsonToList(String arrayJson);

    List<MaterialDto> arrayJsonToListMat(String arrayJson);

    List<ConsultaMicas> arrayJsonToListMica(String arrayJson);

    List<CPValidoDto> arrayJsonToListCP(String arrayJson);


}
