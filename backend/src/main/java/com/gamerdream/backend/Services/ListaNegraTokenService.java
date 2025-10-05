package com.gamerdream.backend.Services;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ListaNegraTokenService {
    private final Set<String> listanegra = ConcurrentHashMap.newKeySet();

    public void adicionarPraListaNegra(String token) {
        listanegra.add(token);
    }

    public boolean taNaListaNegra(String token) {
        return listanegra.contains(token);
    }
}