import Api from './Api';

export default {
  async criarNovoFuncionario(novoFuncionario) {
    try {
      const response = await Api().post('/', novoFuncionario);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async getFuncionarios() {
    try {
      const response = await Api().get('/');
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async getFuncionarioId(id) {
    try {
      const response = await Api().get(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async atualizarFuncionarioId(id) {
    try {
      const response = await Api().put(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async deletarFuncionarioId(id) {
    try {
      const response = await Api().delete(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
};
