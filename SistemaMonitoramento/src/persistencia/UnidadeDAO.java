package persistencia;

import java.util.List;
import logica.UnidadeMovel;


public interface UnidadeDAO {
	
	public void salvar(UnidadeMovel unidadeMovel) throws Exception;
	//public List<UnidadeMovel> buscarQtdeMinima(double qtde) throws Exception;
	public UnidadeMovel buscar(String idUnidade) throws Exception;
	public void atualizar(UnidadeMovel unidadeMovel) throws Exception;
	public void salveOuAtualize(UnidadeMovel unidadeMovel) throws Exception;
}
