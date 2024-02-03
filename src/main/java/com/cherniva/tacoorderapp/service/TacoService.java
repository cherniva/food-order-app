package com.cherniva.tacoorderapp.service;

import com.cherniva.tacoorderapp.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TacoService {

    private final TacoRepository tacoRepository;



}
