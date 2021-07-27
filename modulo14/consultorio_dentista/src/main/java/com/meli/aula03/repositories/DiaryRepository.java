package com.meli.aula03.repositories;

import com.meli.aula03.entities.Dentist;
import com.meli.aula03.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    public List<Diary> findDiariesByDentist(Dentist d);

}