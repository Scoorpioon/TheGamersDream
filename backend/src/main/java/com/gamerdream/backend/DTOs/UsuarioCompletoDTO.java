package com.gamerdream.backend.DTOs;

import com.gamerdream.backend.Models.Usuarios.Empresa;
import com.gamerdream.backend.Models.Usuarios.Pessoa;
import com.gamerdream.backend.Models.Usuarios.Usuario;

public record UsuarioCompletoDTO(Usuario usuario, Empresa empresa, Pessoa pessoa) {}