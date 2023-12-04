let btnMenu = document.getElementById('btn-menu')
let menu = document.getElementById('menu-mobile')
let overlay = document.getElementById('overlay-menu')

btnMenu.addEventListener('click', ()=>{
    menu.classList.add('abrir-menu')
})

menu.addEventListener('click', ()=>{
    menu.classList.remove('abrir-menu')
})

overlay.addEventListener('click', ()=>{
    menu.classList.remove('abrir-menu')
})

document.getElementById("meuFormulario").addEventListener("submit", async function (event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    try {
        const response = await fetch('/salvar-mensagem', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            await Swal.fire({
                icon: 'success',
                title: await response.text(),
                showConfirmButton: false,
                timer: 1500
            });
        } else {
            await Swal.fire({
                icon: 'error',
                title: await response.text(),
                showConfirmButton: true
            });
        }
    } catch (error) {
        // Lidar com erros de requisição
        console.error('Erro:', error);
        // Exibir mensagem de erro usando SweetAlert2
        await Swal.fire({
            icon: 'error',
            title: 'Erro ao salvar mensagem.',
            text: 'Por favor, tente novamente mais tarde.',
            showConfirmButton: true
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const menuLinks = document.querySelectorAll('nav.menu-desktop a');

    menuLinks.forEach(link => {
        link.addEventListener('click', scrollToSection);
    });

    function scrollToSection(e) {
        e.preventDefault();

        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);

        // Obtemos a posição do topo do elemento em relação à janela
        const offsetTop = targetElement.offsetTop;

        // Realizamos o scroll suave
        window.scrollTo({
            top: offsetTop,
            behavior: 'smooth'
        });
    }
});
