window.onload = function () {
  let isLoggedIn = sessionStorage.getItem('jwt');
  if (isLoggedIn) window.location.href = 'index.html';

  document.getElementById('login-btn').onclick = function (event) {
    event.preventDefault();
    return login();
  }

  async function login() {
    await fetch('http://localhost:3000/login', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify({
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
      })
    }).then((response) => response.json())
    .then((response)=>{
      sessionStorage.setItem('jwt', response.accessToken)
      isLoggedIn = sessionStorage.getItem('jwt')
      if (isLoggedIn) window.location.href = 'index.html';
    })
    .catch(err => console.error(err));
  }
}