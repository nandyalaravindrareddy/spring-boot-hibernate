package com.wellsfargo.dto;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

import java.io.*;
import java.util.Map;

public class ReadJson {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = new FileInputStream("/home/india/GCP_RnD/to_be_deleted/apply_complete_deleteComputeInstanceAdmin.json");
            Reader r = new InputStreamReader(is, "UTF-8");
            Gson gson = new GsonBuilder().create();
            JsonStreamParser p = new JsonStreamParser(r);

            while (p.hasNext()) {
                JsonElement e = p.next();
                if (e.isJsonObject()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    TfResponse tfResponse = gson.fromJson(e, TfResponse.class);
                    System.out.println(tfResponse);
                }
            }

            // Convert JSON string from file to Object
            TfResponse tfResponse = mapper.readValue(new File("/home/india/Desktop/tfresponse.json"), TfResponse.class);
            System.out.println(tfResponse.getHook().getResource().getResource_name());
            System.out.println(tfResponse.getHook().getId_value());

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
