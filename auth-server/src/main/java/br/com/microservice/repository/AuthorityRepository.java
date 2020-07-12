package br.com.microservice.repository;


import br.com.microservice.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
	
	Authority findByName(String name);
	
}