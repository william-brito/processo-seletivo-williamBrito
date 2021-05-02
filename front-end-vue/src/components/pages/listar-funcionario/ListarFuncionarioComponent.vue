<template>
  <div class="row justify-content-center">
    <h3 class="text-center">Listagem de Funcionarios</h3>
    <table class="table tavle-striped">
      <thead>
        <tr>
          <th class="text-center">Nome do Funcionario</th>
          <th class="text-center">Nome do Setor</th>
          <th class="text-center">Salario</th>
          <th class="text-center">Email</th>
          <th class="text-center">idade</th>
          <th class="text-center">Acoes</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="funcionario in funcionarios" :key="funcionario._id">
          <td>{{funcionario.NOME_FUNCIONARIO}}</td>
          <td>{{funcionario.NOME_SETOR}}</td>
          <td>{{funcionario.NU_SALARIO}}</td>
          <td>{{funcionario.DS_EMAIL}}</td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
};
</script>
