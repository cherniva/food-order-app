package com.cherniva.tacoorderapp.repository;

import com.cherniva.tacoorderapp.model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
