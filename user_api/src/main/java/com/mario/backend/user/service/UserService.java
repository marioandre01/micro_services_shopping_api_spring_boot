package com.mario.backend.user.service;

import com.mario.backend.dto.UserDTO;
import com.mario.backend.exception.UserNotFoundException;
import com.mario.backend.user.convert.DTOConvert;
import com.mario.backend.user.model.User;
import com.mario.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(DTOConvert::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return DTOConvert.convertToUserDTO(usuario.get());
        }
        return null;
    }
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convertToUser(userDTO));
        return DTOConvert.convertToUserDTO(user);
    }
    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }
    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return DTOConvert.convertToUserDTO(user);
        }
//      exceção para usuário que não existe  
        throw new UserNotFoundException();
    }
    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(DTOConvert::convertToUserDTO)
                .collect(Collectors.toList());
    }
}
