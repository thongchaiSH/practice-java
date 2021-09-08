package com.th.junit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.junit.domain.FaceRecognitionRequestBo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

@Slf4j
public class JSONToObjectTest {

    @Test
    public void jsonToFile() throws  Exception{
        ClassLoader classLoader=getClass().getClassLoader();
        FileReader file=new FileReader(classLoader.getResource("AML/faceRecognition_valid.json").getFile()) ;
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader( file);
        String json= reader.lines().collect(Collectors.joining(System.lineSeparator()));
        FaceRecognitionRequestBo request=mapper.readValue(json, FaceRecognitionRequestBo.class);
        log.debug("{}",request);
    }
}
