package study.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.domain.User;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneInfo, Integer> {
    boolean existsById(Integer id);
    List<PhoneInfo>  findAllByUser(User user);
}
