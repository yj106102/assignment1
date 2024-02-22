package study.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.assignment1.domain.PhoneInfo;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneInfo, Integer> {
}
