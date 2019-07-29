package repository;

import controller.SmsMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsMessageRepository extends JpaRepository<SmsMessage, Long> {
}
