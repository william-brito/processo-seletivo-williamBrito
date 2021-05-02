<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Criar novo setor</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="handleSubmitForm">
          <!---- INÍCIO DO BLOCO: Nome do Setor ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome</label>
            <input
              type="text"
              id="idNomeSetor"
              name="idNomeSetor"
              placeholder="Digite o Nome do Setor"
              class="form-control"
              v-model="setorForm.NOME_SETOR"
              :class="{'is-invalid': isSubmitted && $v.setorForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.setorForm.NOME_SETOR.required"
            >O Campo "Nome do Setor" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Nome do Setor ---->
          <div class="form-group">
            <button type="button" @click="enviarNovoSetor" class="btn btn-primary">
              <font-awesome-icon :icon="['fas', 'user-plus']" />Setor
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import { required } from 'vuelidate/lib/validators';
import SetorService from '../../../services/SetorService';

export default {
  data() {
    return {
      setorForm: {
        NOME_SETOR: null,
      },
      isSubmitted: false,
    };
  },
  validations: {
    setorForm: {
      NOME_SETOR: {
        required,
      },
    },
  },
  methods: {
    handleSubmitForm() {},
    async enviarNovoSetor() {
      try {
        this.isSubmitted = true;
        this.$v.$touch();
        if (this.$v.$invalid) {
          this.$swal('Atencao!', 'Voce precisa incluir todos os campos obrigatorios!', 'error');
          return;
        }
        await SetorService.criarNovoSetor(this.setorForm);
        this.$swal({
          title: 'Setor adicionado com sucesso!',
          icon: 'success',
          showConfirmButton: true,
          allowOutsideClick: false,
          allowEnterKey: true,
          allowEscapeKey: false,
        }).then((data) => {
          this.$router.push({
            name: 'listarSetores',
          });
        });
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>
