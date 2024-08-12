package org.example.clickup.service;

import org.example.clickup.dto.UserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }
    public Result addUser(UserDto userDto) {
        User user = new User();
        user.setFullname(userDto.getFullname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setColor(userDto.getColor());
        userRepository.save(user);
        return new Result(true,"Created");
    }
    public Result updateUser(Integer id,UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFullname(userDto.getFullname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setColor(userDto.getColor());
            userRepository.save(user);
            return new Result(true, "saved");
        }
        return new Result(false, "user not found");
    }
    public Result deleteUser(Integer id) {
        Optional<User> userList = userRepository.findById(id);
        if (userList.isEmpty()) {
            return new Result(false, "user not found");
        }
        userRepository.deleteById(id);
        return new Result(true, "deleted");
    }

}
