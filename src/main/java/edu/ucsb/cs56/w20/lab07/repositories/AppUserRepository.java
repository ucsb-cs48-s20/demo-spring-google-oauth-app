package edu.ucsb.cs56.w20.lab07.repositories;

import edu.ucsb.cs56.w20.lab07.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
  public List<AppUser> findByEmail(String email);
}
