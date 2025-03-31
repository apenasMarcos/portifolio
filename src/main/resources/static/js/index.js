document.getElementById("meuFormulario").addEventListener("submit", async function (event) {
    event.preventDefault();

    const sender = document.getElementById("sender").value;
    const phone = document.getElementById("phone").value;

    if (!sender && !phone) {
        await Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Por favor, preencha o campo de e-mail ou celular.',
            showConfirmButton: true
        });
        return;
    }

    const formData = new FormData(event.target);

    try {
        const response = await fetch('/save-message', {
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
        console.error('Erro:', error);
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