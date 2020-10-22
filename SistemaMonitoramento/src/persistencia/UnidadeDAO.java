package persistencia;

import java.util.List;
import logica.UnidadeMovel;
import logica.dto.UnidadeDTO;


public interface UnidadeDAO {
	
	public void salvar(UnidadeMovel unidadeMovel) throws Exception;
	public List<UnidadeMovel> buscarTodas() throws Exception;
	public UnidadeMovel buscar(String idUnidade) throws Exception;
	public void atualizar(UnidadeMovel unidadeMovel) throws Exception;
	public void salveOuAtualize(UnidadeMovel unidadeMovel) throws Exception;
}
