package org.example.clickup.service;

import org.example.clickup.dto.SpaceViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.SpaceView;
import org.example.clickup.model.View;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.SpaceViewRepository;
import org.example.clickup.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceViewService {
    @Autowired
    private SpaceViewRepository spaceViewRepository;

    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private ViewRepository viewRepository;

    public List<SpaceView> getAllSpaceViews() {
        return spaceViewRepository.findAll();
    }
    public SpaceView getSpaceViewById(Integer id) {
        Optional<SpaceView> byId = spaceViewRepository.findById(id);
        return byId.orElse(null);
    }
    public Result createSpaceView(SpaceViewDto spaceViewDto) {
        Optional<Space> space = spaceRepository.findById(spaceViewDto.getSpaceId());
        Optional<View> view = viewRepository.findById(spaceViewDto.getViewId());
        SpaceView spaceView = new SpaceView();
        spaceView.setSpaceId(space.get());
        spaceView.setViewId(view.get());
        spaceViewRepository.save(spaceView);
        return new Result(true, "SpaceView created successfully");

    }
    public Result updateSpaceView(Integer id, SpaceViewDto spaceViewDto) {
        Optional<SpaceView> existingSpaceView = spaceViewRepository.findById(id);
        if (existingSpaceView.isPresent()) {
            SpaceView spaceView = existingSpaceView.get();
            Optional<Space> space = spaceRepository.findById(spaceViewDto.getSpaceId());
            Optional<View> view = viewRepository.findById(spaceViewDto.getViewId());
            spaceView.setSpaceId(space.get());
            spaceView.setViewId(view.get());
            spaceViewRepository.save(spaceView);
            return new Result(true, "SpaceView updated successfully");
            }

        return new Result(false, "SpaceView not found");
    }
    public Result deleteSpaceView(Integer id) {
        spaceViewRepository.deleteById(id);
        return new Result(true, "SpaceView deleted successfully");
    }

}
