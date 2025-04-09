document.addEventListener('DOMContentLoaded', function() {
    let body = document.querySelector('body');
    let trilho = document.getElementById('trilho');
    let topoSite = document.getElementById('topo-do-site');
    let especialidades = document.getElementById('especialidades');
    let sobre = document.getElementById('sobre');
    let scroll = document.getElementById('scroll-down');
    let modalOverlay = document.getElementById('modal-split');
    let footerLogoImage = document.getElementById('footerLogoImage');

    if (trilho) {
        trilho.addEventListener('click', function () {
            [trilho, topoSite, especialidades, sobre, scroll, body, modalOverlay].forEach(elemento => elemento.classList.toggle('dark'));

            footerLogoImage.src = trilho.classList.contains('dark') ? "/images/logo-dark.png" : "/images/logo-light.png";
        });
    } else {
        trilho = document.getElementById('errorTrilho');
        trilho.addEventListener('click', function () {
            [trilho, topoSite, body].forEach(elemento => elemento.classList.toggle('dark'));

            footerLogoImage.src = trilho.classList.contains('dark') ? "/images/logo-dark.png" : "/images/logo-light.png";
        });
    }
});
