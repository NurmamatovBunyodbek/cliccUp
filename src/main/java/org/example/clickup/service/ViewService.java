package org.example.clickup.service;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    ViewRepository viewRepository;

    public List<View> getallViews() {
        return viewRepository.findAll();
    }
    public View getViewById(Integer id) {
        return viewRepository.getById(id);
    }
    public Result addView(ViewDto viewDto) {
        View view = new View();
        view.setName(viewDto.getName());
        Optional<View> byId = viewRepository.findById(viewDto.getIconid());
        if (byId.isPresent()) {
            view.setIconid(byId.get().getIconid());
        }
        viewRepository.save(view);
        return new Result(true, "Successfully added view");
    }
    public Result updateView(Integer id,ViewDto viewDto) {
        Optional<View> byId = viewRepository.findById(id);
        if (byId.isPresent()) {
            View view = byId.get();
            view.setName(viewDto.getName());
            view.setIconid(view.getIconid());
            viewRepository.save(view);
            return new Result(true, "Successfully updated view");
        }
        return new Result(false, "View not found");
    }
    public Result deleteView(Integer id) {
        Optional<View> byId = viewRepository.findById(id);
        if (byId.isPresent()) {
            viewRepository.delete(byId.get());
            return new Result(true, "Successfully deleted view");
        }
        return new Result(false, "View not found");
    }
}