package com.project.schedule.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.schedule.entidades.Local;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{

}

