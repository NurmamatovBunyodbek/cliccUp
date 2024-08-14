package org.example.clickup.service;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.IconRepository;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.UserRepository;
import org.example.clickup.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
     SpaceRepository spaceRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    IconRepository iconRepository;

    @Autowired
    UserRepository userRepository;


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

        Optional<Workspace> workspaceOptional = workspaceRepository.findById(spaceDto.getWorkspaceid());
        Workspace workspace = workspaceOptional.get();

        space.setWorkspaceid((List<Workspace>) workspace);


        space.setInitial_letter(spaceDto.getInitial_letter());

        Optional<Icon> optionalIcon = iconRepository.findById(spaceDto.getIconId());
        Icon icon = optionalIcon.get();
        space.setIconId((List<Icon>) icon);

        space.setAvatar_id(spaceDto.getAvatar_id());

        Optional<User> optionalUser = userRepository.findById(spaceDto.getUserid());
        User user = optionalUser.get();
        space.setUserid(user);

        space.setAcces_type(spaceDto.getAcces_type());
        spaceRepository.save(space);
        return new Result(true, "Space added successfully");
    }

    public Result updateSpace(Integer id, SpaceDto spaceDto) {
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
