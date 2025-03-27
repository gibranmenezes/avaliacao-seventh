const form = document.getElementById('formulario');
const mensagemDiv = document.getElementById('mensagem');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  
  const formData = new FormData(form);
  const { nome, email } = Object.fromEntries(formData);
  const trimmedNome = nome.trim();
  const trimmedEmail = email.trim();

  mensagemDiv.className = 'mensagem';
  mensagemDiv.textContent = '';

  if (!validaCamposPreenchidos(trimmedNome, trimmedEmail)) return;
  if (!validaEmail(trimmedEmail)) return;

  showMessage('Formulário enviado com sucesso! ✅', 'sucesso');
  form.reset();
});

const showMessage = (text, type) => {
  mensagemDiv.textContent = text;
  mensagemDiv.classList.add(type, 'visible');
  
  if (type === 'sucesso') {
    setTimeout(() => mensagemDiv.classList.remove('visible'), 3000);
  }
};

const isValidEmail = (email) => {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  };
  
  function validaCamposPreenchidos(nome, email) { //Aqui tem um exemplo de hoisting que é uma pergunta do teste.
    if (!nome || !email) {
      showMessage('Por favor, preencha todos os campos.', 'erro');
      return false;
    }
    return true;
  }
  
  function validaEmail(email) {
    if (!isValidEmail(email)) {
      showMessage('Por favor, insira um e-mail válido.', 'erro');
      return false;
    }
    return true;
  }