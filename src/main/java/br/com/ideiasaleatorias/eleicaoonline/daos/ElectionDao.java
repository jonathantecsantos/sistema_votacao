package br.com.ideiasaleatorias.eleicaoonline.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ideiasaleatorias.eleicaoonline.models.Election;

@Repository
public interface ElectionDao extends CrudRepository<Election, Integer>{

	List<Election> findByOwnerId(Integer ownerId);

}
