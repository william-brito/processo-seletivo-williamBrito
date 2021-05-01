import axios from 'axios';

export default () => axios.create({
  baseURL: 'http://localhost:3000/funcionarios',
  headers: [{ 'Access-Control-Allow-Origin': '*' }],
  withCredentials: true,
  mode: 'cors',
});
