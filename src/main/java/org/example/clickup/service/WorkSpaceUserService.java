package org.example.clickup.service;

import org.example.clickup.dto.WorkSpaceUserDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.UserRepository;
import org.example.clickup.repository.WorkSpaceUserRepository;
import org.example.clickup.repository.WorkspaceRepository;
import org.example.clickup.repository.WorkspaceRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkSpaceUserService {

    @Autowired
    WorkSpaceUserRepository workSpaceUserRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkspaceRoleRepository workspaceRoleRepository;


    public List<WorkSpaceUser> getALl() {
        return workSpaceUserRepository.findAll();
    }

    // create

    public Result create(WorkSpaceUserDto workSpaceUserDto) {

        WorkSpaceUser workSpaceUser = new WorkSpaceUser();

        Optional<Workspace> optionalWorkspace =
                workspaceRepository.findById(workSpaceUserDto.getWorkspaceid());

        Workspace workspace = optionalWorkspace.get();
        workSpaceUser.setWorkspaceid(workspace);

        Optional<User> optionalUser = userRepository.findById(workSpaceUserDto.getUserid());
        User user = optionalUser.get();

        workSpaceUser.setUserid(user);

        Optional<WorkSpaceRole> optional = workspaceRoleRepository.findById(workSpaceUserDto.getWorkspaceroleId());
        WorkSpaceRole workSpaceRole = optional.get();

        workSpaceUser.setWorkspaceroleId(workSpaceRole);
        workSpaceUserRepository.save(workSpaceUser);

        return new Result(true, "Saqlandi");
    }


}