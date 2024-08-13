package org.example.clickup.service;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {

    @Autowired
    private IconRepository iconRepository;

    public List<Icon> getAllIcons() {
        return iconRepository.findAll();
    }
    public Icon getIconById(Integer id) {
        Optional<Icon> byId = iconRepository.findById(id);
        return byId.get();
    }

    public Result addIcon(IconDto iconDto) {
        Icon icon = new Icon();
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());
        icon.setIcon(iconDto.getIcon());
        iconRepository.save(icon);
        return new Result(true, "Icon added");
    }
    public Result updateIcon(Integer id, IconDto iconDto) {
        Optional<Icon> byId = iconRepository.findById(id);
        if (byId.isPresent()) {
            Icon icon = byId.get();
            icon.setIcon(iconDto.getIcon());
            icon.setColor(iconDto.getColor());
            icon.setInitialLetter(iconDto.getInitialLetter());
            iconRepository.save(icon);
            return new Result(true, "Icon updated");
        }
        return new Result(false, "Icon not found");
    }
    public Result deleteIcon(Integer id) {
        Optional<Icon> byId = iconRepository.findById(id);
        if (byId.isPresent()) {
            iconRepository.delete(byId.get());
            return new Result(true, "Icon deleted");
        }
        return new Result(false, "Icon not found");
    }
}
