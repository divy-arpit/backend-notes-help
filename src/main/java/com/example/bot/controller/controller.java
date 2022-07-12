package com.example.bot.controller;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bot.model.DataInput;

@RestController
public class  controller {

    @GetMapping("/checkIfFileExists/{mail}")
    public String checkFile(@PathVariable String mail) throws IOException{
        FileManager manager=new FileManager();
        return manager.ReadFile(mail);
        
    }
    @GetMapping("/writeData/")
    public String writeData(@RequestBody Map<String, String> payload) throws IOException{
        DataInput dataInput=new DataInput();
        dataInput.mail=payload.get("mail");
        dataInput.data=payload.get("data");
        FileManager manager=new FileManager();
        manager.SaveData(dataInput.mail, dataInput.data);
        return "200";
        

    }

}