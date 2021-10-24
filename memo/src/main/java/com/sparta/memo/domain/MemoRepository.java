package com.sparta.memo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // modifiedAt 기준으로 최신순 정렬(내림차순)
    // List<Memo> findAllByOrderByModifiedAtDesc();

    // 조회 시간으로부터 24시간 이내
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
