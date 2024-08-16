package org.example.clickup.service;

import org.example.clickup.dto.SpaceClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.SpaceClickApps;
import org.example.clickup.repository.ClickAppsRepository;
import org.example.clickup.repository.SpaceClickAppsRepository;
import org.example.clickup.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceClickAppsService {
    @Autowired
    private SpaceClickAppsRepository spaceClickAppsRepository;

    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private ClickAppsRepository clickAppsRepository;

    public List<SpaceClickApps> getSpaceClickApps() {
        return spaceClickAppsRepository.findAll();
    }

    public SpaceClickApps getAllClickAppsBySpaceId(Integer id) {
        Optional<SpaceClickApps> appsOptional = spaceClickAppsRepository.findById(id);
        return appsOptional.get();
    }

    public SpaceClickApps createSpaceClickApps(SpaceClickAppsDto spaceClickAppsDto) {
        Optional<Space> space = spaceRepository.findById(spaceClickAppsDto.getSpaceid());
        Optional<ClickApps> clickApps = clickAppsRepository.findById(spaceClickAppsDto.getClickAppsid());

        if (space.isPresent() && clickApps.isPresent()) {
            SpaceClickApps spaceClickApps = new SpaceClickApps();
            spaceClickApps.setSpaceid(space.get());
            spaceClickApps.setClickAppsid(clickApps.get());
            return spaceClickAppsRepository.save(spaceClickApps);
        }
        return null;
    }

    public Result updateSpaceClickApps(Integer id, SpaceClickAppsDto spaceClickAppsDto) {
        Optional<SpaceClickApps> existingSpaceClickApps = spaceClickAppsRepository.findById(id);
        if (existingSpaceClickApps.isPresent()) {
            SpaceClickApps spaceClickApps = existingSpaceClickApps.get();
            Optional<Space> space = spaceRepository.findById(spaceClickAppsDto.getSpaceid());
            Optional<ClickApps> clickApps = clickAppsRepository.findById(spaceClickAppsDto.getClickAppsid());

            spaceClickApps.setSpaceid(space.get());
            spaceClickApps.setClickAppsid(clickApps.get());
            spaceClickAppsRepository.save(spaceClickApps);
            return new Result(true, "Successfully updated spaceclickapps");
        }
        return new Result(false, "Space not found");
    }

    public Result deleteSpaceClickApps(Integer id) {
        spaceClickAppsRepository.deleteById(id);
        return new Result(true, "deleted");
    }
}
