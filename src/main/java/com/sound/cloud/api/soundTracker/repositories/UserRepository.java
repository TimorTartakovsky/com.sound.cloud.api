package com.sound.cloud.api.soundTracker.repositories;
import com.sound.cloud.api.soundTracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Long> {
}
