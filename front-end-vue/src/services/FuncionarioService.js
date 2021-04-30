import Api from './Api';

export default {
	async criarNovoFuncionario(novoFuncionario){
		try{
			const response = await Api().post('/funcionarios', novoFuncionario);
			return response.data;
		}catch(error) {
			console.log(error);
		}
	},		
	async getFuncionarios(){
		try{
			const response = await Api().get('/funcionarios');
			return response.data;
		}catch(error) {
			console.log(error);
		}
	},
	async getFuncionarioId(id){
		try{
			const response = await Api().get('/funcionarios/${id}');
			return response.data;
		}catch(error) {
			console.log(error);
		}	
	},
	async atualizarFuncionarioId(id){
		try{
			const response = await Api().put('/funcionarios/${id}');
			return response.data;
		}catch(error) {
			console.log(error);
		}	
	},
	async deletarFuncionarioId(id){
		try{
			const response = await Api().delete('/funcionarios/${id}');
			return response.data;
		}catch(error) {
			console.log(error);
		}	
	},
	
};


