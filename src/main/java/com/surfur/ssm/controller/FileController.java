package com.surfur.ssm.controller;

import com.alibaba.druid.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    public static final String filePath = "D:\\work\\test\\";

    @PostMapping("/upload-file")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new RuntimeException("文件不能为空");
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        long size = file.getSize();
        System.out.println("size = " + size);
        String contentType = file.getContentType();
        System.out.println("contentType = " + contentType);

        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = originalFilename.replace(fileType, "");
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        String dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        fileName = uuid + dateFormat + fileName + fileType;
        file.transferTo(new File(filePath + fileName));
    }

    /**
     * 下载文件
     *
     * @param response HttpServletResponse 响应对象
     * @param fileName 文件名称
     * @throws IOException 异常
     */
    @GetMapping("/download-file")
    public void downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws Exception {
        File file = new File(filePath + fileName);
        setResponseHeaders(response, file, fileName);
        /*
         优化后
            使用缓冲区 (byte[] buffer) 读取文件，避免一次性将大文件全部读入内存，提升性能并降低内存占用。
         */

        // 输出文件内容
        try (FileInputStream fis = new FileInputStream(file);
             ServletOutputStream os = response.getOutputStream()) {
            byte[] bytes = new byte[1024];
            int byteRead;
            while ((byteRead = fis.read(bytes)) != -1) {
                os.write(bytes, 0, byteRead);
            }
        }
    }

    /*
    存在缺点，如果一次性将大文件全部读入内存，非常占用内存
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        int read = fis.read(bytes);

        setResponseHeaders(response, file, fileName);

        // 输出文件内容
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(bytes);
            outputStream.flush();
        }
     */

    /**
     * 设置下载响应头
     *
     * @param response HttpServletResponse 响应对象
     * @param file     文件对象
     * @param fileName 文件名称
     * @throws UnsupportedEncodingException 异常
     */
    private static void setResponseHeaders(HttpServletResponse response, File file, String fileName) throws UnsupportedEncodingException {
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        // 设置请求头
        response.setContentType("application/octet-stream");
        // 方式一： 可以
        // response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
        // 方式二： 如果 fileName 包含特殊字符（如空格、中文等），它必须经过 URL 编码。未编码的特殊字符可能导致浏览器使用默认文件名。
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);
        response.setContentLengthLong(file.length());
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
