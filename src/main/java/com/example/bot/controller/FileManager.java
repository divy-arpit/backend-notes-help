package com.example.bot.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.example.bot.model.Constants;


public class FileManager {
    // call when save button is called
    public String SaveData(String mailId,String data) throws IOException{
        String fileLocarionString=Constants.fileLoc+mailId+".txt";
        File file=new File(fileLocarionString);
        FileWriter writer=new FileWriter(file);
        writer.write(data);
        writer.close();
        
        return "200";
    }
    // if file exists, return its data else return code 404;
    public String ReadFile(String mailId) throws IOException{
        String fileLocarionString=Constants.fileLoc+mailId+".txt";
        File file=new File(fileLocarionString);
        if(file.exists()){
            BufferedReader reader=new BufferedReader(new FileReader(fileLocarionString));
            StringBuilder builder=new StringBuilder("");
            String st;
            while ((st = reader.readLine()) != null)
                builder.append(st);
            reader.close();
            return builder.toString();
        }
        else{
            return "404";
        }
        
    }
}
