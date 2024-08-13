package org.example.clickup.service;

import org.example.clickup.dto.AttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<Attachment> getAttachments() {
        return attachmentRepository.findAll();
    }
    public Attachment getAttachmentBYID(Integer id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        return byId.get();
    }
    public Result addAttachment(AttachmentDto attachmentDto) {
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setOriginalName(attachmentDto.getOriginalName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContent_type(attachmentDto.getContentType());
        attachmentRepository.save(attachment);
        return new Result(true, "Successfully added attachment");
    }

    public Result updateAttachment(Integer id,AttachmentDto attachmentDto) {
        Attachment attachment = attachmentRepository.findById(id).get();
        attachment.setName(attachmentDto.getName());
        attachment.setOriginalName(attachmentDto.getOriginalName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContent_type(attachmentDto.getContentType());
        attachmentRepository.save(attachment);
        return new Result(true, "Successfully updated attachment");

    }
    public Result deleteAttachment(Integer id) {
        attachmentRepository.deleteById(id);
        return new Result(true, "Successfully deleted attachment");
    }
}
