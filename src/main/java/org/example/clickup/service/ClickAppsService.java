package org.example.clickup.service;

import org.example.clickup.dto.ClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Result;
import org.example.clickup.repository.ClickAppsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClickAppsService {
    @Autowired
    private ClickAppsRepository clickAppsRepository;

    public ClickAppsService getallClickApps() {
        return (ClickAppsService) clickAppsRepository;

    }
    //shu joyida xato bor
    public ClickApps getClickAppsBYID(Integer id) {
        Optional<ClickApps> byId = clickAppsRepository.findById(id);
        return byId.get();
    }
    public Result addClickApps(ClickAppsDto clickAppsDto) {
        ClickApps clickApps = new ClickApps();
        clickApps.setName(clickAppsDto.getName());
        clickAppsRepository.save(clickApps);
        return new Result(true,"Successfully added click apps");
    }

    public Result updateClickApps(Integer id,ClickAppsDto clickAppsDto) {
        Optional<ClickApps> byId = clickAppsRepository.findById(id);
        if (byId.isPresent()) {
            ClickApps clickApps = byId.get();
            clickApps.setName(clickAppsDto.getName());
            clickAppsRepository.save(clickApps);
            return new Result(true,"Successfully updated click apps");
        }
        return new Result(false,"Click apps not found");
    }
    public Result deleteClickApps(Integer id) {
        Optional<ClickApps> byId = clickAppsRepository.findById(id);
        if (byId.isPresent()) {
            clickAppsRepository.delete(byId.get());
            return new Result(true,"Successfully deleted click apps");
        }
        return new Result(false,"Click apps not found");
    }
}
