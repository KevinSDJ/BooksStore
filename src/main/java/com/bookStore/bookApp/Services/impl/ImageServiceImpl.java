package com.bookStore.bookApp.Services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.bookStore.bookApp.DTO.BookImageDTO;
import com.bookStore.bookApp.Services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);
    private static final String uploadFiles= System.getProperty("user.dir")+"/src/main/resources/static/images/";

    @Override
    public String saveImage(BookImageDTO image) {
        BufferedOutputStream outFile=null;
        FileOutputStream outWriteFile=null;
        File file=null;

        // como puedo guardar la imagen?
        // pueder ser en el mismo formato base64?
        // seria tipo de archivo + tipo de codificacion+ nombre de archivo? sera la mejor manera?
        // o puedo guardar solo en nombre y servirlo como mvc

        try{
            byte[] data= Base64.getDecoder().decode(image.getData());
            
            file= new File(uploadFiles,image.getNameFile());
            if(!file.exists()){
                outWriteFile= new FileOutputStream(file);
                outFile= new BufferedOutputStream(outWriteFile);
                outFile.write(data);
            }else{
                log.warn("File already exist, skip save");
            }
            
        }catch(Exception e){
            log.error(e.getMessage());
        }finally{
            if(outFile!=null){
                try{
                    outFile.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(outWriteFile!=null){
                try{
                    outWriteFile.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        

        return image.getNameFile();
    }
    
}
