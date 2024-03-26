package ru.mts.Homework_MTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.Homework_MTS.Entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {}