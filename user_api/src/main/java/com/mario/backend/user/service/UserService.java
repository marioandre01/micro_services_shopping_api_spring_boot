package com.mario.backend.user.service;

import com.mario.backend.user.dto.UserDTO;
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
                .map(UserDTO::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return UserDTO.convertToUserDTO(usuario.get());
        }
        return null;
    }
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convertToUser(userDTO));
        return UserDTO.convertToUserDTO(user);
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
            return UserDTO.convertToUserDTO(user);
        }
        return null;
    }
    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convertToUserDTO)
                .collect(Collectors.toList());
    }
}
