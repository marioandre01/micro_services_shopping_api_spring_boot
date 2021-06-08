package com.mario.backend.user.model;

import com.mario.backend.user.dto.UserDTO;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data // gera os gets e sets
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;

    @CreationTimestamp //gerar timestamp automaticamente ao criar um user
    private Date dataCadastro;

    // gets e sets omitidos

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setNome(userDTO.getNome());
        user.setEndereco(userDTO.getEndereco());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());

        return user;
    }

}
