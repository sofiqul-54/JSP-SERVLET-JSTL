package com.coderbd.repo;

import com.coderbd.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {
}
