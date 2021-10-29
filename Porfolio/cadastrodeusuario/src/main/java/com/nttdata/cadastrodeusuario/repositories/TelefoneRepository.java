package com.nttdata.cadastrodeusuario.repositories;

import com.nttdata.cadastrodeusuario.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
