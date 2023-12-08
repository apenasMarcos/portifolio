document.addEventListener('DOMContentLoaded', function() {
    let trilho = document.getElementById('trilho');
    let topoSite = document.getElementById('topo-do-site');
    let especiliadades = document.getElementById('especiliadades');
    let sobre = document.getElementById('sobre');
    let body = document.querySelector('body');
    let h2 = document.querySelector('h2');
    let logoImage = document.getElementById('logoImage');
    let footerLogoImage = document.getElementById('footerLogoImage');

    trilho.addEventListener('click', () => {
        trilho.classList.toggle('dark');
        topoSite.classList.toggle('dark');
        especiliadades.classList.toggle('dark');
        sobre.classList.toggle('dark');
        body.classList.toggle('dark');
        h2.classList.toggle('dark');

        if (trilho.classList.contains('dark')) {
            logoImage.src = "/images/logo-dark.png";
            footerLogoImage.src = "/images/logo-dark.png";
        } else {
            logoImage.src = "/images/logo-light.png";
            footerLogoImage.src = "/images/logo-light.png";
        }
    });
});
