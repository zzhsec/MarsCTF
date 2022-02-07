package com.b1ackc4t.marsctfserver.controller;

import com.b1ackc4t.marsctfserver.pojo.ReturnRes;
import com.b1ackc4t.marsctfserver.service.CTFFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
public class CTFFileController {

    final CTFFileService ctfFileService;

    @Autowired
    public CTFFileController(CTFFileService ctfFileService) {
        this.ctfFileService = ctfFileService;
    }

    /**
     * 上传附件
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    @PostMapping("/admin/uploadCTFFile")
    public ReturnRes upload(@RequestParam(name = "file") MultipartFile file) throws FileNotFoundException {

        return ctfFileService.upload(file);
    }

    /**
     * 删除附件
     * @param fid
     * @return
     */
    @PostMapping("/admin/removeCTFFile")
    public ReturnRes remove(@RequestParam(name = "id") Integer fid) {
        return ctfFileService.removeCTFFile(fid);
    }

    @GetMapping("/user/downloadCTFFile/{id:\\d+}")
    public ReturnRes download(@PathVariable Integer id, HttpServletResponse response) {return ctfFileService.download(id, response);}

}