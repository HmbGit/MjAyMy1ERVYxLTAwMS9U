package com.demo.game.repository;

import com.demo.game.model.Square;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * the Square Repository
 */
@Repository
public interface SquareRepository extends CrudRepository<Square,Long> {
}
