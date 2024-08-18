package org.example.clickup.service;

import org.example.clickup.dto.TagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.Workspace;
import org.example.clickup.repository.TagRepository;
import org.example.clickup.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag findById(Integer id) {
        Optional<Tag> byId = tagRepository.findById(id);
        return byId.get();
    }
    public Result createTag(TagDto tagDto) {
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(tagDto.getWorkspaceid());
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        tag.setWorkspaceid(workspaceOptional.get());
        tagRepository.save(tag);
        return new Result(true, "Tag created successfully");

    }


    public Result updateTag(Integer id, TagDto tagDto) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (tagOptional.isPresent()) {
            Optional<Workspace> workspaceOptional = workspaceRepository.findById(tagDto.getWorkspaceid());
            Tag tag = tagOptional.get();
            tag.setName(tagDto.getName());
            tag.setColor(tagDto.getColor());
            tag.setWorkspaceid(workspaceOptional.get());
            tagRepository.save(tag);
            return new Result(true, "Tag updated successfully");
            }
        return new Result(false, "Tag not found");
    }

    public Result deleteTag(Integer id) {
        if (tagRepository.existsById(id)) {
            tagRepository.deleteById(id);
            return new Result(true, "Tag deleted successfully");
        }
        return new Result(false, "Tag not found");
    }

}
