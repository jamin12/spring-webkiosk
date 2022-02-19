package com.example.webkiosk.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.example.webkiosk.entity.FileDto;
import com.example.webkiosk.entity.Product;
import com.example.webkiosk.entity.User;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUpload {
    public String fileUpload(MultipartHttpServletRequest request, User user, String fileName)
            throws IllegalStateException, IOException {
        String path = "C:/Users/jamin/Desktop/jamin/project/spring-webkiosk/spring-webkiosk/src/main/resources/static/image/"
                + user.getUserNum();
        File file = new File(path);
        if (file.exists() == false) {
            file.mkdirs();
        }

        Iterator<String> FileIt = request.getFileNames();
        String name;
        String newFileName = null;
        while (FileIt.hasNext()) {
            name = FileIt.next();
            List<MultipartFile> list = request.getFiles(name);
            for (MultipartFile multipartFile : list) {
                // 파일 dto 생성
                FileDto fileDto = new FileDto();

                newFileName = fileName + ".jpg";

                file = new File(path + "/" + newFileName);
                multipartFile.transferTo(file);
            }

        }
        return newFileName;
    }

}
