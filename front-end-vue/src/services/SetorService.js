import Api from './Api';

export default {
  async criarNovoSetor(novoSetor) {
    try {
      const response = await Api().post('/', novoSetor);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async getSetores() {
    try {
      const response = await Api().get('/');
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async getSetorId(id) {
    try {
      const response = await Api().get(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async atualizarSetorId(id) {
    try {
      const response = await Api().put(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
  async deletarSetorId(id) {
    try {
      const response = await Api().delete(`/${id}`);
      return response.data;
    } catch (error) {
      return console.log(error);
    }
  },
};
