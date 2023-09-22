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
