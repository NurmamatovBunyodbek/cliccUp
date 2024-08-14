package org.example.clickup.service;

import org.example.clickup.dto.SpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceUser;
import org.example.clickup.repository.SpaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class SpaceUserService {
    @Autowired
    SpaceUserRepository spaceUserRepository;
    public SpaceUser getallSpaceUsers(SpaceUser spaceUser) {
       return (SpaceUser) spaceUserRepository.findAll();
    }
    public SpaceUser getSpaceUserById(Integer id) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(id);
        return byId.get();
    }
    public Result addSpaceUser(SpaceUserDto spaceUserDto) {
        SpaceUser spaceUser = new SpaceUser();
        Optional<SpaceUser> byId = spaceUserRepository.findById(spaceUser.getId());
        if (byId.isPresent()) {
          //  spaceUser.setSpaceid(spaceUserDto.getSpaceid());
        }
        spaceUserDto.setMemberid(spaceUserDto.getMemberid());
        spaceUserRepository.save(spaceUser);
        return new Result(true, "Space user added successfully");
    }
    public Result updateSpaceUser(Integer id,SpaceUserDto spaceUserDto) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(id);
        if (byId.isPresent()) {
            SpaceUser spaceUser = byId.get();
            Optional<SpaceUser> byId1 = spaceUserRepository.findById(spaceUser.getId());
            if (byId1.isPresent()) {
                spaceUserDto.setSpaceid(spaceUserDto.getSpaceid());
            }
            spaceUser.setMemberid(spaceUserDto.getMemberid());
            spaceUserRepository.save(spaceUser);
            return new Result(true, "Space user updated successfully");
        }
        return new Result(false, "Space user not found");

    }
    public Result deleteSpaceUser(Integer id) {
        Optional<SpaceUser> byId = spaceUserRepository.findById(id);
        if (byId.isPresent()) {
            spaceUserRepository.delete(byId.get());
            return new Result(true, "Space user deleted successfully");
        }

    return new Result(false, "Space user not found");
    }

}
