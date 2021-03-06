package br.com.leandrobove.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobove.cursomc.entities.Categoria;
import br.com.leandrobove.cursomc.exceptions.ObjectNotFoundException;
import br.com.leandrobove.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);

		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada -  id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
