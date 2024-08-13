package org.example.clickup.controller;

import jakarta.annotation.Resource;
import org.example.clickup.dto.AttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    //CRUD
    @Autowired
    private AttachmentService attachmentService;

    @GetMapping
    public List<Attachment> getAll() {
        return attachmentService.getAttachments();
    }
    @GetMapping
    public Attachment attachmentbyId(@PathVariable Integer id) {
        return attachmentService.getAttachmentBYID(id);
    }
    @PostMapping
    public Result add(@RequestBody AttachmentDto attachmentDto) {
        return attachmentService.addAttachment(attachmentDto);
    }
    @PutMapping
    public Result update(@PathVariable Integer id, @RequestBody AttachmentDto attachmentDto) {
        return attachmentService.updateAttachment(id, attachmentDto);
    }
    @DeleteMapping
    public Result delete(@PathVariable Integer id) {
        return attachmentService.deleteAttachment(id);
    }
}
