import axios from 'axios';

export default () => axios.create({
	baseURL: 'http://localhost:3306/funcionarios_prova'
});