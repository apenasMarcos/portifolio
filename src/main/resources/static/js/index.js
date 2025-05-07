document.addEventListener('DOMContentLoaded', function() {
    const menuLinks = document.querySelectorAll('nav.menu-desktop a');

    menuLinks.forEach(link => {
        link.addEventListener('click', scrollToSection);
    });

    function scrollToSection(e) {
        e.preventDefault();

        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);

        const offsetTop = targetElement.offsetTop;

        window.scrollTo({
            top: offsetTop,
            behavior: 'smooth'
        });
    }
});

document.querySelector('.scroll-down').addEventListener('click', function () {
    document.getElementById("sobre").scrollIntoView({ behavior: "smooth" });
});