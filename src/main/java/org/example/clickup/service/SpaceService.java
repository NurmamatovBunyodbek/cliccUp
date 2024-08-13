package org.example.clickup.service;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    private SpaceRepository spaceRepository;
    public List<Space> getAllSpaces() {
        return spaceRepository.findAll();
    }
    public Space getSpaceById(Integer id) {
        Optional<Space> byId = spaceRepository.findById(id);
        return byId.get();
    }
    public Result addSpace(SpaceDto spaceDto) {
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setColor(spaceDto.getColor());
        space.setInitial_letter(spaceDto.getInitial_letter());
        space.setAvatar_id(spaceDto.getAvatar_id());
        space.setAcces_type(spaceDto.getAcces_type());
        spaceRepository.save(space);
        return new Result(true, "Space added successfully");
    }
    public Result updateSpace(Integer id,SpaceDto spaceDto) {
        Optional<Space> spaceOptional = spaceRepository.findById(id);
        if (spaceOptional.isPresent()) {
            Space space = spaceOptional.get();
            space.setName(spaceDto.getName());
            space.setColor(spaceDto.getColor());
            space.setInitial_letter(spaceDto.getInitial_letter());
            space.setAvatar_id(spaceDto.getAvatar_id());
            space.setAcces_type(spaceDto.getAcces_type());
            spaceRepository.save(space);
            return new Result(true, "Space updated successfully");
        }
        return new Result(false, "Space not found");
    }
    public Result deleteSpace(Integer id) {
        Optional<Space> spaceOptional = spaceRepository.findById(id);
        if (spaceOptional.isPresent()) {
            spaceRepository.delete(spaceOptional.get());
            return new Result(true, "Space deleted successfully");
        }
        return new Result(false, "Space not found");
    }

}
