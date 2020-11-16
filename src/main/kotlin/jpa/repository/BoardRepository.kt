package jpa.repository

import jpa.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BoardRepository : JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}