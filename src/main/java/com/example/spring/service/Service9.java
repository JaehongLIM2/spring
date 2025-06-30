package com.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
@Transactional
public class Service9 {
    public void action1(String username, MultipartFile upload) {
        System.out.println("username = " + username);
        System.out.println("upload = " + upload.getOriginalFilename());

        try {
            InputStream is = upload.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            String filePath = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();
            OutputStream os = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            try (is; bis; os; bos) {
                byte[] buffer = new byte[1024];
                int length;

                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
    }

    public void action2(String username, MultipartFile uploadFile) {
        System.out.println("username = " + username);
        System.out.println("uploadFile = " + uploadFile.getOriginalFilename());
        if (uploadFile != null) {


            try {
                InputStream is = uploadFile.getInputStream();
                String filePath = "C:/Temp/uploadFiles/" + uploadFile.getOriginalFilename();
                Path path = Paths.get(filePath);

                Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
                new RuntimeException(e);
            }
        }
    }

    public void action3(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                if (file.getSize() > 0) {
                    try {
                        InputStream is = file.getInputStream();
                        String filePath = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        Path path = Paths.get(filePath);

                        Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    public void action4(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                if (file != null && !file.isEmpty()) {
                    try(InputStream is = file.getInputStream()) {
                        String filePath = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        Path path = Paths.get(filePath);

                        Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }
}
