package com.wellsfargo.dto;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {

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
