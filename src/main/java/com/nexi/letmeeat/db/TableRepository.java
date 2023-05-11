package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables, Long> {
}
