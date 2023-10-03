document.addEventListener("DOMContentLoaded", function () {
            fetch('http://localhost:3306/cursos')
                .then(response => response.json())
                .then(cursos => {
                    const cursoContainer = document.getElementById('curso-container');

                    cursos.forEach(curso => {
                        const card = document.createElement('div');
                        card.className = 'curso-card';

                        const nome = document.createElement('h2');
                        nome.textContent = curso.nome;

                        const descricao = document.createElement('p');
                        descricao.textContent = curso.descricao;

                        card.appendChild(nome);
                        card.appendChild(descricao);
                        cursoContainer.appendChild(card);
                    });
                })
                .catch(error => console.error('Erro na requisição:', error));
        });