package cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
