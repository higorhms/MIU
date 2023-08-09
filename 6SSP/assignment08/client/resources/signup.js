window.onload = function () {
  const isLoggedIn = sessionStorage.getItem('jwt');
  if (isLoggedIn) window.location.href = 'index.html';

  document.getElementById('signup-btn').onclick = function (event) {
    event.preventDefault();
    return signup();
  }

  async function signup() {
    await fetch('http://localhost:3000/signup', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify({
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
      })
    })
      .catch(err => console.error(err));
  }
}