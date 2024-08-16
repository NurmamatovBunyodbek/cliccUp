package org.example.clickup.service;

import org.example.clickup.dto.SpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceUser;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.SpaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceUserService {
    @Autowired
    SpaceUserRepository spaceUserRepository;
    @Autowired
    SpaceRepository spaceRepository;

    public List<SpaceUser> getallSpaceUsers() {
        return spaceUserRepository.findAll();
    }

    public SpaceUser getSpaceUserById(Integer id) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(id);
        return byId.get();
    }

    public Result createSpaceUser(SpaceUserDto spaceUserDto) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(spaceUserDto.getSpaceid());
        if (byId.isPresent()) {
            SpaceUser spaceUser = new SpaceUser();
            spaceUser.setSpaceid(byId.get().getSpaceid());
            spaceUser.setMemberid(spaceUserDto.getMemberid());
            spaceUserRepository.save(spaceUser);
            return new Result(true, "Space user created");
        }

        return new Result(false, "Space not found");
    }

    public Result updateSpaceUser(Integer id, SpaceUserDto spaceUserDto) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(id);
        if (byId.isPresent()) {
            SpaceUser spaceUser = byId.get();
            Optional<SpaceUser> byId1 = spaceUserRepository.findById(spaceUser.getId());
            if (byId1.isPresent()) {
                spaceUserDto.setSpaceid(spaceUserDto.getSpaceid());
                spaceUser.setMemberid(spaceUserDto.getMemberid());
                spaceUserRepository.save(spaceUser);
                return new Result(true, "Space user updated successfully");
            }
            return new Result(false, "Space not found");

        }
        return new Result(false, "SpaceUser not found");

    }

    public Result deleteSpaceUser(Integer id) {
        spaceUserRepository.deleteById(id);
        return new Result(true, "Space user deleted successfully");
    }

}
