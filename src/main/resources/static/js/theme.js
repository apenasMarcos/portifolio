document.addEventListener('DOMContentLoaded', function() {
    let body = document.querySelector('body');
    let trilho = document.getElementById('trilho');
    let topoSite = document.getElementById('topo-do-site');
    let especiliadades = document.getElementById('especiliadades');
    let sobre = document.getElementById('sobre');
    let logoImage = document.getElementById('logoImage');
    let footerLogoImage = document.getElementById('footerLogoImage');

    if (trilho) {
        trilho.addEventListener('click', function () {
            [trilho, topoSite, especiliadades, sobre, body].forEach(elemento => elemento.classList.toggle('dark'));

            logoImage.src = trilho.classList.contains('dark') ? "/images/logo-dark.png" : "/images/logo-light.png";
            footerLogoImage.src = logoImage.src;
        });
    } else {
        trilho = document.getElementById('errorTrilho');
        trilho.addEventListener('click', function () {
            [trilho, topoSite, body].forEach(elemento => elemento.classList.toggle('dark'));

            logoImage.src = trilho.classList.contains('dark') ? "/images/logo-dark.png" : "/images/logo-light.png";
            footerLogoImage.src = logoImage.src;
        });
    }
});
