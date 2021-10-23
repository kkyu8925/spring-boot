package com.sparta.memo.domain;

import com.sparta.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc(); // modifiedAt 기준으로 최신순 정렬(내림차순)
}
