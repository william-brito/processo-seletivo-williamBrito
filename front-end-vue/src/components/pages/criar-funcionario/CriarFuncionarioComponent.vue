<template>
<div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Criar novo funcionario</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="handleSubmitForm">
          <!---- INÍCIO DO BLOCO: Nome do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome</label>
            <input
              type="text"
              placeholder="Digite o Nome do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_FUNCIONARIO"
            />
          </div>
          <!---- FIM DO BLOCO: Nome do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Setor do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Setor</label>
            <input
              type="text"
              placeholder="Digite o Setor do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_SETOR"
            />
          </div>
          <!---- FIM DO BLOCO: Setor do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Salário do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Salario</label>
            <input
              type="number"
              placeholder="Digite o Salario do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_SALARIO"
            />
          </div>
          <!---- FIM DO BLOCO: Salário do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Email do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Email</label>
            <input
              type="text"
              placeholder="Digite o Email do Funcionario"
              class="form-control"
              v-model="funcionarioForm.DS_EMAIL"
            />
          </div>
          <!---- FIM DO BLOCO: Email do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Idade</label>
            <input
              type="number"
              placeholder="Digite a Idade do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_IDADE"
            />
          </div>
          <!---- FIM DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <button class="btn btn-primary" type="submit">+ Adicionar Funcionario</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  </template>
 <script>
export default {
  data() {
    return {
      funcionarioForm: {
        NOME_FUNCIONARIO: '',
        NOME_SETOR: '',
        NU_SALARIO: '',
        DS_EMAIL: '',
        NU_IDADE: '',
      },
    };
  },
  methods: {
    handleSubmitForm() {
    },
  },
};
</script>