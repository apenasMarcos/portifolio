const modal = document.getElementById('modal');
const closeBtn = document.getElementById('closeModal');
const techContainer = modal.querySelector('.tech-icons');


const projetos = {
    projeto1: {
        titulo: 'Projeto Viagens',
        descricao: 'Sistema de busca e filtragem de destinos turísticos com integração via API.',
        imagem: '/images/imagem.jpg',
        github: 'https://github.com/seurepo/viagens',
        link: 'https://projeto-viagens.netlify.app',
        tecnologias: ['html', 'css', 'javascript']
    },
    projeto2: {
        titulo: 'Conversor Universal',
        descricao: 'Aplicativo desktop feita em Java com Swing e tema escuro FlatLaf. Realiza conversão de:\n' +
            ' 💰 Moedas (com cotação em tempo real via AwesomeAPI), \n' +
            '📏 Comprimento, \n ' +
            '⚖️ Massa, \n ' +
            '🌡️ Temperatura e \n ' +
            '💾 Armazenamento',
        imagem: '/images/projetos/conversor-moedas.png',
        github: 'https://github.com/apenasMarcos/conversor-de-moedas',
        link: '',
        tecnologias: ['Java', 'Swing', 'FlatLaf', 'Gson', 'Maven', 'AwesomeAPI', 'Junit']
    },
    projeto3: {
        titulo: 'Projeto TREIX',
        descricao: 'Dashboard para controle financeiro pessoal com gráficos interativos.',
        imagem: '/images/imagem.jpg',
        github: 'https://github.com/seurepo/financeiro',
        link: '',
        tecnologias: ['react', 'chartjs', 'sass']
    }
};


document.querySelectorAll('.img-port').forEach(img => {
    img.addEventListener('click', () => {
        const id = img.getAttribute('data-id');
        const projeto = projetos[id];

        if (projeto) {
            modal.querySelector('.modal-image img').src = projeto.imagem;
            modal.querySelector('.modal-info h2').textContent = projeto.titulo;
            modal.querySelector('.modal-info p').innerHTML = projeto.descricao;

            const links = modal.querySelector('.modal-info').querySelectorAll('a');
            links[0].href = projeto.github;
            links[0].textContent = 'Repositório no GitHub';

            if (projeto.link) {
                links[1].href = projeto.link;
                links[1].textContent = '🌐 Ver Projeto Online';
                links[1].style.display = 'inline';
            } else {
                links[1].style.display = 'none';
            }

            if (projeto.tecnologias && projeto.tecnologias.length > 0) {
                techContainer.innerHTML = '';
                projeto.tecnologias.forEach(tech => {
                    const span = document.createElement('span');
                    span.classList.add('tech-icon');
                    span.textContent = tech;
                    techContainer.appendChild(span);
                });
            }

            modal.classList.add('active');
        }
    });
});

closeBtn.addEventListener('click', () => {
    modal.classList.remove('active');
});

modal.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.classList.remove('active');
    }
});