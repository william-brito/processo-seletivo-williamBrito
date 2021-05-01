import { conect } from './Api';

export default {

  
  criarNovoFuncionario: (funcionario) => (
    conect.post('funcionarios', funcionario)
  ),

  getFuncionarios: () => (
    conect.get('funcionarios')
  ),

  getFuncionarioId: (id) => (
    conect.get(`funcionarios/${id}`)
  ),

  atualizarFuncionarioId: (id, funcionario) => (
    conect.put(`funcionarios/${id}`, funcionario)
  ),

  deletarFuncionarioId: (id) => (
    conect.delete(`funcionarios/${id}`)
  ),
};
