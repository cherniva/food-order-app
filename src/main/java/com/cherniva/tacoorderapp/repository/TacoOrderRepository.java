package com.cherniva.tacoorderapp.repository;

import com.cherniva.tacoorderapp.model.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoOrderRepository extends JpaRepository<TacoOrder, Long> {
}
