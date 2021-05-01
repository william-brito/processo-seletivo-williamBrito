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
};