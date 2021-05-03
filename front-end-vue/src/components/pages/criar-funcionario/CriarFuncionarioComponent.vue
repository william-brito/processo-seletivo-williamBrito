<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Criar novo funcionario</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="handleSubmitForm()">
          <!---- INÍCIO DO BLOCO: Nome do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome</label>
            <input
              type="text"
              id="NOME_FUNCIONARIO"
              name="NOME_FUNCIONARIO"
              placeholder="Digite o Nome do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_FUNCIONARIO"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.NOME_FUNCIONARIO.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NOME_FUNCIONARIO.required" class="invalid
              -feedback"
            >O Campo "Nome do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Nome do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Setor do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Setor</label>
            <input
              type="text"
              id="NOME_SETOR"
              name="NOME_SETOR"
              placeholder="Digite o Setor do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_SETOR"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.NOME_SETOR.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NOME_SETOR.required" class="invalid
              -feedback"
            >O Campo "Setor do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Setor do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Salário do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Salario</label>
            <input
              type="number"
              id="NU_SALARIO"
              name="NU_SALARIO"
              placeholder="Digite o Salario do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_SALARIO"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.NU_SALARIO.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NU_SALARIO.required" class="invalid
              -feedback"
            >O Campo "Salario do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Salário do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Email do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Email</label>
            <input
              type="text"
              id="DS_EMAIL"
              name="DS_EMAIL"
              placeholder="Digite o Email do Funcionario"
              class="form-control"
              v-model="funcionarioForm.DS_EMAIL"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.DS_EMAIL.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.DS_EMAIL.required " class="invalid
              -feedback"
            >O Campo "Email do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Email do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Idade</label>
            <input
              type="number"
              id="NU_IDADE"
              name="NU_IDADE"
              placeholder="Digite a Idade do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_IDADE"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.NU_IDADE.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NU_IDADE.required" class="invalid
              -feedback"
            >O Campo "Idade do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <button @click="enviarNovoFuncionario" class="btn btn-primary">
              <font-awesome-icon :icon="['fas', 'user-plus']" /> Funcionario
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import { required } from 'vuelidate/lib/validators';
import FuncionarioService from '../../../services/FuncionarioService';

export default {
  name: 'CriarFuncionarioComponent',
  data() {
    return {
      funcionarioForm: {
        NOME_FUNCIONARIO: null,
        NOME_SETOR: null,
        NU_SALARIO: null,
        DS_EMAIL: null,
        NU_IDADE: null,
      },
      isSubmitted: false,
    };
  },
  validations: {
    funcionarioForm: {
      NOME_FUNCIONARIO: {
        required,
      },
      NOME_SETOR: {
        required,
      },
      NU_SALARIO: {
        required,
      },
      DS_EMAIL: {
        required,
      },
      NU_IDADE: {
        required,
      },
    },
  },
  methods: {
    handleSubmitForm() {},
    async enviarNovoFuncionario() {
      try {
        this.isSubmitted = true;
        this.$v.$touch();
        if (this.$v.$invalid) {
          this.$swal('Atencao!', 'Voce precisa incluir todos os campos obrigatorios!', 'error');
          return;
        }
        await FuncionarioService.criarNovoFuncionario(this.funcionarioForm);
        this.$swal({
          title: 'Funcionario adicionado com sucesso!',
          icon: 'success',
          showConfirmButton: true,
          allowOutsideClick: false,
          allowEnterKey: true,
          allowEscapeKey: false,
        }).then((data) => {
          this.$router.push({
            name: 'listarFuncionarios',
          });
        });
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>
