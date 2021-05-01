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
};
