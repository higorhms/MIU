window.onload = function () {
    const isLoggedIn = sessionStorage.getItem('jwt');
    if (!isLoggedIn) window.location.href = 'login.html';

    getBooks();

    document.getElementById('book-btn').onclick = function (event) {
        event.preventDefault();
        if (!document.getElementById('book-btn').dataset.id) return addBook();
        return editBook();
    }

    async function getBooks() {
        let books = await fetch('http://localhost:3000/books/', {
            headers: getHeaders(),
        }).then(response => response.json());
        books.forEach(prod => renderBook(prod));
    }

    function renderBook(prod) {
        const div = document.createElement('div');
        div.classList = 'col-lg-4';
        div.id = prod._id;

        const title = document.createElement('h2');
        title.textContent = prod.title;

        const author = document.createElement('p');
        author.textContent = prod.author;

        const ISBN = document.createElement('p');
        ISBN.textContent = prod.ISBN;

        const publishedDate = document.createElement('p');
        publishedDate.textContent = prod.publishedDate;

        div.appendChild(title);
        div.appendChild(author);
        div.appendChild(ISBN);
        div.appendChild(publishedDate);

        const actions = document.createElement('p');
        const updateBtn = document.createElement('a');
        updateBtn.classList = 'btn btn-secondary';
        updateBtn.textContent = 'UPDATE';
        updateBtn.addEventListener('click', function (event) {
            event.preventDefault();
            document.getElementById('book-heading').textContent = 'Edit Book';
            document.getElementById('title').value = prod.title;
            document.getElementById('author').value = prod.author;
            document.getElementById('ISBN').value = prod.ISBN;
            document.getElementById('publishedDate').value = prod.publishedDate;
            document.getElementById('book-btn').dataset.id = prod._id;
        });

        const deleteBtn = document.createElement('a');
        deleteBtn.classList = 'btn btn-secondary';
        deleteBtn.textContent = 'DELETE';

        deleteBtn.addEventListener('click', function (event) {
            event.preventDefault();
            fetch('http://localhost:3000/books/' + prod._id, {
                method: 'DELETE',
                headers: getHeaders(),
            }).then(() => {
                alert('Delete Successfully!');
                div.remove();
            });
        });

        actions.appendChild(updateBtn);
        actions.appendChild(deleteBtn);

        div.appendChild(actions);

        document.getElementById('books').appendChild(div);
    }


    async function addBook() {
        await fetch('http://localhost:3000/books/', {
            method: 'POST',
            headers: getHeaders(),
            body: JSON.stringify({
                title: document.getElementById('title').value,
                ISBN: document.getElementById('ISBN').value,
                author: document.getElementById('author').value,
                publishedDate: document.getElementById('publishedDate').value
            })
        }).then(() => {
            document.getElementById('book-form').reset()
            window.location.reload();
        }).catch(err => console.error(err));
    }

    function editBook() {
        const prodId = document.getElementById('book-btn').dataset.id;
        const title = document.getElementById('title').value;
        const author = document.getElementById('author').value;
        const ISBN = document.getElementById('ISBN').value;
        const publishedDate = document.getElementById('publishedDate').value

        fetch('http://localhost:3000/books/' + prodId, {
            method: 'PUT',
            headers: getHeaders(),
            body: JSON.stringify({
                title: title,
                author: author,
                ISBN: ISBN,
                publishedDate
            })
        }).then(() => {
            const bookDiv = document.getElementById(prodId);
            bookDiv.querySelector('h2').textContent = title;
            const paragraphArr = bookDiv.querySelectorAll('p');
            paragraphArr[0].textContent = author;
            paragraphArr[1].textContent = ISBN;

            document.getElementById('book-heading').textContent = 'Add a new Book';
            document.getElementById('book-btn').dataset.id = '';
            document.getElementById('book-form').reset();
        });
    }

    document.getElementById('nav-signout').addEventListener('click', () => {
        sessionStorage.clear();
    });

    function getHeaders() {
        return {
            'Content-type': 'application/json',
            'Authorization': `Bearer: ${sessionStorage.getItem('jwt')}`
        }
    }
}