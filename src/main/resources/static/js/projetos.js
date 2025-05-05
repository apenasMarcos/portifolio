const modal = document.getElementById('modal');
const closeBtn = document.getElementById('closeModal');
const techContainer = modal.querySelector('.tech-icons');
const topicosContainer = modal.querySelector('.modal-topicos');
const projetosContainer = document.getElementById('projetos-container');
const projetos = {
    projeto1: {
        titulo: 'Mural Criando Futuro',
        descricao: 'O Mural Criando o Futuro é uma aplicação web desenvolvida  com o objetivo de melhorar a comunicação entre escolas, creches e a comunidade escolar. A plataforma permite a publicação de avisos, notícias e cardápios de forma centralizada, acessível e intuitiva.\n' +
            '\n' +
            'O projeto foi desenvolvido com Java (Spring Boot) no backend e HTML/CSS/JS com Bootstrap no frontend, além de integrar tecnologias como Spring Security, Docker, Caffeine Cache, Supabase, Back4App e Imgur API.\n' +
            '\n',
        imagem: '/images/projetos/mural-criando-futuro.png',
        github: 'https://github.com/apenasMarcos/Mural-Criando-o-Futuro',
        link: '',
        youtube: 'https://www.youtube.com/watch?v=0Bo-PrUSYiY',
        tecnologias: ['Html', 'CSS', 'Javascript', 'Java', 'Spring Boot', 'Docker', 'Spring Security', 'Caffeine Cache', 'Supabase', 'Imgur API'],
        topicos: [
            '🖼️ Mural de postagens com imagens',
            '👤 Gerenciamento de conteúdo por usuários autenticados',
            '📅 Exibição de cardápio semanal',
            '🏢 Seção institucional com informações de contato',
            '🎨 Interface amigável e responsiva',
            '⚡ Sistema de cache para performance otimizada'
        ]
    },
    projeto2: {
        titulo: 'Conversor Universal',
        descricao: 'Aplicativo desktop feita em Java com Swing e tema escuro FlatLaf.',
        imagem: '/images/projetos/conversor-moedas.png',
        github: 'https://github.com/apenasMarcos/conversor-de-moedas',
        link: '',
        tecnologias: ['Java', 'Swing', 'FlatLaf', 'Gson', 'Maven', 'AwesomeAPI', 'Junit'],
        topicos: [
            '💰 Conversor de Moedas (com cotação em tempo real via AwesomeAPI)',
            '📏 Conversor de Comprimento',
            '⚖️ Conversor de Massa',
            '🌡️ Conversor de Temperatura',
            '💾 Conversor de Armazenamento'
        ]
    },
    projeto3: {
        titulo: 'Organizador de Tarefas',
    descricao: 'Aplicação web para gerenciar tarefas, com funcionalidades de adicionar, editar, excluir e reorganizar tarefas com drag-and-drop enviando requisições para o back-end',
        imagem: '/images/projetos/organizador-tarefas.png',
        github: 'https://github.com/apenasMarcos/agendador-tarefas',
        link: '',
        tecnologias: ['HTML', 'CSS', 'JavaScript', 'Java' , 'Spring Boot', 'Thymeleaf', 'Docker'],
        topicos: [
            '📝 Adicionar, editar e excluir tarefas',
            '📋 Visualização de tarefas cadastradas',
            '🔄 Reorganização de tarefas via drag-and-drop',
            '💬 Confirmação antes da exclusão de tarefas',
            '🚀 Deploy simplificado utilizando Docker'
        ]
    },
    projeto4: {
        titulo: 'Decodificador de Texto',
        descricao: 'O Decodificador de Texto é uma aplicação web desenvolvida como parte do desafio proposto pela Alura em parceria com a Oracle ONE. O objetivo é aplicar os conhecimentos de HTML, CSS e JavaScript criando uma ferramenta simples, responsiva e funcional para codificação e decodificação de mensagens.\n' +
            '\n' +
            'A aplicação conta com um design claro e escuro, botões interativos, mensagens de alerta e uma interface minimalista, com foco em usabilidade e acessibilidade.\n' +
            '\n',
        imagem: '/images/projetos/criptografia_e_descriptografia.png',
        github: 'https://github.com/apenasMarcos/decodificador-de-texto',
        link: 'https://apenasmarcos.github.io/decodificador-de-texto/',
        youtube: '',
        tecnologias: ['HTML', 'CSS', 'JavaScript'],
        topicos: [
            '🔐 Criptografia e descriptografia de mensagens',
            '🌗 Alternância entre tema claro e escuro',
            '📱 Design responsivo para diferentes dispositivos',
            '🎯 Interface limpa e intuitiva',
            '⚡ Animações e transições suaves',
            '🧪 Projeto desenvolvido como parte de desafio da Alura + Oracle ONE'
        ]
    },
    projeto5: {
        titulo: 'Em andamento',
        descricao: 'Inicialmente minha ideia é desenvolver um aplicativo para visualizar series recém lançadas e suas avaliações no IMDB, podendo também ser possivel adicioanr comentarios ' +
            'e avaliações para cada usuário logado',
        imagem: '/images/projetos/obra.png',
        github: 'https://github.com/apenasMarcos/screenmatch',
        link: '',
        youtube: '',
        tecnologias: ['HTML', 'CSS', 'JavaScript', 'Java', 'Spring Boot', 'Thymeleaf'],
        topicos: [
        ]
    },
};

const linha1 = document.getElementById('linha-1');
const linha2 = document.getElementById('linha-2');

Object.entries(projetos).forEach(([id, projeto], index) => {
    const div = document.createElement('div');
    div.className = 'img-port';
    div.style.backgroundImage = `url(${projeto.imagem})`;
    div.setAttribute('data-id', id);

    const overlay = document.createElement('div');
    overlay.className = 'overlay';
    overlay.textContent = projeto.titulo;

    div.appendChild(overlay);

    if (index < 3) {
        linha1.appendChild(div);
    } else {
        linha2.appendChild(div);
    }
});

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

            if (projeto.youtube) {
                links[2].href = projeto.youtube;
                links[2].textContent = '📹 Apresentação projeto';
                links[2].style.display = 'inline';
            } else {
                links[2].style.display = 'none';
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

            if (projeto.topicos && projeto.topicos.length > 0 && topicosContainer) {
                topicosContainer.innerHTML = '<h3>Principais funcionalidades:</h3><ul>';
                projeto.topicos.forEach(topico => {
                    topicosContainer.innerHTML += `<li>${topico}</li>`;
                });
                topicosContainer.innerHTML += '</ul>';
            } else if (topicosContainer) {
                topicosContainer.innerHTML = '';
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