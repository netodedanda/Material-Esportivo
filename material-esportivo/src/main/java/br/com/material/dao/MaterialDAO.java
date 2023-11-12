package br.com.material.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.material.model.Material;

@Repository
public class MaterialDAO {
	
	private static List<Material> materiais;
	
	public MaterialDAO() {
		materiais = new LinkedList<Material>();
	}
	public void salvar(Material material) {
		materiais.add(material);
		System.out.println(materiais);
	}
	public List<Material> getAll() {  
	return materiais;}

	public Material getId(int id) {
		return materiais.get(id);
	}

public void excluir(int id) {
	materiais.remove(id);
}

public void editar(int id, Material material) {
	materiais.get(id).setNome(material.getNome());
	materiais.get(id).setPreco(material.getPreco());
	materiais.get(id).setQuantidade(material.getQuantidade());
}
}
