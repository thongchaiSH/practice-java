package com.tutorial.feign.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.feign.client.UploadClient;
import com.tutorial.feign.models.FaceRecognitionBO;
import com.tutorial.feign.models.FaceRecognitionRequestBo;
import com.tutorial.feign.models.Todo;
import com.tutorial.feign.service.THConnector;
import com.tutorial.feign.service.TodoService;
import com.tutorial.feign.util.JsonUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("todo-list")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private THConnector thConnector;

    @Autowired
    private UploadClient uploadClient;

    @GetMapping("")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("{number}")
    public Todo getSingleTodo(@PathVariable String number){
        return todoService.getSingleTodo(number);
    }

    @PostMapping("")
    public Todo createTodo(@RequestBody Todo item){
        return todoService.createTodo(item);
    }

    @SneakyThrows
    @PostMapping(value = "/faceRecognition", consumes = "multipart/form-data", produces = "application/json")
    public Object faceRecognition(
            @RequestParam("force_face_comparison")Boolean forceFaceComparison,
            @RequestParam(value = "accepted_consents",required = false) String[] acceptedConsents,
            @RequestParam("types") String[] types,
            @RequestParam("customer_data") String customerData,
            @RequestPart("files")List<MultipartFile> files
    ){
        FaceRecognitionRequestBo request=FaceRecognitionRequestBo.builder()
                .files(files)
                .types(Arrays.asList(types))
                .acceptedConsents(Arrays.asList(acceptedConsents))
                .forceFaceComparison(forceFaceComparison)
                .build();

        FaceRecognitionBO bo=new ObjectMapper().readValue(customerData,FaceRecognitionBO.class);
        request.setCustomerData(bo);

        return uploadClient.faceRecognition(
                request.getForceFaceComparison(),
                request.getAcceptedConsents(),
                request.getTypes(),
                JsonUtils.toJson(request.getCustomerData()),
                request.getFiles()
        );
//        return thConnector.faceRecognition(request);
    }


}
