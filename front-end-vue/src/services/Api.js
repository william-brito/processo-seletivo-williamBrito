import axios from 'axios';

export const conect = axios.create({
  baseURL: 'http://localhost:3306/funcionarios/',
});
